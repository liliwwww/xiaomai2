package androidx.compose.animation.core;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ComplexDoubleKt {
    @NotNull
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d, double d2, double d3) {
        double d4 = -d2;
        double d5 = (d2 * d2) - ((4.0d * d) * d3);
        ComplexDouble complexSqrt = complexSqrt(d5);
        complexSqrt._real += d4;
        double d6 = d * 2.0d;
        complexSqrt._real /= d6;
        complexSqrt._imaginary /= d6;
        ComplexDouble complexSqrt2 = complexSqrt(d5);
        double d7 = -1;
        complexSqrt2._real *= d7;
        complexSqrt2._imaginary *= d7;
        complexSqrt2._real += d4;
        complexSqrt2._real /= d6;
        complexSqrt2._imaginary /= d6;
        return TuplesKt.to(complexSqrt, complexSqrt2);
    }

    @NotNull
    public static final ComplexDouble complexSqrt(double d) {
        return d < 0.0d ? new ComplexDouble(0.0d, Math.sqrt(Math.abs(d))) : new ComplexDouble(Math.sqrt(d), 0.0d);
    }

    @NotNull
    public static final ComplexDouble minus(double d, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        double d2 = -1;
        complexDouble._real *= d2;
        complexDouble._imaginary *= d2;
        complexDouble._real += d;
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble plus(double d, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        complexDouble._real += d;
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble times(double d, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        return complexDouble;
    }
}
