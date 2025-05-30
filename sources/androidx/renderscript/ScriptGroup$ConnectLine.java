package androidx.renderscript;

import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ScriptGroup$ConnectLine {
    Allocation mAllocation;
    Type mAllocationType;
    Script.KernelID mFrom;
    Script$FieldID mToF;
    Script.KernelID mToK;

    ScriptGroup$ConnectLine(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
        this.mFrom = kernelID;
        this.mToK = kernelID2;
        this.mAllocationType = type;
    }

    ScriptGroup$ConnectLine(Type type, Script.KernelID kernelID, Script$FieldID script$FieldID) {
        this.mFrom = kernelID;
        this.mToF = script$FieldID;
        this.mAllocationType = type;
    }
}
