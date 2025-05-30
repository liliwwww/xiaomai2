package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    /* renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m5409TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    @PublishedApi
    /* renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m5410checkArithmeticR2X_6o(long j) {
        if (!(!m5415isUnspecifiedR2X_6o(j))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
    }

    @PublishedApi
    /* renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m5411checkArithmeticNB67dxo(long j, long j2) {
        if (!((m5415isUnspecifiedR2X_6o(j) || m5415isUnspecifiedR2X_6o(j2)) ? false : true)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        if (TextUnitType.m5425equalsimpl0(TextUnit.m5396getTypeUIouoOA(j), TextUnit.m5396getTypeUIouoOA(j2))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m5427toStringimpl(TextUnit.m5396getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m5427toStringimpl(TextUnit.m5396getTypeUIouoOA(j2)))).toString());
    }

    @PublishedApi
    /* renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m5412checkArithmeticvU0ePk(long j, long j2, long j3) {
        if (!((m5415isUnspecifiedR2X_6o(j) || m5415isUnspecifiedR2X_6o(j2) || m5415isUnspecifiedR2X_6o(j3)) ? false : true)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        if (TextUnitType.m5425equalsimpl0(TextUnit.m5396getTypeUIouoOA(j), TextUnit.m5396getTypeUIouoOA(j2)) && TextUnitType.m5425equalsimpl0(TextUnit.m5396getTypeUIouoOA(j2), TextUnit.m5396getTypeUIouoOA(j3))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m5427toStringimpl(TextUnit.m5396getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m5427toStringimpl(TextUnit.m5396getTypeUIouoOA(j2)))).toString());
    }

    public static final long getEm(float f) {
        return pack(UNIT_TYPE_EM, f);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(double d) {
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(float f) {
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static final long getSp(float f) {
        return pack(UNIT_TYPE_SP, f);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(double d) {
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(float f) {
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(int i) {
    }

    /* renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m5413isSpecifiedR2X_6o(long j) {
        return !m5415isUnspecifiedR2X_6o(j);
    }

    @Stable
    /* renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m5414isSpecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m5415isUnspecifiedR2X_6o(long j) {
        return TextUnit.m5395getRawTypeimpl(j) == 0;
    }

    @Stable
    /* renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m5416isUnspecifiedR2X_6o$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m5417lerpC3pnCVY(long j, long j2, float f) {
        m5411checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m5395getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m5397getValueimpl(j), TextUnit.m5397getValueimpl(j2), f));
    }

    @PublishedApi
    public static final long pack(long j, float f) {
        return TextUnit.m5389constructorimpl(j | (Float.floatToIntBits(f) & 4294967295L));
    }

    /* renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m5418takeOrElseeAf_CNQ(long j, @NotNull Function0<TextUnit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return m5415isUnspecifiedR2X_6o(j) ^ true ? j : ((TextUnit) function0.invoke()).m5406unboximpl();
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m5420timesmpE4wyQ(float f, long j) {
        m5410checkArithmeticR2X_6o(j);
        return pack(TextUnit.m5395getRawTypeimpl(j), f * TextUnit.m5397getValueimpl(j));
    }

    public static final long getEm(double d) {
        return pack(UNIT_TYPE_EM, (float) d);
    }

    public static final long getSp(double d) {
        return pack(UNIT_TYPE_SP, (float) d);
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, i);
    }

    public static final long getSp(int i) {
        return pack(UNIT_TYPE_SP, i);
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m5419timesmpE4wyQ(double d, long j) {
        m5410checkArithmeticR2X_6o(j);
        return pack(TextUnit.m5395getRawTypeimpl(j), ((float) d) * TextUnit.m5397getValueimpl(j));
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m5421timesmpE4wyQ(int i, long j) {
        m5410checkArithmeticR2X_6o(j);
        return pack(TextUnit.m5395getRawTypeimpl(j), i * TextUnit.m5397getValueimpl(j));
    }
}
