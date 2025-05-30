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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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

    public int getDelayMillis() {
        return this.delayMillis;
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ey5.a(this, animationVector, animationVector2, animationVector3);
    }

    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return dy5.a(this, animationVector, animationVector2, animationVector3);
    }

    @NotNull
    public V getValueFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "targetValue");
        Intrinsics.checkNotNullParameter(v3, "initialVelocity");
        int access$clampPlayTime = (int) VectorizedAnimationSpecKt.access$clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.containsKey(Integer.valueOf(access$clampPlayTime))) {
            return (V) ((Pair) MapsKt.getValue(this.keyframes, Integer.valueOf(access$clampPlayTime))).getFirst();
        }
        if (access$clampPlayTime >= getDurationMillis()) {
            return v2;
        }
        if (access$clampPlayTime <= 0) {
            return v;
        }
        int durationMillis = getDurationMillis();
        Easing linearEasing = EasingKt.getLinearEasing();
        int i = 0;
        AnimationVector animationVector = v;
        int i2 = 0;
        for (Map.Entry<Integer, Pair<V, Easing>> entry : this.keyframes.entrySet()) {
            int intValue = entry.getKey().intValue();
            Pair<V, Easing> value = entry.getValue();
            if (access$clampPlayTime > intValue && intValue >= i2) {
                animationVector = (AnimationVector) value.getFirst();
                linearEasing = (Easing) value.getSecond();
                i2 = intValue;
            } else if (access$clampPlayTime < intValue && intValue <= durationMillis) {
                v2 = (V) value.getFirst();
                durationMillis = intValue;
            }
        }
        float transform = linearEasing.transform((access$clampPlayTime - i2) / (durationMillis - i2));
        init(v);
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        while (true) {
            V v4 = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v5 = this.valueVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            } else {
                v4 = v5;
            }
            v4.set$animation_core_release(i, VectorConvertersKt.lerp(animationVector.get$animation_core_release(i), v2.get$animation_core_release(i), transform));
            i++;
        }
        V v6 = this.valueVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    @NotNull
    public V getVelocityFromNanos(long j, @NotNull V v, @NotNull V v2, @NotNull V v3) {
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(v2, "targetValue");
        Intrinsics.checkNotNullParameter(v3, "initialVelocity");
        long access$clampPlayTime = VectorizedAnimationSpecKt.access$clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (access$clampPlayTime <= 0) {
            return v3;
        }
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(this, access$clampPlayTime - 1, v, v2, v3);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(this, access$clampPlayTime, v, v2, v3);
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

    public /* synthetic */ boolean isInfinite() {
        return fy5.a(this);
    }

    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }
}
