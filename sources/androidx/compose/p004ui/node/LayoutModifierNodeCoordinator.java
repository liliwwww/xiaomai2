package androidx.compose.p004ui.node;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.Paint;
import androidx.compose.p004ui.graphics.PaintingStyle;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LookaheadScope;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Paint modifierBoundsPaint;

    @NotNull
    private LayoutModifierNode layoutModifierNode;

    @Nullable
    private IntermediateLayoutModifierNode lookAheadTransientMeasureNode;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private final class LookaheadDelegateForIntermediateLayoutModifier extends LookaheadDelegate {

        @NotNull
        private final IntermediateLayoutModifierNode intermediateMeasureNode;

        @NotNull
        private final PassThroughMeasureResult passThroughMeasureResult;
        final /* synthetic */ LayoutModifierNodeCoordinator this$0;

        /* compiled from: Taobao */
        /* loaded from: classes2.dex */
        private final class PassThroughMeasureResult implements MeasureResult {

            @NotNull
            private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();

            public PassThroughMeasureResult() {
            }

            @Override // androidx.compose.p004ui.layout.MeasureResult
            @NotNull
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            @Override // androidx.compose.p004ui.layout.MeasureResult
            public int getHeight() {
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getHeight();
            }

            @Override // androidx.compose.p004ui.layout.MeasureResult
            public int getWidth() {
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                return lookaheadDelegate$ui_release.getMeasureResult$ui_release().getWidth();
            }

            @Override // androidx.compose.p004ui.layout.MeasureResult
            public void placeChildren() {
                Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                LookaheadDelegate lookaheadDelegate$ui_release = LookaheadDelegateForIntermediateLayoutModifier.this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
                Placeable.PlacementScope.place$default(companion, lookaheadDelegate$ui_release, 0, 0, 0.0f, 4, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateForIntermediateLayoutModifier(@NotNull LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, @NotNull LookaheadScope lookaheadScope, IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
            super(layoutModifierNodeCoordinator, lookaheadScope);
            Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
            Intrinsics.checkNotNullParameter(intermediateLayoutModifierNode, "intermediateMeasureNode");
            this.this$0 = layoutModifierNodeCoordinator;
            this.intermediateMeasureNode = intermediateLayoutModifierNode;
            this.passThroughMeasureResult = new PassThroughMeasureResult();
        }

        @Override // androidx.compose.p004ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
            int calculateAlignmentAndPlaceChildAsNeeded;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(calculateAlignmentAndPlaceChildAsNeeded));
            return calculateAlignmentAndPlaceChildAsNeeded;
        }

        @NotNull
        public final IntermediateLayoutModifierNode getIntermediateMeasureNode() {
            return this.intermediateMeasureNode;
        }

        @Override // androidx.compose.p004ui.layout.Measurable
        @NotNull
        /* renamed from: measure-BRTryo0 */
        public Placeable mo4187measureBRTryo0(long j) {
            IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.intermediateMeasureNode;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.this$0;
            m4222setMeasurementConstraintsBRTryo0(j);
            LookaheadDelegate lookaheadDelegate$ui_release = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            lookaheadDelegate$ui_release.mo4187measureBRTryo0(j);
            intermediateLayoutModifierNode.mo4267setTargetSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate$ui_release.getMeasureResult$ui_release().getWidth(), lookaheadDelegate$ui_release.getMeasureResult$ui_release().getHeight()));
            set_measureResult(this.passThroughMeasureResult);
            return this;
        }
    }

    /* compiled from: Taobao */
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        final /* synthetic */ LayoutModifierNodeCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateForLayoutModifierNode(@NotNull LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, LookaheadScope lookaheadScope) {
            super(layoutModifierNodeCoordinator, lookaheadScope);
            Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
            this.this$0 = layoutModifierNodeCoordinator;
        }

        @Override // androidx.compose.p004ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
            int calculateAlignmentAndPlaceChildAsNeeded;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(calculateAlignmentAndPlaceChildAsNeeded));
            return calculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.p004ui.node.LookaheadDelegate, androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate$ui_release, i);
        }

        @Override // androidx.compose.p004ui.node.LookaheadDelegate, androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate$ui_release, i);
        }

        @Override // androidx.compose.p004ui.layout.Measurable
        @NotNull
        /* renamed from: measure-BRTryo0 */
        public Placeable mo4187measureBRTryo0(long j) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.this$0;
            m4222setMeasurementConstraintsBRTryo0(j);
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            set_measureResult(layoutModifierNode.mo4264measure3p2s80s(this, lookaheadDelegate$ui_release, j));
            return this;
        }

        @Override // androidx.compose.p004ui.node.LookaheadDelegate, androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate$ui_release, i);
        }

        @Override // androidx.compose.p004ui.node.LookaheadDelegate, androidx.compose.p004ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate$ui_release, i);
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo2677setColor8_81llA(Color.Companion.m2814getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo2681setStylek9PVt8s(PaintingStyle.Companion.m3019getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutModifierNodeCoordinator(@NotNull LayoutNode layoutNode, @NotNull LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(layoutModifierNode, "measureNode");
        this.layoutModifierNode = layoutModifierNode;
        this.lookAheadTransientMeasureNode = (((layoutModifierNode.getNode().getKindSet$ui_release() & NodeKind.m4398constructorimpl(512)) != 0) && (layoutModifierNode instanceof IntermediateLayoutModifierNode)) ? (IntermediateLayoutModifierNode) layoutModifierNode : null;
    }

    @Override // androidx.compose.p004ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        int calculateAlignmentAndPlaceChildAsNeeded;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            return lookaheadDelegate$ui_release.getCachedAlignmentLine$ui_release(alignmentLine);
        }
        calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
        return calculateAlignmentAndPlaceChildAsNeeded;
    }

    @Override // androidx.compose.p004ui.node.NodeCoordinator
    @NotNull
    public LookaheadDelegate createLookaheadDelegate(@NotNull LookaheadScope lookaheadScope) {
        Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = this.lookAheadTransientMeasureNode;
        return intermediateLayoutModifierNode != null ? new LookaheadDelegateForIntermediateLayoutModifier(this, lookaheadScope, intermediateLayoutModifierNode) : new LookaheadDelegateForLayoutModifierNode(this, lookaheadScope);
    }

    @NotNull
    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    @Override // androidx.compose.p004ui.node.NodeCoordinator
    @NotNull
    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    @NotNull
    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui_release = getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i) {
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i) {
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    @Override // androidx.compose.p004ui.layout.Measurable
    @NotNull
    /* renamed from: measure-BRTryo0 */
    public Placeable mo4187measureBRTryo0(long j) {
        m4222setMeasurementConstraintsBRTryo0(j);
        setMeasureResult$ui_release(this.layoutModifierNode.mo4264measure3p2s80s(this, getWrappedNonNull(), j));
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.mo4443resizeozmzZPI(m4219getMeasuredSizeYbymL2g());
        }
        onMeasured();
        return this;
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i) {
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i) {
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    @Override // androidx.compose.p004ui.node.NodeCoordinator
    public void onLayoutModifierNodeChanged() {
        super.onLayoutModifierNodeChanged();
        LayoutModifierNode layoutModifierNode = this.layoutModifierNode;
        if (!((layoutModifierNode.getNode().getKindSet$ui_release() & NodeKind.m4398constructorimpl(512)) != 0) || !(layoutModifierNode instanceof IntermediateLayoutModifierNode)) {
            this.lookAheadTransientMeasureNode = null;
            LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release != null) {
                updateLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode(this, lookaheadDelegate$ui_release.getLookaheadScope()));
                return;
            }
            return;
        }
        IntermediateLayoutModifierNode intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) layoutModifierNode;
        this.lookAheadTransientMeasureNode = intermediateLayoutModifierNode;
        LookaheadDelegate lookaheadDelegate$ui_release2 = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release2 != null) {
            updateLookaheadDelegate(new LookaheadDelegateForIntermediateLayoutModifier(this, lookaheadDelegate$ui_release2.getLookaheadScope(), intermediateLayoutModifierNode));
        }
    }

    @Override // androidx.compose.p004ui.node.NodeCoordinator
    public void performDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrappedNonNull().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p004ui.node.NodeCoordinator, androidx.compose.p004ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo4188placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        super.mo4188placeAtf8xVGno(j, f, function1);
        if (isShallowPlacing$ui_release()) {
            return;
        }
        onPlaced();
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int m5376getWidthimpl = IntSize.m5376getWidthimpl(m4219getMeasuredSizeYbymL2g());
        LayoutDirection layoutDirection = getLayoutDirection();
        LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
        int parentWidth = companion.getParentWidth();
        LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.parentWidth = m5376getWidthimpl;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        boolean configureForPlacingForAlignment = companion.configureForPlacingForAlignment(this);
        getMeasureResult$ui_release().placeChildren();
        setPlacingForAlignment$ui_release(configureForPlacingForAlignment);
        Placeable.PlacementScope.parentWidth = parentWidth;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
        Placeable.PlacementScope._coordinates = layoutCoordinates;
        Placeable.PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
    }

    public final void setLayoutModifierNode$ui_release(@NotNull LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<set-?>");
        this.layoutModifierNode = layoutModifierNode;
    }
}
