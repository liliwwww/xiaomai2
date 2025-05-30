package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.o51;

/* compiled from: Taobao */
@Stable
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class SwipeableState<T> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private final MutableState<Float> absoluteOffset;

    @NotNull
    private final MutableState anchors$delegate;

    @NotNull
    private final AnimationSpec<Float> animationSpec;

    @NotNull
    private final MutableState<Float> animationTarget;

    @NotNull
    private final Function1<T, Boolean> confirmStateChange;

    @NotNull
    private final MutableState currentValue$delegate;

    @NotNull
    private final DraggableState draggableState;

    @NotNull
    private final MutableState isAnimationRunning$delegate;

    @NotNull
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;

    @NotNull
    private final MutableState<Float> offsetState;

    @NotNull
    private final MutableState<Float> overflowState;

    @NotNull
    private final MutableState resistance$delegate;

    @NotNull
    private final MutableState thresholds$delegate;

    @NotNull
    private final MutableState velocityThreshold$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableState(T t, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = function1;
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isAnimationRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        Float valueOf = Float.valueOf(0.0f);
        this.offsetState = SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.overflowState = SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.absoluteOffset = SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animationTarget = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), (SnapshotMutationPolicy) null, 2, (Object) null);
        final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Map<Float, ? extends T>>(this) { // from class: androidx.compose.material.SwipeableState$latestNonEmptyAnchorsFlow$1
            final /* synthetic */ SwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @NotNull
            public final Map<Float, T> invoke() {
                return this.this$0.getAnchors$material_release();
            }
        });
        this.latestNonEmptyAnchorsFlow = d.K(new Flow<Map<Float, ? extends T>>() { // from class: androidx.compose.material.SwipeableState$special$$inlined$filter$1
            @Nullable
            public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
                Object collect = snapshotFlow.collect(new 2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = SnapshotStateKt.mutableStateOf$default(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableState$thresholds$2
            @NotNull
            public final Float invoke(float f, float f2) {
                return Float.valueOf(0.0f);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
            }
        }, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.velocityThreshold$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.resistance$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.draggableState = DraggableKt.DraggableState(new draggableState.1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object a = o51.a(this.draggableState, (MutatePriority) null, new SwipeableState$animateInternalToOffset$2(this, f, animationSpec, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SwipeableState swipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i & 2) != 0) {
            animationSpec = swipeableState.animationSpec;
        }
        return swipeableState.animateTo(obj, animationSpec, continuation);
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getDirection$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getProgress$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getTargetValue$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object snapInternalToOffset(float f, Continuation<? super Unit> continuation) {
        Object a = o51.a(this.draggableState, (MutatePriority) null, new SwipeableState$snapInternalToOffset$2(f, this, null), continuation, 1, (Object) null);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object animateTo(T t, @NotNull AnimationSpec<Float> animationSpec, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new animateTo.2(t, this, animationSpec), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void ensureInit$material_release(@NotNull Map<Float, ? extends T> map) {
        Float offset;
        Intrinsics.checkNotNullParameter(map, "newAnchors");
        if (getAnchors$material_release().isEmpty()) {
            offset = SwipeableKt.getOffset(map, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
            }
            this.offsetState.setValue(offset);
            this.absoluteOffset.setValue(offset);
        }
    }

    @NotNull
    public final Map<Float, T> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    @NotNull
    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    @NotNull
    public final Function1<T, Boolean> getConfirmStateChange$material_release() {
        return this.confirmStateChange;
    }

    public final T getCurrentValue() {
        return (T) this.currentValue$delegate.getValue();
    }

    public final float getDirection() {
        Float offset;
        offset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
        if (offset == null) {
            return 0.0f;
        }
        return Math.signum(((Number) getOffset().getValue()).floatValue() - offset.floatValue());
    }

    @NotNull
    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final float getMaxBound$material_release() {
        return this.maxBound;
    }

    public final float getMinBound$material_release() {
        return this.minBound;
    }

    @NotNull
    public final State<Float> getOffset() {
        return this.offsetState;
    }

    @NotNull
    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    @NotNull
    public final SwipeProgress<T> getProgress() {
        List findBounds;
        Object currentValue;
        Object obj;
        float f;
        findBounds = SwipeableKt.findBounds(((Number) getOffset().getValue()).floatValue(), getAnchors$material_release().keySet());
        int size = findBounds.size();
        if (size == 0) {
            T currentValue2 = getCurrentValue();
            currentValue = getCurrentValue();
            obj = currentValue2;
        } else {
            if (size != 1) {
                Pair pair = getDirection() > 0.0f ? TuplesKt.to(findBounds.get(0), findBounds.get(1)) : TuplesKt.to(findBounds.get(1), findBounds.get(0));
                float floatValue = ((Number) pair.component1()).floatValue();
                float floatValue2 = ((Number) pair.component2()).floatValue();
                obj = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(floatValue));
                currentValue = MapsKt.getValue(getAnchors$material_release(), Float.valueOf(floatValue2));
                f = (((Number) getOffset().getValue()).floatValue() - floatValue) / (floatValue2 - floatValue);
                return new SwipeProgress<>(obj, currentValue, f);
            }
            Object value = MapsKt.getValue(getAnchors$material_release(), findBounds.get(0));
            currentValue = MapsKt.getValue(getAnchors$material_release(), findBounds.get(0));
            obj = value;
        }
        f = 1.0f;
        return new SwipeProgress<>(obj, currentValue, f);
    }

    @Nullable
    public final ResistanceConfig getResistance$material_release() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final T getTargetValue() {
        Float offset;
        float computeTarget;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            computeTarget = value.floatValue();
        } else {
            float floatValue = ((Number) getOffset().getValue()).floatValue();
            offset = SwipeableKt.getOffset(getAnchors$material_release(), getCurrentValue());
            computeTarget = SwipeableKt.computeTarget(floatValue, offset != null ? offset.floatValue() : ((Number) getOffset().getValue()).floatValue(), getAnchors$material_release().keySet(), getThresholds$material_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t = getAnchors$material_release().get(Float.valueOf(computeTarget));
        return t == null ? getCurrentValue() : t;
    }

    @NotNull
    public final Function2<Float, Float, Float> getThresholds$material_release() {
        return (Function2) this.thresholds$delegate.getValue();
    }

    public final float getVelocityThreshold$material_release() {
        return ((Number) this.velocityThreshold$delegate.getValue()).floatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final float performDrag(float f) {
        float coerceIn = RangesKt.coerceIn(this.absoluteOffset.getValue().floatValue() + f, this.minBound, this.maxBound) - this.absoluteOffset.getValue().floatValue();
        if (Math.abs(coerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(coerceIn);
        }
        return coerceIn;
    }

    @Nullable
    public final Object performFling(float f, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new performFling.2(this, f), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x020d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processNewAnchors$material_release(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r10, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.processNewAnchors$material_release(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setAnchors$material_release(@NotNull Map<Float, ? extends T> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final void setMaxBound$material_release(float f) {
        this.maxBound = f;
    }

    public final void setMinBound$material_release(float f) {
        this.minBound = f;
    }

    public final void setResistance$material_release(@Nullable ResistanceConfig resistanceConfig) {
        this.resistance$delegate.setValue(resistanceConfig);
    }

    public final void setThresholds$material_release(@NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.thresholds$delegate.setValue(function2);
    }

    public final void setVelocityThreshold$material_release(float f) {
        this.velocityThreshold$delegate.setValue(Float.valueOf(f));
    }

    @ExperimentalMaterialApi
    @Nullable
    public final Object snapTo(T t, @NotNull Continuation<? super Unit> continuation) {
        Object collect = this.latestNonEmptyAnchorsFlow.collect(new snapTo.2(t, this), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableState.1
            @NotNull
            public final Boolean invoke(T t) {
                return Boolean.TRUE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m674invoke(Object obj2) {
                return invoke((AnonymousClass1) obj2);
            }
        } : function1);
    }
}
