package androidx.compose.animation.core;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ComplexDoubleKt {
    @NotNull
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d, double d2, double d3) {
        double d4 = -d2;
        double d5 = (d2 * d2) - ((4.0d * d) * d3);
        ComplexDouble complexSqrt = complexSqrt(d5);
        ComplexDouble.access$set_real$p(complexSqrt, ComplexDouble.access$get_real$p(complexSqrt) + d4);
        double d6 = d * 2.0d;
        ComplexDouble.access$set_real$p(complexSqrt, ComplexDouble.access$get_real$p(complexSqrt) / d6);
        ComplexDouble.access$set_imaginary$p(complexSqrt, ComplexDouble.access$get_imaginary$p(complexSqrt) / d6);
        ComplexDouble complexSqrt2 = complexSqrt(d5);
        double d7 = -1;
        ComplexDouble.access$set_real$p(complexSqrt2, ComplexDouble.access$get_real$p(complexSqrt2) * d7);
        ComplexDouble.access$set_imaginary$p(complexSqrt2, ComplexDouble.access$get_imaginary$p(complexSqrt2) * d7);
        ComplexDouble.access$set_real$p(complexSqrt2, ComplexDouble.access$get_real$p(complexSqrt2) + d4);
        ComplexDouble.access$set_real$p(complexSqrt2, ComplexDouble.access$get_real$p(complexSqrt2) / d6);
        ComplexDouble.access$set_imaginary$p(complexSqrt2, ComplexDouble.access$get_imaginary$p(complexSqrt2) / d6);
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
        ComplexDouble.access$set_real$p(complexDouble, ComplexDouble.access$get_real$p(complexDouble) * d2);
        ComplexDouble.access$set_imaginary$p(complexDouble, ComplexDouble.access$get_imaginary$p(complexDouble) * d2);
        ComplexDouble.access$set_real$p(complexDouble, ComplexDouble.access$get_real$p(complexDouble) + d);
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble plus(double d, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        ComplexDouble.access$set_real$p(complexDouble, ComplexDouble.access$get_real$p(complexDouble) + d);
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble times(double d, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        ComplexDouble.access$set_real$p(complexDouble, ComplexDouble.access$get_real$p(complexDouble) * d);
        ComplexDouble.access$set_imaginary$p(complexDouble, ComplexDouble.access$get_imaginary$p(complexDouble) * d);
        return complexDouble;
    }
}
