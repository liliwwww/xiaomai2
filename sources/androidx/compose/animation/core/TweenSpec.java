package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TweenSpec<T> implements DurationBasedAnimationSpec<T> {
    private final int delay;
    private final int durationMillis;

    @NotNull
    private final Easing easing;

    public TweenSpec() {
        this(0, 0, null, 7, null);
    }

    public TweenSpec(int i, int i2, @NotNull Easing easing) {
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.durationMillis = i;
        this.delay = i2;
        this.easing = easing;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TweenSpec)) {
            return false;
        }
        TweenSpec tweenSpec = (TweenSpec) obj;
        return tweenSpec.durationMillis == this.durationMillis && tweenSpec.delay == this.delay && Intrinsics.areEqual(tweenSpec.easing, this.easing);
    }

    public final int getDelay() {
        return this.delay;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    @NotNull
    public final Easing getEasing() {
        return this.easing;
    }

    public int hashCode() {
        return (((this.durationMillis * 31) + this.easing.hashCode()) * 31) + this.delay;
    }

    @NotNull
    /* renamed from: vectorize, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public <V extends AnimationVector> VectorizedTweenSpec<V> m99vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        return new VectorizedTweenSpec<>(this.durationMillis, this.delay, this.easing);
    }

    public /* synthetic */ TweenSpec(int i, int i2, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing);
    }
}
