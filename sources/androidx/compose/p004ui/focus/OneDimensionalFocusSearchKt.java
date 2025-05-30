package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.layout.BeyondBoundsLayout;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class OneDimensionalFocusSearchKt {

    @NotNull
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";

    @NotNull
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @ExperimentalComposeUiApi
    private static final boolean backwardFocusSearch(FocusTargetModifierNode focusTargetModifierNode, Function1<? super FocusTargetModifierNode, Boolean> function1) {
        FocusStateImpl focusStateImpl$ui_release = focusTargetModifierNode.getFocusStateImpl$ui_release();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i = iArr[focusStateImpl$ui_release.ordinal()];
        if (i == 1) {
            FocusTargetModifierNode activeChild = FocusTraversalKt.getActiveChild(focusTargetModifierNode);
            if (activeChild == null) {
                throw new IllegalStateException(NoActiveChild.toString());
            }
            int i2 = iArr[activeChild.getFocusStateImpl$ui_release().ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    return m2511generateAndSearchChildren4C6V_qg(focusTargetModifierNode, activeChild, FocusDirection.Companion.m2494getPreviousdhqQ8s(), function1);
                }
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException(NoActiveChild.toString());
            }
            if (!backwardFocusSearch(activeChild, function1) && !m2511generateAndSearchChildren4C6V_qg(focusTargetModifierNode, activeChild, FocusDirection.Companion.m2494getPreviousdhqQ8s(), function1) && (!focusTargetModifierNode.fetchFocusProperties$ui_release().getCanFocus() || !((Boolean) function1.invoke(activeChild)).booleanValue())) {
                return false;
            }
        } else {
            if (i == 2 || i == 3) {
                return pickChildForBackwardSearch(focusTargetModifierNode, function1);
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (!pickChildForBackwardSearch(focusTargetModifierNode, function1)) {
                if (!(focusTargetModifierNode.fetchFocusProperties$ui_release().getCanFocus() ? ((Boolean) function1.invoke(focusTargetModifierNode)).booleanValue() : false)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            if (z) {
                function1.invoke(mutableVector.getContent()[first]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[first], t)) {
                z = true;
            }
            if (first == last) {
                return;
            } else {
                first++;
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first > last) {
            return;
        }
        while (true) {
            if (z) {
                function1.invoke(mutableVector.getContent()[last]);
            }
            if (Intrinsics.areEqual(mutableVector.getContent()[last], t)) {
                z = true;
            }
            if (last == first) {
                return;
            } else {
                last--;
            }
        }
    }

    @ExperimentalComposeUiApi
    private static final boolean forwardFocusSearch(FocusTargetModifierNode focusTargetModifierNode, Function1<? super FocusTargetModifierNode, Boolean> function1) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetModifierNode.getFocusStateImpl$ui_release().ordinal()];
        if (i == 1) {
            FocusTargetModifierNode activeChild = FocusTraversalKt.getActiveChild(focusTargetModifierNode);
            if (activeChild != null) {
                return forwardFocusSearch(activeChild, function1) || m2511generateAndSearchChildren4C6V_qg(focusTargetModifierNode, activeChild, FocusDirection.Companion.m2492getNextdhqQ8s(), function1);
            }
            throw new IllegalStateException(NoActiveChild.toString());
        }
        if (i == 2 || i == 3) {
            return pickChildForForwardSearch(focusTargetModifierNode, function1);
        }
        if (i == 4) {
            return focusTargetModifierNode.fetchFocusProperties$ui_release().getCanFocus() ? ((Boolean) function1.invoke(focusTargetModifierNode)).booleanValue() : pickChildForForwardSearch(focusTargetModifierNode, function1);
        }
        throw new NoWhenBranchMatchedException();
    }

    @ExperimentalComposeUiApi
    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m2511generateAndSearchChildren4C6V_qg(final FocusTargetModifierNode focusTargetModifierNode, final FocusTargetModifierNode focusTargetModifierNode2, final int i, final Function1<? super FocusTargetModifierNode, Boolean> function1) {
        if (m2513searchChildren4C6V_qg(focusTargetModifierNode, focusTargetModifierNode2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2475searchBeyondBoundsOMvw8(focusTargetModifierNode, i, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Nullable
            public final Boolean invoke(@NotNull BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                boolean m2513searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(beyondBoundsScope, "$this$searchBeyondBounds");
                m2513searchChildren4C6V_qg = OneDimensionalFocusSearchKt.m2513searchChildren4C6V_qg(FocusTargetModifierNode.this, focusTargetModifierNode2, i, function1);
                Boolean valueOf = Boolean.valueOf(m2513searchChildren4C6V_qg);
                if (valueOf.booleanValue() || !beyondBoundsScope.getHasMoreContent()) {
                    return valueOf;
                }
                return null;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean isRoot(FocusTargetModifierNode focusTargetModifierNode) {
        Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(focusTargetModifierNode, NodeKind.m4398constructorimpl(1024));
        if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
            nearestAncestor = null;
        }
        return ((FocusTargetModifierNode) nearestAncestor) == null;
    }

    @ExperimentalComposeUiApi
    /* renamed from: oneDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m2512oneDimensionalFocusSearchOMvw8(@NotNull FocusTargetModifierNode focusTargetModifierNode, int i, @NotNull Function1<? super FocusTargetModifierNode, Boolean> function1) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2492getNextdhqQ8s())) {
            return forwardFocusSearch(focusTargetModifierNode, function1);
        }
        if (FocusDirection.m2479equalsimpl0(i, companion.m2494getPreviousdhqQ8s())) {
            return backwardFocusSearch(focusTargetModifierNode, function1);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    @ExperimentalComposeUiApi
    private static final boolean pickChildForBackwardSearch(FocusTargetModifierNode focusTargetModifierNode, Function1<? super FocusTargetModifierNode, Boolean> function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1024);
        if (!focusTargetModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetModifierNode.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m4398constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet$ui_release() & m4398constructorimpl) == 0) {
                        node = node.getChild$ui_release();
                    } else if (node instanceof FocusTargetModifierNode) {
                        mutableVector.add((FocusTargetModifierNode) node);
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector.getContent();
            do {
                FocusTargetModifierNode focusTargetModifierNode2 = (FocusTargetModifierNode) content[i];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetModifierNode2) && backwardFocusSearch(focusTargetModifierNode2, function1)) {
                    return true;
                }
                i--;
            } while (i >= 0);
        }
        return false;
    }

    @ExperimentalComposeUiApi
    private static final boolean pickChildForForwardSearch(FocusTargetModifierNode focusTargetModifierNode, Function1<? super FocusTargetModifierNode, Boolean> function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1024);
        if (!focusTargetModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetModifierNode.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m4398constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet$ui_release() & m4398constructorimpl) == 0) {
                        node = node.getChild$ui_release();
                    } else if (node instanceof FocusTargetModifierNode) {
                        mutableVector.add((FocusTargetModifierNode) node);
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Object[] content = mutableVector.getContent();
        int i = 0;
        do {
            FocusTargetModifierNode focusTargetModifierNode2 = (FocusTargetModifierNode) content[i];
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetModifierNode2) && forwardFocusSearch(focusTargetModifierNode2, function1)) {
                return true;
            }
            i++;
        } while (i < size);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalComposeUiApi
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m2513searchChildren4C6V_qg(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2, int i, Function1<? super FocusTargetModifierNode, Boolean> function1) {
        if (!(focusTargetModifierNode.getFocusStateImpl$ui_release() == FocusStateImpl.ActiveParent)) {
            throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
        }
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1024);
        if (!focusTargetModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusTargetModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, focusTargetModifierNode.getNode());
        } else {
            mutableVector2.add(child$ui_release);
        }
        while (mutableVector2.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m4398constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet$ui_release() & m4398constructorimpl) == 0) {
                        node = node.getChild$ui_release();
                    } else if (node instanceof FocusTargetModifierNode) {
                        mutableVector.add((FocusTargetModifierNode) node);
                    }
                }
            }
        }
        mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2492getNextdhqQ8s())) {
            IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
            int first = intRange.getFirst();
            int last = intRange.getLast();
            if (first <= last) {
                boolean z = false;
                while (true) {
                    if (z) {
                        FocusTargetModifierNode focusTargetModifierNode3 = (FocusTargetModifierNode) mutableVector.getContent()[first];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetModifierNode3) && forwardFocusSearch(focusTargetModifierNode3, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(mutableVector.getContent()[first], focusTargetModifierNode2)) {
                        z = true;
                    }
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
        } else {
            if (!FocusDirection.m2479equalsimpl0(i, companion.m2494getPreviousdhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            IntRange intRange2 = new IntRange(0, mutableVector.getSize() - 1);
            int first2 = intRange2.getFirst();
            int last2 = intRange2.getLast();
            if (first2 <= last2) {
                boolean z2 = false;
                while (true) {
                    if (z2) {
                        FocusTargetModifierNode focusTargetModifierNode4 = (FocusTargetModifierNode) mutableVector.getContent()[last2];
                        if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetModifierNode4) && backwardFocusSearch(focusTargetModifierNode4, function1)) {
                            return true;
                        }
                    }
                    if (Intrinsics.areEqual(mutableVector.getContent()[last2], focusTargetModifierNode2)) {
                        z2 = true;
                    }
                    if (last2 == first2) {
                        break;
                    }
                    last2--;
                }
            }
        }
        if (FocusDirection.m2479equalsimpl0(i, FocusDirection.Companion.m2492getNextdhqQ8s()) || !focusTargetModifierNode.fetchFocusProperties$ui_release().getCanFocus() || isRoot(focusTargetModifierNode)) {
            return false;
        }
        return ((Boolean) function1.invoke(focusTargetModifierNode)).booleanValue();
    }
}
