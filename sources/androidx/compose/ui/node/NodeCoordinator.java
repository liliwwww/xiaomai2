package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {

    @NotNull
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";

    @NotNull
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";

    @Nullable
    private MeasureResult _measureResult;

    @Nullable
    private MutableRect _rectCache;

    @NotNull
    private final Function0<Unit> invalidateParentLayer;
    private boolean isClipping;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;

    @Nullable
    private OwnedLayer layer;

    @Nullable
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;

    @NotNull
    private Density layerDensity;

    @NotNull
    private LayoutDirection layerLayoutDirection;

    @Nullable
    private LayerPositionalProperties layerPositionalProperties;

    @NotNull
    private final LayoutNode layoutNode;

    @Nullable
    private LookaheadDelegate lookaheadDelegate;

    @Nullable
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;

    @Nullable
    private NodeCoordinator wrapped;

    @Nullable
    private NodeCoordinator wrappedBy;
    private float zIndex;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = Companion.onCommitAffectingLayerParams.1.INSTANCE;

    @NotNull
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((NodeCoordinator) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull NodeCoordinator nodeCoordinator) {
            Intrinsics.checkNotNullParameter(nodeCoordinator, "coordinator");
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };

    @NotNull
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();

    @NotNull
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();

    @NotNull
    private static final float[] tmpMatrix = Matrix.m1153constructorimpl$default(null, 1, null);

    @NotNull
    private static final HitTestSource<PointerInputModifierNode> PointerInputSource = new HitTestSource<PointerInputModifierNode>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo1654childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j, @NotNull HitTestResult<PointerInputModifierNode> hitTestResult, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.hitTest-M_7yMNQ$ui_release(j, hitTestResult, z, z2);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo1655entityTypeOLwlOKw() {
            return NodeKind.m1660constructorimpl(16);
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(@NotNull LayoutNode layoutNode) {
            Intrinsics.checkNotNullParameter(layoutNode, "parentLayoutNode");
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(@NotNull PointerInputModifierNode pointerInputModifierNode) {
            Intrinsics.checkNotNullParameter(pointerInputModifierNode, "node");
            return pointerInputModifierNode.interceptOutOfBoundsChildEvents();
        }
    };

    @NotNull
    private static final HitTestSource<SemanticsModifierNode> SemanticsSource = new Companion.SemanticsSource.1();

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPointerInputSource$annotations() {
        }

        @NotNull
        public final HitTestSource<PointerInputModifierNode> getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        @NotNull
        public final HitTestSource<SemanticsModifierNode> getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    /* compiled from: Taobao */
    public interface HitTestSource<N extends DelegatableNode> {
        /* renamed from: childHitTest-YqVAtuI */
        void mo1654childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j, @NotNull HitTestResult<N> hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw */
        int mo1655entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(@NotNull N n);

        boolean shouldHitTestChildren(@NotNull LayoutNode layoutNode);
    }

    public NodeCoordinator(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.Companion.getZero-nOcc-ac();
        this.invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1656invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1656invoke() {
                NodeCoordinator wrappedBy$ui_release = NodeCoordinator.this.getWrappedBy$ui_release();
                if (wrappedBy$ui_release != null) {
                    wrappedBy$ui_release.invalidateLayer();
                }
            }
        };
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        fromParentRect(mutableRect, z);
    }

    /* renamed from: ancestorToLocal-R5De75A, reason: not valid java name */
    private final long m1632ancestorToLocalR5De75A(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        return (nodeCoordinator2 == null || Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) ? m1641fromParentPositionMKHz9U(j) : m1641fromParentPositionMKHz9U(nodeCoordinator2.m1632ancestorToLocalR5De75A(nodeCoordinator, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        int m1660constructorimpl = NodeKind.m1660constructorimpl(4);
        boolean m1668getIncludeSelfInTraversalH91voCI = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(m1660constructorimpl);
        DrawModifierNode drawModifierNode = null;
        drawModifierNode = null;
        drawModifierNode = null;
        drawModifierNode = null;
        Modifier$Node tail = getTail();
        if (m1668getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
            Modifier$Node headNode = headNode(m1668getIncludeSelfInTraversalH91voCI);
            while (true) {
                if (headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m1660constructorimpl) != 0) {
                    if ((headNode.getKindSet$ui_release() & m1660constructorimpl) == 0) {
                        if (headNode == tail) {
                            break;
                        } else {
                            headNode = headNode.getChild$ui_release();
                        }
                    } else {
                        drawModifierNode = (DrawModifierNode) (headNode instanceof DrawModifierNode ? headNode : null);
                    }
                } else {
                    break;
                }
            }
        }
        DrawModifierNode drawModifierNode2 = drawModifierNode;
        if (drawModifierNode2 == null) {
            performDraw(canvas);
        } else {
            getLayoutNode().getMDrawScope$ui_release().m1610drawx_KDEd0$ui_release(canvas, IntSizeKt.m2202toSizeozmzZPI(mo1522getSizeYbymL2g()), this, drawModifierNode2);
        }
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z) {
        float f = IntOffset.getX-impl(mo1615getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - f);
        mutableRect.setRight(mutableRect.getRight() - f);
        float f2 = IntOffset.getY-impl(mo1615getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - f2);
        mutableRect.setBottom(mutableRect.getBottom() - f2);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                mutableRect.intersect(0.0f, 0.0f, IntSize.getWidth-impl(mo1522getSizeYbymL2g()), IntSize.getHeight-impl(mo1522getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier$Node headNode(boolean z) {
        Modifier$Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (!z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                return nodeCoordinator.getTail();
            }
            return null;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || (tail = nodeCoordinator2.getTail()) == null) {
            return null;
        }
        return tail.getChild$ui_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU, reason: not valid java name */
    public final <T extends DelegatableNode> void m1633hit1hIXUjU(T t, HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        if (t == null) {
            m1647hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hit(t, z2, new hit.1(this, t, hitTestSource, j, hitTestResult, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final <T extends DelegatableNode> void m1634hitNearJHbHoSQ(T t, HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2, float f) {
        if (t == null) {
            m1647hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(t, f, z2, new hitNear.1(this, t, hitTestSource, j, hitTestResult, z, z2, f));
        }
    }

    /* renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m1635offsetFromEdgeMKHz9U(long j) {
        float m848getXimpl = Offset.m848getXimpl(j);
        float max = Math.max(0.0f, m848getXimpl < 0.0f ? -m848getXimpl : m848getXimpl - getMeasuredWidth());
        float m849getYimpl = Offset.m849getYimpl(j);
        return OffsetKt.Offset(max, Math.max(0.0f, m849getYimpl < 0.0f ? -m849getYimpl : m849getYimpl - getMeasuredHeight()));
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator nodeCoordinator, Rect rect, Continuation<? super Unit> continuation) {
        Object propagateRelocationRequest;
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        return (nodeCoordinator2 != null && (propagateRelocationRequest = nodeCoordinator2.propagateRelocationRequest(rect.m871translatek4lQ0M(nodeCoordinator2.localBoundingBoxOf(nodeCoordinator, false).m869getTopLeftF1C5BW0()), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final <T extends DelegatableNode> void m1636speculativeHitJHbHoSQ(T t, HitTestSource<T> hitTestSource, long j, HitTestResult<T> hitTestResult, boolean z, boolean z2, float f) {
        Object m1658nextUncheckedUntilhw7D004;
        if (t == null) {
            m1647hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else if (hitTestSource.interceptOutOfBoundsChildEvents(t)) {
            hitTestResult.speculativeHit(t, f, z2, new speculativeHit.1(this, t, hitTestSource, j, hitTestResult, z, z2, f));
        } else {
            m1658nextUncheckedUntilhw7D004 = NodeCoordinatorKt.m1658nextUncheckedUntilhw7D004(t, hitTestSource.mo1655entityTypeOLwlOKw(), NodeKind.m1660constructorimpl(2));
            m1636speculativeHitJHbHoSQ((DelegatableNode) m1658nextUncheckedUntilhw7D004, hitTestSource, j, hitTestResult, z, z2, f);
        }
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) layoutCoordinates : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m1637transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (Intrinsics.areEqual(nodeCoordinator, this)) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        Intrinsics.checkNotNull(nodeCoordinator2);
        nodeCoordinator2.m1637transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
        if (!IntOffset.equals-impl0(mo1615getPositionnOccac(), IntOffset.Companion.getZero-nOcc-ac())) {
            float[] fArr2 = tmpMatrix;
            Matrix.m1162resetimpl(fArr2);
            Matrix.m1173translateimpl$default(fArr2, -IntOffset.getX-impl(mo1615getPositionnOccac()), -IntOffset.getY-impl(mo1615getPositionnOccac()), 0.0f, 4, null);
            Matrix.m1170timesAssign58bKbWc(fArr, fArr2);
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.m1701inverseTransform58bKbWc(fArr);
        }
    }

    /* renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m1638transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.m1706transform58bKbWc(fArr);
            }
            if (!IntOffset.equals-impl0(nodeCoordinator2.mo1615getPositionnOccac(), IntOffset.Companion.getZero-nOcc-ac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m1162resetimpl(fArr2);
                Matrix.m1173translateimpl$default(fArr2, IntOffset.getX-impl(r1), IntOffset.getY-impl(r1), 0.0f, 4, null);
                Matrix.m1170timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
            reusableGraphicsLayerScope.reset();
            reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
            reusableGraphicsLayerScope.m1203setSizeuvyYCjk(IntSizeKt.m2202toSizeozmzZPI(mo1522getSizeYbymL2g()));
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new updateLayerParameters.1(function1));
            LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
            if (layerPositionalProperties == null) {
                layerPositionalProperties = new LayerPositionalProperties();
                this.layerPositionalProperties = layerPositionalProperties;
            }
            layerPositionalProperties.copyFrom(reusableGraphicsLayerScope);
            ownedLayer.m1707updateLayerPropertiesdDxrwY(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.m1198getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getClip(), reusableGraphicsLayerScope.getRenderEffect(), reusableGraphicsLayerScope.m1194getAmbientShadowColor0d7_KjU(), reusableGraphicsLayerScope.m1197getSpotShadowColor0d7_KjU(), reusableGraphicsLayerScope.m1195getCompositingStrategyNrFUSI(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
            this.isClipping = reusableGraphicsLayerScope.getClip();
        } else {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    public void attach() {
        onLayerBlockUpdated(this.layerBlock);
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m1639calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m903getWidthimpl(j) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m900getHeightimpl(j) - getMeasuredHeight()) / 2.0f));
    }

    @NotNull
    public abstract LookaheadDelegate createLookaheadDelegate(@NotNull LookaheadScope lookaheadScope);

    public void detach() {
        if (this.layer != null) {
            onLayerBlockUpdated(null);
        }
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m1640distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        if (getMeasuredWidth() >= Size.m903getWidthimpl(j2) && getMeasuredHeight() >= Size.m900getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long m1639calculateMinimumTouchTargetPaddingE7KxVPU = m1639calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float m903getWidthimpl = Size.m903getWidthimpl(m1639calculateMinimumTouchTargetPaddingE7KxVPU);
        float m900getHeightimpl = Size.m900getHeightimpl(m1639calculateMinimumTouchTargetPaddingE7KxVPU);
        long m1635offsetFromEdgeMKHz9U = m1635offsetFromEdgeMKHz9U(j);
        if ((m903getWidthimpl > 0.0f || m900getHeightimpl > 0.0f) && Offset.m848getXimpl(m1635offsetFromEdgeMKHz9U) <= m903getWidthimpl && Offset.m849getYimpl(m1635offsetFromEdgeMKHz9U) <= m900getHeightimpl) {
            return Offset.m847getDistanceSquaredimpl(m1635offsetFromEdgeMKHz9U);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float f = IntOffset.getX-impl(mo1615getPositionnOccac());
        float f2 = IntOffset.getY-impl(mo1615getPositionnOccac());
        canvas.translate(f, f2);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-f, -f2);
    }

    protected final void drawBorder(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, IntSize.getWidth-impl(m1564getMeasuredSizeYbymL2g()) - 0.5f, IntSize.getHeight-impl(m1564getMeasuredSizeYbymL2g()) - 0.5f), paint);
    }

    @NotNull
    public final NodeCoordinator findCommonAncestor$ui_release(@NotNull NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "other");
        LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode2 = getLayoutNode();
        if (layoutNode == layoutNode2) {
            Modifier$Node tail = nodeCoordinator.getTail();
            Modifier$Node tail2 = getTail();
            int m1660constructorimpl = NodeKind.m1660constructorimpl(2);
            if (!tail2.getNode().isAttached()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            for (Modifier$Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & m1660constructorimpl) != 0 && parent$ui_release == tail) {
                    return nodeCoordinator;
                }
            }
            return this;
        }
        while (layoutNode.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode = layoutNode.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode);
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode != layoutNode2) {
            layoutNode = layoutNode.getParent$ui_release();
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode == null || layoutNode2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        return layoutNode2 == getLayoutNode() ? this : layoutNode == nodeCoordinator.getLayoutNode() ? nodeCoordinator : layoutNode.getInnerCoordinator$ui_release();
    }

    /* renamed from: fromParentPosition-MK-Hz9U, reason: not valid java name */
    public long m1641fromParentPositionMKHz9U(long j) {
        long j2 = IntOffsetKt.minus-Nv-tHpc(j, mo1615getPositionnOccac());
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer != null ? ownedLayer.m1703mapOffset8S9VItk(j2, true) : j2;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    @NotNull
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    @Nullable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    @NotNull
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    @Nullable
    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Nullable
    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    @NotNull
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Nullable
    public final LookaheadDelegate getLookaheadDelegate$ui_release() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    @NotNull
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m1642getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo314toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().m1796getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    @Nullable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @Nullable
    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.IntrinsicMeasurable
    @Nullable
    public Object getParentData() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Modifier$Node tail = getTail();
        if (getLayoutNode().getNodes$ui_release().m1622hasH91voCI$ui_release(NodeKind.m1660constructorimpl(64))) {
            Density density = getLayoutNode().getDensity();
            for (Modifier$Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if (tail$ui_release != tail) {
                    if (((NodeKind.m1660constructorimpl(64) & tail$ui_release.getKindSet$ui_release()) != 0) && (tail$ui_release instanceof ParentDataModifierNode)) {
                        objectRef.element = ((ParentDataModifierNode) tail$ui_release).modifyParentData(density, objectRef.element);
                    }
                }
            }
        }
        return objectRef.element;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @Nullable
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac */
    public long mo1615getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @NotNull
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        LinkedHashSet linkedHashSet = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            Map alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z = true;
            }
            if (z) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(alignmentLines.keySet());
            }
        }
        return linkedHashSet == null ? SetsKt.emptySet() : linkedHashSet;
    }

    @NotNull
    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo1522getSizeYbymL2g() {
        return m1564getMeasuredSizeYbymL2g();
    }

    @NotNull
    public abstract Modifier$Node getTail();

    @Nullable
    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    @Nullable
    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    /* renamed from: hasNode-H91voCI, reason: not valid java name */
    public final boolean m1643hasNodeH91voCI(int i) {
        Modifier$Node headNode = headNode(NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(i));
        return headNode != null && DelegatableNodeKt.m1596has64DMado(headNode, i);
    }

    /* renamed from: head-H91voCI, reason: not valid java name */
    public final /* synthetic */ <T> T m1644headH91voCI(int i) {
        boolean m1668getIncludeSelfInTraversalH91voCI = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(i);
        Modifier$Node tail = getTail();
        if (!m1668getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        for (Object obj = (T) headNode(m1668getIncludeSelfInTraversalH91voCI); obj != null && (((Modifier$Node) obj).getAggregateChildKindSet$ui_release() & i) != 0; obj = (T) ((Modifier$Node) obj).getChild$ui_release()) {
            if ((((Modifier$Node) obj).getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) obj;
            }
            if (obj == tail) {
                return null;
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: headUnchecked-H91voCI, reason: not valid java name */
    public final <T> T m1645headUncheckedH91voCI(int i) {
        boolean m1668getIncludeSelfInTraversalH91voCI = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(i);
        Modifier$Node tail = getTail();
        if (!m1668getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        for (Object obj = (T) headNode(m1668getIncludeSelfInTraversalH91voCI); obj != null && (((Modifier$Node) obj).getAggregateChildKindSet$ui_release() & i) != 0; obj = (T) ((Modifier$Node) obj).getChild$ui_release()) {
            if ((((Modifier$Node) obj).getKindSet$ui_release() & i) != 0) {
                return (T) obj;
            }
            if (obj == tail) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final <T extends DelegatableNode> void m1646hitTestYqVAtuI(@NotNull HitTestSource<T> hitTestSource, long j, @NotNull HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        DelegatableNode delegatableNode = (DelegatableNode) m1645headUncheckedH91voCI(hitTestSource.mo1655entityTypeOLwlOKw());
        if (!m1653withinLayerBoundsk4lQ0M(j)) {
            if (z) {
                float m1640distanceInMinimumTouchTargettz77jQw = m1640distanceInMinimumTouchTargettz77jQw(j, m1642getMinimumTouchTargetSizeNHjbRc());
                if (((Float.isInfinite(m1640distanceInMinimumTouchTargettz77jQw) || Float.isNaN(m1640distanceInMinimumTouchTargettz77jQw)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(m1640distanceInMinimumTouchTargettz77jQw, false)) {
                    m1634hitNearJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, false, m1640distanceInMinimumTouchTargettz77jQw);
                    return;
                }
                return;
            }
            return;
        }
        if (delegatableNode == null) {
            m1647hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        if (m1648isPointerInBoundsk4lQ0M(j)) {
            m1633hit1hIXUjU(delegatableNode, hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        float m1640distanceInMinimumTouchTargettz77jQw2 = !z ? Float.POSITIVE_INFINITY : m1640distanceInMinimumTouchTargettz77jQw(j, m1642getMinimumTouchTargetSizeNHjbRc());
        if (((Float.isInfinite(m1640distanceInMinimumTouchTargettz77jQw2) || Float.isNaN(m1640distanceInMinimumTouchTargettz77jQw2)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(m1640distanceInMinimumTouchTargettz77jQw2, z2)) {
            m1634hitNearJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, z2, m1640distanceInMinimumTouchTargettz77jQw2);
        } else {
            m1636speculativeHitJHbHoSQ(delegatableNode, hitTestSource, j, hitTestResult, z, z2, m1640distanceInMinimumTouchTargettz77jQw2);
        }
    }

    /* renamed from: hitTestChild-YqVAtuI, reason: not valid java name */
    public <T extends DelegatableNode> void m1647hitTestChildYqVAtuI(@NotNull HitTestSource<T> hitTestSource, long j, @NotNull HitTestResult<T> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m1646hitTestYqVAtuI(hitTestSource, nodeCoordinator.m1641fromParentPositionMKHz9U(j), hitTestResult, z, z2);
        }
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().isAttached();
    }

    /* renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m1648isPointerInBoundsk4lQ0M(long j) {
        float m848getXimpl = Offset.m848getXimpl(j);
        float m849getYimpl = Offset.m849getYimpl(j);
        return m848getXimpl >= 0.0f && m849getYimpl >= 0.0f && m848getXimpl < ((float) getMeasuredWidth()) && m849getYimpl < ((float) getMeasuredHeight());
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public boolean isValid() {
        return this.layer != null && isAttached();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    @NotNull
    public Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        if (!layoutCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + layoutCoordinates + " is not attached!").toString());
        }
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        MutableRect rectCache = getRectCache();
        rectCache.setLeft(0.0f);
        rectCache.setTop(0.0f);
        rectCache.setRight(IntSize.getWidth-impl(layoutCoordinates.mo1522getSizeYbymL2g()));
        rectCache.setBottom(IntSize.getHeight-impl(layoutCoordinates.mo1522getSizeYbymL2g()));
        while (coordinator != findCommonAncestor$ui_release) {
            rectInParent$ui_release$default(coordinator, rectCache, z, false, 4, null);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        ancestorToLocal(findCommonAncestor$ui_release, rectCache, z);
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo1523localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            j = coordinator.m1651toParentPositionMKHz9U(j);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m1632ancestorToLocalR5De75A(findCommonAncestor$ui_release, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo1524localToRootMKHz9U(long j) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
            j = nodeCoordinator.m1651toParentPositionMKHz9U(j);
        }
        return j;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo1525localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).calculatePositionInWindow-MK-Hz9U(mo1524localToRootMKHz9U(j));
    }

    public final void onLayerBlockUpdated(@Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        Owner owner$ui_release;
        boolean z = (this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, getLayoutNode().getDensity()) && this.layerLayoutDirection == getLayoutNode().getLayoutDirection()) ? false : true;
        this.layerBlock = function1;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        if (!isAttached() || function1 == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(getLayoutNode());
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        if (this.layer != null) {
            if (z) {
                updateLayerParameters();
                return;
            }
            return;
        }
        OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this, this.invalidateParentLayer);
        createLayer.m1705resizeozmzZPI(m1564getMeasuredSizeYbymL2g());
        createLayer.m1704movegyyYBs(mo1615getPositionnOccac());
        this.layer = createLayer;
        updateLayerParameters();
        getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
        this.invalidateParentLayer.invoke();
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    protected void onMeasureResultChanged(int i, int i2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.m1705resizeozmzZPI(IntSizeKt.IntSize(i, i2));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
        m1566setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
        graphicsLayerScope.m1203setSizeuvyYCjk(IntSizeKt.m2202toSizeozmzZPI(m1564getMeasuredSizeYbymL2g()));
        int m1660constructorimpl = NodeKind.m1660constructorimpl(4);
        boolean m1668getIncludeSelfInTraversalH91voCI = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(m1660constructorimpl);
        Modifier$Node tail = getTail();
        if (!m1668getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier$Node headNode = headNode(m1668getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m1660constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & m1660constructorimpl) != 0 && (headNode instanceof DrawModifierNode)) {
                ((DrawModifierNode) headNode).onMeasureResultChanged();
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    public final void onMeasured() {
        Modifier$Node parent$ui_release;
        if (m1643hasNodeH91voCI(NodeKind.m1660constructorimpl(128))) {
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                try {
                    int m1660constructorimpl = NodeKind.m1660constructorimpl(128);
                    boolean m1668getIncludeSelfInTraversalH91voCI = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(m1660constructorimpl);
                    if (m1668getIncludeSelfInTraversalH91voCI) {
                        parent$ui_release = getTail();
                    } else {
                        parent$ui_release = getTail().getParent$ui_release();
                        if (parent$ui_release == null) {
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    for (Modifier$Node headNode = headNode(m1668getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m1660constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
                        if ((headNode.getKindSet$ui_release() & m1660constructorimpl) != 0 && (headNode instanceof LayoutAwareModifierNode)) {
                            ((LayoutAwareModifierNode) headNode).onRemeasured-ozmzZPI(m1564getMeasuredSizeYbymL2g());
                        }
                        if (headNode == parent$ui_release) {
                            break;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                }
            } finally {
                createNonObservableSnapshot.dispose();
            }
        }
    }

    public final void onPlaced() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (lookaheadDelegate != null) {
            int m1660constructorimpl = NodeKind.m1660constructorimpl(128);
            boolean m1668getIncludeSelfInTraversalH91voCI = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(m1660constructorimpl);
            Modifier$Node tail = getTail();
            if (m1668getIncludeSelfInTraversalH91voCI || (tail = tail.getParent$ui_release()) != null) {
                for (Modifier$Node headNode = headNode(m1668getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & m1660constructorimpl) != 0; headNode = headNode.getChild$ui_release()) {
                    if ((headNode.getKindSet$ui_release() & m1660constructorimpl) != 0 && (headNode instanceof LayoutAwareModifierNode)) {
                        ((LayoutAwareModifierNode) headNode).onLookaheadPlaced(lookaheadDelegate.getLookaheadLayoutCoordinates());
                    }
                    if (headNode == tail) {
                        break;
                    }
                }
            }
        }
        int m1660constructorimpl2 = NodeKind.m1660constructorimpl(128);
        boolean m1668getIncludeSelfInTraversalH91voCI2 = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(m1660constructorimpl2);
        Modifier$Node tail2 = getTail();
        if (!m1668getIncludeSelfInTraversalH91voCI2 && (tail2 = tail2.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier$Node headNode2 = headNode(m1668getIncludeSelfInTraversalH91voCI2); headNode2 != null && (headNode2.getAggregateChildKindSet$ui_release() & m1660constructorimpl2) != 0; headNode2 = headNode2.getChild$ui_release()) {
            if ((headNode2.getKindSet$ui_release() & m1660constructorimpl2) != 0 && (headNode2 instanceof LayoutAwareModifierNode)) {
                ((LayoutAwareModifierNode) headNode2).onPlaced(this);
            }
            if (headNode2 == tail2) {
                return;
            }
        }
    }

    public void performDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    @NotNull
    /* renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    protected final Placeable m1649performingMeasureK40F9xA(long j, @NotNull Function0<? extends Placeable> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        m1567setMeasurementConstraintsBRTryo0(j);
        Placeable placeable = (Placeable) function0.invoke();
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.m1705resizeozmzZPI(m1564getMeasuredSizeYbymL2g());
        }
        return placeable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo1558placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        onLayerBlockUpdated(function1);
        if (!IntOffset.equals-impl0(mo1615getPositionnOccac(), j)) {
            m1650setPositiongyyYBs(j);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m1704movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f;
    }

    @Nullable
    public Object propagateRelocationRequest(@NotNull Rect rect, @NotNull Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    public final void rectInParent$ui_release(@NotNull MutableRect mutableRect, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(mutableRect, "bounds");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long m1642getMinimumTouchTargetSizeNHjbRc = m1642getMinimumTouchTargetSizeNHjbRc();
                    float m903getWidthimpl = Size.m903getWidthimpl(m1642getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float m900getHeightimpl = Size.m900getHeightimpl(m1642getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    mutableRect.intersect(-m903getWidthimpl, -m900getHeightimpl, IntSize.getWidth-impl(mo1522getSizeYbymL2g()) + m903getWidthimpl, IntSize.getHeight-impl(mo1522getSizeYbymL2g()) + m900getHeightimpl);
                } else if (z) {
                    mutableRect.intersect(0.0f, 0.0f, IntSize.getWidth-impl(mo1522getSizeYbymL2g()), IntSize.getHeight-impl(mo1522getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float f = IntOffset.getX-impl(mo1615getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + f);
        mutableRect.setRight(mutableRect.getRight() + f);
        float f2 = IntOffset.getY-impl(mo1615getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + f2);
        mutableRect.setBottom(mutableRect.getBottom() + f2);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo1558placeAtf8xVGno(mo1615getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    public void setMeasureResult$ui_release(@NotNull MeasureResult measureResult) {
        Intrinsics.checkNotNullParameter(measureResult, "value");
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (measureResult2 == null || measureResult.getWidth() != measureResult2.getWidth() || measureResult.getHeight() != measureResult2.getHeight()) {
                onMeasureResultChanged(measureResult.getWidth(), measureResult.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
    }

    /* renamed from: setPosition--gyyYBs, reason: not valid java name */
    protected void m1650setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final void setWrapped$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final void setWrappedBy$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Modifier$Node headNode = headNode(NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(NodeKind.m1660constructorimpl(16)));
        if (headNode == null) {
            return false;
        }
        int m1660constructorimpl = NodeKind.m1660constructorimpl(16);
        if (!headNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node node = headNode.getNode();
        if ((node.getAggregateChildKindSet$ui_release() & m1660constructorimpl) != 0) {
            for (PointerInputModifierNode child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & m1660constructorimpl) != 0 && (child$ui_release instanceof PointerInputModifierNode) && child$ui_release.sharePointerInputWithSiblings()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: toParentPosition-MK-Hz9U, reason: not valid java name */
    public long m1651toParentPositionMKHz9U(long j) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.m1703mapOffset8S9VItk(j, false);
        }
        return IntOffsetKt.plus-Nv-tHpc(j, mo1615getPositionnOccac());
    }

    @NotNull
    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect rectCache = getRectCache();
        long m1639calculateMinimumTouchTargetPaddingE7KxVPU = m1639calculateMinimumTouchTargetPaddingE7KxVPU(m1642getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m903getWidthimpl(m1639calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setTop(-Size.m900getHeightimpl(m1639calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setRight(getMeasuredWidth() + Size.m903getWidthimpl(m1639calculateMinimumTouchTargetPaddingE7KxVPU));
        rectCache.setBottom(getMeasuredHeight() + Size.m900getHeightimpl(m1639calculateMinimumTouchTargetPaddingE7KxVPU));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(rectCache);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo1526transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m1162resetimpl(fArr);
        coordinator.m1638transformToAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
        m1637transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
    }

    protected final void updateLookaheadDelegate(@NotNull LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final void updateLookaheadScope$ui_release(@Nullable LookaheadScope lookaheadScope) {
        if (lookaheadScope != null) {
            LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
            r0 = !Intrinsics.areEqual(lookaheadScope, lookaheadDelegate != null ? lookaheadDelegate.getLookaheadScope() : null) ? createLookaheadDelegate(lookaheadScope) : this.lookaheadDelegate;
        }
        this.lookaheadDelegate = r0;
    }

    public final void visitNodes(int i, boolean z, @NotNull Function1<? super Modifier$Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Modifier$Node tail = getTail();
        if (!z && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier$Node headNode = headNode(z); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                function1.invoke(headNode);
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ, reason: not valid java name */
    public final /* synthetic */ <T> void m1652visitNodesaLcG6gQ(int i, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        boolean m1668getIncludeSelfInTraversalH91voCI = NodeKindKt.m1668getIncludeSelfInTraversalH91voCI(i);
        Modifier$Node tail = getTail();
        if (!m1668getIncludeSelfInTraversalH91voCI && (tail = tail.getParent$ui_release()) == null) {
            return;
        }
        for (Modifier$Node headNode = headNode(m1668getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet$ui_release() & i) != 0; headNode = headNode.getChild$ui_release()) {
            if ((headNode.getKindSet$ui_release() & i) != 0) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                function1.invoke(headNode);
            }
            if (headNode == tail) {
                return;
            }
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo1527windowToLocalMKHz9U(long j) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        return mo1523localPositionOfR5De75A(findRootCoordinates, Offset.m852minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).calculateLocalPosition-MK-Hz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
    }

    protected final void withPositionTranslation(@NotNull Canvas canvas, @NotNull Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(function1, "block");
        float f = IntOffset.getX-impl(mo1615getPositionnOccac());
        float f2 = IntOffset.getY-impl(mo1615getPositionnOccac());
        canvas.translate(f, f2);
        function1.invoke(canvas);
        canvas.translate(-f, -f2);
    }

    /* renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m1653withinLayerBoundsk4lQ0M(long j) {
        if (!OffsetKt.isFinite-k-4lQ0M(j)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        return ownedLayer == null || !this.isClipping || ownedLayer.m1702isInLayerk4lQ0M(j);
    }

    public void invoke(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!getLayoutNode().isPlaced()) {
            this.lastLayerDrawingWasSkipped = true;
        } else {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new invoke.1(this, canvas));
            this.lastLayerDrawingWasSkipped = false;
        }
    }
}
