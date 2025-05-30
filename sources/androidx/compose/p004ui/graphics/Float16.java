package androidx.compose.p004ui.graphics;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    private static final int FP16_COMBINED = 32767;
    private static final int FP16_EXPONENT_BIAS = 15;
    private static final int FP16_EXPONENT_MASK = 31;
    private static final int FP16_EXPONENT_MAX = 31744;
    private static final int FP16_EXPONENT_SHIFT = 10;
    private static final int FP16_SIGNIFICAND_MASK = 1023;
    private static final int FP16_SIGN_MASK = 32768;
    private static final int FP16_SIGN_SHIFT = 15;
    private static final float FP32_DENORMAL_FLOAT;
    private static final int FP32_DENORMAL_MAGIC = 1056964608;
    private static final int FP32_EXPONENT_BIAS = 127;
    private static final int FP32_EXPONENT_MASK = 255;
    private static final int FP32_EXPONENT_SHIFT = 23;
    private static final int FP32_QNAN_MASK = 4194304;
    private static final int FP32_SIGNIFICAND_MASK = 8388607;
    private static final int FP32_SIGN_SHIFT = 31;
    public static final int MaxExponent = 15;
    public static final int MinExponent = -14;
    public static final int Size = 16;
    private final short halfValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final short Epsilon = m2891constructorimpl((short) 5120);
    private static final short LowestValue = m2891constructorimpl((short) -1025);
    private static final short MaxValue = m2891constructorimpl((short) 31743);
    private static final short MinNormal = m2891constructorimpl((short) 1024);
    private static final short MinValue = m2891constructorimpl((short) 1);
    private static final short NaN = m2891constructorimpl((short) 32256);
    private static final short NegativeInfinity = m2891constructorimpl((short) -1024);
    private static final short NegativeZero = m2891constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m2891constructorimpl((short) 31744);
    private static final short PositiveZero = m2891constructorimpl((short) 0);
    private static final short One = m2890constructorimpl(1.0f);
    private static final short NegativeOne = m2890constructorimpl(-1.0f);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final short floatToHalf(float f) {
            int i;
            int i2;
            int floatToRawIntBits = Float.floatToRawIntBits(f);
            int i3 = floatToRawIntBits >>> 31;
            int i4 = (floatToRawIntBits >>> 23) & 255;
            int i5 = floatToRawIntBits & Float16.FP32_SIGNIFICAND_MASK;
            if (i4 == 255) {
                i = i5 != 0 ? 512 : 0;
                r3 = 31;
            } else {
                int i6 = (i4 - 127) + 15;
                if (i6 >= 31) {
                    i = 0;
                    r3 = 49;
                } else if (i6 > 0) {
                    int i7 = i5 >> 13;
                    if ((i5 & 4096) != 0) {
                        i2 = (((i6 << 10) | i7) + 1) | (i3 << 15);
                        return (short) i2;
                    }
                    i = i7;
                    r3 = i6;
                } else if (i6 >= -10) {
                    int i8 = (i5 | 8388608) >> (1 - i6);
                    if ((i8 & 4096) != 0) {
                        i8 += 8192;
                    }
                    i = i8 >> 13;
                } else {
                    i = 0;
                }
            }
            i2 = i | (i3 << 15) | (r3 << 10);
            return (short) i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int toCompareValue(short s) {
            return (s & 32768) != 0 ? 32768 - (s & 65535) : s & 65535;
        }

        /* renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m2918getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m2919getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m2920getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m2921getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m2922getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m2923getNaNslo4al4() {
            return Float16.NaN;
        }

        /* renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m2924getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m2925getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m2926getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m2927getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }
    }

    static {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        FP32_DENORMAL_FLOAT = Float.intBitsToFloat(FP32_DENORMAL_MAGIC);
    }

    private /* synthetic */ Float16(short s) {
        this.halfValue = s;
    }

    /* renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m2885absoluteValueslo4al4(short s) {
        return m2891constructorimpl((short) (s & Short.MAX_VALUE));
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m2886boximpl(short s) {
        return new Float16(s);
    }

    /* renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m2887ceilslo4al4(short s) {
        int i = s & 65535;
        int i2 = i & FP16_COMBINED;
        if (i2 < 15360) {
            i = ((-((~(i >> 15)) & (i2 == 0 ? 0 : 1))) & 15360) | (32768 & i);
        } else if (i2 < 25600) {
            int i3 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + (((i >> 15) - 1) & i3)) & (~i3);
        }
        return m2891constructorimpl((short) i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m2890constructorimpl(float f) {
        return m2891constructorimpl(Companion.floatToHalf(f));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m2891constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2892equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m2917unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2893equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m2894floorslo4al4(short s) {
        int i = s & 65535;
        int i2 = i & FP16_COMBINED;
        if (i2 < 15360) {
            i = ((i <= 32768 ? 0 : 65535) & 15360) | (i & 32768);
        } else if (i2 < 25600) {
            int i3 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + ((-(i >> 15)) & i3)) & (~i3);
        }
        return m2891constructorimpl((short) i);
    }

    /* renamed from: getExponent-impl, reason: not valid java name */
    public static final int m2895getExponentimpl(short s) {
        return ((s >>> 10) & 31) - 15;
    }

    /* renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m2896getSignslo4al4(short s) {
        return m2901isNaNimpl(s) ? NaN : m2888compareTo41bOqos(s, NegativeZero) < 0 ? NegativeOne : m2888compareTo41bOqos(s, PositiveZero) > 0 ? One : s;
    }

    /* renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m2897getSignificandimpl(short s) {
        return s & 1023;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2898hashCodeimpl(short s) {
        return s;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m2899isFiniteimpl(short s) {
        return (s & Short.MAX_VALUE) != FP16_EXPONENT_MAX;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m2900isInfiniteimpl(short s) {
        return (s & Short.MAX_VALUE) == FP16_EXPONENT_MAX;
    }

    /* renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m2901isNaNimpl(short s) {
        return (s & Short.MAX_VALUE) > FP16_EXPONENT_MAX;
    }

    /* renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m2902isNormalizedimpl(short s) {
        int i = s & FP16_EXPONENT_MAX;
        return (i == 0 || i == FP16_EXPONENT_MAX) ? false : true;
    }

    /* renamed from: round-slo4al4, reason: not valid java name */
    public static final short m2903roundslo4al4(short s) {
        int i = s & 65535;
        int i2 = i & FP16_COMBINED;
        if (i2 < 15360) {
            i = (i & 32768) | ((i2 < 14336 ? 0 : 65535) & 15360);
        } else if (i2 < 25600) {
            int i3 = 25 - (i2 >> 10);
            i = (i + (1 << (i3 - 1))) & (~((1 << i3) - 1));
        }
        return m2891constructorimpl((short) i);
    }

    /* renamed from: toBits-impl, reason: not valid java name */
    public static final int m2904toBitsimpl(short s) {
        return m2901isNaNimpl(s) ? NaN : s & 65535;
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    public static final byte m2905toByteimpl(short s) {
        return (byte) m2907toFloatimpl(s);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m2906toDoubleimpl(short s) {
        return m2907toFloatimpl(s);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    public static final float m2907toFloatimpl(short s) {
        int i;
        int i2 = s & 65535;
        int i3 = 32768 & i2;
        int i4 = (i2 >>> 10) & 31;
        int i5 = i2 & FP16_SIGNIFICAND_MASK;
        int i6 = 0;
        if (i4 != 0) {
            int i7 = i5 << 13;
            if (i4 == 31) {
                if (i7 != 0) {
                    i7 |= 4194304;
                }
                i = i7;
                i6 = 255;
            } else {
                i6 = (i4 - 15) + FP32_EXPONENT_BIAS;
                i = i7;
            }
        } else {
            if (i5 != 0) {
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                float intBitsToFloat = Float.intBitsToFloat(i5 + FP32_DENORMAL_MAGIC) - FP32_DENORMAL_FLOAT;
                return i3 == 0 ? intBitsToFloat : -intBitsToFloat;
            }
            i = 0;
        }
        int i8 = i | (i3 << 16) | (i6 << 23);
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(i8);
    }

    @NotNull
    /* renamed from: toHexString-impl, reason: not valid java name */
    public static final String m2908toHexStringimpl(short s) {
        StringBuilder sb = new StringBuilder();
        int i = s & 65535;
        int i2 = i >>> 15;
        int i3 = (i >>> 10) & 31;
        int i4 = i & FP16_SIGNIFICAND_MASK;
        if (i3 != 31) {
            if (i2 == 1) {
                sb.append('-');
            }
            if (i3 != 0) {
                sb.append("0x1.");
                String num = Integer.toString(i4, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(num, ""));
                sb.append('p');
                sb.append(String.valueOf(i3 - 15));
            } else if (i4 == 0) {
                sb.append("0x0.0p0");
            } else {
                sb.append("0x0.");
                String num2 = Integer.toString(i4, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(num2, ""));
                sb.append("p-14");
            }
        } else if (i4 == 0) {
            if (i2 != 0) {
                sb.append('-');
            }
            sb.append("Infinity");
        } else {
            sb.append("NaN");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "o.toString()");
        return sb2;
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m2909toIntimpl(short s) {
        return (int) m2907toFloatimpl(s);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m2910toLongimpl(short s) {
        return (long) m2907toFloatimpl(s);
    }

    /* renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m2911toRawBitsimpl(short s) {
        return s & 65535;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    public static final short m2912toShortimpl(short s) {
        return (short) m2907toFloatimpl(s);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2913toStringimpl(short s) {
        return String.valueOf(m2907toFloatimpl(s));
    }

    /* renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m2914truncslo4al4(short s) {
        int i;
        int i2 = s & 65535;
        int i3 = i2 & FP16_COMBINED;
        if (i3 >= 15360) {
            i = i3 < 25600 ? ~((1 << (25 - (i3 >> 10))) - 1) : 32768;
            return m2891constructorimpl((short) i2);
        }
        i2 &= i;
        return m2891constructorimpl((short) i2);
    }

    /* renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m2915withSignqCeQghg(short s, short s2) {
        return m2891constructorimpl((short) ((s & Short.MAX_VALUE) | (s2 & 32768)));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m2916compareTo41bOqos(float16.m2917unboximpl());
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m2916compareTo41bOqos(short s) {
        return m2888compareTo41bOqos(this.halfValue, s);
    }

    public boolean equals(Object obj) {
        return m2892equalsimpl(this.halfValue, obj);
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public int hashCode() {
        return m2898hashCodeimpl(this.halfValue);
    }

    @NotNull
    public String toString() {
        return m2913toStringimpl(this.halfValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m2917unboximpl() {
        return this.halfValue;
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m2888compareTo41bOqos(short s, short s2) {
        if (m2901isNaNimpl(s)) {
            return !m2901isNaNimpl(s2) ? 1 : 0;
        }
        if (m2901isNaNimpl(s2)) {
            return -1;
        }
        Companion companion = Companion;
        return Intrinsics.compare(companion.toCompareValue(s), companion.toCompareValue(s2));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m2889constructorimpl(double d) {
        return m2890constructorimpl((float) d);
    }
}
