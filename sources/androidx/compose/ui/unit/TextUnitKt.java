package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    /* renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m2225TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    @PublishedApi
    /* renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m2226checkArithmeticR2X_6o(long j) {
        if (!(!m2231isUnspecifiedR2X_6o(j))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
    }

    @PublishedApi
    /* renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m2227checkArithmeticNB67dxo(long j, long j2) {
        if (!((m2231isUnspecifiedR2X_6o(j) || m2231isUnspecifiedR2X_6o(j2)) ? false : true)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        if (TextUnitType.equals-impl0(TextUnit.m2212getTypeUIouoOA(j), TextUnit.m2212getTypeUIouoOA(j2))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.toString-impl(TextUnit.m2212getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.toString-impl(TextUnit.m2212getTypeUIouoOA(j2)))).toString());
    }

    @PublishedApi
    /* renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m2228checkArithmeticvU0ePk(long j, long j2, long j3) {
        if (!((m2231isUnspecifiedR2X_6o(j) || m2231isUnspecifiedR2X_6o(j2) || m2231isUnspecifiedR2X_6o(j3)) ? false : true)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
        if (TextUnitType.equals-impl0(TextUnit.m2212getTypeUIouoOA(j), TextUnit.m2212getTypeUIouoOA(j2)) && TextUnitType.equals-impl0(TextUnit.m2212getTypeUIouoOA(j2), TextUnit.m2212getTypeUIouoOA(j3))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.toString-impl(TextUnit.m2212getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.toString-impl(TextUnit.m2212getTypeUIouoOA(j2)))).toString());
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
    public static final boolean m2229isSpecifiedR2X_6o(long j) {
        return !m2231isUnspecifiedR2X_6o(j);
    }

    @Stable
    /* renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m2230isSpecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m2231isUnspecifiedR2X_6o(long j) {
        return TextUnit.m2211getRawTypeimpl(j) == 0;
    }

    @Stable
    /* renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m2232isUnspecifiedR2X_6o$annotations(long j) {
    }

    @Stable
    /* renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m2233lerpC3pnCVY(long j, long j2, float f) {
        m2227checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m2211getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m2213getValueimpl(j), TextUnit.m2213getValueimpl(j2), f));
    }

    @PublishedApi
    public static final long pack(long j, float f) {
        return TextUnit.m2205constructorimpl(j | (Float.floatToIntBits(f) & 4294967295L));
    }

    /* renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m2234takeOrElseeAf_CNQ(long j, @NotNull Function0<TextUnit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return m2231isUnspecifiedR2X_6o(j) ^ true ? j : ((TextUnit) function0.invoke()).m2222unboximpl();
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m2236timesmpE4wyQ(float f, long j) {
        m2226checkArithmeticR2X_6o(j);
        return pack(TextUnit.m2211getRawTypeimpl(j), f * TextUnit.m2213getValueimpl(j));
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
    public static final long m2235timesmpE4wyQ(double d, long j) {
        m2226checkArithmeticR2X_6o(j);
        return pack(TextUnit.m2211getRawTypeimpl(j), ((float) d) * TextUnit.m2213getValueimpl(j));
    }

    @Stable
    /* renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m2237timesmpE4wyQ(int i, long j) {
        m2226checkArithmeticR2X_6o(j);
        return pack(TextUnit.m2211getRawTypeimpl(j), i * TextUnit.m2213getValueimpl(j));
    }
}
