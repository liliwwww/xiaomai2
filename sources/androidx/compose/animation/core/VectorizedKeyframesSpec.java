package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.dy5;
import tb.ey5;
import tb.fy5;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;

    @NotNull
    private final Map<Integer, Pair<V, Easing>> keyframes;
    private V valueVector;
    private V velocityVector;

    public VectorizedKeyframesSpec(@NotNull Map<Integer, ? extends Pair<? extends V, ? extends Easing>> map, int i, int i2) {
        Intrinsics.checkNotNullParameter(map, "keyframes");
        this.keyframes = map;
        this.durationMillis = i;
        this.delayMillis = i2;
    }

    private final void init(V v) {
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v);
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ey5.a(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return dy5.a(this, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getValueFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        long clampPlayTime;
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "targetValue");
        Intrinsics.checkNotNullParameter(v3, "initialVelocity");
        clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        int i = (int) clampPlayTime;
        if (this.keyframes.containsKey(Integer.valueOf(i))) {
            return (V) ((Pair) MapsKt.getValue(this.keyframes, Integer.valueOf(i))).getFirst();
        }
        if (i >= getDurationMillis()) {
            return v2;
        }
        if (i <= 0) {
            return v;
        }
        int durationMillis = getDurationMillis();
        Easing linearEasing = EasingKt.getLinearEasing();
        int i2 = 0;
        AnimationVector animationVector = v;
        int i3 = 0;
        for (Map.Entry<Integer, Pair<V, Easing>> entry : this.keyframes.entrySet()) {
            int intValue = entry.getKey().intValue();
            Pair<V, Easing> value = entry.getValue();
            if (i > intValue && intValue >= i3) {
                animationVector = (AnimationVector) value.getFirst();
                linearEasing = (Easing) value.getSecond();
                i3 = intValue;
            } else if (i < intValue && intValue <= durationMillis) {
                v2 = (V) value.getFirst();
                durationMillis = intValue;
            }
        }
        float transform = linearEasing.transform((i - i3) / (durationMillis - i3));
        init(v);
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        while (true) {
            V v4 = null;
            if (i2 >= size$animation_core_release) {
                break;
            }
            V v5 = this.valueVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            } else {
                v4 = v5;
            }
            v4.set$animation_core_release(i2, VectorConvertersKt.lerp(animationVector.get$animation_core_release(i2), v2.get$animation_core_release(i2), transform));
            i2++;
        }
        V v6 = this.valueVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    @NotNull
    public V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        long clampPlayTime;
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "targetValue");
        Intrinsics.checkNotNullParameter(v3, "initialVelocity");
        clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (clampPlayTime <= 0) {
            return v3;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, clampPlayTime - 1, v, v2, v3);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, clampPlayTime, v, v2, v3);
        init(v);
        int i = 0;
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        while (true) {
            V v4 = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v5 = this.velocityVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            } else {
                v4 = v5;
            }
            v4.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v6 = this.velocityVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return fy5.a(this);
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }
}
