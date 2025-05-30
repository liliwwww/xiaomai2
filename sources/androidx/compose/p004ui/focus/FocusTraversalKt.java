package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.NodeChain;
import androidx.compose.p004ui.node.NodeCoordinator;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class FocusTraversalKt {

    @NotNull
    private static final String invalidFocusDirection = "Invalid FocusDirection";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bf A[SYNTHETIC] */
    @androidx.compose.p004ui.ExperimentalComposeUiApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void collectAccessibleChildren(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.node.DelegatableNode r9, @org.jetbrains.annotations.NotNull androidx.compose.runtime.collection.MutableVector<androidx.compose.p004ui.focus.FocusTargetModifierNode> r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "accessibleChildren"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.p004ui.node.NodeKind.m4398constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto Lca
            r1 = 16
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r1 = new androidx.compose.ui.Modifier.Node[r1]
            r3 = 0
            r2.<init>(r1, r3)
            androidx.compose.ui.Modifier$Node r1 = r9.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
            if (r1 != 0) goto L36
            androidx.compose.ui.Modifier$Node r9 = r9.getNode()
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r9)
            goto L39
        L36:
            r2.add(r1)
        L39:
            boolean r9 = r2.isNotEmpty()
            if (r9 == 0) goto Lc9
            int r9 = r2.getSize()
            r1 = 1
            int r9 = r9 - r1
            java.lang.Object r9 = r2.removeAt(r9)
            androidx.compose.ui.Modifier$Node r9 = (androidx.compose.ui.Modifier.Node) r9
            int r4 = r9.getAggregateChildKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto Lc4
            r4 = r9
        L53:
            if (r4 == 0) goto Lc4
            int r5 = r4.getKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto Lbf
            boolean r5 = r4 instanceof androidx.compose.p004ui.focus.FocusTargetModifierNode
            if (r5 == 0) goto Lbc
            r5 = r4
            androidx.compose.ui.focus.FocusTargetModifierNode r5 = (androidx.compose.p004ui.focus.FocusTargetModifierNode) r5
            androidx.compose.ui.focus.FocusProperties r6 = r5.fetchFocusProperties$ui_release()
            boolean r6 = r6.getCanFocus()
            if (r6 == 0) goto L72
            r10.add(r5)
        L70:
            r5 = 0
            goto Lbd
        L72:
            androidx.compose.ui.focus.FocusProperties r5 = r5.fetchFocusProperties$ui_release()
            kotlin.jvm.functions.Function1 r5 = r5.getEnter()
            androidx.compose.ui.focus.FocusDirection$Companion r6 = androidx.compose.p004ui.focus.FocusDirection.Companion
            int r6 = r6.m2488getEnterdhqQ8s()
            androidx.compose.ui.focus.FocusDirection r6 = androidx.compose.p004ui.focus.FocusDirection.m2476boximpl(r6)
            java.lang.Object r5 = r5.invoke(r6)
            androidx.compose.ui.focus.FocusRequester r5 = (androidx.compose.p004ui.focus.FocusRequester) r5
            androidx.compose.ui.focus.FocusRequester$Companion r6 = androidx.compose.p004ui.focus.FocusRequester.Companion
            androidx.compose.ui.focus.FocusRequester r7 = r6.getCancel()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r7)
            if (r7 == 0) goto L97
        L96:
            goto L70
        L97:
            androidx.compose.ui.focus.FocusRequester r6 = r6.getDefault()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r6 == 0) goto La2
            goto Lbc
        La2:
            androidx.compose.runtime.collection.MutableVector r5 = r5.getFocusRequesterNodes$ui_release()
            int r6 = r5.getSize()
            if (r6 <= 0) goto L70
            java.lang.Object[] r5 = r5.getContent()
            r7 = 0
        Lb1:
            r8 = r5[r7]
            androidx.compose.ui.focus.FocusRequesterModifierNode r8 = (androidx.compose.p004ui.focus.FocusRequesterModifierNode) r8
            collectAccessibleChildren(r8, r10)
            int r7 = r7 + r1
            if (r7 < r6) goto Lb1
            goto L96
        Lbc:
            r5 = 1
        Lbd:
            if (r5 == 0) goto L39
        Lbf:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L53
        Lc4:
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r9)
            goto L39
        Lc9:
            return
        Lca:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Check failed."
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.focus.FocusTraversalKt.collectAccessibleChildren(androidx.compose.ui.node.DelegatableNode, androidx.compose.runtime.collection.MutableVector):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
    
        continue;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.p004ui.focus.FocusTargetModifierNode findActiveFocusNode(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.focus.FocusTargetModifierNode r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.ui.focus.FocusStateImpl r0 = r6.getFocusStateImpl$ui_release()
            int[] r1 = androidx.compose.ui.focus.FocusTraversalKt.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L98
            r2 = 2
            if (r0 == r2) goto L98
            r2 = 3
            r3 = 0
            if (r0 == r2) goto L25
            r6 = 4
            if (r0 != r6) goto L1f
            return r3
        L1f:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L25:
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.p004ui.node.NodeKind.m4398constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r2 = r6.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L8c
            r2 = 16
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r2 = new androidx.compose.ui.Modifier.Node[r2]
            r5 = 0
            r4.<init>(r2, r5)
            androidx.compose.ui.Modifier$Node r2 = r6.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getChild$ui_release()
            if (r2 != 0) goto L51
            androidx.compose.ui.Modifier$Node r6 = r6.getNode()
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r4, r6)
            goto L54
        L51:
            r4.add(r2)
        L54:
            boolean r6 = r4.isNotEmpty()
            if (r6 == 0) goto L8b
            int r6 = r4.getSize()
            int r6 = r6 - r1
            java.lang.Object r6 = r4.removeAt(r6)
            androidx.compose.ui.Modifier$Node r6 = (androidx.compose.ui.Modifier.Node) r6
            int r2 = r6.getAggregateChildKindSet$ui_release()
            r2 = r2 & r0
            if (r2 != 0) goto L70
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r4, r6)
            goto L54
        L70:
            if (r6 == 0) goto L54
            int r2 = r6.getKindSet$ui_release()
            r2 = r2 & r0
            if (r2 == 0) goto L86
            boolean r2 = r6 instanceof androidx.compose.p004ui.focus.FocusTargetModifierNode
            if (r2 == 0) goto L54
            androidx.compose.ui.focus.FocusTargetModifierNode r6 = (androidx.compose.p004ui.focus.FocusTargetModifierNode) r6
            androidx.compose.ui.focus.FocusTargetModifierNode r6 = findActiveFocusNode(r6)
            if (r6 == 0) goto L54
            return r6
        L86:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L70
        L8b:
            return r3
        L8c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        L98:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.focus.FocusTraversalKt.findActiveFocusNode(androidx.compose.ui.focus.FocusTargetModifierNode):androidx.compose.ui.focus.FocusTargetModifierNode");
    }

    @Nullable
    public static final FocusTargetModifierNode findNonDeactivatedParent(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1024);
        if (!focusTargetModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = focusTargetModifierNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetModifierNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m4398constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m4398constructorimpl) != 0 && (parent$ui_release instanceof FocusTargetModifierNode)) {
                        FocusTargetModifierNode focusTargetModifierNode2 = (FocusTargetModifierNode) parent$ui_release;
                        if (focusTargetModifierNode2.fetchFocusProperties$ui_release().getCanFocus()) {
                            return focusTargetModifierNode2;
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return null;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final Rect focusRect(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Rect localBoundingBoxOf;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        NodeCoordinator coordinator$ui_release = focusTargetModifierNode.getCoordinator$ui_release();
        return (coordinator$ui_release == null || (localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(coordinator$ui_release).localBoundingBoxOf(coordinator$ui_release, false)) == null) ? Rect.Companion.getZero() : localBoundingBoxOf;
    }

    /* renamed from: focusSearch-sMXa3k8, reason: not valid java name */
    public static final boolean m2509focusSearchsMXa3k8(@NotNull FocusTargetModifierNode focusTargetModifierNode, int i, @NotNull LayoutDirection layoutDirection, @NotNull Function1<? super FocusTargetModifierNode, Boolean> function1) {
        int m2491getLeftdhqQ8s;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2492getNextdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2494getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m2512oneDimensionalFocusSearchOMvw8(focusTargetModifierNode, i, function1);
        }
        if (FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
            return TwoDimensionalFocusSearchKt.m2521twoDimensionalFocusSearchOMvw8(focusTargetModifierNode, i, function1);
        }
        if (!FocusDirection.m2479equalsimpl0(i, companion.m2488getEnterdhqQ8s())) {
            if (!FocusDirection.m2479equalsimpl0(i, companion.m2489getExitdhqQ8s())) {
                throw new IllegalStateException(invalidFocusDirection.toString());
            }
            FocusTargetModifierNode findActiveFocusNode = findActiveFocusNode(focusTargetModifierNode);
            FocusTargetModifierNode findNonDeactivatedParent = findActiveFocusNode != null ? findNonDeactivatedParent(findActiveFocusNode) : null;
            if (findNonDeactivatedParent == null || Intrinsics.areEqual(findNonDeactivatedParent, focusTargetModifierNode)) {
                return false;
            }
            return ((Boolean) function1.invoke(findNonDeactivatedParent)).booleanValue();
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        if (i2 == 1) {
            m2491getLeftdhqQ8s = companion.m2491getLeftdhqQ8s();
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            m2491getLeftdhqQ8s = companion.m2495getRightdhqQ8s();
        }
        FocusTargetModifierNode findActiveFocusNode2 = findActiveFocusNode(focusTargetModifierNode);
        if (findActiveFocusNode2 != null) {
            return TwoDimensionalFocusSearchKt.m2521twoDimensionalFocusSearchOMvw8(findActiveFocusNode2, m2491getLeftdhqQ8s, function1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0040, code lost:
    
        continue;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.p004ui.focus.FocusTargetModifierNode getActiveChild(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.focus.FocusTargetModifierNode r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.ui.Modifier$Node r0 = r6.getNode()
            boolean r0 = r0.isAttached()
            r1 = 0
            if (r0 != 0) goto L11
            return r1
        L11:
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.p004ui.node.NodeKind.m4398constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r2 = r6.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L88
            r2 = 16
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r2 = new androidx.compose.ui.Modifier.Node[r2]
            r4 = 0
            r3.<init>(r2, r4)
            androidx.compose.ui.Modifier$Node r2 = r6.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getChild$ui_release()
            if (r2 != 0) goto L3d
            androidx.compose.ui.Modifier$Node r6 = r6.getNode()
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r3, r6)
            goto L40
        L3d:
            r3.add(r2)
        L40:
            boolean r6 = r3.isNotEmpty()
            if (r6 == 0) goto L87
            int r6 = r3.getSize()
            r2 = 1
            int r6 = r6 - r2
            java.lang.Object r6 = r3.removeAt(r6)
            androidx.compose.ui.Modifier$Node r6 = (androidx.compose.ui.Modifier.Node) r6
            int r4 = r6.getAggregateChildKindSet$ui_release()
            r4 = r4 & r0
            if (r4 != 0) goto L5d
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r3, r6)
            goto L40
        L5d:
            if (r6 == 0) goto L40
            int r4 = r6.getKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto L82
            boolean r4 = r6 instanceof androidx.compose.p004ui.focus.FocusTargetModifierNode
            if (r4 == 0) goto L40
            androidx.compose.ui.focus.FocusTargetModifierNode r6 = (androidx.compose.p004ui.focus.FocusTargetModifierNode) r6
            androidx.compose.ui.focus.FocusStateImpl r4 = r6.getFocusStateImpl$ui_release()
            int[] r5 = androidx.compose.ui.focus.FocusTraversalKt.WhenMappings.$EnumSwitchMapping$1
            int r4 = r4.ordinal()
            r4 = r5[r4]
            if (r4 == r2) goto L81
            r2 = 2
            if (r4 == r2) goto L81
            r2 = 3
            if (r4 == r2) goto L81
            goto L40
        L81:
            return r6
        L82:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L5d
        L87:
            return r1
        L88:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.focus.FocusTraversalKt.getActiveChild(androidx.compose.ui.focus.FocusTargetModifierNode):androidx.compose.ui.focus.FocusTargetModifierNode");
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getActiveChild$annotations(FocusTargetModifierNode focusTargetModifierNode) {
    }

    public static final boolean isEligibleForFocusSearch(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        LayoutNode layoutNode;
        LayoutNode layoutNode2;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<this>");
        NodeCoordinator coordinator$ui_release = focusTargetModifierNode.getCoordinator$ui_release();
        if ((coordinator$ui_release == null || (layoutNode2 = coordinator$ui_release.getLayoutNode()) == null || !layoutNode2.isPlaced()) ? false : true) {
            NodeCoordinator coordinator$ui_release2 = focusTargetModifierNode.getCoordinator$ui_release();
            if ((coordinator$ui_release2 == null || (layoutNode = coordinator$ui_release2.getLayoutNode()) == null || !layoutNode.isAttached()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void isEligibleForFocusSearch$annotations(FocusTargetModifierNode focusTargetModifierNode) {
    }
}
