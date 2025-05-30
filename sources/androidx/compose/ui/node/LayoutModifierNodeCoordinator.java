package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        final /* synthetic */ LayoutModifierNodeCoordinator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LookaheadDelegateForLayoutModifierNode(@NotNull LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, LookaheadScope lookaheadScope) {
            super(layoutModifierNodeCoordinator, lookaheadScope);
            Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
            this.this$0 = layoutModifierNodeCoordinator;
        }

        public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            int access$calculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.access$calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(access$calculateAlignmentAndPlaceChildAsNeeded));
            return access$calculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int maxIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate$ui_release, i);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int maxIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate$ui_release, i);
        }

        @NotNull
        /* renamed from: measure-BRTryo0, reason: not valid java name */
        public Placeable m2124measureBRTryo0(long j) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = this.this$0;
            setMeasurementConstraints-BRTryo0(j);
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            set_measureResult(layoutModifierNode.m2121measure3p2s80s(this, lookaheadDelegate$ui_release, j));
            return this;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int minIntrinsicHeight(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate$ui_release, i);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int minIntrinsicWidth(int i) {
            LayoutModifierNode layoutModifierNode = this.this$0.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getWrappedNonNull().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate$ui_release, i);
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m1167setColor8_81llA(Color.Companion.m1075getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m1171setStylek9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        modifierBoundsPaint = Paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutModifierNodeCoordinator(@NotNull LayoutNode layoutNode, @NotNull LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Intrinsics.checkNotNullParameter(layoutModifierNode, "measureNode");
        this.layoutModifierNode = layoutModifierNode;
        this.lookAheadTransientMeasureNode = (((layoutModifierNode.getNode().getKindSet$ui_release() & NodeKind.constructor-impl(512)) != 0) && (layoutModifierNode instanceof IntermediateLayoutModifierNode)) ? (IntermediateLayoutModifierNode) layoutModifierNode : null;
    }

    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
        return lookaheadDelegate$ui_release != null ? lookaheadDelegate$ui_release.getCachedAlignmentLine$ui_release(alignmentLine) : LayoutModifierNodeCoordinatorKt.access$calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

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

    public int maxIntrinsicHeight(int i) {
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    public int maxIntrinsicWidth(int i) {
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    @NotNull
    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable m2122measureBRTryo0(long j) {
        NodeCoordinator.access$setMeasurementConstraints-BRTryo0(this, j);
        setMeasureResult$ui_release(this.layoutModifierNode.m2121measure3p2s80s(this, getWrappedNonNull(), j));
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.resize-ozmzZPI(NodeCoordinator.access$getMeasuredSize-YbymL2g(this));
        }
        onMeasured();
        return this;
    }

    public int minIntrinsicHeight(int i) {
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), i);
    }

    public int minIntrinsicWidth(int i) {
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), i);
    }

    public void onLayoutModifierNodeChanged() {
        super.onLayoutModifierNodeChanged();
        LayoutModifierNode layoutModifierNode = this.layoutModifierNode;
        if (!((layoutModifierNode.getNode().getKindSet$ui_release() & NodeKind.constructor-impl(512)) != 0) || !(layoutModifierNode instanceof IntermediateLayoutModifierNode)) {
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

    public void performDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getWrappedNonNull().draw(canvas);
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    protected void m2123placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        LayoutCoordinates layoutCoordinates;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        super.placeAt-f8xVGno(j, f, function1);
        if (isShallowPlacing$ui_release()) {
            return;
        }
        onPlaced();
        Placeable$PlacementScope.Companion companion = Placeable$PlacementScope.Companion;
        int m2685getWidthimpl = IntSize.m2685getWidthimpl(getMeasuredSize-YbymL2g());
        LayoutDirection layoutDirection = getLayoutDirection();
        layoutCoordinates = Placeable$PlacementScope._coordinates;
        int access$getParentWidth = Placeable$PlacementScope.Companion.access$getParentWidth(companion);
        LayoutDirection access$getParentLayoutDirection = Placeable$PlacementScope.Companion.access$getParentLayoutDirection(companion);
        layoutNodeLayoutDelegate = Placeable$PlacementScope.layoutDelegate;
        Placeable$PlacementScope.parentWidth = m2685getWidthimpl;
        Placeable$PlacementScope.parentLayoutDirection = layoutDirection;
        boolean access$configureForPlacingForAlignment = Placeable$PlacementScope.Companion.access$configureForPlacingForAlignment(companion, this);
        getMeasureResult$ui_release().placeChildren();
        setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
        Placeable$PlacementScope.parentWidth = access$getParentWidth;
        Placeable$PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
        Placeable$PlacementScope._coordinates = layoutCoordinates;
        Placeable$PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
    }

    public final void setLayoutModifierNode$ui_release(@NotNull LayoutModifierNode layoutModifierNode) {
        Intrinsics.checkNotNullParameter(layoutModifierNode, "<set-?>");
        this.layoutModifierNode = layoutModifierNode;
    }
}
