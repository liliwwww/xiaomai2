package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusTransactionsKt {
    @ExperimentalComposeUiApi
    public static final boolean captureFocus(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1) {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Captured);
            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
            return true;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @ExperimentalComposeUiApi
    private static final boolean clearChildFocus(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2) {
        FocusTargetModifierNode activeChild = FocusTraversalKt.getActiveChild(focusTargetModifierNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetModifierNode, z, z2);
    }

    @ExperimentalComposeUiApi
    public static final boolean clearFocus(@NotNull FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1) {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
            }
        } else {
            if (i == 2) {
                if (!z) {
                    return z;
                }
                focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
                if (!z2) {
                    return z;
                }
                FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
                return z;
            }
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (!clearChildFocus(focusTargetModifierNode, z, z2)) {
                    return false;
                }
                focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
                if (z2) {
                    FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
                }
            }
        }
        return true;
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetModifierNode, z, z2);
    }

    @ExperimentalComposeUiApi
    public static final boolean freeFocus(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
            return true;
        }
        if (i == 3 || i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean grantFocus(final FocusTargetModifierNode focusTargetModifierNode) {
        ObserverNodeKt.observeReads(focusTargetModifierNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m830invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m830invoke() {
                FocusTargetModifierNode.this.fetchFocusProperties$ui_release();
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i != 3 && i != 4) {
            return true;
        }
        focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
        return true;
    }

    @ExperimentalComposeUiApi
    public static final boolean requestFocus(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        boolean z;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        if (!focusTargetModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!focusTargetModifierNode.fetchFocusProperties$ui_release().getCanFocus()) {
            return TwoDimensionalFocusSearchKt.findChildCorrespondingToFocusEnter--OM-vw8(focusTargetModifierNode, FocusDirection.Companion.getEnter-dhqQ-8s(), new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$requestFocus$1
                @NotNull
                public final Boolean invoke(@NotNull FocusTargetModifierNode focusTargetModifierNode2) {
                    Intrinsics.checkNotNullParameter(focusTargetModifierNode2, "it");
                    return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetModifierNode2));
                }
            });
        }
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1 || i == 2) {
            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
            return true;
        }
        if (i == 3) {
            z = clearChildFocus$default(focusTargetModifierNode, false, false, 3, null) && grantFocus(focusTargetModifierNode);
            if (z) {
                FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
            }
            return z;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        Modifier$Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.m1660constructorimpl(1024));
        FocusTargetModifierNode focusTargetModifierNode2 = (FocusTargetModifierNode) (nearestAncestor instanceof FocusTargetModifierNode ? nearestAncestor : null);
        if (focusTargetModifierNode2 != null) {
            return requestFocusForChild(focusTargetModifierNode2, focusTargetModifierNode);
        }
        z = requestFocusForOwner(focusTargetModifierNode) && grantFocus(focusTargetModifierNode);
        if (z) {
            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
        }
        return z;
    }

    private static final boolean requestFocusForChild(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2) {
        Modifier$Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode2, NodeKind.m1660constructorimpl(1024));
        if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
            nearestAncestor = null;
        }
        if (!Intrinsics.areEqual((FocusTargetModifierNode) nearestAncestor, focusTargetModifierNode)) {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1) {
            boolean grantFocus = grantFocus(focusTargetModifierNode2);
            if (!grantFocus) {
                return grantFocus;
            }
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.ActiveParent);
            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode2);
            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
            return grantFocus;
        }
        if (i == 2) {
            return false;
        }
        if (i == 3) {
            if (FocusTraversalKt.getActiveChild(focusTargetModifierNode) == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            boolean z = clearChildFocus$default(focusTargetModifierNode, false, false, 3, null) && grantFocus(focusTargetModifierNode2);
            if (z) {
                FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode2);
            }
            return z;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        Modifier$Node nearestAncestor2 = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.m1660constructorimpl(1024));
        FocusTargetModifierNode focusTargetModifierNode3 = (FocusTargetModifierNode) (nearestAncestor2 instanceof FocusTargetModifierNode ? nearestAncestor2 : null);
        if (focusTargetModifierNode3 == null && requestFocusForOwner(focusTargetModifierNode)) {
            focusTargetModifierNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
            FocusEventModifierKt.refreshFocusEventNodes(focusTargetModifierNode);
            return requestFocusForChild(focusTargetModifierNode, focusTargetModifierNode2);
        }
        if (focusTargetModifierNode3 == null || !requestFocusForChild(focusTargetModifierNode3, focusTargetModifierNode)) {
            return false;
        }
        boolean requestFocusForChild = requestFocusForChild(focusTargetModifierNode, focusTargetModifierNode2);
        if (focusTargetModifierNode.getFocusState() == FocusStateImpl.ActiveParent) {
            return requestFocusForChild;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private static final boolean requestFocusForOwner(FocusTargetModifierNode focusTargetModifierNode) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        NodeCoordinator coordinator$ui_release = focusTargetModifierNode.getCoordinator$ui_release();
        if (coordinator$ui_release == null || (layoutNode = coordinator$ui_release.getLayoutNode()) == null || (owner$ui_release = layoutNode.getOwner$ui_release()) == null) {
            throw new IllegalStateException("Owner not initialized.".toString());
        }
        return owner$ui_release.requestFocus();
    }
}
