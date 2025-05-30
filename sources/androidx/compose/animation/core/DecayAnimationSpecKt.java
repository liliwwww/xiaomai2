package androidx.compose.animation.core;

import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class DecayAnimationSpecKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, V extends AnimationVector> T calculateTargetValue(@NotNull DecayAnimationSpec<T> decayAnimationSpec, @NotNull TwoWayConverter<T, V> twoWayConverter, T t, T t2) {
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "<this>");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        return (T) twoWayConverter.getConvertFromVector().invoke(decayAnimationSpec.vectorize(twoWayConverter).getTargetValue((AnimationVector) twoWayConverter.getConvertToVector().invoke(t), (AnimationVector) twoWayConverter.getConvertToVector().invoke(t2)));
    }

    @NotNull
    public static final <T> DecayAnimationSpec<T> exponentialDecay(float f, float f2) {
        return generateDecayAnimationSpec(new FloatExponentialDecaySpec(f, f2));
    }

    public static /* synthetic */ DecayAnimationSpec exponentialDecay$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.1f;
        }
        return exponentialDecay(f, f2);
    }

    @NotNull
    public static final <T> DecayAnimationSpec<T> generateDecayAnimationSpec(@NotNull FloatDecayAnimationSpec floatDecayAnimationSpec) {
        Intrinsics.checkNotNullParameter(floatDecayAnimationSpec, "<this>");
        return new DecayAnimationSpecImpl(floatDecayAnimationSpec);
    }

    public static final float calculateTargetValue(@NotNull DecayAnimationSpec<Float> decayAnimationSpec, float f, float f2) {
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "<this>");
        return ((AnimationVector1D) decayAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE)).getTargetValue(AnimationVectorsKt.AnimationVector(f), AnimationVectorsKt.AnimationVector(f2))).getValue();
    }
}
