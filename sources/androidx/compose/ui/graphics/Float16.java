package androidx.compose.ui.graphics;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final short Epsilon = m1095constructorimpl((short) 5120);
    private static final short LowestValue = m1095constructorimpl((short) -1025);
    private static final short MaxValue = m1095constructorimpl((short) 31743);
    private static final short MinNormal = m1095constructorimpl((short) 1024);
    private static final short MinValue = m1095constructorimpl((short) 1);
    private static final short NaN = m1095constructorimpl((short) 32256);
    private static final short NegativeInfinity = m1095constructorimpl((short) -1024);
    private static final short NegativeZero = m1095constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m1095constructorimpl((short) 31744);
    private static final short PositiveZero = m1095constructorimpl((short) 0);
    private static final short One = m1094constructorimpl(1.0f);
    private static final short NegativeOne = m1094constructorimpl(-1.0f);

    static {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        FP32_DENORMAL_FLOAT = Float.intBitsToFloat(FP32_DENORMAL_MAGIC);
    }

    private /* synthetic */ Float16(short s) {
        this.halfValue = s;
    }

    /* renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m1089absoluteValueslo4al4(short s) {
        return m1095constructorimpl((short) (s & Short.MAX_VALUE));
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m1090boximpl(short s) {
        return new Float16(s);
    }

    /* renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m1091ceilslo4al4(short s) {
        int i = s & 65535;
        int i2 = i & FP16_COMBINED;
        if (i2 < 15360) {
            i = ((-((~(i >> 15)) & (i2 == 0 ? 0 : 1))) & 15360) | (32768 & i);
        } else if (i2 < 25600) {
            int i3 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + (((i >> 15) - 1) & i3)) & (~i3);
        }
        return m1095constructorimpl((short) i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1094constructorimpl(float f) {
        return m1095constructorimpl(Companion.access$floatToHalf(Companion, f));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1095constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1096equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m1121unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1097equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m1098floorslo4al4(short s) {
        int i = s & 65535;
        int i2 = i & FP16_COMBINED;
        if (i2 < 15360) {
            i = ((i <= 32768 ? 0 : 65535) & 15360) | (i & 32768);
        } else if (i2 < 25600) {
            int i3 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + ((-(i >> 15)) & i3)) & (~i3);
        }
        return m1095constructorimpl((short) i);
    }

    /* renamed from: getExponent-impl, reason: not valid java name */
    public static final int m1099getExponentimpl(short s) {
        return ((s >>> 10) & 31) - 15;
    }

    /* renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m1100getSignslo4al4(short s) {
        return m1105isNaNimpl(s) ? NaN : m1092compareTo41bOqos(s, NegativeZero) < 0 ? NegativeOne : m1092compareTo41bOqos(s, PositiveZero) > 0 ? One : s;
    }

    /* renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m1101getSignificandimpl(short s) {
        return s & 1023;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1102hashCodeimpl(short s) {
        return s;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1103isFiniteimpl(short s) {
        return (s & Short.MAX_VALUE) != FP16_EXPONENT_MAX;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1104isInfiniteimpl(short s) {
        return (s & Short.MAX_VALUE) == FP16_EXPONENT_MAX;
    }

    /* renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m1105isNaNimpl(short s) {
        return (s & Short.MAX_VALUE) > FP16_EXPONENT_MAX;
    }

    /* renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m1106isNormalizedimpl(short s) {
        int i = s & FP16_EXPONENT_MAX;
        return (i == 0 || i == FP16_EXPONENT_MAX) ? false : true;
    }

    /* renamed from: round-slo4al4, reason: not valid java name */
    public static final short m1107roundslo4al4(short s) {
        int i = s & 65535;
        int i2 = i & FP16_COMBINED;
        if (i2 < 15360) {
            i = (i & 32768) | ((i2 < 14336 ? 0 : 65535) & 15360);
        } else if (i2 < 25600) {
            int i3 = 25 - (i2 >> 10);
            i = (i + (1 << (i3 - 1))) & (~((1 << i3) - 1));
        }
        return m1095constructorimpl((short) i);
    }

    /* renamed from: toBits-impl, reason: not valid java name */
    public static final int m1108toBitsimpl(short s) {
        return m1105isNaNimpl(s) ? NaN : s & 65535;
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    public static final byte m1109toByteimpl(short s) {
        return (byte) m1111toFloatimpl(s);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1110toDoubleimpl(short s) {
        return m1111toFloatimpl(s);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    public static final float m1111toFloatimpl(short s) {
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
    public static final String m1112toHexStringimpl(short s) {
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
    public static final int m1113toIntimpl(short s) {
        return (int) m1111toFloatimpl(s);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m1114toLongimpl(short s) {
        return (long) m1111toFloatimpl(s);
    }

    /* renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m1115toRawBitsimpl(short s) {
        return s & 65535;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    public static final short m1116toShortimpl(short s) {
        return (short) m1111toFloatimpl(s);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1117toStringimpl(short s) {
        return String.valueOf(m1111toFloatimpl(s));
    }

    /* renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m1118truncslo4al4(short s) {
        int i;
        int i2 = s & 65535;
        int i3 = i2 & FP16_COMBINED;
        if (i3 >= 15360) {
            i = i3 < 25600 ? ~((1 << (25 - (i3 >> 10))) - 1) : 32768;
            return m1095constructorimpl((short) i2);
        }
        i2 &= i;
        return m1095constructorimpl((short) i2);
    }

    /* renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m1119withSignqCeQghg(short s, short s2) {
        return m1095constructorimpl((short) ((s & Short.MAX_VALUE) | (s2 & 32768)));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m1120compareTo41bOqos(float16.m1121unboximpl());
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m1120compareTo41bOqos(short s) {
        return m1092compareTo41bOqos(this.halfValue, s);
    }

    public boolean equals(Object obj) {
        return m1096equalsimpl(this.halfValue, obj);
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public int hashCode() {
        return m1102hashCodeimpl(this.halfValue);
    }

    @NotNull
    public String toString() {
        return m1117toStringimpl(this.halfValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m1121unboximpl() {
        return this.halfValue;
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m1092compareTo41bOqos(short s, short s2) {
        if (m1105isNaNimpl(s)) {
            return !m1105isNaNimpl(s2) ? 1 : 0;
        }
        if (m1105isNaNimpl(s2)) {
            return -1;
        }
        Companion companion = Companion;
        return Intrinsics.compare(Companion.access$toCompareValue(companion, s), Companion.access$toCompareValue(companion, s2));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1093constructorimpl(double d) {
        return m1094constructorimpl((float) d);
    }
}
