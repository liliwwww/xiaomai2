package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SwipeableV2State<T> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private final MutableState anchors$delegate;

    @NotNull
    private final AnimationSpec<Float> animationSpec;

    @NotNull
    private final Function1<T, Boolean> confirmStateChange;

    @NotNull
    private final MutableState currentState$delegate;

    @NotNull
    private final MutableState<Float> dragPosition;

    @NotNull
    private final DraggableState draggableState;

    @NotNull
    private final MutableState isAnimationRunning$delegate;

    @NotNull
    private final MutableState lastVelocity$delegate;

    @NotNull
    private final State maxBound$delegate;

    @NotNull
    private final State minBound$delegate;

    @NotNull
    private final State<Float> offset;

    @NotNull
    private final MutableState positionalThresholds$delegate;

    @NotNull
    private final State progress$delegate;

    @NotNull
    private final State targetState$delegate;

    @NotNull
    private final State unsafeOffset$delegate;

    @NotNull
    private final MutableState velocityThreshold$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableV2State(T t, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = function1;
        this.currentState$delegate = SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetState$delegate = SnapshotStateKt.derivedStateOf(new targetState.2(this));
        this.offset = SnapshotStateKt.derivedStateOf(new offset.1(this));
        this.isAnimationRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new progress.2(this));
        Float valueOf = Float.valueOf(0.0f);
        this.lastVelocity$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.dragPosition = SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.unsafeOffset$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$unsafeOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m679invoke() {
                MutableState mutableState;
                float minBound;
                float maxBound;
                mutableState = ((SwipeableV2State) this.this$0).dragPosition;
                float floatValue = ((Number) mutableState.getValue()).floatValue();
                minBound = this.this$0.getMinBound();
                maxBound = this.this$0.getMaxBound();
                return Float.valueOf(RangesKt.coerceIn(floatValue, minBound, maxBound));
            }
        });
        this.minBound$delegate = SnapshotStateKt.derivedStateOf(new minBound.2(this));
        this.maxBound$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$maxBound$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m678invoke() {
                Float maxOrNull;
                maxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(maxOrNull != null ? maxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        this.positionalThresholds$delegate = SnapshotStateKt.mutableStateOf$default(positionalThresholds.2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.velocityThreshold$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.draggableState = DraggableKt.DraggableState(new draggableState.1(this));
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, continuation);
    }

    private final T computeTarget(float f, T t, Function2<? super T, ? super T, Float> function2, float f2, float f3) {
        float requireAnchor;
        Object closestState;
        Object closestState2;
        Object closestState3;
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        requireAnchor = SwipeableV2Kt.requireAnchor(anchors$material_release, t);
        if (requireAnchor <= f) {
            if (f2 >= f3) {
                closestState3 = SwipeableV2Kt.closestState(anchors$material_release, f, true);
                return (T) closestState3;
            }
            closestState = SwipeableV2Kt.closestState(anchors$material_release, f, true);
            if (f < ((Number) function2.invoke(t, closestState)).floatValue()) {
                return t;
            }
        } else {
            if (f2 <= (-f3)) {
                closestState2 = SwipeableV2Kt.closestState(anchors$material_release, f, false);
                return (T) closestState2;
            }
            closestState = SwipeableV2Kt.closestState(anchors$material_release, f, false);
            if (f > ((Number) function2.invoke(t, closestState)).floatValue()) {
                return t;
            }
        }
        return (T) closestState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMaxBound() {
        return ((Number) this.maxBound$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMinBound() {
        return ((Number) this.minBound$delegate.getValue()).floatValue();
    }

    private final Function2<T, T, Float> getPositionalThresholds() {
        return (Function2) this.positionalThresholds$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getUnsafeOffset() {
        return ((Number) this.unsafeOffset$delegate.getValue()).floatValue();
    }

    private final float getVelocityThreshold() {
        return ((Number) this.velocityThreshold$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(z));
    }

    private final void setCurrentState(T t) {
        this.currentState$delegate.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setValue(Float.valueOf(f));
    }

    private final void setPositionalThresholds(Function2<? super T, ? super T, Float> function2) {
        this.positionalThresholds$delegate.setValue(function2);
    }

    private final void setVelocityThreshold(float f) {
        this.velocityThreshold$delegate.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateTo(T r12, float r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableV2State.animateTo(java.lang.Object, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float dispatchRawDelta(float f) {
        float coerceIn = RangesKt.coerceIn(this.dragPosition.getValue().floatValue() + f, getMinBound(), getMaxBound()) - this.dragPosition.getValue().floatValue();
        if (Math.abs(coerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(coerceIn);
        }
        return coerceIn;
    }

    @NotNull
    public final Map<T, Float> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    @NotNull
    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    @NotNull
    public final Function1<T, Boolean> getConfirmStateChange() {
        return this.confirmStateChange;
    }

    public final T getCurrentState() {
        return (T) this.currentState$delegate.getValue();
    }

    @NotNull
    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        return ((Number) this.lastVelocity$delegate.getValue()).floatValue();
    }

    @NotNull
    public final State<Float> getOffset() {
        return this.offset;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public final T getTargetState() {
        return (T) this.targetState$delegate.getValue();
    }

    public final boolean hasAnchorForState(T t) {
        return getAnchors$material_release().containsKey(t);
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final void setAnchors$material_release(@NotNull Map<T, Float> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object settle(float f, @NotNull Continuation<? super Unit> continuation) {
        Object currentState = getCurrentState();
        Object computeTarget = computeTarget(((Number) this.offset.getValue()).floatValue(), currentState, getPositionalThresholds(), f, getVelocityThreshold());
        if (((Boolean) this.confirmStateChange.invoke(computeTarget)).booleanValue()) {
            Object animateTo = animateTo(computeTarget, f, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = animateTo(currentState, f, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object snapTo(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.compose.material.SwipeableV2State$snapTo$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.material.SwipeableV2State$snapTo$1 r0 = (androidx.compose.material.SwipeableV2State$snapTo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.SwipeableV2State$snapTo$1 r0 = new androidx.compose.material.SwipeableV2State$snapTo$1
            r0.<init>(r7, r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r8 = r4.L$1
            java.lang.Object r0 = r4.L$0
            androidx.compose.material.SwipeableV2State r0 = (androidx.compose.material.SwipeableV2State) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5e
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.Map r9 = r7.getAnchors$material_release()
            float r9 = androidx.compose.material.SwipeableV2Kt.access$requireAnchor(r9, r8)
            androidx.compose.foundation.gestures.DraggableState r1 = r7.draggableState
            r3 = 0
            androidx.compose.material.SwipeableV2State$snapTo$2 r5 = new androidx.compose.material.SwipeableV2State$snapTo$2
            r6 = 0
            r5.<init>(r9, r7, r6)
            r9 = 1
            r4.L$0 = r7
            r4.L$1 = r8
            r4.label = r2
            r2 = r3
            r3 = r5
            r5 = r9
            java.lang.Object r9 = tb.o51.a(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L5d
            return r0
        L5d:
            r0 = r7
        L5e:
            r0.setCurrentState(r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableV2State.snapTo(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void updateAnchors$material_release(@NotNull Map<T, Float> map) {
        float requireAnchor;
        Intrinsics.checkNotNullParameter(map, "newAnchors");
        boolean isEmpty = getAnchors$material_release().isEmpty();
        setAnchors$material_release(map);
        if (isEmpty) {
            MutableState<Float> mutableState = this.dragPosition;
            requireAnchor = SwipeableV2Kt.requireAnchor(getAnchors$material_release(), getCurrentState());
            mutableState.setValue(Float.valueOf(requireAnchor));
        }
    }

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? 1.INSTANCE : function1);
    }
}
