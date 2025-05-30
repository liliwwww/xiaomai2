package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.unit.TextUnitType;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
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
        public static /* synthetic */ void m5407getUnspecifiedXSAIIZE$annotations() {
        }

        @NotNull
        public final TextUnitType[] getTextUnitTypes$ui_unit_release() {
            return TextUnit.TextUnitTypes;
        }

        /* renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m5408getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m5422boximpl(companion.m5431getUnspecifiedUIouoOA()), TextUnitType.m5422boximpl(companion.m5430getSpUIouoOA()), TextUnitType.m5422boximpl(companion.m5429getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m5387boximpl(long j) {
        return new TextUnit(j);
    }

    /* renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m5388compareToR2X_6o(long j, long j2) {
        TextUnitKt.m5411checkArithmeticNB67dxo(j, j2);
        return Float.compare(m5397getValueimpl(j), m5397getValueimpl(j2));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5389constructorimpl(long j) {
        return j;
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5391divkPz2Gy4(long j, float f) {
        TextUnitKt.m5410checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5395getRawTypeimpl(j), m5397getValueimpl(j) / f);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5393equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).m5406unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5394equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getRawType$annotations() {
    }

    /* renamed from: getRawType-impl, reason: not valid java name */
    public static final long m5395getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m5396getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m5395getRawTypeimpl(j) >>> 32)].m5428unboximpl();
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m5397getValueimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5398hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m5399isEmimpl(long j) {
        return m5395getRawTypeimpl(j) == 8589934592L;
    }

    /* renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m5400isSpimpl(long j) {
        return m5395getRawTypeimpl(j) == 4294967296L;
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5402timeskPz2Gy4(long j, float f) {
        TextUnitKt.m5410checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5395getRawTypeimpl(j), m5397getValueimpl(j) * f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5404toStringimpl(long j) {
        long m5396getTypeUIouoOA = m5396getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5431getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5430getSpUIouoOA())) {
            return m5397getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m5425equalsimpl0(m5396getTypeUIouoOA, companion.m5429getEmUIouoOA())) {
            return "Invalid";
        }
        return m5397getValueimpl(j) + ".em";
    }

    /* renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m5405unaryMinusXSAIIZE(long j) {
        TextUnitKt.m5410checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5395getRawTypeimpl(j), -m5397getValueimpl(j));
    }

    public boolean equals(Object obj) {
        return m5393equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5398hashCodeimpl(this.packedValue);
    }

    @NotNull
    public String toString() {
        return m5404toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5406unboximpl() {
        return this.packedValue;
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5390divkPz2Gy4(long j, double d) {
        TextUnitKt.m5410checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5395getRawTypeimpl(j), (float) (m5397getValueimpl(j) / d));
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5401timeskPz2Gy4(long j, double d) {
        TextUnitKt.m5410checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5395getRawTypeimpl(j), (float) (m5397getValueimpl(j) * d));
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5392divkPz2Gy4(long j, int i) {
        TextUnitKt.m5410checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5395getRawTypeimpl(j), m5397getValueimpl(j) / i);
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5403timeskPz2Gy4(long j, int i) {
        TextUnitKt.m5410checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5395getRawTypeimpl(j), m5397getValueimpl(j) * i);
    }
}
