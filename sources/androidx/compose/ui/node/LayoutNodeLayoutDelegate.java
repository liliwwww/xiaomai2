package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutNodeLayoutDelegate {
    private int childrenAccessingCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringPlacement;

    @NotNull
    private final LayoutNode layoutNode;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;

    @NotNull
    private LayoutNode.LayoutState layoutState;
    private boolean lookaheadLayoutPending;
    private boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;

    @Nullable
    private LookaheadPassDelegate lookaheadPassDelegate;

    @NotNull
    private final MeasurePassDelegate measurePassDelegate;
    private boolean measurePending;

    /* compiled from: Taobao */
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {

        @NotNull
        private final MutableVector<Measurable> _childMeasurables;

        @NotNull
        private final AlignmentLines alignmentLines;
        private boolean childMeasurablesDirty;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private boolean isPreviouslyPlaced;
        private long lastPosition;

        @Nullable
        private Constraints lookaheadConstraints;

        @NotNull
        private final LookaheadScope lookaheadScope;
        private boolean measuredOnce;

        @Nullable
        private Object parentData;
        private boolean parentDataDirty;
        private boolean placedOnce;
        final /* synthetic */ LayoutNodeLayoutDelegate this$0;

        public LookaheadPassDelegate(@NotNull LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LookaheadScope lookaheadScope) {
            Intrinsics.checkNotNullParameter(lookaheadScope, "lookaheadScope");
            this.this$0 = layoutNodeLayoutDelegate;
            this.lookaheadScope = lookaheadScope;
            this.lastPosition = IntOffset.Companion.m2653getZeronOccac();
            this.isPlaced = true;
            this.alignmentLines = new LookaheadAlignmentLines(this);
            this._childMeasurables = new MutableVector<>(new Measurable[16], 0);
            this.childMeasurablesDirty = true;
            this.parentDataDirty = true;
            this.parentData = layoutNodeLayoutDelegate.getMeasurePassDelegate$ui_release().getParentData();
        }

        private final void forEachChildDelegate(Function1<? super LookaheadPassDelegate, Unit> function1) {
            MutableVector<LayoutNode> mutableVector = this.this$0.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                int i = 0;
                LayoutNode[] content = mutableVector.getContent();
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = content[i].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    function1.invoke(lookaheadPassDelegate$ui_release);
                    i++;
                } while (i < size);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void markSubtreeNotPlaced() {
            int i = 0;
            setPlaced(false);
            MutableVector<LayoutNode> mutableVector = this.this$0.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = content[i].getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.markSubtreeNotPlaced();
                    i++;
                } while (i < size);
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode layoutNode = this.this$0.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode2 = content[i];
                    if (layoutNode2.getLookaheadMeasurePending$ui_release() && layoutNode2.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode2.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        Constraints m2147getLastConstraintsDWUhwKw = m2147getLastConstraintsDWUhwKw();
                        Intrinsics.checkNotNull(m2147getLastConstraintsDWUhwKw);
                        if (lookaheadPassDelegate$ui_release.m2150remeasureBRTryo0(m2147getLastConstraintsDWUhwKw.unbox-impl())) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, null);
                        }
                    }
                    i++;
                } while (i < size);
            }
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.this$0.layoutNode, false, 1, null);
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || this.this$0.layoutNode.getIntrinsicsUsageByParent$ui_release() != LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            LayoutNode layoutNode = this.this$0.layoutNode;
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            layoutNode.setIntrinsicsUsageByParent$ui_release(i != 2 ? i != 3 ? parent$ui_release.getIntrinsicsUsageByParent$ui_release() : LayoutNode.UsageByParent.InLayoutBlock : LayoutNode.UsageByParent.InMeasureBlock);
        }

        private final void requestSubtreeForLookahead() {
            MutableVector<LayoutNode> mutableVector = this.this$0.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                int i = 0;
                LayoutNode[] content = mutableVector.getContent();
                do {
                    LayoutNode layoutNode = content[i];
                    layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.requestSubtreeForLookahead();
                    i++;
                } while (i < size);
            }
        }

        private final void trackLookaheadMeasurementByParent(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release == null) {
                layoutNode.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                return;
            }
            if (!(layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.NotUsed || layoutNode.getCanMultiMeasure$ui_release())) {
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + layoutNode.getMeasuredByParentInLookahead$ui_release() + ". Parent state " + parent$ui_release.getLayoutState$ui_release() + '.').toString());
            }
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            if (i == 1 || i == 2) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i != 3 && i != 4) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            layoutNode.setMeasuredByParentInLookahead$ui_release(usageByParent);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @NotNull
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (this.this$0.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        this.this$0.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            LookaheadDelegate lookaheadDelegate$ui_release = getInnerCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release != null) {
                lookaheadDelegate$ui_release.setPlacingForAlignment$ui_release(true);
            }
            layoutChildren();
            LookaheadDelegate lookaheadDelegate$ui_release2 = getInnerCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release2 != null) {
                lookaheadDelegate$ui_release2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void forEachChildAlignmentLinesOwner(@NotNull Function1<? super AlignmentLinesOwner, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            List<LayoutNode> children$ui_release = this.this$0.layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i = 0; i < size; i++) {
                AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = children$ui_release.get(i).getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
                Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                function1.invoke(lookaheadAlignmentLinesOwner$ui_release);
            }
        }

        public int get(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = this.this$0.layoutNode.getParent$ui_release();
                if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            int i = lookaheadDelegate$ui_release.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @NotNull
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        @NotNull
        public final List<Measurable> getChildMeasurables$ui_release() {
            this.this$0.layoutNode.getChildren$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.access$updateChildMeasurables(this.this$0.layoutNode, this._childMeasurables, new Function1<LayoutNode, Measurable>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2
                @NotNull
                public final Measurable invoke(@NotNull LayoutNode layoutNode) {
                    Intrinsics.checkNotNullParameter(layoutNode, "it");
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    return lookaheadPassDelegate$ui_release;
                }
            });
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        public final boolean getChildMeasurablesDirty$ui_release() {
            return this.childMeasurablesDirty;
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @NotNull
        public NodeCoordinator getInnerCoordinator() {
            return this.this$0.layoutNode.getInnerCoordinator$ui_release();
        }

        @Nullable
        /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
        public final Constraints m2147getLastConstraintsDWUhwKw() {
            return this.lookaheadConstraints;
        }

        public int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.getMeasuredHeight();
        }

        public int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.getMeasuredWidth();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @Nullable
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getLookaheadAlignmentLinesOwner$ui_release();
        }

        @Nullable
        public Object getParentData() {
            return this.parentData;
        }

        public final void invalidateIntrinsicsParent(boolean z) {
            LayoutNode parent$ui_release;
            LayoutNode parent$ui_release2 = this.this$0.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = this.this$0.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release2 == null || intrinsicsUsageByParent$ui_release == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            while (parent$ui_release2.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                parent$ui_release2 = parent$ui_release;
            }
            int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
            if (i == 1) {
                parent$ui_release2.requestLookaheadRemeasure$ui_release(z);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
                parent$ui_release2.requestLookaheadRelayout$ui_release(z);
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public boolean isPlaced() {
            return this.isPlaced;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (this.this$0.getLookaheadLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            LookaheadDelegate lookaheadDelegate$ui_release = getInnerCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            if (this.this$0.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate$ui_release.isPlacingForAlignment$ui_release() && this.this$0.getLookaheadLayoutPending$ui_release())) {
                this.this$0.lookaheadLayoutPending = false;
                LayoutNode.LayoutState layoutState$ui_release = this.this$0.getLayoutState$ui_release();
                this.this$0.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.this$0.layoutNode).getSnapshotObserver(), this.this$0.layoutNode, false, new layoutChildren.1(this, this.this$0, lookaheadDelegate$ui_release), 2, (Object) null);
                this.this$0.layoutState = layoutState$ui_release;
                if (this.this$0.getCoordinatesAccessedDuringPlacement() && lookaheadDelegate$ui_release.isPlacingForAlignment$ui_release()) {
                    requestLayout();
                }
                this.this$0.lookaheadLayoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
        }

        public int maxIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.maxIntrinsicHeight(i);
        }

        public int maxIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.maxIntrinsicWidth(i);
        }

        @NotNull
        /* renamed from: measure-BRTryo0, reason: not valid java name */
        public Placeable m2148measureBRTryo0(long j) {
            trackLookaheadMeasurementByParent(this.this$0.layoutNode);
            if (this.this$0.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                this.this$0.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            m2150remeasureBRTryo0(j);
            return this;
        }

        public int minIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.minIntrinsicHeight(i);
        }

        public int minIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.minIntrinsicWidth(i);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (this.this$0.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List<LayoutNode> children$ui_release = this.this$0.layoutNode.getChildren$ui_release();
                int size = children$ui_release.size();
                for (int i = 0; i < size; i++) {
                    LayoutNode layoutNode = children$ui_release.get(i);
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                    if (layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement() && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutDelegate$ui_release.getLookaheadPassDelegate$ui_release();
                    if (lookaheadPassDelegate$ui_release != null) {
                        lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                }
            }
        }

        public final void onPlaced() {
            if (isPlaced()) {
                return;
            }
            setPlaced(true);
            if (this.isPreviouslyPlaced) {
                return;
            }
            requestSubtreeForLookahead();
        }

        /* renamed from: placeAt-f8xVGno, reason: not valid java name */
        protected void m2149placeAtf8xVGno(final long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            this.this$0.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            this.placedOnce = true;
            if (!IntOffset.m2642equalsimpl0(j, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            Owner requireOwner = LayoutNodeKt.requireOwner(this.this$0.layoutNode);
            this.this$0.setCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver snapshotObserver = requireOwner.getSnapshotObserver();
            LayoutNode layoutNode = this.this$0.layoutNode;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
            OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2151invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2151invoke() {
                    Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = LayoutNodeLayoutDelegate.this;
                    long j2 = j;
                    LookaheadDelegate lookaheadDelegate$ui_release = layoutNodeLayoutDelegate2.getOuterCoordinator().getLookaheadDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                    Placeable$PlacementScope.m2068place70tqf50$default(companion, lookaheadDelegate$ui_release, j2, 0.0f, 2, null);
                }
            }, 2, (Object) null);
            this.lastPosition = j;
            this.this$0.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* renamed from: remeasure-BRTryo0, reason: not valid java name */
        public final boolean m2150remeasureBRTryo0(long j) {
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            this.this$0.layoutNode.setCanMultiMeasure$ui_release(this.this$0.layoutNode.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()));
            if (!this.this$0.layoutNode.getLookaheadMeasurePending$ui_release()) {
                Constraints constraints = this.lookaheadConstraints;
                if (constraints == null ? false : Constraints.equals-impl0(constraints.unbox-impl(), j)) {
                    return false;
                }
            }
            this.lookaheadConstraints = Constraints.box-impl(j);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AlignmentLinesOwner) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
                    Intrinsics.checkNotNullParameter(alignmentLinesOwner, "it");
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            if (!(lookaheadDelegate$ui_release != null)) {
                throw new IllegalStateException("Lookahead result from lookaheadRemeasure cannot be null".toString());
            }
            long IntSize = IntSizeKt.IntSize(lookaheadDelegate$ui_release.getWidth(), lookaheadDelegate$ui_release.getHeight());
            this.this$0.m2143performLookaheadMeasureBRTryo0(j);
            setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(lookaheadDelegate$ui_release.getWidth(), lookaheadDelegate$ui_release.getHeight()));
            return (IntSize.m2685getWidthimpl(IntSize) == lookaheadDelegate$ui_release.getWidth() && IntSize.m2684getHeightimpl(IntSize) == lookaheadDelegate$ui_release.getHeight()) ? false : true;
        }

        public final void replace() {
            if (!this.placedOnce) {
                throw new IllegalStateException("Check failed.".toString());
            }
            m2149placeAtf8xVGno(this.lastPosition, 0.0f, null);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(this.this$0.layoutNode, false, 1, null);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.this$0.layoutNode, false, 1, null);
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z) {
            this.childMeasurablesDirty = z;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        public void setPlaced(boolean z) {
            this.isPlaced = z;
        }

        public final boolean updateParentData() {
            if (!this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            Object parentData = getParentData();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            boolean z = !Intrinsics.areEqual(parentData, lookaheadDelegate$ui_release.getParentData());
            LookaheadDelegate lookaheadDelegate$ui_release2 = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release2);
            this.parentData = lookaheadDelegate$ui_release2.getParentData();
            return z;
        }
    }

    /* compiled from: Taobao */
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private boolean duringAlignmentLinesQuery;

        @Nullable
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private float lastZIndex;
        private boolean measuredOnce;

        @Nullable
        private Object parentData;
        private boolean placedOnce;
        private long lastPosition = IntOffset.Companion.m2653getZeronOccac();
        private boolean parentDataDirty = true;

        @NotNull
        private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);

        @NotNull
        private final MutableVector<Measurable> _childMeasurables = new MutableVector<>(new Measurable[16], 0);
        private boolean childMeasurablesDirty = true;

        /* compiled from: Taobao */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public MeasurePassDelegate() {
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i = 0;
                do {
                    LayoutNode layoutNode2 = content[i];
                    if (layoutNode2.getMeasurePending$ui_release() && layoutNode2.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m2128remeasure_Sx5XlM$ui_release$default(layoutNode2, null, 1, null)) {
                        LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, null);
                    }
                    i++;
                } while (i < size);
            }
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() != LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            layoutNode.setIntrinsicsUsageByParent$ui_release(i != 1 ? i != 2 ? parent$ui_release.getIntrinsicsUsageByParent$ui_release() : LayoutNode.UsageByParent.InLayoutBlock : LayoutNode.UsageByParent.InMeasureBlock);
        }

        /* renamed from: placeOuterCoordinator-f8xVGno, reason: not valid java name */
        private final void m2152placeOuterCoordinatorf8xVGno(final long j, final float f, final Function1<? super GraphicsLayerScope, Unit> function1) {
            this.lastPosition = j;
            this.lastZIndex = f;
            this.lastLayerBlock = function1;
            this.placedOnce = true;
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode).getSnapshotObserver();
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            snapshotObserver.observeLayoutModifierSnapshotReads$ui_release(layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2157invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2157invoke() {
                    Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
                    Function1<GraphicsLayerScope, Unit> function12 = function1;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNodeLayoutDelegate;
                    long j2 = j;
                    float f2 = f;
                    if (function12 == null) {
                        companion.m2072place70tqf50(layoutNodeLayoutDelegate2.getOuterCoordinator(), j2, f2);
                    } else {
                        companion.m2077placeWithLayeraW9wM(layoutNodeLayoutDelegate2.getOuterCoordinator(), j2, f2, function12);
                    }
                }
            });
        }

        private final void trackMeasurementByParent(LayoutNode layoutNode) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release == null) {
                layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                return;
            }
            if (!(layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.NotUsed || layoutNode.getCanMultiMeasure$ui_release())) {
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + layoutNode.getMeasuredByParent$ui_release() + ". Parent state " + parent$ui_release.getLayoutState$ui_release() + '.').toString());
            }
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            if (i == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            layoutNode.setMeasuredByParent$ui_release(usageByParent);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @NotNull
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        LayoutNodeLayoutDelegate.this.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(true);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void forEachChildAlignmentLinesOwner(@NotNull Function1<? super AlignmentLinesOwner, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            List<LayoutNode> children$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i = 0; i < size; i++) {
                function1.invoke(children$ui_release.get(i).getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
            }
        }

        public int get(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            int i = LayoutNodeLayoutDelegate.this.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @NotNull
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        @NotNull
        public final List<Measurable> getChildMeasurables$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.updateChildrenIfDirty$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.access$updateChildMeasurables(LayoutNodeLayoutDelegate.this.layoutNode, this._childMeasurables, childMeasurables.1.INSTANCE);
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        public final boolean getChildMeasurablesDirty$ui_release() {
            return this.childMeasurablesDirty;
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @NotNull
        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        @Nullable
        /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
        public final Constraints m2153getLastConstraintsDWUhwKw() {
            if (this.measuredOnce) {
                return Constraints.box-impl(getMeasurementConstraints-msEJaDk());
            }
            return null;
        }

        public int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        public int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        @Nullable
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getAlignmentLinesOwner$ui_release();
        }

        @Nullable
        public Object getParentData() {
            return this.parentData;
        }

        public final void invalidateIntrinsicsParent(boolean z) {
            LayoutNode parent$ui_release;
            LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent$ui_release2 == null || intrinsicsUsageByParent$ui_release == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            while (parent$ui_release2.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent$ui_release && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                parent$ui_release2 = parent$ui_release;
            }
            int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent$ui_release.ordinal()];
            if (i == 1) {
                parent$ui_release2.requestRemeasure$ui_release(z);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
                parent$ui_release2.requestRelayout$ui_release(z);
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public boolean isPlaced() {
            return LayoutNodeLayoutDelegate.this.layoutNode.isPlaced();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            if (LayoutNodeLayoutDelegate.this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release())) {
                LayoutNodeLayoutDelegate.this.layoutPending = false;
                LayoutNode.LayoutState layoutState$ui_release = LayoutNodeLayoutDelegate.this.getLayoutState$ui_release();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
                LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(layoutNode, false, new layoutChildren.1.1(LayoutNodeLayoutDelegate.this, this, layoutNode));
                LayoutNodeLayoutDelegate.this.layoutState = layoutState$ui_release;
                if (getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.layoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
        }

        public int maxIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(i);
        }

        public int maxIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(i);
        }

        @NotNull
        /* renamed from: measure-BRTryo0, reason: not valid java name */
        public Placeable m2154measureBRTryo0(long j) {
            LayoutNode.UsageByParent intrinsicsUsageByParent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
            if (intrinsicsUsageByParent$ui_release == usageByParent) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                this.measuredOnce = true;
                setMeasurementConstraints-BRTryo0(j);
                LayoutNodeLayoutDelegate.this.layoutNode.setMeasuredByParentInLookahead$ui_release(usageByParent);
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.m2148measureBRTryo0(j);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            m2156remeasureBRTryo0(j);
            return this;
        }

        public int minIntrinsicHeight(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(i);
        }

        public int minIntrinsicWidth(int i) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(i);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List<LayoutNode> children$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
                int size = children$ui_release.size();
                for (int i = 0; i < size; i++) {
                    LayoutNode layoutNode = children$ui_release.get(i);
                    LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                    if (layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement() && !layoutDelegate$ui_release.getLayoutPending$ui_release()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                    }
                    layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                }
            }
        }

        /* renamed from: placeAt-f8xVGno, reason: not valid java name */
        protected void m2155placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
            if (!IntOffset.m2642equalsimpl0(j, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                Placeable$PlacementScope.place$default(companion, lookaheadPassDelegate$ui_release, IntOffset.m2643getXimpl(j), IntOffset.m2644getYimpl(j), 0.0f, 4, null);
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
            m2152placeOuterCoordinatorf8xVGno(j, f, function1);
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* renamed from: remeasure-BRTryo0, reason: not valid java name */
        public final boolean m2156remeasureBRTryo0(long j) {
            Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            boolean z = true;
            LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure$ui_release() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure$ui_release()));
            if (!LayoutNodeLayoutDelegate.this.layoutNode.getMeasurePending$ui_release() && Constraints.equals-impl0(getMeasurementConstraints-msEJaDk(), j)) {
                requireOwner.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.layoutNode);
                LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                return false;
            }
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(remeasure.1.INSTANCE);
            this.measuredOnce = true;
            long j2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getSize-YbymL2g();
            setMeasurementConstraints-BRTryo0(j);
            LayoutNodeLayoutDelegate.this.m2144performMeasureBRTryo0(j);
            if (IntSize.m2683equalsimpl0(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getSize-YbymL2g(), j2) && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth() == getWidth() && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight() == getHeight()) {
                z = false;
            }
            setMeasuredSize-ozmzZPI(IntSizeKt.IntSize(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight()));
            return z;
        }

        public final void replace() {
            if (!this.placedOnce) {
                throw new IllegalStateException("Check failed.".toString());
            }
            m2152placeOuterCoordinatorf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z) {
            this.childMeasurablesDirty = z;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        public final boolean updateParentData() {
            if (!this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            boolean z = !Intrinsics.areEqual(getParentData(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData());
            this.parentData = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData();
            return z;
        }
    }

    public LayoutNodeLayoutDelegate(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layoutState = LayoutNode.LayoutState.Idle;
        this.measurePassDelegate = new MeasurePassDelegate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOutMostLookaheadRoot(LayoutNode layoutNode) {
        LookaheadScope mLookaheadScope$ui_release = layoutNode.getMLookaheadScope$ui_release();
        return Intrinsics.areEqual(mLookaheadScope$ui_release != null ? mLookaheadScope$ui_release.getRoot() : null, layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performLookaheadMeasure-BRTryo0, reason: not valid java name */
    public final void m2143performLookaheadMeasureBRTryo0(long j) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, new performLookaheadMeasure.1(this, j), 2, (Object) null);
        markLookaheadLayoutPending$ui_release();
        if (isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performMeasure-BRTryo0, reason: not valid java name */
    public final void m2144performMeasureBRTryo0(long j) {
        LayoutNode.LayoutState layoutState = this.layoutState;
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Idle;
        if (!(layoutState == layoutState2)) {
            throw new IllegalStateException("layout state is not idle before measure starts".toString());
        }
        LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
        this.layoutState = layoutState3;
        this.measurePending = false;
        LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, false, new performMeasure.2(this, j));
        if (this.layoutState == layoutState3) {
            markLayoutPending$ui_release();
            this.layoutState = layoutState2;
        }
    }

    @NotNull
    public final AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return this.measurePassDelegate;
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    @Nullable
    /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m2145getLastConstraintsDWUhwKw() {
        return this.measurePassDelegate.m2153getLastConstraintsDWUhwKw();
    }

    @Nullable
    /* renamed from: getLastLookaheadConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m2146getLastLookaheadConstraintsDWUhwKw() {
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            return lookaheadPassDelegate.m2147getLastConstraintsDWUhwKw();
        }
        return null;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    @NotNull
    public final LayoutNode.LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    @Nullable
    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.lookaheadLayoutPending;
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.lookaheadMeasurePending;
    }

    @Nullable
    public final LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.lookaheadPassDelegate;
    }

    @NotNull
    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.measurePassDelegate;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    @NotNull
    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes$ui_release().getOuterCoordinator$ui_release();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    public final void invalidateParentData() {
        this.measurePassDelegate.invalidateParentData();
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.invalidateParentData();
        }
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildMeasurablesDirty$ui_release(true);
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.setChildMeasurablesDirty$ui_release(true);
        }
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void onLookaheadScopeChanged$ui_release(@Nullable LookaheadScope lookaheadScope) {
        this.lookaheadPassDelegate = lookaheadScope != null ? new LookaheadPassDelegate(this, lookaheadScope) : null;
    }

    public final void resetAlignmentLines() {
        AlignmentLines alignmentLines;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate == null || (alignmentLines = lookaheadPassDelegate.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.reset$ui_release();
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int i) {
        int i2 = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = i;
        if ((i2 == 0) != (i == 0)) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate layoutDelegate$ui_release = parent$ui_release != null ? parent$ui_release.getLayoutDelegate$ui_release() : null;
            if (layoutDelegate$ui_release != null) {
                if (i == 0) {
                    layoutDelegate$ui_release.setChildrenAccessingCoordinatesDuringPlacement(layoutDelegate$ui_release.childrenAccessingCoordinatesDuringPlacement - 1);
                } else {
                    layoutDelegate$ui_release.setChildrenAccessingCoordinatesDuringPlacement(layoutDelegate$ui_release.childrenAccessingCoordinatesDuringPlacement + 1);
                }
            }
        }
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean z) {
        if (this.coordinatesAccessedDuringPlacement != z) {
            this.coordinatesAccessedDuringPlacement = z;
            if (z) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void updateParentData() {
        LayoutNode parent$ui_release;
        if (this.measurePassDelegate.updateParentData() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
            LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, 1, null);
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null && lookaheadPassDelegate.updateParentData()) {
            if (isOutMostLookaheadRoot(this.layoutNode)) {
                LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, false, 1, null);
                    return;
                }
                return;
            }
            LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release3 != null) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release3, false, 1, null);
            }
        }
    }
}
