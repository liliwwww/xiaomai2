package androidx.compose.animation.core;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SnapSpec<T> implements DurationBasedAnimationSpec<T> {
    private final int delay;

    public SnapSpec() {
        this(0, 1, null);
    }

    public SnapSpec(int i) {
        this.delay = i;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof SnapSpec) && ((SnapSpec) obj).delay == this.delay;
    }

    public final int getDelay() {
        return this.delay;
    }

    public int hashCode() {
        return this.delay;
    }

    public /* synthetic */ SnapSpec(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    @NotNull
    /* renamed from: vectorize, reason: collision with other method in class and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> m89vectorize(@NotNull TwoWayConverter<T, V> twoWayConverter) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "converter");
        return new VectorizedSnapSpec(this.delay);
    }
}
