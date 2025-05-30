package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SemanticsModifierNodeKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final SemanticsConfiguration collapsedSemanticsConfiguration(@NotNull SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        Modifier.Node localChild = DelegatableNodeKt.localChild(semanticsModifierNode, NodeKind.constructor-impl(8));
        if (!(localChild instanceof SemanticsModifierNode)) {
            localChild = null;
        }
        SemanticsModifierNode semanticsModifierNode2 = (SemanticsModifierNode) localChild;
        if (semanticsModifierNode2 == null || semanticsModifierNode.getSemanticsConfiguration().isClearingSemantics()) {
            return semanticsModifierNode.getSemanticsConfiguration();
        }
        SemanticsConfiguration copy = semanticsModifierNode.getSemanticsConfiguration().copy();
        copy.collapsePeer$ui_release(collapsedSemanticsConfiguration(semanticsModifierNode2));
        return copy;
    }

    public static final boolean getUseMinimumTouchTarget(@NotNull SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        return SemanticsConfigurationKt.getOrNull(semanticsModifierNode.getSemanticsConfiguration(), SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static /* synthetic */ void getUseMinimumTouchTarget$annotations(SemanticsModifierNode semanticsModifierNode) {
    }

    @ExperimentalComposeUiApi
    public static final void invalidateSemantics(@NotNull SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        DelegatableNodeKt.requireOwner(semanticsModifierNode).onSemanticsChange();
    }

    @NotNull
    public static final Rect touchBoundsInRoot(@NotNull SemanticsModifierNode semanticsModifierNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "<this>");
        return !semanticsModifierNode.getNode().isAttached() ? Rect.Companion.getZero() : !getUseMinimumTouchTarget(semanticsModifierNode) ? LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.requireCoordinator-64DMado(semanticsModifierNode, NodeKind.constructor-impl(8))) : DelegatableNodeKt.requireCoordinator-64DMado(semanticsModifierNode, NodeKind.constructor-impl(8)).touchBoundsInRoot();
    }
}
