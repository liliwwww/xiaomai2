package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class InnerNodeCoordinator extends NodeCoordinator {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Paint innerBoundsPaint;

    @NotNull
    private final Modifier.Node tail;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m1167setColor8_81llA(Color.Companion.m1082getRed0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.m1171setStylek9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        innerBoundsPaint = Paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerNodeCoordinator(@NotNull LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.tail = new Modifier.Node() { // from class: androidx.compose.ui.node.InnerNodeCoordinator$tail$1
            @NotNull
            public String toString() {
                return "<tail>";
            }
        };
        getTail().updateCoordinator$ui_release(this);
    }

    public static /* synthetic */ void getTail$annotations() {
    }

    public int calculateAlignmentLine(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate$ui_release = getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            return lookaheadDelegate$ui_release.calculateAlignmentLine(alignmentLine);
        }
        Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @NotNull
    public LookaheadDelegate createLookaheadDelegate(@NotNull LookaheadScope lookaheadScope) {
        Intrinsics.checkNotNullParameter(lookaheadScope, "scope");
        return new LookaheadDelegateImpl(this, lookaheadScope);
    }

    @NotNull
    public Modifier.Node getTail() {
        return this.tail;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0 A[EDGE_INSN: B:22:0x00a0->B:28:0x00a0 BREAK  A[LOOP:0: B:10:0x0064->B:21:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
    /* renamed from: hitTestChild-YqVAtuI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T extends androidx.compose.ui.node.DelegatableNode> void m2115hitTestChildYqVAtuI(@org.jetbrains.annotations.NotNull androidx.compose.ui.node.NodeCoordinator.HitTestSource<T> r20, long r21, @org.jetbrains.annotations.NotNull androidx.compose.ui.node.HitTestResult<T> r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r0 = r19
            r8 = r20
            r9 = r21
            r11 = r23
            java.lang.String r1 = "hitTestSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "hitTestResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            androidx.compose.ui.node.LayoutNode r1 = r19.getLayoutNode()
            boolean r1 = r8.shouldHitTestChildren(r1)
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L46
            boolean r1 = r0.withinLayerBounds-k-4lQ0M(r9)
            if (r1 == 0) goto L28
            r14 = r25
            r1 = 1
            goto L49
        L28:
            if (r24 == 0) goto L46
            long r1 = r19.getMinimumTouchTargetSize-NH-jbRc()
            float r1 = r0.distanceInMinimumTouchTarget-tz77jQw(r9, r1)
            boolean r2 = java.lang.Float.isInfinite(r1)
            if (r2 != 0) goto L40
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L40
            r1 = 1
            goto L41
        L40:
            r1 = 0
        L41:
            if (r1 == 0) goto L46
            r1 = 1
            r14 = 0
            goto L49
        L46:
            r14 = r25
            r1 = 0
        L49:
            if (r1 == 0) goto La3
            int r15 = androidx.compose.ui.node.HitTestResult.access$getHitDepth$p(r23)
            androidx.compose.ui.node.LayoutNode r1 = r19.getLayoutNode()
            androidx.compose.runtime.collection.MutableVector r1 = r1.getZSortedChildren()
            int r2 = r1.getSize()
            if (r2 <= 0) goto La0
            int r2 = r2 - r13
            java.lang.Object[] r16 = r1.getContent()
            r17 = r2
        L64:
            r1 = r16[r17]
            r18 = r1
            androidx.compose.ui.node.LayoutNode r18 = (androidx.compose.ui.node.LayoutNode) r18
            boolean r1 = r18.isPlaced()
            if (r1 == 0) goto L99
            r1 = r20
            r2 = r18
            r3 = r21
            r5 = r23
            r6 = r24
            r7 = r14
            r1.childHitTest-YqVAtuI(r2, r3, r5, r6, r7)
            boolean r1 = r23.hasHit()
            if (r1 != 0) goto L86
        L84:
            r1 = 1
            goto L95
        L86:
            androidx.compose.ui.node.NodeCoordinator r1 = r18.getOuterCoordinator$ui_release()
            boolean r1 = r1.shouldSharePointerInputWithSiblings()
            if (r1 == 0) goto L94
            r23.acceptHits()
            goto L84
        L94:
            r1 = 0
        L95:
            if (r1 != 0) goto L99
            r1 = 1
            goto L9a
        L99:
            r1 = 0
        L9a:
            if (r1 != 0) goto La0
            int r17 = r17 + (-1)
            if (r17 >= 0) goto L64
        La0:
            androidx.compose.ui.node.HitTestResult.access$setHitDepth$p(r11, r15)
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerNodeCoordinator.m2115hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator$HitTestSource, long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    public int maxIntrinsicHeight(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().maxIntrinsicWidth(i);
    }

    @NotNull
    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable m2116measureBRTryo0(long j) {
        NodeCoordinator.access$setMeasurementConstraints-BRTryo0(this, j);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector.getContent();
            do {
                content[i].setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i++;
            } while (i < size);
        }
        setMeasureResult$ui_release(getLayoutNode().getMeasurePolicy().measure-3p2s80s(this, getLayoutNode().getChildMeasurables$ui_release(), j));
        onMeasured();
        return this;
    }

    public int minIntrinsicHeight(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicHeight(i);
    }

    public int minIntrinsicWidth(int i) {
        return getLayoutNode().getIntrinsicsPolicy$ui_release().minIntrinsicWidth(i);
    }

    public void performDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = zSortedChildren.getContent();
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.isPlaced()) {
                    layoutNode.draw$ui_release(canvas);
                }
                i++;
            } while (i < size);
        }
        if (requireOwner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    protected void m2117placeAtf8xVGno(long j, float f, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        super.placeAt-f8xVGno(j, f, function1);
        if (isShallowPlacing$ui_release()) {
            return;
        }
        onPlaced();
        getLayoutNode().onNodePlaced$ui_release();
    }
}
