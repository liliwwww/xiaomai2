package androidx.renderscript;

import androidx.renderscript.Script;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ScriptGroup$Node {
    int dagNumber;
    ScriptGroup$Node mNext;
    int mOrder;
    Script mScript;
    boolean mSeen;
    ArrayList<Script.KernelID> mKernels = new ArrayList<>();
    ArrayList<ScriptGroup$ConnectLine> mInputs = new ArrayList<>();
    ArrayList<ScriptGroup$ConnectLine> mOutputs = new ArrayList<>();

    ScriptGroup$Node(Script script) {
        this.mScript = script;
    }
}
