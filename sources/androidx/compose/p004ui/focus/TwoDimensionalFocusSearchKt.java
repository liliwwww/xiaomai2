package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.focus.FocusDirection;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.BeyondBoundsLayout;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TwoDimensionalFocusSearchKt {

    @NotNull
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";

    @NotNull
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
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
    private static final FocusTargetModifierNode activeNode(FocusTargetModifierNode focusTargetModifierNode) {
        if (!(focusTargetModifierNode.getFocusState() == FocusStateImpl.ActiveParent)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetModifierNode);
        if (findActiveFocusNode != null) {
            return findActiveFocusNode;
        }
        throw new IllegalStateException(NoActiveChild.toString());
    }

    /* renamed from: beamBeats-I7lrPNg, reason: not valid java name */
    private static final boolean m2515beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i, rect)) {
            return false;
        }
        if (beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i, rect)) {
            FocusDirection.Companion companion = FocusDirection.Companion;
            if (!FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s()) && !FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s()) && beamBeats_I7lrPNg$majorAxisDistance$8(rect2, i, rect) >= beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i, rect)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!(FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s()))) {
            if (!(FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if (rect.getRight() > rect2.getLeft() && rect.getLeft() < rect2.getRight()) {
                return true;
            }
        } else if (rect.getBottom() > rect2.getTop() && rect.getTop() < rect2.getBottom()) {
            return true;
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s())) {
            if (rect2.getLeft() >= rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
            if (rect2.getRight() <= rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s())) {
            if (rect2.getTop() >= rect.getBottom()) {
                return true;
            }
        } else {
            if (!FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if (rect2.getBottom() <= rect.getTop()) {
                return true;
            }
        }
        return false;
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$8(Rect rect, int i, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s())) {
            if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else {
                if (!FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i, Rect rect2) {
        float bottom;
        float bottom2;
        float top;
        float top2;
        float f;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s())) {
            if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else {
                if (!FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            }
            f = bottom - bottom2;
            return Math.max(1.0f, f);
        }
        top = rect2.getLeft();
        top2 = rect.getLeft();
        f = top - top2;
        return Math.max(1.0f, f);
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }

    @ExperimentalComposeUiApi
    /* renamed from: findBestCandidate-4WY_MpI, reason: not valid java name */
    private static final FocusTargetModifierNode m2516findBestCandidate4WY_MpI(MutableVector<FocusTargetModifierNode> mutableVector, Rect rect, int i) {
        Rect translate;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s())) {
            translate = rect.translate(rect.getWidth() + 1, 0.0f);
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
            translate = rect.translate(-(rect.getWidth() + 1), 0.0f);
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s())) {
            translate = rect.translate(0.0f, rect.getHeight() + 1);
        } else {
            if (!FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            translate = rect.translate(0.0f, -(rect.getHeight() + 1));
        }
        FocusTargetModifierNode focusTargetModifierNode = null;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i2 = 0;
            FocusTargetModifierNode[] content = mutableVector.getContent();
            do {
                FocusTargetModifierNode focusTargetModifierNode2 = content[i2];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetModifierNode2)) {
                    Rect focusRect = FocusTraversalKt.focusRect(focusTargetModifierNode2);
                    if (m2519isBetterCandidateI7lrPNg(focusRect, translate, rect, i)) {
                        focusTargetModifierNode = focusTargetModifierNode2;
                        translate = focusRect;
                    }
                }
                i2++;
            } while (i2 < size);
        }
        return focusTargetModifierNode;
    }

    @ExperimentalComposeUiApi
    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8, reason: not valid java name */
    public static final boolean m2517findChildCorrespondingToFocusEnterOMvw8(@NotNull FocusTargetModifierNode focusTargetModifierNode, int i, @NotNull Function1<? super FocusTargetModifierNode, Boolean> function1) {
        Rect bottomRight;
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "$this$findChildCorrespondingToFocusEnter");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        Boolean findFocusTarget$ui_release = ((FocusRequester) focusTargetModifierNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2476boximpl(i))).findFocusTarget$ui_release(function1);
        if (findFocusTarget$ui_release != null) {
            return findFocusTarget$ui_release.booleanValue();
        }
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        FocusTraversalKt.collectAccessibleChildren(focusTargetModifierNode, mutableVector);
        if (mutableVector.getSize() <= 1) {
            FocusTargetModifierNode focusTargetModifierNode2 = (FocusTargetModifierNode) (mutableVector.isEmpty() ? null : mutableVector.getContent()[0]);
            if (focusTargetModifierNode2 != null) {
                return ((Boolean) function1.invoke(focusTargetModifierNode2)).booleanValue();
            }
            return false;
        }
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2488getEnterdhqQ8s())) {
            i = companion.m2495getRightdhqQ8s();
        }
        if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
            bottomRight = topLeft(FocusTraversalKt.focusRect(focusTargetModifierNode));
        } else {
            if (!(FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            bottomRight = bottomRight(FocusTraversalKt.focusRect(focusTargetModifierNode));
        }
        FocusTargetModifierNode m2516findBestCandidate4WY_MpI = m2516findBestCandidate4WY_MpI(mutableVector, bottomRight, i);
        if (m2516findBestCandidate4WY_MpI != null) {
            return ((Boolean) function1.invoke(m2516findBestCandidate4WY_MpI)).booleanValue();
        }
        return false;
    }

    @ExperimentalComposeUiApi
    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    private static final boolean m2518generateAndSearchChildren4C6V_qg(final FocusTargetModifierNode focusTargetModifierNode, final FocusTargetModifierNode focusTargetModifierNode2, final int i, final Function1<? super FocusTargetModifierNode, Boolean> function1) {
        if (m2520searchChildren4C6V_qg(focusTargetModifierNode, focusTargetModifierNode2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2475searchBeyondBoundsOMvw8(focusTargetModifierNode, i, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Nullable
            public final Boolean invoke(@NotNull BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                boolean m2520searchChildren4C6V_qg;
                Intrinsics.checkNotNullParameter(beyondBoundsScope, "$this$searchBeyondBounds");
                m2520searchChildren4C6V_qg = TwoDimensionalFocusSearchKt.m2520searchChildren4C6V_qg(FocusTargetModifierNode.this, focusTargetModifierNode2, i, function1);
                Boolean valueOf = Boolean.valueOf(m2520searchChildren4C6V_qg);
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

    /* renamed from: isBetterCandidate-I7lrPNg, reason: not valid java name */
    private static final boolean m2519isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (isBetterCandidate_I7lrPNg$isCandidate(rect, i, rect3)) {
            if (!isBetterCandidate_I7lrPNg$isCandidate(rect2, i, rect3) || m2515beamBeatsI7lrPNg(rect3, rect, rect2, i)) {
                return true;
            }
            if (!m2515beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i, Rect rect2) {
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s())) {
            if ((rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
            if ((rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s())) {
            if ((rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop()) {
                return true;
            }
        } else {
            if (!FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            if ((rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom()) {
                return true;
            }
        }
        return false;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i, Rect rect2) {
        float top;
        float bottom;
        float top2;
        float bottom2;
        float f;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (!FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s())) {
            if (FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else {
                if (!FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s())) {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                top = rect.getTop();
                bottom = rect2.getBottom();
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        top2 = rect2.getLeft();
        bottom2 = rect.getRight();
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float left;
        float left2;
        float width;
        FocusDirection.Companion companion = FocusDirection.Companion;
        if (FocusDirection.m2479equalsimpl0(i, companion.m2491getLeftdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2495getRightdhqQ8s())) {
            f = 2;
            left = rect2.getTop() + (rect2.getHeight() / f);
            left2 = rect.getTop();
            width = rect.getHeight();
        } else {
            if (!(FocusDirection.m2479equalsimpl0(i, companion.m2496getUpdhqQ8s()) ? true : FocusDirection.m2479equalsimpl0(i, companion.m2487getDowndhqQ8s()))) {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = 2;
            left = rect2.getLeft() + (rect2.getWidth() / f);
            left2 = rect.getLeft();
            width = rect.getWidth();
        }
        return left - (left2 + (width / f));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        long abs = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i, rect));
        long abs2 = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i, rect));
        return (13 * abs * abs) + (abs2 * abs2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalComposeUiApi
    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m2520searchChildren4C6V_qg(FocusTargetModifierNode focusTargetModifierNode, FocusTargetModifierNode focusTargetModifierNode2, int i, Function1<? super FocusTargetModifierNode, Boolean> function1) {
        FocusTargetModifierNode m2516findBestCandidate4WY_MpI;
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
        while (mutableVector.isNotEmpty() && (m2516findBestCandidate4WY_MpI = m2516findBestCandidate4WY_MpI(mutableVector, FocusTraversalKt.focusRect(focusTargetModifierNode2), i)) != null) {
            if (m2516findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getCanFocus()) {
                return ((Boolean) function1.invoke(m2516findBestCandidate4WY_MpI)).booleanValue();
            }
            Boolean findFocusTarget$ui_release = ((FocusRequester) m2516findBestCandidate4WY_MpI.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2476boximpl(i))).findFocusTarget$ui_release(function1);
            if (findFocusTarget$ui_release != null) {
                return findFocusTarget$ui_release.booleanValue();
            }
            if (m2518generateAndSearchChildren4C6V_qg(m2516findBestCandidate4WY_MpI, focusTargetModifierNode2, i, function1)) {
                return true;
            }
            mutableVector.remove(m2516findBestCandidate4WY_MpI);
        }
        return false;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    @ExperimentalComposeUiApi
    /* renamed from: twoDimensionalFocusSearch--OM-vw8, reason: not valid java name */
    public static final boolean m2521twoDimensionalFocusSearchOMvw8(@NotNull FocusTargetModifierNode focusTargetModifierNode, int i, @NotNull Function1<? super FocusTargetModifierNode, Boolean> function1) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(function1, "onFound");
        FocusStateImpl focusStateImpl$ui_release = focusTargetModifierNode.getFocusStateImpl$ui_release();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i2 = iArr[focusStateImpl$ui_release.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return m2517findChildCorrespondingToFocusEnterOMvw8(focusTargetModifierNode, i, function1);
            }
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            if (focusTargetModifierNode.fetchFocusProperties$ui_release().getCanFocus()) {
                return ((Boolean) function1.invoke(focusTargetModifierNode)).booleanValue();
            }
            return false;
        }
        FocusTargetModifierNode activeChild = FocusTraversalKt.getActiveChild(focusTargetModifierNode);
        if (activeChild == null) {
            throw new IllegalStateException(NoActiveChild.toString());
        }
        int i3 = iArr[activeChild.getFocusStateImpl$ui_release().ordinal()];
        if (i3 == 1) {
            if (m2521twoDimensionalFocusSearchOMvw8(activeChild, i, function1)) {
                return true;
            }
            Boolean findFocusTarget$ui_release = ((FocusRequester) activeChild.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m2476boximpl(i))).findFocusTarget$ui_release(function1);
            return findFocusTarget$ui_release != null ? findFocusTarget$ui_release.booleanValue() : m2518generateAndSearchChildren4C6V_qg(focusTargetModifierNode, activeNode(activeChild), i, function1);
        }
        if (i3 == 2 || i3 == 3) {
            return m2518generateAndSearchChildren4C6V_qg(focusTargetModifierNode, activeChild, i, function1);
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException(NoActiveChild.toString());
    }
}
