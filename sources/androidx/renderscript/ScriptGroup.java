package androidx.renderscript;

import android.os.Build;
import android.util.Log;
import androidx.renderscript.Allocation;
import androidx.renderscript.Script;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ScriptGroup extends BaseObj {
    private static final int MIN_API_VERSION = 23;
    private static final String TAG = "ScriptGroup";
    private List<Closure> mClosures;
    IO[] mInputs;
    private List<Input> mInputs2;
    private String mName;
    private ArrayList<Node> mNodes;
    IO[] mOutputs;
    private Future[] mOutputs2;
    private boolean mUseIncSupp;

    /* compiled from: Taobao */
    public static final class Closure extends BaseObj {
        private static final String TAG = "Closure";
        private Object[] mArgs;
        private Map<Script.FieldID, Object> mBindings;
        private FieldPacker mFP;
        private Map<Script.FieldID, Future> mGlobalFuture;
        private Future mReturnFuture;
        private Allocation mReturnValue;

        /* compiled from: Taobao */
        private static final class ValueAndSize {
            public int size;
            public long value;

            public ValueAndSize(RenderScript renderScript, Object obj) {
                if (obj instanceof Allocation) {
                    this.value = ((Allocation) obj).getID(renderScript);
                    this.size = -1;
                    return;
                }
                if (obj instanceof Boolean) {
                    this.value = ((Boolean) obj).booleanValue() ? 1L : 0L;
                    this.size = 4;
                    return;
                }
                if (obj instanceof Integer) {
                    this.value = ((Integer) obj).longValue();
                    this.size = 4;
                    return;
                }
                if (obj instanceof Long) {
                    this.value = ((Long) obj).longValue();
                    this.size = 8;
                } else if (obj instanceof Float) {
                    this.value = ((Float) obj).longValue();
                    this.size = 4;
                } else if (obj instanceof Double) {
                    this.value = ((Double) obj).longValue();
                    this.size = 8;
                }
            }
        }

        Closure(long j, RenderScript renderScript) {
            super(j, renderScript);
        }

        private void retrieveValueAndDependenceInfo(RenderScript renderScript, int i, Script.FieldID fieldID, Object obj, long[] jArr, int[] iArr, long[] jArr2, long[] jArr3) {
            if (obj instanceof Future) {
                Future future = (Future) obj;
                Object value = future.getValue();
                jArr2[i] = future.getClosure().getID(renderScript);
                Script.FieldID fieldID2 = future.getFieldID();
                jArr3[i] = fieldID2 != null ? fieldID2.getID(renderScript) : 0L;
                obj = value;
            } else {
                jArr2[i] = 0;
                jArr3[i] = 0;
            }
            if (!(obj instanceof Input)) {
                ValueAndSize valueAndSize = new ValueAndSize(renderScript, obj);
                jArr[i] = valueAndSize.value;
                iArr[i] = valueAndSize.size;
            } else {
                Input input = (Input) obj;
                if (i < this.mArgs.length) {
                    input.addReference(this, i);
                } else {
                    input.addReference(this, fieldID);
                }
                jArr[i] = 0;
                iArr[i] = 0;
            }
        }

        public Future getGlobal(Script.FieldID fieldID) {
            Future future = this.mGlobalFuture.get(fieldID);
            if (future != null) {
                return future;
            }
            Object obj = this.mBindings.get(fieldID);
            if (obj instanceof Future) {
                obj = ((Future) obj).getValue();
            }
            Future future2 = new Future(this, fieldID, obj);
            this.mGlobalFuture.put(fieldID, future2);
            return future2;
        }

        public Future getReturn() {
            if (this.mReturnFuture == null) {
                this.mReturnFuture = new Future(this, (Script.FieldID) null, this.mReturnValue);
            }
            return this.mReturnFuture;
        }

        void setArg(int i, Object obj) {
            if (obj instanceof Future) {
                obj = ((Future) obj).getValue();
            }
            this.mArgs[i] = obj;
            ValueAndSize valueAndSize = new ValueAndSize(((BaseObj) this).mRS, obj);
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nClosureSetArg(getID(renderScript), i, valueAndSize.value, valueAndSize.size);
        }

        void setGlobal(Script.FieldID fieldID, Object obj) {
            if (obj instanceof Future) {
                obj = ((Future) obj).getValue();
            }
            this.mBindings.put(fieldID, obj);
            ValueAndSize valueAndSize = new ValueAndSize(((BaseObj) this).mRS, obj);
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nClosureSetGlobal(getID(renderScript), fieldID.getID(((BaseObj) this).mRS), valueAndSize.value, valueAndSize.size);
        }

        Closure(RenderScript renderScript, Script.KernelID kernelID, Type type, Object[] objArr, Map<Script.FieldID, Object> map) {
            super(0L, renderScript);
            if (Build.VERSION.SDK_INT < 23 && renderScript.isUseNative()) {
                throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
            }
            this.mArgs = objArr;
            this.mReturnValue = Allocation.createTyped(renderScript, type);
            this.mBindings = map;
            this.mGlobalFuture = new HashMap();
            int length = objArr.length + map.size();
            long[] jArr = new long[length];
            long[] jArr2 = new long[length];
            int[] iArr = new int[length];
            long[] jArr3 = new long[length];
            long[] jArr4 = new long[length];
            int i = 0;
            while (i < objArr.length) {
                jArr[i] = 0;
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                retrieveValueAndDependenceInfo(renderScript, i, null, objArr[i], jArr2, iArr, jArr6, jArr5);
                i++;
                jArr2 = jArr2;
                jArr3 = jArr6;
                jArr4 = jArr5;
                iArr = iArr;
            }
            int i2 = i;
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            int[] iArr2 = iArr;
            long[] jArr9 = jArr2;
            for (Map.Entry<Script.FieldID, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                Script.FieldID key = entry.getKey();
                jArr[i2] = key.getID(renderScript);
                retrieveValueAndDependenceInfo(renderScript, i2, key, value, jArr9, iArr2, jArr8, jArr7);
                i2++;
            }
            setID(renderScript.nClosureCreate(kernelID.getID(renderScript), this.mReturnValue.getID(renderScript), jArr, jArr9, iArr2, jArr8, jArr7));
        }

        Closure(RenderScript renderScript, Script.InvokeID invokeID, Object[] objArr, Map<Script.FieldID, Object> map) {
            super(0L, renderScript);
            if (Build.VERSION.SDK_INT < 23 && renderScript.isUseNative()) {
                throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
            }
            this.mFP = FieldPacker.createFromArray(objArr);
            this.mArgs = objArr;
            this.mBindings = map;
            this.mGlobalFuture = new HashMap();
            int size = map.size();
            long[] jArr = new long[size];
            long[] jArr2 = new long[size];
            int[] iArr = new int[size];
            long[] jArr3 = new long[size];
            long[] jArr4 = new long[size];
            int i = 0;
            for (Map.Entry<Script.FieldID, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                Script.FieldID key = entry.getKey();
                jArr[i] = key.getID(renderScript);
                retrieveValueAndDependenceInfo(renderScript, i, key, value, jArr2, iArr, jArr3, jArr4);
                i++;
            }
            setID(renderScript.nInvokeClosureCreate(invokeID.getID(renderScript), this.mFP.getData(), jArr, jArr2, iArr));
        }
    }

    ScriptGroup(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.mUseIncSupp = false;
        this.mNodes = new ArrayList<>();
    }

    public Object[] execute(Object... objArr) {
        if (objArr.length < this.mInputs2.size()) {
            Log.e(TAG, toString() + " receives " + objArr.length + " inputs, less than expected " + this.mInputs2.size());
            return null;
        }
        if (objArr.length > this.mInputs2.size()) {
            Log.i(TAG, toString() + " receives " + objArr.length + " inputs, more than expected " + this.mInputs2.size());
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mInputs2.size(); i2++) {
            Object obj = objArr[i2];
            if ((obj instanceof Future) || (obj instanceof Input)) {
                Log.e(TAG, toString() + ": input " + i2 + " is a future or unbound value");
                return null;
            }
            this.mInputs2.get(i2).set(obj);
        }
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptGroup2Execute(getID(renderScript));
        Future[] futureArr = this.mOutputs2;
        Object[] objArr2 = new Object[futureArr.length];
        int length = futureArr.length;
        int i3 = 0;
        while (i < length) {
            Object value = futureArr[i].getValue();
            if (value instanceof Input) {
                value = ((Input) value).get();
            }
            objArr2[i3] = value;
            i++;
            i3++;
        }
        return objArr2;
    }

    public void setInput(Script.KernelID kernelID, Allocation allocation) {
        int i = 0;
        while (true) {
            IO[] ioArr = this.mInputs;
            if (i >= ioArr.length) {
                throw new RSIllegalArgumentException("Script not found");
            }
            if (ioArr[i].mKID == kernelID) {
                ioArr[i].mAllocation = allocation;
                if (this.mUseIncSupp) {
                    return;
                }
                RenderScript renderScript = ((BaseObj) this).mRS;
                renderScript.nScriptGroupSetInput(getID(renderScript), kernelID.getID(((BaseObj) this).mRS), ((BaseObj) this).mRS.safeID(allocation));
                return;
            }
            i++;
        }
    }

    public void setOutput(Script.KernelID kernelID, Allocation allocation) {
        int i = 0;
        while (true) {
            IO[] ioArr = this.mOutputs;
            if (i >= ioArr.length) {
                throw new RSIllegalArgumentException("Script not found");
            }
            if (ioArr[i].mKID == kernelID) {
                ioArr[i].mAllocation = allocation;
                if (this.mUseIncSupp) {
                    return;
                }
                RenderScript renderScript = ((BaseObj) this).mRS;
                renderScript.nScriptGroupSetOutput(getID(renderScript), kernelID.getID(((BaseObj) this).mRS), ((BaseObj) this).mRS.safeID(allocation));
                return;
            }
            i++;
        }
    }

    ScriptGroup(RenderScript renderScript, String str, List<Closure> list, List<Input> list2, Future[] futureArr) {
        super(0L, renderScript);
        this.mUseIncSupp = false;
        this.mNodes = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 23 && renderScript.isUseNative()) {
            throw new RSRuntimeException("ScriptGroup2 not supported in this API level");
        }
        this.mName = str;
        this.mClosures = list;
        this.mInputs2 = list2;
        this.mOutputs2 = futureArr;
        int size = list.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = list.get(i).getID(renderScript);
        }
        setID(renderScript.nScriptGroup2Create(str, renderScript.getApplicationContext().getCacheDir().toString(), jArr));
    }

    public void execute() {
        if (!this.mUseIncSupp) {
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptGroupExecute(getID(renderScript));
            return;
        }
        for (int i = 0; i < this.mNodes.size(); i++) {
            Node node = this.mNodes.get(i);
            for (int i2 = 0; i2 < node.mOutputs.size(); i2++) {
                ConnectLine connectLine = (ConnectLine) node.mOutputs.get(i2);
                if (connectLine.mAllocation == null) {
                    Allocation createTyped = Allocation.createTyped(((BaseObj) this).mRS, connectLine.mAllocationType, Allocation.MipmapControl.MIPMAP_NONE, 1);
                    connectLine.mAllocation = createTyped;
                    for (int i3 = i2 + 1; i3 < node.mOutputs.size(); i3++) {
                        if (((ConnectLine) node.mOutputs.get(i3)).mFrom == connectLine.mFrom) {
                            ((ConnectLine) node.mOutputs.get(i3)).mAllocation = createTyped;
                        }
                    }
                }
            }
        }
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            Node next = it.next();
            Iterator it2 = next.mKernels.iterator();
            while (it2.hasNext()) {
                Script.KernelID kernelID = (Script.KernelID) it2.next();
                Iterator it3 = next.mInputs.iterator();
                Allocation allocation = null;
                while (it3.hasNext()) {
                    ConnectLine connectLine2 = (ConnectLine) it3.next();
                    if (connectLine2.mToK == kernelID) {
                        allocation = connectLine2.mAllocation;
                    }
                }
                for (IO io : this.mInputs) {
                    if (io.mKID == kernelID) {
                        allocation = io.mAllocation;
                    }
                }
                Iterator it4 = next.mOutputs.iterator();
                Allocation allocation2 = null;
                while (it4.hasNext()) {
                    ConnectLine connectLine3 = (ConnectLine) it4.next();
                    if (connectLine3.mFrom == kernelID) {
                        allocation2 = connectLine3.mAllocation;
                    }
                }
                for (IO io2 : this.mOutputs) {
                    if (io2.mKID == kernelID) {
                        allocation2 = io2.mAllocation;
                    }
                }
                kernelID.mScript.forEach(kernelID.mSlot, allocation, allocation2, null);
            }
        }
    }
}
