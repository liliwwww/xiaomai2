package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BeyondBoundsLayoutKt {
    @ExperimentalComposeUiApi
    @Nullable
    /* renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m825searchBeyondBoundsOMvw8(@NotNull FocusTargetModifierNode focusTargetModifierNode, int i, @NotNull Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        int m1507getBeforehoxUOeE;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(function1, "block");
        BeyondBoundsLayout beyondBoundsLayoutParent$ui_release = focusTargetModifierNode.getBeyondBoundsLayoutParent$ui_release();
        if (beyondBoundsLayoutParent$ui_release == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.equals-impl0(i, companion.getUp-dhqQ-8s())) {
            m1507getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1505getAbovehoxUOeE();
        } else if (FocusDirection.equals-impl0(i, companion.getDown-dhqQ-8s())) {
            m1507getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1508getBelowhoxUOeE();
        } else if (FocusDirection.equals-impl0(i, companion.getLeft-dhqQ-8s())) {
            m1507getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1509getLefthoxUOeE();
        } else if (FocusDirection.equals-impl0(i, companion.getRight-dhqQ-8s())) {
            m1507getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1510getRighthoxUOeE();
        } else if (FocusDirection.equals-impl0(i, companion.getNext-dhqQ-8s())) {
            m1507getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1506getAfterhoxUOeE();
        } else {
            if (!FocusDirection.equals-impl0(i, companion.getPrevious-dhqQ-8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            m1507getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m1507getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent$ui_release.m1504layouto7g1Pn8(m1507getBeforehoxUOeE, function1);
    }
}
