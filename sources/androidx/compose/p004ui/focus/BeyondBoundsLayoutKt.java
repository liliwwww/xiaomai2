package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.layout.BeyondBoundsLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    @ExperimentalComposeUiApi
    @Nullable
    /* renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m2475searchBeyondBoundsOMvw8(@NotNull FocusTargetModifierNode focusTargetModifierNode, int i, @NotNull Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        int m4172getBeforehoxUOeE;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "$this$searchBeyondBounds");
        Intrinsics.checkNotNullParameter(function1, "block");
        BeyondBoundsLayout beyondBoundsLayoutParent$ui_release = focusTargetModifierNode.getBeyondBoundsLayoutParent$ui_release();
        if (beyondBoundsLayoutParent$ui_release == null) {
            return null;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s())) {
            m4172getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4170getAbovehoxUOeE();
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
            m4172getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4173getBelowhoxUOeE();
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s())) {
            m4172getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4174getLefthoxUOeE();
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
            m4172getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4175getRighthoxUOeE();
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2492getNextdhqQ8s())) {
            m4172getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4171getAfterhoxUOeE();
        } else {
            if (!FocusDirection.m2479equalsimpl0(i, companion.m2494getPreviousdhqQ8s())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            m4172getBeforehoxUOeE = BeyondBoundsLayout.LayoutDirection.Companion.m4172getBeforehoxUOeE();
        }
        return (T) beyondBoundsLayoutParent$ui_release.mo1503layouto7g1Pn8(m4172getBeforehoxUOeE, function1);
    }
}
