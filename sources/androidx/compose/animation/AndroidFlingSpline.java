package androidx.compose.animation;

import androidx.appcompat.R;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidFlingSpline {

    @NotNull
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final int NbSamples = 100;

    @NotNull
    private static final float[] SplinePositions;

    @NotNull
    private static final float[] SplineTimes;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class FlingResult {
        public static final int $stable = 0;
        private final float distanceCoefficient;
        private final float velocityCoefficient;

        public FlingResult(float f, float f2) {
            this.distanceCoefficient = f;
            this.velocityCoefficient = f2;
        }

        public static /* synthetic */ FlingResult copy$default(FlingResult flingResult, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = flingResult.distanceCoefficient;
            }
            if ((i & 2) != 0) {
                f2 = flingResult.velocityCoefficient;
            }
            return flingResult.copy(f, f2);
        }

        public final float component1() {
            return this.distanceCoefficient;
        }

        public final float component2() {
            return this.velocityCoefficient;
        }

        @NotNull
        public final FlingResult copy(float f, float f2) {
            return new FlingResult(f, f2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingResult)) {
                return false;
            }
            FlingResult flingResult = (FlingResult) obj;
            return Intrinsics.areEqual(Float.valueOf(this.distanceCoefficient), Float.valueOf(flingResult.distanceCoefficient)) && Intrinsics.areEqual(Float.valueOf(this.velocityCoefficient), Float.valueOf(flingResult.velocityCoefficient));
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.distanceCoefficient) * 31) + Float.floatToIntBits(this.velocityCoefficient);
        }

        @NotNull
        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.distanceCoefficient + ", velocityCoefficient=" + this.velocityCoefficient + ')';
        }
    }

    static {
        float[] fArr = new float[R.styleable.AppCompatTheme_switchStyle];
        SplinePositions = fArr;
        float[] fArr2 = new float[R.styleable.AppCompatTheme_switchStyle];
        SplineTimes = fArr2;
        SplineBasedDecayKt.access$computeSplineInfo(fArr, fArr2, 100);
    }

    private AndroidFlingSpline() {
    }

    public final double deceleration(float f, float f2) {
        return Math.log((Math.abs(f) * 0.35f) / f2);
    }

    @NotNull
    public final FlingResult flingPosition(float f) {
        float f2;
        float f3;
        float f4 = 100;
        int i = (int) (f4 * f);
        if (i < 100) {
            float f5 = i / f4;
            int i2 = i + 1;
            float f6 = i2 / f4;
            float[] fArr = SplinePositions;
            float f7 = fArr[i];
            f3 = (fArr[i2] - f7) / (f6 - f5);
            f2 = f7 + ((f - f5) * f3);
        } else {
            f2 = 1.0f;
            f3 = 0.0f;
        }
        return new FlingResult(f2, f3);
    }
}
