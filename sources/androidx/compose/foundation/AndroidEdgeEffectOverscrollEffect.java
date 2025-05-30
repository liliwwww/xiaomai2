package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {

    @NotNull
    private final List<EdgeEffect> allEffects;

    @NotNull
    private final EdgeEffect bottomEffect;

    @NotNull
    private final EdgeEffect bottomEffectNegation;
    private long containerSize;

    @NotNull
    private final Modifier effectModifier;
    private boolean invalidationEnabled;

    @NotNull
    private final EdgeEffect leftEffect;

    @NotNull
    private final EdgeEffect leftEffectNegation;

    @NotNull
    private final Function1<IntSize, Unit> onNewSize;

    @NotNull
    private final OverscrollConfiguration overscrollConfig;

    @Nullable
    private PointerId pointerId;

    @Nullable
    private Offset pointerPosition;

    @NotNull
    private final MutableState<Unit> redrawSignal;

    @NotNull
    private final EdgeEffect rightEffect;

    @NotNull
    private final EdgeEffect rightEffectNegation;
    private boolean scrollCycleInProgress;

    @NotNull
    private final EdgeEffect topEffect;

    @NotNull
    private final EdgeEffect topEffectNegation;

    public AndroidEdgeEffectOverscrollEffect(@NotNull Context context, @NotNull OverscrollConfiguration overscrollConfiguration) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(overscrollConfiguration, "overscrollConfig");
        this.overscrollConfig = overscrollConfiguration;
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        EdgeEffect create = edgeEffectCompat.create(context, null);
        this.topEffect = create;
        EdgeEffect create2 = edgeEffectCompat.create(context, null);
        this.bottomEffect = create2;
        EdgeEffect create3 = edgeEffectCompat.create(context, null);
        this.leftEffect = create3;
        EdgeEffect create4 = edgeEffectCompat.create(context, null);
        this.rightEffect = create4;
        List<EdgeEffect> listOf = CollectionsKt.listOf(new EdgeEffect[]{create3, create, create4, create2});
        this.allEffects = listOf;
        this.topEffectNegation = edgeEffectCompat.create(context, null);
        this.bottomEffectNegation = edgeEffectCompat.create(context, null);
        this.leftEffectNegation = edgeEffectCompat.create(context, null);
        this.rightEffectNegation = edgeEffectCompat.create(context, null);
        int size = listOf.size();
        for (int i = 0; i < size; i++) {
            listOf.get(i).setColor(ColorKt.toArgb-8_81llA(this.overscrollConfig.getGlowColor-0d7_KjU()));
        }
        Unit unit = Unit.INSTANCE;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(unit, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.Companion.getZero-NH-jbRc();
        onNewSize.1 r9 = new onNewSize.1(this);
        this.onNewSize = r9;
        Modifier.Companion companion = Modifier.Companion;
        modifier = AndroidOverscrollKt.StretchOverscrollNonClippingLayer;
        this.effectModifier = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(companion.then(modifier), unit, new effectModifier.1(this, (Continuation) null)), r9).then(new DrawOverscrollModifier(this, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AndroidEdgeEffectOverscrollEffect$special$.inlined.debugInspectorInfo.1(this) : InspectableValueKt.getNoInspectorInfo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            EdgeEffect edgeEffect = list.get(i);
            edgeEffect.onRelease();
            z = edgeEffect.isFinished() || z;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    private final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.getWidth-impl(this.containerSize), (-Size.getHeight-impl(this.containerSize)) + drawScope.toPx-0680j_4(this.overscrollConfig.getDrawPadding().calculateBottomPadding-D9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.getHeight-impl(this.containerSize), drawScope.toPx-0680j_4(this.overscrollConfig.getDrawPadding().calculateLeftPadding-u2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt.roundToInt(Size.getWidth-impl(this.containerSize));
        float f = this.overscrollConfig.getDrawPadding().calculateRightPadding-u2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, (-roundToInt) + drawScope.toPx-0680j_4(f));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    private final boolean drawTop(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.translate(0.0f, drawScope.toPx-0680j_4(this.overscrollConfig.getDrawPadding().calculateTopPadding-D9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    /* renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    private final float m107pullBottom0a9Yr6o(long j, long j2) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.bottomEffect, -(Offset.getY-impl(j) / Size.getHeight-impl(this.containerSize)), 1 - (Offset.getX-impl(j2) / Size.getWidth-impl(this.containerSize)))) * Size.getHeight-impl(this.containerSize);
    }

    /* renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    private final float m108pullLeft0a9Yr6o(long j, long j2) {
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.leftEffect, Offset.getX-impl(j) / Size.getWidth-impl(this.containerSize), 1 - (Offset.getY-impl(j2) / Size.getHeight-impl(this.containerSize))) * Size.getWidth-impl(this.containerSize);
    }

    /* renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    private final float m109pullRight0a9Yr6o(long j, long j2) {
        return (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.rightEffect, -(Offset.getX-impl(j) / Size.getWidth-impl(this.containerSize)), Offset.getY-impl(j2) / Size.getHeight-impl(this.containerSize))) * Size.getWidth-impl(this.containerSize);
    }

    /* renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    private final float m110pullTop0a9Yr6o(long j, long j2) {
        float f = Offset.getX-impl(j2) / Size.getWidth-impl(this.containerSize);
        return EdgeEffectCompat.INSTANCE.onPullDistanceCompat(this.topEffect, Offset.getY-impl(j) / Size.getHeight-impl(this.containerSize), f) * Size.getHeight-impl(this.containerSize);
    }

    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    private final boolean m111releaseOppositeOverscrollk4lQ0M(long j) {
        boolean z;
        if (this.leftEffect.isFinished() || Offset.getX-impl(j) >= 0.0f) {
            z = false;
        } else {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.leftEffect, Offset.getX-impl(j));
            z = this.leftEffect.isFinished();
        }
        if (!this.rightEffect.isFinished() && Offset.getX-impl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.rightEffect, Offset.getX-impl(j));
            z = z || this.rightEffect.isFinished();
        }
        if (!this.topEffect.isFinished() && Offset.getY-impl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.topEffect, Offset.getY-impl(j));
            z = z || this.topEffect.isFinished();
        }
        if (this.bottomEffect.isFinished() || Offset.getY-impl(j) <= 0.0f) {
            return z;
        }
        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.bottomEffect, Offset.getY-impl(j));
        return z || this.bottomEffect.isFinished();
    }

    private final boolean stopOverscrollAnimation() {
        boolean z;
        long j = SizeKt.getCenter-uvyYCjk(this.containerSize);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        if (edgeEffectCompat.getDistanceCompat(this.leftEffect) == 0.0f) {
            z = false;
        } else {
            m108pullLeft0a9Yr6o(Offset.Companion.m1024getZeroF1C5BW0(), j);
            z = true;
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.rightEffect) == 0.0f)) {
            m109pullRight0a9Yr6o(Offset.Companion.m1024getZeroF1C5BW0(), j);
            z = true;
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.topEffect) == 0.0f)) {
            m110pullTop0a9Yr6o(Offset.Companion.m1024getZeroF1C5BW0(), j);
            z = true;
        }
        if (edgeEffectCompat.getDistanceCompat(this.bottomEffect) == 0.0f) {
            return z;
        }
        m107pullBottom0a9Yr6o(Offset.Companion.m1024getZeroF1C5BW0(), j);
        return true;
    }

    @Nullable
    /* renamed from: consumePostFling-sF-c-tU, reason: not valid java name */
    public Object m112consumePostFlingsFctU(long j, @NotNull Continuation<? super Unit> continuation) {
        if (Size.isEmpty-impl(this.containerSize)) {
            return Unit.INSTANCE;
        }
        this.scrollCycleInProgress = false;
        if (Velocity.m2710getXimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.leftEffect, MathKt.roundToInt(Velocity.m2710getXimpl(j)));
        } else if (Velocity.m2710getXimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.rightEffect, -MathKt.roundToInt(Velocity.m2710getXimpl(j)));
        }
        if (Velocity.m2711getYimpl(j) > 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.topEffect, MathKt.roundToInt(Velocity.m2711getYimpl(j)));
        } else if (Velocity.m2711getYimpl(j) < 0.0f) {
            EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.bottomEffect, -MathKt.roundToInt(Velocity.m2711getYimpl(j)));
        }
        if (!Velocity.m2709equalsimpl0(j, Velocity.Companion.getZero-9UxMQ8M())) {
            invalidateOverscroll();
        }
        animateToRelease();
        return Unit.INSTANCE;
    }

    /* renamed from: consumePostScroll-OMhpSzk, reason: not valid java name */
    public void m113consumePostScrollOMhpSzk(long j, long j2, int i) {
        boolean z;
        if (Size.isEmpty-impl(this.containerSize)) {
            return;
        }
        boolean z2 = true;
        if (NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getDrag-WNlRxjI())) {
            Offset offset = this.pointerPosition;
            long j3 = offset != null ? offset.unbox-impl() : SizeKt.getCenter-uvyYCjk(this.containerSize);
            if (Offset.getX-impl(j2) > 0.0f) {
                m108pullLeft0a9Yr6o(j2, j3);
            } else if (Offset.getX-impl(j2) < 0.0f) {
                m109pullRight0a9Yr6o(j2, j3);
            }
            if (Offset.getY-impl(j2) > 0.0f) {
                m110pullTop0a9Yr6o(j2, j3);
            } else if (Offset.getY-impl(j2) < 0.0f) {
                m107pullBottom0a9Yr6o(j2, j3);
            }
            z = !Offset.equals-impl0(j2, Offset.Companion.m1024getZeroF1C5BW0());
        } else {
            z = false;
        }
        if (!m111releaseOppositeOverscrollk4lQ0M(j) && !z) {
            z2 = false;
        }
        if (z2) {
            invalidateOverscroll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: consumePreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m114consumePreFlingQWom1Mo(long r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r8) {
        /*
            r5 = this;
            long r0 = r5.containerSize
            boolean r8 = androidx.compose.ui.geometry.Size.isEmpty-impl(r0)
            if (r8 == 0) goto L13
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.Companion
            long r6 = r6.getZero-9UxMQ8M()
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m2701boximpl(r6)
            return r6
        L13:
            float r8 = androidx.compose.ui.unit.Velocity.m2710getXimpl(r6)
            r0 = 1
            r1 = 0
            r2 = 0
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 <= 0) goto L41
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r3 = r8.getDistanceCompat(r3)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 != 0) goto L2c
            r3 = 1
            goto L2d
        L2c:
            r3 = 0
        L2d:
            if (r3 != 0) goto L41
            android.widget.EdgeEffect r3 = r5.leftEffect
            float r4 = androidx.compose.ui.unit.Velocity.m2710getXimpl(r6)
            int r4 = kotlin.math.MathKt.roundToInt(r4)
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m2710getXimpl(r6)
            goto L6e
        L41:
            float r8 = androidx.compose.ui.unit.Velocity.m2710getXimpl(r6)
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 >= 0) goto L6d
            androidx.compose.foundation.EdgeEffectCompat r8 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r3 = r8.getDistanceCompat(r3)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 != 0) goto L57
            r3 = 1
            goto L58
        L57:
            r3 = 0
        L58:
            if (r3 != 0) goto L6d
            android.widget.EdgeEffect r3 = r5.rightEffect
            float r4 = androidx.compose.ui.unit.Velocity.m2710getXimpl(r6)
            int r4 = kotlin.math.MathKt.roundToInt(r4)
            int r4 = -r4
            r8.onAbsorbCompat(r3, r4)
            float r8 = androidx.compose.ui.unit.Velocity.m2710getXimpl(r6)
            goto L6e
        L6d:
            r8 = 0
        L6e:
            float r3 = androidx.compose.ui.unit.Velocity.m2711getYimpl(r6)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 <= 0) goto L99
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.topEffect
            float r4 = r3.getDistanceCompat(r4)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto L84
            r4 = 1
            goto L85
        L84:
            r4 = 0
        L85:
            if (r4 != 0) goto L99
            android.widget.EdgeEffect r0 = r5.topEffect
            float r1 = androidx.compose.ui.unit.Velocity.m2711getYimpl(r6)
            int r1 = kotlin.math.MathKt.roundToInt(r1)
            r3.onAbsorbCompat(r0, r1)
            float r2 = androidx.compose.ui.unit.Velocity.m2711getYimpl(r6)
            goto Lc3
        L99:
            float r3 = androidx.compose.ui.unit.Velocity.m2711getYimpl(r6)
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 >= 0) goto Lc3
            androidx.compose.foundation.EdgeEffectCompat r3 = androidx.compose.foundation.EdgeEffectCompat.INSTANCE
            android.widget.EdgeEffect r4 = r5.bottomEffect
            float r4 = r3.getDistanceCompat(r4)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 != 0) goto Lae
            goto Laf
        Lae:
            r0 = 0
        Laf:
            if (r0 != 0) goto Lc3
            android.widget.EdgeEffect r0 = r5.bottomEffect
            float r1 = androidx.compose.ui.unit.Velocity.m2711getYimpl(r6)
            int r1 = kotlin.math.MathKt.roundToInt(r1)
            int r1 = -r1
            r3.onAbsorbCompat(r0, r1)
            float r2 = androidx.compose.ui.unit.Velocity.m2711getYimpl(r6)
        Lc3:
            long r6 = androidx.compose.ui.unit.VelocityKt.Velocity(r8, r2)
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r8.getZero-9UxMQ8M()
            boolean r8 = androidx.compose.ui.unit.Velocity.m2709equalsimpl0(r6, r0)
            if (r8 != 0) goto Ld6
            r5.invalidateOverscroll()
        Ld6:
            androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m2701boximpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m114consumePreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0094  */
    /* renamed from: consumePreScroll-OzD1aCk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long m115consumePreScrollOzD1aCk(long r8, int r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.m115consumePreScrollOzD1aCk(long, int):long");
    }

    public final void drawOverscroll(@NotNull DrawScope drawScope) {
        boolean z;
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (Size.isEmpty-impl(this.containerSize)) {
            return;
        }
        androidx.compose.ui.graphics.Canvas canvas = drawScope.getDrawContext().getCanvas();
        this.redrawSignal.getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
        boolean z2 = true;
        if (!(edgeEffectCompat.getDistanceCompat(this.leftEffectNegation) == 0.0f)) {
            drawRight(drawScope, this.leftEffectNegation, nativeCanvas);
            this.leftEffectNegation.finish();
        }
        if (this.leftEffect.isFinished()) {
            z = false;
        } else {
            z = drawLeft(drawScope, this.leftEffect, nativeCanvas);
            edgeEffectCompat.onPullDistanceCompat(this.leftEffectNegation, edgeEffectCompat.getDistanceCompat(this.leftEffect), 0.0f);
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.topEffectNegation) == 0.0f)) {
            drawBottom(drawScope, this.topEffectNegation, nativeCanvas);
            this.topEffectNegation.finish();
        }
        if (!this.topEffect.isFinished()) {
            z = drawTop(drawScope, this.topEffect, nativeCanvas) || z;
            edgeEffectCompat.onPullDistanceCompat(this.topEffectNegation, edgeEffectCompat.getDistanceCompat(this.topEffect), 0.0f);
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.rightEffectNegation) == 0.0f)) {
            drawLeft(drawScope, this.rightEffectNegation, nativeCanvas);
            this.rightEffectNegation.finish();
        }
        if (!this.rightEffect.isFinished()) {
            z = drawRight(drawScope, this.rightEffect, nativeCanvas) || z;
            edgeEffectCompat.onPullDistanceCompat(this.rightEffectNegation, edgeEffectCompat.getDistanceCompat(this.rightEffect), 0.0f);
        }
        if (!(edgeEffectCompat.getDistanceCompat(this.bottomEffectNegation) == 0.0f)) {
            drawTop(drawScope, this.bottomEffectNegation, nativeCanvas);
            this.bottomEffectNegation.finish();
        }
        if (!this.bottomEffect.isFinished()) {
            if (!drawBottom(drawScope, this.bottomEffect, nativeCanvas) && !z) {
                z2 = false;
            }
            edgeEffectCompat.onPullDistanceCompat(this.bottomEffectNegation, edgeEffectCompat.getDistanceCompat(this.bottomEffect), 0.0f);
            z = z2;
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    @NotNull
    public Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final boolean getInvalidationEnabled$foundation_release() {
        return this.invalidationEnabled;
    }

    public boolean isInProgress() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(list.get(i)) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }
}
