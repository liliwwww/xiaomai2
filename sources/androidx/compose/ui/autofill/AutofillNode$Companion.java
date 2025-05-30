package androidx.compose.ui.autofill;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AutofillNode$Companion {
    private AutofillNode$Companion() {
    }

    public /* synthetic */ AutofillNode$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int generateId() {
        int access$getPreviousId$cp;
        synchronized (this) {
            AutofillNode$Companion autofillNode$Companion = AutofillNode.Companion;
            AutofillNode.access$setPreviousId$cp(AutofillNode.access$getPreviousId$cp() + 1);
            access$getPreviousId$cp = AutofillNode.access$getPreviousId$cp();
        }
        return access$getPreviousId$cp;
    }
}
