package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RepeatableSpec<T> implements FiniteAnimationSpec<T> {

    @NotNull
    private final DurationBasedAnimationSpec<T> animation;
    private final long initialStartOffset;
    private final int iterations;

    @NotNull
    private final RepeatMode repeatMode;

    private RepeatableSpec(int i, DurationBasedAnimationSpec<T> durationBasedAnimationSpec, RepeatMode repeatMode, long j) {
        this.iterations = i;
        this.animation = durationBasedAnimationSpec;
        this.repeatMode = repeatMode;
        this.initialStartOffset = j;
    }

    public /* synthetic */ RepeatableSpec(int i, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, durationBasedAnimationSpec, repeatMode, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof RepeatableSpec)) {
            return false;
        }
        RepeatableSpec repeatableSpec = (RepeatableSpec) obj;
        return repeatableSpec.iterations == this.iterations && Intrinsics.areEqual(repeatableSpec.animation, this.animation) && repeatableSpec.repeatMode == this.repeatMode && StartOffset.equals-impl0(repeatableSpec.initialStartOffset, this.initialStartOffset);
    }

    @NotNull
    public final DurationBasedAnimationSpec<T> getAnimation() {
        return this.animation;
    }

    /* renamed from: getInitialStartOffset-Rmkjzm4, reason: not valid java name */
    public final long m86getInitialStartOffsetRmkjzm4() {
        return this.initialStartOffset;
    }

    public final int getIterations() {
        return this.iterations;
    }

    @NotNull
    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        return (((((this.iterations * 31) + this.animation.hashCode()) * 31) + this.repeatMode.hashCode()) * 31) + StartOffset.hashCode-impl(this.initialStartOffset);
    }

    @NotNull
    public <V extends AnimationVector> VectorizedFiniteAnimationSpec<V> vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        return new VectorizedRepeatableSpec(this.iterations, this.animation.m89vectorize(twoWayConverter), this.repeatMode, this.initialStartOffset, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ RepeatableSpec(int i, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, durationBasedAnimationSpec, (i2 & 4) != 0 ? RepeatMode.Restart : repeatMode, (i2 & 8) != 0 ? StartOffset.constructor-impl$default(0, 0, 2, (DefaultConstructorMarker) null) : j, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ RepeatableSpec(int i, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, durationBasedAnimationSpec, (i2 & 4) != 0 ? RepeatMode.Restart : repeatMode);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This constructor has been deprecated")
    public /* synthetic */ RepeatableSpec(int i, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode) {
        this(i, durationBasedAnimationSpec, repeatMode, StartOffset.constructor-impl$default(0, 0, 2, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(durationBasedAnimationSpec, "animation");
        Intrinsics.checkNotNullParameter(repeatMode, "repeatMode");
    }
}
