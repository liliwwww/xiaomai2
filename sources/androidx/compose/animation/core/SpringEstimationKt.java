package androidx.compose.animation.core;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return estimateAnimationDurationMillis(f, f2, f3, f4, f5);
    }

    private static final double estimateCriticallyDamped(Pair<ComplexDouble, ComplexDouble> pair, final double d, double d2, double d3) {
        double d4;
        final double d5;
        Function1<Double, Double> function1;
        Function1<Double, Double> function12;
        double d6;
        final double real = ((ComplexDouble) pair.getFirst()).getReal();
        double d7 = real * d;
        final double d8 = d2 - d7;
        double log = Math.log(Math.abs(d3 / d)) / real;
        double estimateCriticallyDamped$t2Iterate = estimateCriticallyDamped$t2Iterate(Math.log(Math.abs(d3 / d8)), real) / real;
        int i = 0;
        if (!((Double.isInfinite(log) || Double.isNaN(log)) ? false : true)) {
            d4 = estimateCriticallyDamped$t2Iterate;
        } else {
            if (!(!((Double.isInfinite(estimateCriticallyDamped$t2Iterate) || Double.isNaN(estimateCriticallyDamped$t2Iterate)) ? false : true))) {
                log = Math.max(log, estimateCriticallyDamped$t2Iterate);
            }
            d4 = log;
        }
        double d9 = (-(d7 + d8)) / (real * d8);
        if (!Double.isNaN(d9) && d9 > 0.0d) {
            if (d9 <= 0.0d || (-estimateCriticallyDamped$xInflection(d, real, d9, d8)) >= d3) {
                d4 = (-(2.0d / real)) - (d / d8);
                d5 = d3;
                function1 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @NotNull
                    public final Double invoke(double d10) {
                        return Double.valueOf(((d + (d8 * d10)) * Math.exp(real * d10)) + d5);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).doubleValue());
                    }
                };
                function12 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @NotNull
                    public final Double invoke(double d10) {
                        double d11 = d8;
                        double d12 = real;
                        return Double.valueOf(((d11 * ((d12 * d10) + 1)) + (d * d12)) * Math.exp(d12 * d10));
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).doubleValue());
                    }
                };
                d6 = Double.MAX_VALUE;
                while (d6 > 0.001d && i < 100) {
                    i++;
                    double doubleValue = d4 - (((Number) function1.invoke(Double.valueOf(d4))).doubleValue() / ((Number) function12.invoke(Double.valueOf(d4))).doubleValue());
                    double abs = Math.abs(d4 - doubleValue);
                    d4 = doubleValue;
                    d6 = abs;
                }
                return d4;
            }
            if (d8 < 0.0d && d > 0.0d) {
                d4 = 0.0d;
            }
        }
        d5 = -d3;
        function1 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Double invoke(double d10) {
                return Double.valueOf(((d + (d8 * d10)) * Math.exp(real * d10)) + d5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).doubleValue());
            }
        };
        function12 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Double invoke(double d10) {
                double d11 = d8;
                double d12 = real;
                return Double.valueOf(((d11 * ((d12 * d10) + 1)) + (d * d12)) * Math.exp(d12 * d10));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).doubleValue());
            }
        };
        d6 = Double.MAX_VALUE;
        while (d6 > 0.001d) {
            i++;
            double doubleValue2 = d4 - (((Number) function1.invoke(Double.valueOf(d4))).doubleValue() / ((Number) function12.invoke(Double.valueOf(d4))).doubleValue());
            double abs2 = Math.abs(d4 - doubleValue2);
            d4 = doubleValue2;
            d6 = abs2;
        }
        return d4;
    }

    private static final double estimateCriticallyDamped$t2Iterate(double d, double d2) {
        double d3 = d;
        for (int i = 0; i < 6; i++) {
            d3 = d - Math.log(Math.abs(d3 / d2));
        }
        return d3;
    }

    private static final double estimateCriticallyDamped$xInflection(double d, double d2, double d3, double d4) {
        double d5 = d2 * d3;
        return (d * Math.exp(d5)) + (d4 * d3 * Math.exp(d5));
    }

    private static final long estimateDurationInternal(Pair<ComplexDouble, ComplexDouble> pair, double d, double d2, double d3, double d4) {
        if (d3 == 0.0d) {
            if (d2 == 0.0d) {
                return 0L;
            }
        }
        if (d3 < 0.0d) {
            d2 = -d2;
        }
        double d5 = d2;
        double abs = Math.abs(d3);
        return (long) ((d > 1.0d ? estimateOverDamped(pair, abs, d5, d4) : d < 1.0d ? estimateUnderDamped(pair, abs, d5, d4) : estimateCriticallyDamped(pair, abs, d5, d4)) * 1000.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final double estimateOverDamped(kotlin.Pair<androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble> r31, double r32, double r34, double r36) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(kotlin.Pair, double, double, double):double");
    }

    /* renamed from: estimateOverDamped$xInflection-0, reason: not valid java name */
    private static final double m1066estimateOverDamped$xInflection0(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final double estimateUnderDamped(Pair<ComplexDouble, ComplexDouble> pair, double d, double d2, double d3) {
        double real = ((ComplexDouble) pair.getFirst()).getReal();
        double imaginary = (d2 - (real * d)) / ((ComplexDouble) pair.getFirst()).getImaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (imaginary * imaginary))) / real;
    }

    private static final boolean isNotFinite(double d) {
        return !((Double.isInfinite(d) || Double.isNaN(d)) ? false : true);
    }

    private static final double iterateNewtonsMethod(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return d - (((Number) function1.invoke(Double.valueOf(d))).doubleValue() / ((Number) function12.invoke(Double.valueOf(d))).doubleValue());
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(1.0d, 2.0d * d2 * Math.sqrt(d), d), d2, d3, d4, d5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5, double d6) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(d3, d2, d), d2 / (Math.sqrt(d * d3) * 2.0d), d4, d5, d6);
    }
}
