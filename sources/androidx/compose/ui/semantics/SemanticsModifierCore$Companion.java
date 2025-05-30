package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SemanticsModifierCore$Companion {
    private SemanticsModifierCore$Companion() {
    }

    public /* synthetic */ SemanticsModifierCore$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int generateSemanticsId() {
        return SemanticsModifierCore.access$getLastIdentifier$cp().addAndGet(1);
    }
}
