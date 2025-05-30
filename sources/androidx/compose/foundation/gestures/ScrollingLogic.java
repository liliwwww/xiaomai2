package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p004ui.unit.Velocity;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class ScrollingLogic {

    @NotNull
    private final FlingBehavior flingBehavior;

    @NotNull
    private final MutableState<Boolean> isNestedFlinging;

    @NotNull
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;

    @NotNull
    private final Orientation orientation;

    @Nullable
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;

    @NotNull
    private final ScrollableState scrollableState;

    public ScrollingLogic(@NotNull Orientation orientation, boolean z, @NotNull State<NestedScrollDispatcher> state, @NotNull ScrollableState scrollableState, @NotNull FlingBehavior flingBehavior, @Nullable OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(state, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = state;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
        this.isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: overscrollPostConsumeDelta-OMhpSzk, reason: not valid java name */
    private final void m1294overscrollPostConsumeDeltaOMhpSzk(long j, long j2, int i) {
        if (this.overscrollEffect == null || !getShouldDispatchOverscroll()) {
            return;
        }
        this.overscrollEffect.mo1109consumePostScrollOMhpSzk(j, j2, i);
    }

    /* renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m1295dispatchScroll3eAAhYA(@NotNull ScrollScope scrollScope, long j, int i) {
        Intrinsics.checkNotNullParameter(scrollScope, "$this$dispatchScroll");
        long m1301singleAxisOffsetMKHz9U = m1301singleAxisOffsetMKHz9U(j);
        long m1298overscrollPreConsumeDeltaOzD1aCk = m1298overscrollPreConsumeDeltaOzD1aCk(m1301singleAxisOffsetMKHz9U, i);
        long m2560minusMKHz9U = Offset.m2560minusMKHz9U(m1301singleAxisOffsetMKHz9U, m1298overscrollPreConsumeDeltaOzD1aCk);
        NestedScrollDispatcher value = this.nestedScrollDispatcher.getValue();
        long m3981dispatchPreScrollOzD1aCk = value.m3981dispatchPreScrollOzD1aCk(m2560minusMKHz9U, i);
        long m2560minusMKHz9U2 = Offset.m2560minusMKHz9U(m2560minusMKHz9U, m3981dispatchPreScrollOzD1aCk);
        long m1300reverseIfNeededMKHz9U = m1300reverseIfNeededMKHz9U(m1305toOffsettuRUvjQ(scrollScope.scrollBy(m1304toFloatk4lQ0M(m1300reverseIfNeededMKHz9U(m2560minusMKHz9U2)))));
        long m2560minusMKHz9U3 = Offset.m2560minusMKHz9U(m2560minusMKHz9U2, m1300reverseIfNeededMKHz9U);
        long m3979dispatchPostScrollDzOQY0M = value.m3979dispatchPostScrollDzOQY0M(m1300reverseIfNeededMKHz9U, m2560minusMKHz9U3, i);
        m1294overscrollPostConsumeDeltaOMhpSzk(m2560minusMKHz9U2, Offset.m2560minusMKHz9U(m2560minusMKHz9U3, m3979dispatchPostScrollDzOQY0M), i);
        return Offset.m2561plusMKHz9U(Offset.m2561plusMKHz9U(Offset.m2561plusMKHz9U(m1298overscrollPreConsumeDeltaOzD1aCk, m3981dispatchPreScrollOzD1aCk), m1300reverseIfNeededMKHz9U), m3979dispatchPostScrollDzOQY0M);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1296doFlingAnimationQWom1Mo(long r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.p004ui.unit.Velocity> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L13
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
        L18:
            r4 = r0
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r13 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L5d
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.scrollableState
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r5 = 1
            r6 = 0
            r4.L$0 = r15
            r4.label = r2
            r2 = r3
            r3 = r11
            java.lang.Object r13 = tb.eo4.e(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L5c
            return r0
        L5c:
            r13 = r15
        L5d:
            long r13 = r13.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.p004ui.unit.Velocity.m5432boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m1296doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    @NotNull
    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Nullable
    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    @NotNull
    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1297onDragStoppedsFctU(long r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m1297onDragStoppedsFctU(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: overscrollPreConsumeDelta-OzD1aCk, reason: not valid java name */
    public final long m1298overscrollPreConsumeDeltaOzD1aCk(long j, int i) {
        return (this.overscrollEffect == null || !getShouldDispatchOverscroll()) ? Offset.Companion.m2572getZeroF1C5BW0() : this.overscrollEffect.mo1111consumePreScrollOzD1aCk(j, i);
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m1299performRawScrollMKHz9U(long j) {
        return this.scrollableState.isScrollInProgress() ? Offset.Companion.m2572getZeroF1C5BW0() : m1305toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m1304toFloatk4lQ0M(j)))));
    }

    public final void registerNestedFling(boolean z) {
        this.isNestedFlinging.setValue(Boolean.valueOf(z));
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m1300reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m2563timestuRUvjQ(j, -1.0f) : j;
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress() && !this.isNestedFlinging.getValue().booleanValue()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m1301singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m2550copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m2550copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m1302singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5437copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m5437copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m1303toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5441getXimpl(j) : Velocity.m5442getYimpl(j);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m1304toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m2556getXimpl(j) : Offset.m2557getYimpl(j);
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m1305toOffsettuRUvjQ(float f) {
        return (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0 ? Offset.Companion.m2572getZeroF1C5BW0() : this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m1306updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m5437copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m5437copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }
}
