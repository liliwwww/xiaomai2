package androidx.renderscript;

import androidx.renderscript.ScriptGroup;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ScriptGroup$Future {
    ScriptGroup.Closure mClosure;
    Script$FieldID mFieldID;
    Object mValue;

    ScriptGroup$Future(ScriptGroup.Closure closure, Script$FieldID script$FieldID, Object obj) {
        this.mClosure = closure;
        this.mFieldID = script$FieldID;
        this.mValue = obj;
    }

    ScriptGroup.Closure getClosure() {
        return this.mClosure;
    }

    Script$FieldID getFieldID() {
        return this.mFieldID;
    }

    Object getValue() {
        return this.mValue;
    }
}
