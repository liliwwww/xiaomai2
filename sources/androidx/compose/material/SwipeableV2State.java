package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
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
/* loaded from: classes.dex */
public final class SwipeableV2State<T> {

    @NotNull
    public static final Companion Companion = new Companion(null);

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

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> Saver<SwipeableV2State<T>, T> Saver(@NotNull final AnimationSpec<Float> animationSpec, @NotNull final Function1<? super T, Boolean> function1) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
            return SaverKt.Saver(new Function2<SaverScope, SwipeableV2State<T>, T>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$1
                @Nullable
                public final T invoke(@NotNull SaverScope saverScope, @NotNull SwipeableV2State<T> swipeableV2State) {
                    Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
                    Intrinsics.checkNotNullParameter(swipeableV2State, "it");
                    return swipeableV2State.getCurrentState();
                }
            }, new Function1<T, SwipeableV2State<T>>() { // from class: androidx.compose.material.SwipeableV2State$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2266invoke(Object obj) {
                    return invoke((SwipeableV2State$Companion$Saver$2<T>) obj);
                }

                @Nullable
                public final SwipeableV2State<T> invoke(@NotNull T t) {
                    Intrinsics.checkNotNullParameter(t, "it");
                    return new SwipeableV2State<>(t, animationSpec, function1);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableV2State(T t, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = function1;
        this.currentState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetState$delegate = SnapshotStateKt.derivedStateOf(new Function0<T>(this) { // from class: androidx.compose.material.SwipeableV2State$targetState$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            public final T invoke() {
                float unsafeOffset;
                float unsafeOffset2;
                Object closestState;
                unsafeOffset = this.this$0.getUnsafeOffset();
                if (Float.isNaN(unsafeOffset)) {
                    return this.this$0.getCurrentState();
                }
                Map<T, Float> anchors$material_release = this.this$0.getAnchors$material_release();
                unsafeOffset2 = this.this$0.getUnsafeOffset();
                closestState = SwipeableV2Kt.closestState(anchors$material_release, unsafeOffset2);
                return (T) closestState;
            }
        });
        this.offset = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$offset$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2269invoke() {
                float unsafeOffset;
                float unsafeOffset2;
                unsafeOffset = this.this$0.getUnsafeOffset();
                if (Float.isNaN(unsafeOffset)) {
                    throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
                }
                unsafeOffset2 = this.this$0.getUnsafeOffset();
                return Float.valueOf(unsafeOffset2);
            }
        });
        this.isAnimationRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$progress$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2271invoke() {
                Float f = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getCurrentState());
                float f2 = 0.0f;
                float floatValue = f != null ? f.floatValue() : 0.0f;
                Float f3 = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getTargetState());
                float floatValue2 = (f3 != null ? f3.floatValue() : 0.0f) - floatValue;
                if (Math.abs(floatValue2) > 1.0E-6f) {
                    float floatValue3 = (this.this$0.getOffset().getValue().floatValue() - floatValue) / floatValue2;
                    if (floatValue3 >= 1.0E-6f) {
                        if (floatValue3 <= 0.999999f) {
                            f2 = floatValue3;
                        }
                    }
                    return Float.valueOf(f2);
                }
                f2 = 1.0f;
                return Float.valueOf(f2);
            }
        });
        Float valueOf = Float.valueOf(0.0f);
        this.lastVelocity$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.dragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), null, 2, null);
        this.unsafeOffset$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$unsafeOffset$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2272invoke() {
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
        this.minBound$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$minBound$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2268invoke() {
                Float minOrNull;
                minOrNull = SwipeableV2Kt.minOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(minOrNull != null ? minOrNull.floatValue() : Float.NEGATIVE_INFINITY);
            }
        });
        this.maxBound$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>(this) { // from class: androidx.compose.material.SwipeableV2State$maxBound$2
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2267invoke() {
                Float maxOrNull;
                maxOrNull = SwipeableV2Kt.maxOrNull(this.this$0.getAnchors$material_release());
                return Float.valueOf(maxOrNull != null ? maxOrNull.floatValue() : Float.POSITIVE_INFINITY);
            }
        });
        this.positionalThresholds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function2<T, T, Float>() { // from class: androidx.compose.material.SwipeableV2State$positionalThresholds$2
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2270invoke(T t2, T t3) {
                return Float.valueOf(0.0f);
            }
        }, null, 2, null);
        this.velocityThreshold$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.compose.material.SwipeableV2State$draggableState$1
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                MutableState mutableState;
                MutableState mutableState2;
                mutableState = ((SwipeableV2State) this.this$0).dragPosition;
                mutableState2 = ((SwipeableV2State) this.this$0).dragPosition;
                mutableState.setValue(Float.valueOf(((Number) mutableState2.getValue()).floatValue() + f));
            }
        });
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateTo(T r12, float r13, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
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
        return this.currentState$delegate.getValue();
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
        Object computeTarget = computeTarget(this.offset.getValue().floatValue(), currentState, getPositionalThresholds(), f, getVelocityThreshold());
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
        To view partially-correct code enable 'Show inconsistent code' option in preferences
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
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableV2State.1
            @NotNull
            public final Boolean invoke(T t) {
                return Boolean.TRUE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2265invoke(Object obj2) {
                return invoke((C07151) obj2);
            }
        } : function1);
    }
}
