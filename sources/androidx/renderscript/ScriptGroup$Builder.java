package androidx.renderscript;

import androidx.renderscript.Script;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ScriptGroup$Builder {
    private int mKernelCount;
    private RenderScript mRS;
    private ArrayList<ScriptGroup$Node> mNodes = new ArrayList<>();
    private ArrayList<ScriptGroup$ConnectLine> mLines = new ArrayList<>();
    private boolean mUseIncSupp = false;

    public ScriptGroup$Builder(RenderScript renderScript) {
        this.mRS = renderScript;
    }

    private boolean calcOrder() {
        Iterator<ScriptGroup$Node> it = this.mNodes.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ScriptGroup$Node next = it.next();
            if (next.mInputs.size() == 0) {
                Iterator<ScriptGroup$Node> it2 = this.mNodes.iterator();
                while (it2.hasNext()) {
                    it2.next().mSeen = false;
                }
                z &= calcOrderRecurse(next, 1);
            }
        }
        Collections.sort(this.mNodes, new 1(this));
        return z;
    }

    private boolean calcOrderRecurse(ScriptGroup$Node scriptGroup$Node, int i) {
        scriptGroup$Node.mSeen = true;
        if (scriptGroup$Node.mOrder < i) {
            scriptGroup$Node.mOrder = i;
        }
        Iterator<ScriptGroup$ConnectLine> it = scriptGroup$Node.mOutputs.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ScriptGroup$ConnectLine next = it.next();
            Script$FieldID script$FieldID = next.mToF;
            ScriptGroup$Node findNode = script$FieldID != null ? findNode(script$FieldID.mScript) : findNode(next.mToK.mScript);
            if (findNode.mSeen) {
                return false;
            }
            z &= calcOrderRecurse(findNode, scriptGroup$Node.mOrder + 1);
        }
        return z;
    }

    private ScriptGroup$Node findNode(Script script) {
        for (int i = 0; i < this.mNodes.size(); i++) {
            if (script == this.mNodes.get(i).mScript) {
                return this.mNodes.get(i);
            }
        }
        return null;
    }

    private void mergeDAGs(int i, int i2) {
        for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
            if (this.mNodes.get(i3).dagNumber == i2) {
                this.mNodes.get(i3).dagNumber = i;
            }
        }
    }

    private void validateCycle(ScriptGroup$Node scriptGroup$Node, ScriptGroup$Node scriptGroup$Node2) {
        for (int i = 0; i < scriptGroup$Node.mOutputs.size(); i++) {
            ScriptGroup$ConnectLine scriptGroup$ConnectLine = scriptGroup$Node.mOutputs.get(i);
            Script.KernelID kernelID = scriptGroup$ConnectLine.mToK;
            if (kernelID != null) {
                ScriptGroup$Node findNode = findNode(kernelID.mScript);
                if (findNode.equals(scriptGroup$Node2)) {
                    throw new RSInvalidStateException("Loops in group not allowed.");
                }
                validateCycle(findNode, scriptGroup$Node2);
            }
            Script$FieldID script$FieldID = scriptGroup$ConnectLine.mToF;
            if (script$FieldID != null) {
                ScriptGroup$Node findNode2 = findNode(script$FieldID.mScript);
                if (findNode2.equals(scriptGroup$Node2)) {
                    throw new RSInvalidStateException("Loops in group not allowed.");
                }
                validateCycle(findNode2, scriptGroup$Node2);
            }
        }
    }

    private void validateDAG() {
        for (int i = 0; i < this.mNodes.size(); i++) {
            ScriptGroup$Node scriptGroup$Node = this.mNodes.get(i);
            if (scriptGroup$Node.mInputs.size() == 0) {
                if (scriptGroup$Node.mOutputs.size() == 0 && this.mNodes.size() > 1) {
                    throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
                }
                validateDAGRecurse(scriptGroup$Node, i + 1);
            }
        }
        int i2 = this.mNodes.get(0).dagNumber;
        for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
            if (this.mNodes.get(i3).dagNumber != i2) {
                throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
            }
        }
    }

    private void validateDAGRecurse(ScriptGroup$Node scriptGroup$Node, int i) {
        int i2 = scriptGroup$Node.dagNumber;
        if (i2 != 0 && i2 != i) {
            mergeDAGs(i2, i);
            return;
        }
        scriptGroup$Node.dagNumber = i;
        for (int i3 = 0; i3 < scriptGroup$Node.mOutputs.size(); i3++) {
            ScriptGroup$ConnectLine scriptGroup$ConnectLine = scriptGroup$Node.mOutputs.get(i3);
            Script.KernelID kernelID = scriptGroup$ConnectLine.mToK;
            if (kernelID != null) {
                validateDAGRecurse(findNode(kernelID.mScript), i);
            }
            Script$FieldID script$FieldID = scriptGroup$ConnectLine.mToF;
            if (script$FieldID != null) {
                validateDAGRecurse(findNode(script$FieldID.mScript), i);
            }
        }
    }

    public ScriptGroup$Builder addConnection(Type type, Script.KernelID kernelID, Script$FieldID script$FieldID) {
        ScriptGroup$Node findNode = findNode(kernelID);
        if (findNode == null) {
            throw new RSInvalidStateException("From script not found.");
        }
        ScriptGroup$Node findNode2 = findNode(script$FieldID.mScript);
        if (findNode2 == null) {
            throw new RSInvalidStateException("To script not found.");
        }
        ScriptGroup$ConnectLine scriptGroup$ConnectLine = new ScriptGroup$ConnectLine(type, kernelID, script$FieldID);
        this.mLines.add(new ScriptGroup$ConnectLine(type, kernelID, script$FieldID));
        findNode.mOutputs.add(scriptGroup$ConnectLine);
        findNode2.mInputs.add(scriptGroup$ConnectLine);
        validateCycle(findNode, findNode);
        return this;
    }

    public ScriptGroup$Builder addKernel(Script.KernelID kernelID) {
        if (this.mLines.size() != 0) {
            throw new RSInvalidStateException("Kernels may not be added once connections exist.");
        }
        if (kernelID.mScript.isIncSupp()) {
            this.mUseIncSupp = true;
        }
        if (findNode(kernelID) != null) {
            return this;
        }
        this.mKernelCount++;
        ScriptGroup$Node findNode = findNode(kernelID.mScript);
        if (findNode == null) {
            findNode = new ScriptGroup$Node(kernelID.mScript);
            this.mNodes.add(findNode);
        }
        findNode.mKernels.add(kernelID);
        return this;
    }

    public ScriptGroup create() {
        if (this.mNodes.size() == 0) {
            throw new RSInvalidStateException("Empty script groups are not allowed");
        }
        for (int i = 0; i < this.mNodes.size(); i++) {
            this.mNodes.get(i).dagNumber = 0;
        }
        validateDAG();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long[] jArr = new long[this.mKernelCount];
        int i2 = 0;
        for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
            ScriptGroup$Node scriptGroup$Node = this.mNodes.get(i3);
            int i4 = 0;
            while (i4 < scriptGroup$Node.mKernels.size()) {
                final Script.KernelID kernelID = scriptGroup$Node.mKernels.get(i4);
                int i5 = i2 + 1;
                jArr[i2] = kernelID.getID(this.mRS);
                boolean z = false;
                for (int i6 = 0; i6 < scriptGroup$Node.mInputs.size(); i6++) {
                    if (scriptGroup$Node.mInputs.get(i6).mToK == kernelID) {
                        z = true;
                    }
                }
                boolean z2 = false;
                for (int i7 = 0; i7 < scriptGroup$Node.mOutputs.size(); i7++) {
                    if (scriptGroup$Node.mOutputs.get(i7).mFrom == kernelID) {
                        z2 = true;
                    }
                }
                if (!z) {
                    arrayList.add(new Object(kernelID) { // from class: androidx.renderscript.ScriptGroup$IO
                        Allocation mAllocation;
                        Script.KernelID mKID;

                        {
                            this.mKID = kernelID;
                        }
                    });
                }
                if (!z2) {
                    arrayList2.add(new Object(kernelID) { // from class: androidx.renderscript.ScriptGroup$IO
                        Allocation mAllocation;
                        Script.KernelID mKID;

                        {
                            this.mKID = kernelID;
                        }
                    });
                }
                i4++;
                i2 = i5;
            }
        }
        if (i2 != this.mKernelCount) {
            throw new RSRuntimeException("Count mismatch, should not happen.");
        }
        long j = 0;
        if (this.mUseIncSupp) {
            calcOrder();
        } else {
            long[] jArr2 = new long[this.mLines.size()];
            long[] jArr3 = new long[this.mLines.size()];
            long[] jArr4 = new long[this.mLines.size()];
            long[] jArr5 = new long[this.mLines.size()];
            for (int i8 = 0; i8 < this.mLines.size(); i8++) {
                ScriptGroup$ConnectLine scriptGroup$ConnectLine = this.mLines.get(i8);
                jArr2[i8] = scriptGroup$ConnectLine.mFrom.getID(this.mRS);
                Script.KernelID kernelID2 = scriptGroup$ConnectLine.mToK;
                if (kernelID2 != null) {
                    jArr3[i8] = kernelID2.getID(this.mRS);
                }
                Script$FieldID script$FieldID = scriptGroup$ConnectLine.mToF;
                if (script$FieldID != null) {
                    jArr4[i8] = script$FieldID.getID(this.mRS);
                }
                jArr5[i8] = scriptGroup$ConnectLine.mAllocationType.getID(this.mRS);
            }
            long nScriptGroupCreate = this.mRS.nScriptGroupCreate(jArr, jArr2, jArr3, jArr4, jArr5);
            if (nScriptGroupCreate == 0) {
                throw new RSRuntimeException("Object creation error, should not happen.");
            }
            j = nScriptGroupCreate;
        }
        ScriptGroup scriptGroup = new ScriptGroup(j, this.mRS);
        scriptGroup.mOutputs = new ScriptGroup$IO[arrayList2.size()];
        for (int i9 = 0; i9 < arrayList2.size(); i9++) {
            scriptGroup.mOutputs[i9] = (ScriptGroup$IO) arrayList2.get(i9);
        }
        scriptGroup.mInputs = new ScriptGroup$IO[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            scriptGroup.mInputs[i10] = (ScriptGroup$IO) arrayList.get(i10);
        }
        ScriptGroup.access$002(scriptGroup, this.mNodes);
        ScriptGroup.access$102(scriptGroup, this.mUseIncSupp);
        return scriptGroup;
    }

    private ScriptGroup$Node findNode(Script.KernelID kernelID) {
        for (int i = 0; i < this.mNodes.size(); i++) {
            ScriptGroup$Node scriptGroup$Node = this.mNodes.get(i);
            for (int i2 = 0; i2 < scriptGroup$Node.mKernels.size(); i2++) {
                if (kernelID == scriptGroup$Node.mKernels.get(i2)) {
                    return scriptGroup$Node;
                }
            }
        }
        return null;
    }

    public ScriptGroup$Builder addConnection(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
        ScriptGroup$Node findNode = findNode(kernelID);
        if (findNode != null) {
            ScriptGroup$Node findNode2 = findNode(kernelID2);
            if (findNode2 != null) {
                ScriptGroup$ConnectLine scriptGroup$ConnectLine = new ScriptGroup$ConnectLine(type, kernelID, kernelID2);
                this.mLines.add(new ScriptGroup$ConnectLine(type, kernelID, kernelID2));
                findNode.mOutputs.add(scriptGroup$ConnectLine);
                findNode2.mInputs.add(scriptGroup$ConnectLine);
                validateCycle(findNode, findNode);
                return this;
            }
            throw new RSInvalidStateException("To script not found.");
        }
        throw new RSInvalidStateException("From script not found.");
    }
}
