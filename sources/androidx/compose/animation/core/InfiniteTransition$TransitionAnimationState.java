package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class InfiniteTransition$TransitionAnimationState<T, V extends AnimationVector> implements State<T> {

    @NotNull
    private TargetBasedAnimation<T, V> animation;

    @NotNull
    private AnimationSpec<T> animationSpec;
    private T initialValue;
    private boolean isFinished;
    private long playTimeNanosOffset;
    private boolean startOnTheNextFrame;
    private T targetValue;
    final /* synthetic */ InfiniteTransition this$0;

    @NotNull
    private final TwoWayConverter<T, V> typeConverter;

    @NotNull
    private final MutableState value$delegate;

    public InfiniteTransition$TransitionAnimationState(InfiniteTransition infiniteTransition, T t, @NotNull T t2, @NotNull TwoWayConverter<T, V> twoWayConverter, AnimationSpec<T> animationSpec) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.this$0 = infiniteTransition;
        this.initialValue = t;
        this.targetValue = t2;
        this.typeConverter = twoWayConverter;
        this.animationSpec = animationSpec;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.value$delegate = mutableStateOf$default;
        this.animation = new TargetBasedAnimation<>(this.animationSpec, twoWayConverter, this.initialValue, this.targetValue, (AnimationVector) null, 16, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final TargetBasedAnimation<T, V> getAnimation() {
        return this.animation;
    }

    @NotNull
    public final AnimationSpec<T> getAnimationSpec() {
        return this.animationSpec;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public final long getPlayTimeNanosOffset() {
        return this.playTimeNanosOffset;
    }

    public final boolean getStartOnTheNextFrame() {
        return this.startOnTheNextFrame;
    }

    public final T getTargetValue() {
        return this.targetValue;
    }

    @NotNull
    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return (T) this.value$delegate.getValue();
    }

    public final boolean isFinished() {
        return this.isFinished;
    }

    public final void onPlayTimeChanged(long j) {
        InfiniteTransition.access$setRefreshChildNeeded(this.this$0, false);
        if (this.startOnTheNextFrame) {
            this.startOnTheNextFrame = false;
            this.playTimeNanosOffset = j;
        }
        long j2 = j - this.playTimeNanosOffset;
        setValue$animation_core_release(this.animation.getValueFromNanos(j2));
        this.isFinished = this.animation.isFinishedFromNanos(j2);
    }

    public final void reset() {
        this.startOnTheNextFrame = true;
    }

    public final void setAnimation(@NotNull TargetBasedAnimation<T, V> targetBasedAnimation) {
        Intrinsics.checkNotNullParameter(targetBasedAnimation, "<set-?>");
        this.animation = targetBasedAnimation;
    }

    public final void setAnimationSpec(@NotNull AnimationSpec<T> animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "<set-?>");
        this.animationSpec = animationSpec;
    }

    public final void setFinished(boolean z) {
        this.isFinished = z;
    }

    public final void setInitialValue(T t) {
        this.initialValue = t;
    }

    public final void setPlayTimeNanosOffset(long j) {
        this.playTimeNanosOffset = j;
    }

    public final void setStartOnTheNextFrame(boolean z) {
        this.startOnTheNextFrame = z;
    }

    public final void setTargetValue(T t) {
        this.targetValue = t;
    }

    public void setValue$animation_core_release(T t) {
        this.value$delegate.setValue(t);
    }

    public final void skipToEnd() {
        setValue$animation_core_release(this.animation.getTargetValue());
        this.startOnTheNextFrame = true;
    }

    public final void updateValues(T t, T t2, @NotNull AnimationSpec<T> animationSpec) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        this.initialValue = t;
        this.targetValue = t2;
        this.animationSpec = animationSpec;
        this.animation = new TargetBasedAnimation<>(animationSpec, this.typeConverter, t, t2, (AnimationVector) null, 16, (DefaultConstructorMarker) null);
        InfiniteTransition.access$setRefreshChildNeeded(this.this$0, true);
        this.isFinished = false;
        this.startOnTheNextFrame = true;
    }
}
