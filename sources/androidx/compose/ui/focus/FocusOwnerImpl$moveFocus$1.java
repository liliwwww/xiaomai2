package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FocusOwnerImpl$moveFocus$1 extends Lambda implements Function1<FocusTargetModifierNode, Boolean> {
    public static final FocusOwnerImpl$moveFocus$1 INSTANCE = new FocusOwnerImpl$moveFocus$1();

    FocusOwnerImpl$moveFocus$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "it");
        return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetModifierNode));
    }
}
