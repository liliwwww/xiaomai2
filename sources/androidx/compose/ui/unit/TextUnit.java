package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextUnit {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m2223getUnspecifiedXSAIIZE$annotations() {
        }

        @NotNull
        public final TextUnitType[] getTextUnitTypes$ui_unit_release() {
            return TextUnit.TextUnitTypes;
        }

        /* renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m2224getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.box-impl(companion.getUnspecified-UIouoOA()), TextUnitType.box-impl(companion.getSp-UIouoOA()), TextUnitType.box-impl(companion.getEm-UIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m2203boximpl(long j) {
        return new TextUnit(j);
    }

    /* renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m2204compareToR2X_6o(long j, long j2) {
        TextUnitKt.m2227checkArithmeticNB67dxo(j, j2);
        return Float.compare(m2213getValueimpl(j), m2213getValueimpl(j2));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2205constructorimpl(long j) {
        return j;
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m2207divkPz2Gy4(long j, float f) {
        TextUnitKt.m2226checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2211getRawTypeimpl(j), m2213getValueimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2209equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).m2222unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2210equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getRawType$annotations() {
    }

    /* renamed from: getRawType-impl, reason: not valid java name */
    public static final long m2211getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m2212getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m2211getRawTypeimpl(j) >>> 32)].unbox-impl();
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m2213getValueimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2214hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m2215isEmimpl(long j) {
        return m2211getRawTypeimpl(j) == 8589934592L;
    }

    /* renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m2216isSpimpl(long j) {
        return m2211getRawTypeimpl(j) == 4294967296L;
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m2218timeskPz2Gy4(long j, float f) {
        TextUnitKt.m2226checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2211getRawTypeimpl(j), m2213getValueimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2220toStringimpl(long j) {
        long m2212getTypeUIouoOA = m2212getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.equals-impl0(m2212getTypeUIouoOA, companion.getUnspecified-UIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.equals-impl0(m2212getTypeUIouoOA, companion.getSp-UIouoOA())) {
            return m2213getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.equals-impl0(m2212getTypeUIouoOA, companion.getEm-UIouoOA())) {
            return "Invalid";
        }
        return m2213getValueimpl(j) + ".em";
    }

    /* renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m2221unaryMinusXSAIIZE(long j) {
        TextUnitKt.m2226checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2211getRawTypeimpl(j), -m2213getValueimpl(j));
    }

    public boolean equals(Object obj) {
        return m2209equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2214hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m2220toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2222unboximpl() {
        return this.packedValue;
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m2206divkPz2Gy4(long j, double d) {
        TextUnitKt.m2226checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2211getRawTypeimpl(j), (float) (m2213getValueimpl(j) / d));
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m2217timeskPz2Gy4(long j, double d) {
        TextUnitKt.m2226checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2211getRawTypeimpl(j), (float) (m2213getValueimpl(j) * d));
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m2208divkPz2Gy4(long j, int i) {
        TextUnitKt.m2226checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2211getRawTypeimpl(j), m2213getValueimpl(j) / i);
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m2219timeskPz2Gy4(long j, int i) {
        TextUnitKt.m2226checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m2211getRawTypeimpl(j), m2213getValueimpl(j) * i);
    }
}
