package androidx.compose.foundation.layout;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class AndroidFlingSpline {
    private static final int NbSamples = 100;

    @NotNull
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();

    @NotNull
    private static final float[] SplinePositions = new float[101];

    @NotNull
    private static final float[] SplineTimes = new float[101];

    /* compiled from: Taobao */
    @JvmInline
    public static final class FlingResult {
        private final long packedValue;

        private /* synthetic */ FlingResult(long j) {
            this.packedValue = j;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ FlingResult m1332boximpl(long j) {
            return new FlingResult(j);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static long m1333constructorimpl(long j) {
            return j;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m1334equalsimpl(long j, Object obj) {
            return (obj instanceof FlingResult) && j == ((FlingResult) obj).m1340unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1335equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* renamed from: getDistanceCoefficient-impl, reason: not valid java name */
        public static final float m1336getDistanceCoefficientimpl(long j) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j >> 32));
        }

        /* renamed from: getVelocityCoefficient-impl, reason: not valid java name */
        public static final float m1337getVelocityCoefficientimpl(long j) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m1338hashCodeimpl(long j) {
            return c8.a(j);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m1339toStringimpl(long j) {
            return "FlingResult(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m1334equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m1338hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m1339toStringimpl(this.packedValue);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ long m1340unboximpl() {
            return this.packedValue;
        }
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i = 0;
        while (true) {
            float f13 = 1.0f;
            if (i >= 100) {
                float[] fArr = SplineTimes;
                fArr[100] = 1.0f;
                SplinePositions[100] = fArr[100];
                return;
            }
            float f14 = i / 100;
            float f15 = 1.0f;
            while (true) {
                f = 2.0f;
                f2 = ((f15 - f11) / 2.0f) + f11;
                f3 = 3.0f;
                f4 = f13 - f2;
                f5 = f2 * 3.0f * f4;
                f6 = f2 * f2 * f2;
                float f16 = (((f4 * 0.175f) + (f2 * 0.35000002f)) * f5) + f6;
                float f17 = f15;
                if (Math.abs(f16 - f14) < 1.0E-5d) {
                    break;
                }
                if (f16 > f14) {
                    f15 = f2;
                } else {
                    f11 = f2;
                    f15 = f17;
                }
                f13 = 1.0f;
            }
            SplinePositions[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
            float f18 = 1.0f;
            while (true) {
                f7 = ((f18 - f12) / f) + f12;
                f8 = 1.0f - f7;
                f9 = f7 * f3 * f8;
                f10 = f7 * f7 * f7;
                float f19 = (((f8 * 0.5f) + f7) * f9) + f10;
                if (Math.abs(f19 - f14) >= 1.0E-5d) {
                    if (f19 > f14) {
                        f18 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
            }
            SplineTimes[i] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
            i++;
        }
    }

    private AndroidFlingSpline() {
    }

    public final double deceleration(float f, float f2) {
        return Math.log((Math.abs(f) * 0.35f) / f2);
    }

    /* renamed from: flingPosition-LfoxSSI, reason: not valid java name */
    public final long m1331flingPositionLfoxSSI(float f) {
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
        return FlingResult.m1333constructorimpl((Float.floatToIntBits(f3) & 4294967295L) | (Float.floatToIntBits(f2) << 32));
    }
}
