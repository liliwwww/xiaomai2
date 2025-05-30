package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gd2;
import tb.ql3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutNode implements LayoutInfo, Remeasurement, ComposeUiNode, Owner.OnLayoutCompletedListener, OwnerScope {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;

    @NotNull
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;

    @Nullable
    private LayoutNode _foldedParent;

    @Nullable
    private NodeCoordinator _innerLayerCoordinator;

    @Nullable
    private MutableVector<LayoutNode> _unfoldedChildren;

    @NotNull
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;

    @NotNull
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;

    @NotNull
    private final IntrinsicsPolicy intrinsicsPolicy;

    @NotNull
    private UsageByParent intrinsicsUsageByParent;
    private boolean isLookaheadRoot;
    private boolean isPlaced;
    private final boolean isVirtual;

    @NotNull
    private final LayoutNodeLayoutDelegate layoutDelegate;

    @NotNull
    private LayoutDirection layoutDirection;

    @Nullable
    private LookaheadScope mLookaheadScope;

    @NotNull
    private MeasurePolicy measurePolicy;

    @NotNull
    private UsageByParent measuredByParent;

    @NotNull
    private UsageByParent measuredByParentInLookahead;

    @NotNull
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private int nextChildPlaceOrder;

    @NotNull
    private final NodeChain nodes;

    @Nullable
    private Function1<? super Owner, Unit> onAttach;

    @Nullable
    private Function1<? super Owner, Unit> onDetach;

    @Nullable
    private Owner owner;
    private int placeOrder;

    @NotNull
    private UsageByParent previousIntrinsicsUsageByParent;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;
    private final int semanticsId;

    @Nullable
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;

    @NotNull
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private float zIndex;
    private boolean zSortedChildrenInvalidated;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public /* bridge */ /* synthetic */ MeasureResult m2134measure3p2s80s(MeasureScope measureScope, List list, long j) {
            return (MeasureResult) m2135measure3p2s80s(measureScope, (List<? extends Measurable>) list, j);
        }

        @NotNull
        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m2135measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };

    @NotNull
    private static final Function0<LayoutNode> Constructor = Companion.Constructor.1.INSTANCE;

    @NotNull
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long m2133getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.Companion.m2633getZeroMYxV2XQ();
        }

        public float getTouchSlop() {
            return 16.0f;
        }
    };

    @NotNull
    private static final Comparator<LayoutNode> ZComparator = gd2.a;

    /* compiled from: Taobao */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    /* compiled from: Taobao */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {

        @NotNull
        private final String error;

        public NoIntrinsicsMeasurePolicy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
        }

        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m2136maxIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m2137maxIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m2138minIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return ((Number) m2139minIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i)).intValue();
        }

        @NotNull
        /* renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m2136maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m2137maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m2138minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m2139minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    /* compiled from: Taobao */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNode() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public LayoutNode(boolean z, int i) {
        this.isVirtual = z;
        this.semanticsId = i;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2140invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2140invoke() {
                LayoutNode.this.getLayoutDelegate$ui_release().markChildrenDirty();
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.measuredByParent = usageByParent;
        this.measuredByParentInLookahead = usageByParent;
        this.intrinsicsUsageByParent = usageByParent;
        this.previousIntrinsicsUsageByParent = usageByParent;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.Companion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ZComparator$lambda$41(LayoutNode layoutNode, LayoutNode layoutNode2) {
        float f = layoutNode.zIndex;
        float f2 = layoutNode2.zIndex;
        return (f > f2 ? 1 : (f == f2 ? 0 : -1)) == 0 ? Intrinsics.compare(layoutNode.placeOrder, layoutNode2.placeOrder) : Float.compare(f, f2);
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i++;
            } while (i < size);
        }
    }

    private final String debugTreeToString(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i3 = 0;
            do {
                sb.append(content[i3].debugTreeToString(i + 1));
                i3++;
            } while (i3 < size);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "tree.toString()");
        if (i != 0) {
            return sb2;
        }
        String substring = sb2.substring(0, sb2.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final void forEachCoordinator(Function1<? super LayoutModifierNodeCoordinator, Unit> function1) {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            function1.invoke(layoutModifierNodeCoordinator);
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
    }

    private final void forEachCoordinatorIncludingInner(Function1<? super NodeCoordinator, Unit> function1) {
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            function1.invoke(outerCoordinator$ui_release);
        }
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy$ui_release = getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(innerCoordinator$ui_release, wrappedBy$ui_release)) {
                    break;
                }
                if ((innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getLayer() : null) != null) {
                    this._innerLayerCoordinator = innerCoordinator$ui_release;
                    break;
                }
                innerCoordinator$ui_release = innerCoordinator$ui_release != null ? innerCoordinator$ui_release.getWrappedBy$ui_release() : null;
            }
        }
        NodeCoordinator nodeCoordinator = this._innerLayerCoordinator;
        if (nodeCoordinator == null || nodeCoordinator.getLayer() != null) {
            return nodeCoordinator;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    private final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    @PublishedApi
    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    private final void invalidateFocusOnAttach() {
        if (this.nodes.has$ui_release(NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) | NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) | NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_VIEW_SCROLLED))) {
            for (Modifier.Node head$ui_release = this.nodes.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if (((NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) & head$ui_release.getKindSet$ui_release()) != 0) | ((NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) & head$ui_release.getKindSet$ui_release()) != 0) | ((NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_VIEW_SCROLLED) & head$ui_release.getKindSet$ui_release()) != 0)) {
                    NodeKindKt.autoInvalidateInsertedNode(head$ui_release);
                }
            }
        }
    }

    private final void invalidateFocusOnDetach() {
        if (this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END))) {
            for (FocusTargetModifierNode tail$ui_release = this.nodes.getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if (((NodeKind.constructor-impl(AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) & tail$ui_release.getKindSet$ui_release()) != 0) && (tail$ui_release instanceof FocusTargetModifierNode)) {
                    FocusTargetModifierNode focusTargetModifierNode = tail$ui_release;
                    if (focusTargetModifierNode.getFocusState().isFocused()) {
                        LayoutNodeKt.requireOwner(this).getFocusOwner().clearFocus(true, false);
                        focusTargetModifierNode.scheduleInvalidationForFocusEvents$ui_release();
                    }
                }
            }
        }
    }

    public static /* synthetic */ void invalidateSubtree$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        layoutNode.invalidateSubtree(z);
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode parent$ui_release;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (parent$ui_release = getParent$ui_release()) == null) {
            return;
        }
        parent$ui_release.unfoldedVirtualChildrenListDirty = true;
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m2127lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m2146getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m2131lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean isPlaced = isPlaced();
        this.isPlaced = true;
        if (!isPlaced) {
            if (getMeasurePending$ui_release()) {
                requestRemeasure$ui_release(true);
            } else if (getLookaheadMeasurePending$ui_release()) {
                requestLookaheadRemeasure$ui_release(true);
            }
        }
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            if (outerCoordinator$ui_release.getLastLayerDrawingWasSkipped$ui_release()) {
                outerCoordinator$ui_release.invalidateLayer();
            }
        }
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.placeOrder != Integer.MAX_VALUE) {
                    layoutNode.markNodeAndSubtreeAsPlaced();
                    rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                }
                i++;
            } while (i < size);
        }
    }

    private final void markSubtreeAsNotPlaced() {
        if (isPlaced()) {
            int i = 0;
            this.isPlaced = false;
            MutableVector<LayoutNode> mutableVector = get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                do {
                    content[i].markSubtreeAsNotPlaced();
                    i++;
                } while (i < size);
            }
        }
    }

    private final void onChildRemoved(LayoutNode layoutNode) {
        if (layoutNode.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(r0.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            layoutNode.detach$ui_release();
        }
        layoutNode._foldedParent = null;
        layoutNode.getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> vector = layoutNode._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                int i = 0;
                LayoutNode[] content = vector.getContent();
                do {
                    content[i].getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
                    i++;
                } while (i < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                MutableVector<LayoutNode> mutableVector2 = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector2;
                mutableVector = mutableVector2;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                LayoutNode[] content = vector.getContent();
                do {
                    LayoutNode layoutNode = content[i];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i++;
                } while (i < size);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m2128remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m2145getLastConstraintsDWUhwKw();
        }
        return layoutNode.m2132remeasure_Sx5XlM$ui_release(constraints);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z);
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRemeasure$ui_release(z);
    }

    private final void setMLookaheadScope(LookaheadScope lookaheadScope) {
        if (Intrinsics.areEqual(lookaheadScope, this.mLookaheadScope)) {
            return;
        }
        this.mLookaheadScope = lookaheadScope;
        this.layoutDelegate.onLookaheadScopeChanged$ui_release(lookaheadScope);
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            outerCoordinator$ui_release.updateLookaheadScope$ui_release(lookaheadScope);
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        if (this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(4)) && !this.nodes.has-H91voCI$ui_release(NodeKind.constructor-impl(2))) {
            return true;
        }
        for (Modifier.Node head$ui_release = this.nodes.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            if (((NodeKind.constructor-impl(2) & head$ui_release.getKindSet$ui_release()) != 0) && (head$ui_release instanceof LayoutModifierNode) && DelegatableNodeKt.requireCoordinator-64DMado(head$ui_release, NodeKind.constructor-impl(2)).getLayer() != null) {
                return false;
            }
            if ((NodeKind.constructor-impl(4) & head$ui_release.getKindSet$ui_release()) != 0) {
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void attach$ui_release(@org.jetbrains.annotations.NotNull androidx.compose.ui.node.Owner r7) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    public final void checkChildrenPlaceOrderForUpdates$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.previousPlaceOrder != layoutNode.placeOrder) {
                    onZSortedChildrenInvalidated$ui_release();
                    invalidateLayer$ui_release();
                    if (layoutNode.placeOrder == Integer.MAX_VALUE) {
                        layoutNode.markSubtreeAsNotPlaced();
                    }
                }
                i++;
            } while (i < size);
        }
    }

    public final void clearPlaceOrder$ui_release() {
        int i = 0;
        this.nextChildPlaceOrder = 0;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = content[i];
                layoutNode.previousPlaceOrder = layoutNode.placeOrder;
                layoutNode.placeOrder = Integer.MAX_VALUE;
                if (layoutNode.measuredByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.measuredByParent = UsageByParent.NotUsed;
                }
                i++;
            } while (i < size);
        }
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    public final void detach$ui_release() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            sb.append(parent$ui_release != null ? debugTreeToString$default(parent$ui_release, 0, 1, null) : null);
            throw new IllegalStateException(sb.toString().toString());
        }
        invalidateFocusOnDetach();
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            parent$ui_release2.invalidateMeasurements$ui_release();
            this.measuredByParent = UsageByParent.NotUsed;
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            outerCoordinator$ui_release.detach();
        }
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner.onSemanticsChange();
        }
        this.nodes.detach$ui_release();
        owner.onDetach(this);
        this.owner = null;
        this.depth = 0;
        MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
        int size = vector.getSize();
        if (size > 0) {
            LayoutNode[] content = vector.getContent();
            int i = 0;
            do {
                content[i].detach$ui_release();
                i++;
            } while (i < size);
        }
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        if (getLayoutState$ui_release() != LayoutState.Idle || getLayoutPending$ui_release() || getMeasurePending$ui_release() || !isPlaced()) {
            return;
        }
        NodeChain nodeChain = this.nodes;
        int i = NodeKind.constructor-impl(256);
        if ((NodeChain.access$getAggregateChildKindSet(nodeChain) & i) != 0) {
            for (GlobalPositionAwareModifierNode head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & i) != 0 && (head$ui_release instanceof GlobalPositionAwareModifierNode)) {
                    GlobalPositionAwareModifierNode globalPositionAwareModifierNode = head$ui_release;
                    globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.requireCoordinator-64DMado(globalPositionAwareModifierNode, NodeKind.constructor-impl(256)));
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
                    return;
                }
            }
        }
    }

    public final void draw$ui_release(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterCoordinator$ui_release().draw(canvas);
    }

    public final void forEachChild(@NotNull Function1<? super LayoutNode, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                function1.invoke(content[i]);
                i++;
            } while (i < size);
        }
    }

    public final void forEachChildIndexed(@NotNull Function2<? super Integer, ? super LayoutNode, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                function2.invoke(Integer.valueOf(i), content[i]);
                i++;
            } while (i < size);
        }
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        requestRemeasure$ui_release$default(this, false, 1, null);
        Constraints m2145getLastConstraintsDWUhwKw = this.layoutDelegate.m2145getLastConstraintsDWUhwKw();
        if (m2145getLastConstraintsDWUhwKw != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.m2178measureAndLayout0kLqBqw(this, m2145getLastConstraintsDWUhwKw.unbox-impl());
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            ql3.a(owner2, false, 1, (Object) null);
        }
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (!layoutNodeLayoutDelegate.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNodeLayoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
            if (!((lookaheadAlignmentLinesOwner$ui_release == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release()) ? false : true)) {
                return false;
            }
        }
        return true;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    @NotNull
    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        return lookaheadPassDelegate.getChildMeasurables$ui_release();
    }

    @NotNull
    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate().getChildMeasurables$ui_release();
    }

    @NotNull
    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    @NotNull
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public Density getDensity() {
        return this.density;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    @NotNull
    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    @NotNull
    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator$ui_release();
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    @NotNull
    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    @NotNull
    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    @NotNull
    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    @NotNull
    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    @NotNull
    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Nullable
    public final LookaheadScope getMLookaheadScope$ui_release() {
        return this.mLookaheadScope;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @NotNull
    public final UsageByParent getMeasuredByParent$ui_release() {
        return this.measuredByParent;
    }

    @NotNull
    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        return this.measuredByParentInLookahead;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public Modifier getModifier() {
        return this.modifier;
    }

    @NotNull
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    @NotNull
    public final NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    @Nullable
    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    @Nullable
    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    @NotNull
    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    @Nullable
    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    @Nullable
    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        if (!(layoutNode != null && layoutNode.isVirtual)) {
            return layoutNode;
        }
        if (layoutNode != null) {
            return layoutNode.getParent$ui_release();
        }
        return null;
    }

    @Nullable
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    public final int getPlaceOrder$ui_release() {
        return this.placeOrder;
    }

    public final int getPreviousPlaceOrder$ui_release() {
        return this.previousPlaceOrder;
    }

    public int getSemanticsId() {
        return this.semanticsId;
    }

    @Nullable
    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    @NotNull
    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @NotNull
    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m2129hitTestM_7yMNQ$ui_release(long j, @NotNull HitTestResult<PointerInputModifierNode> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        getOuterCoordinator$ui_release().hitTest-YqVAtuI(NodeCoordinator.Companion.getPointerInputSource(), getOuterCoordinator$ui_release().fromParentPosition-MK-Hz9U(j), hitTestResult, z, z2);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m2130hitTestSemanticsM_7yMNQ$ui_release(long j, @NotNull HitTestResult<SemanticsModifierNode> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitSemanticsEntities");
        getOuterCoordinator$ui_release().hitTest-YqVAtuI(NodeCoordinator.Companion.getSemanticsSource(), getOuterCoordinator$ui_release().fromParentPosition-MK-Hz9U(j), hitTestResult, true, z2);
    }

    public final void ignoreRemeasureRequests$ui_release(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.ignoreRemeasureRequests = true;
        function0.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public final void insertAt$ui_release(int i, @NotNull LayoutNode layoutNode) {
        MutableVector<LayoutNode> vector;
        int size;
        Intrinsics.checkNotNullParameter(layoutNode, "instance");
        int i2 = 0;
        if (!(layoutNode._foldedParent == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot insert ");
            sb.append(layoutNode);
            sb.append(" because it already has a parent. This tree: ");
            sb.append(debugTreeToString$default(this, 0, 1, null));
            sb.append(" Other tree: ");
            LayoutNode layoutNode2 = layoutNode._foldedParent;
            sb.append(layoutNode2 != null ? debugTreeToString$default(layoutNode2, 0, 1, null) : null);
            throw new IllegalStateException(sb.toString().toString());
        }
        if (!(layoutNode.owner == null)) {
            throw new IllegalStateException(("Cannot insert " + layoutNode + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(layoutNode, 0, 1, null)).toString());
        }
        layoutNode._foldedParent = this;
        this._foldedChildren.add(i, layoutNode);
        onZSortedChildrenInvalidated$ui_release();
        if (layoutNode.isVirtual) {
            if (!(!this.isVirtual)) {
                throw new IllegalArgumentException("Virtual LayoutNode can't be added into a virtual parent".toString());
            }
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        if (this.isVirtual) {
            LayoutNode layoutNode3 = this._foldedParent;
            if (layoutNode3 != null) {
                r5 = layoutNode3.getInnerCoordinator$ui_release();
            }
        } else {
            r5 = getInnerCoordinator$ui_release();
        }
        outerCoordinator$ui_release.setWrappedBy$ui_release(r5);
        if (layoutNode.isVirtual && (size = (vector = layoutNode._foldedChildren.getVector()).getSize()) > 0) {
            LayoutNode[] content = vector.getContent();
            do {
                content[i2].getOuterCoordinator$ui_release().setWrappedBy$ui_release(getInnerCoordinator$ui_release());
                i2++;
            } while (i2 < size);
        }
        Owner owner = this.owner;
        if (owner != null) {
            layoutNode.attach$ui_release(owner);
        }
        if (layoutNode.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
        }
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            OwnedLayer layer = layoutModifierNodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.mLookaheadScope != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, 1, null);
        } else {
            requestRemeasure$ui_release$default(this, false, 1, null);
        }
    }

    public final void invalidateParentData$ui_release() {
        this.layoutDelegate.invalidateParentData();
    }

    public final void invalidateSubtree(boolean z) {
        OwnedLayer layer;
        if (z) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            LayoutNodeKt.requireOwner(this).onSemanticsChange();
        }
        requestRemeasure$ui_release$default(this, false, 1, null);
        NodeChain nodeChain = this.nodes;
        int i = NodeKind.constructor-impl(2);
        if ((NodeChain.access$getAggregateChildKindSet(nodeChain) & i) != 0) {
            for (LayoutModifierNode head$ui_release = nodeChain.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                if ((head$ui_release.getKindSet$ui_release() & i) != 0 && (head$ui_release instanceof LayoutModifierNode) && (layer = DelegatableNodeKt.requireCoordinator-64DMado(head$ui_release, NodeKind.constructor-impl(2)).getLayer()) != null) {
                    layer.invalidate();
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
                    break;
                }
            }
        }
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                content[i2].invalidateSubtree(false);
                i2++;
            } while (i2 < size);
        }
    }

    public boolean isAttached() {
        return this.owner != null;
    }

    public final boolean isLookaheadRoot() {
        return this.isLookaheadRoot;
    }

    public boolean isPlaced() {
        return this.isPlaced;
    }

    @Nullable
    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        if (lookaheadPassDelegate != null) {
            return Boolean.valueOf(lookaheadPassDelegate.isPlaced());
        }
        return null;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return isAttached();
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m2131lookaheadRemeasure_Sx5XlM$ui_release(@Nullable Constraints constraints) {
        if (constraints == null || this.mLookaheadScope == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        return lookaheadPassDelegate.m2150remeasureBRTryo0(constraints.unbox-impl());
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        lookaheadPassDelegate.replace();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void move$ui_release(int i, int i2, int i3) {
        if (i == i2) {
            return;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            this._foldedChildren.add(i > i2 ? i2 + i4 : (i2 + i3) - 2, this._foldedChildren.removeAt(i > i2 ? i + i4 : i));
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        int i = NodeKind.constructor-impl(128);
        boolean z = NodeKindKt.getIncludeSelfInTraversal-H91voCI(i);
        Modifier.Node tail = innerCoordinator$ui_release.getTail();
        if (!z && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier.Node access$headNode = NodeCoordinator.access$headNode(innerCoordinator$ui_release, z); access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i) != 0; access$headNode = access$headNode.getChild$ui_release()) {
            if ((access$headNode.getKindSet$ui_release() & i) != 0 && (access$headNode instanceof LayoutAwareModifierNode)) {
                ((LayoutAwareModifierNode) access$headNode).onPlaced(getInnerCoordinator$ui_release());
            }
            if (access$headNode == tail) {
                return;
            }
        }
    }

    public final void onNodePlaced$ui_release() {
        LayoutNode parent$ui_release = getParent$ui_release();
        float zIndex = getInnerCoordinator$ui_release().getZIndex();
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            zIndex += layoutModifierNodeCoordinator.getZIndex();
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
        if (!(zIndex == this.zIndex)) {
            this.zIndex = zIndex;
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
            }
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        if (!isPlaced()) {
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
        }
        if (parent$ui_release == null) {
            this.placeOrder = 0;
        } else if (!this.relayoutWithoutParentInProgress && parent$ui_release.getLayoutState$ui_release() == LayoutState.LayingOut) {
            if (!(this.placeOrder == Integer.MAX_VALUE)) {
                throw new IllegalStateException("Place was called on a node which was placed already".toString());
            }
            int i = parent$ui_release.nextChildPlaceOrder;
            this.placeOrder = i;
            parent$ui_release.nextChildPlaceOrder = i + 1;
        }
        this.layoutDelegate.getAlignmentLinesOwner$ui_release().layoutChildren();
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (!this.isVirtual) {
            this.zSortedChildrenInvalidated = true;
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.onZSortedChildrenInvalidated$ui_release();
        }
    }

    public final void place$ui_release(int i, int i2) {
        LayoutCoordinates layoutCoordinates;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = getMeasurePassDelegate();
        Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
        int measuredWidth = measurePassDelegate.getMeasuredWidth();
        LayoutDirection layoutDirection = getLayoutDirection();
        LayoutNode parent$ui_release = getParent$ui_release();
        NodeCoordinator innerCoordinator$ui_release = parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null;
        layoutCoordinates = Placeable$PlacementScope._coordinates;
        int access$getParentWidth = Placeable$PlacementScope.Companion.access$getParentWidth(companion);
        LayoutDirection access$getParentLayoutDirection = Placeable$PlacementScope.Companion.access$getParentLayoutDirection(companion);
        layoutNodeLayoutDelegate = Placeable$PlacementScope.layoutDelegate;
        Placeable$PlacementScope.parentWidth = measuredWidth;
        Placeable$PlacementScope.parentLayoutDirection = layoutDirection;
        boolean access$configureForPlacingForAlignment = Placeable$PlacementScope.Companion.access$configureForPlacingForAlignment(companion, innerCoordinator$ui_release);
        Placeable$PlacementScope.placeRelative$default(companion, measurePassDelegate, i, i2, 0.0f, 4, null);
        if (innerCoordinator$ui_release != null) {
            innerCoordinator$ui_release.setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
        }
        Placeable$PlacementScope.parentWidth = access$getParentWidth;
        Placeable$PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
        Placeable$PlacementScope._coordinates = layoutCoordinates;
        Placeable$PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m2132remeasure_Sx5XlM$ui_release(@Nullable Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui_release();
        }
        return getMeasurePassDelegate().m2156remeasureBRTryo0(constraints.unbox-impl());
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                this._foldedChildren.clear();
                return;
            }
            onChildRemoved(this._foldedChildren.get(size));
        }
    }

    public final void removeAt$ui_release(int i, int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("count (" + i2 + ") must be greater than 0").toString());
        }
        int i3 = (i2 + i) - 1;
        if (i > i3) {
            return;
        }
        while (true) {
            onChildRemoved(this._foldedChildren.removeAt(i3));
            if (i3 == i) {
                return;
            } else {
                i3--;
            }
        }
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        try {
            this.relayoutWithoutParentInProgress = true;
            getMeasurePassDelegate().replace();
        } finally {
            this.relayoutWithoutParentInProgress = false;
        }
    }

    public final void requestLookaheadRelayout$ui_release(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, true, z);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean z) {
        if (!(this.mLookaheadScope != null)) {
            throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
        }
        Owner owner = this.owner;
        if (owner == null || this.ignoreRemeasureRequests || this.isVirtual) {
            return;
        }
        owner.onRequestMeasure(this, true, z);
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        lookaheadPassDelegate.invalidateIntrinsicsParent(z);
    }

    public final void requestRelayout$ui_release(boolean z) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        ql3.c(owner, this, false, z, 2, (Object) null);
    }

    public final void requestRemeasure$ui_release(boolean z) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        ql3.b(owner, this, false, z, 2, (Object) null);
        getMeasurePassDelegate().invalidateIntrinsicsParent(z);
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        if (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + layoutNode.getLayoutState$ui_release());
        }
        if (layoutNode.getMeasurePending$ui_release()) {
            layoutNode.requestRemeasure$ui_release(true);
            return;
        }
        if (layoutNode.getLayoutPending$ui_release()) {
            layoutNode.requestRelayout$ui_release(true);
        } else if (layoutNode.getLookaheadMeasurePending$ui_release()) {
            layoutNode.requestLookaheadRemeasure$ui_release(true);
        } else if (layoutNode.getLookaheadLayoutPending$ui_release()) {
            layoutNode.requestLookaheadRelayout$ui_release(true);
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = content[i];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i++;
            } while (i < size);
        }
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "value");
        if (Intrinsics.areEqual(this.density, density)) {
            return;
        }
        this.density = density;
        onDensityOrLayoutDirectionChanged();
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    public final void setIntrinsicsUsageByParent$ui_release(@NotNull UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "value");
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public final void setLookaheadRoot(boolean z) {
        if (z != this.isLookaheadRoot) {
            if (z) {
                setMLookaheadScope(new LookaheadScope(this));
            } else {
                setMLookaheadScope(null);
            }
            this.isLookaheadRoot = z;
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(@NotNull MeasurePolicy measurePolicy) {
        Intrinsics.checkNotNullParameter(measurePolicy, "value");
        if (Intrinsics.areEqual(this.measurePolicy, measurePolicy)) {
            return;
        }
        this.measurePolicy = measurePolicy;
        this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
        invalidateMeasurements$ui_release();
    }

    public final void setMeasuredByParent$ui_release(@NotNull UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParent = usageByParent;
    }

    public final void setMeasuredByParentInLookahead$ui_release(@NotNull UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParentInLookahead = usageByParent;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "value");
        if (Intrinsics.areEqual(modifier, this.modifier)) {
            return;
        }
        if (!(!this.isVirtual || getModifier() == Modifier.Companion)) {
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
        this.modifier = modifier;
        this.nodes.updateFrom$ui_release(modifier);
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped$ui_release) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release()) {
            outerCoordinator$ui_release.updateLookaheadScope$ui_release(this.mLookaheadScope);
        }
        this.layoutDelegate.updateParentData();
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void setOnAttach$ui_release(@Nullable Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final void setOnDetach$ui_release(@Nullable Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public final void setSubcompositionsState$ui_release(@Nullable LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(@NotNull ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "<set-?>");
        this.viewConfiguration = viewConfiguration;
    }

    @NotNull
    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierCore.Companion.generateSemanticsId() : i);
    }
}
