package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.unit.C0856Dp;
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
public final class DpSize {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m5323getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }

        /* renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m5324getZeroMYxV2XQ() {
            return DpSize.Zero;
        }
    }

    static {
        float f = 0;
        Zero = DpKt.m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(f), C0856Dp.m5216constructorimpl(f));
        C0856Dp.Companion companion = C0856Dp.Companion;
        Unspecified = DpKt.m5238DpSizeYgX7TsA(companion.m5236getUnspecifiedD9Ej5fM(), companion.m5236getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m5302boximpl(long j) {
        return new DpSize(j);
    }

    @Stable
    /* renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m5303component1D9Ej5fM(long j) {
        return m5314getWidthD9Ej5fM(j);
    }

    @Stable
    /* renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m5304component2D9Ej5fM(long j) {
        return m5312getHeightD9Ej5fM(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5305constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m5306copyDwJknco(long j, float f, float f2) {
        return DpKt.m5238DpSizeYgX7TsA(f, f2);
    }

    /* renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m5307copyDwJknco$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5314getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m5312getHeightD9Ej5fM(j);
        }
        return m5306copyDwJknco(j, f, f2);
    }

    @Stable
    /* renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m5309divGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(m5314getWidthD9Ej5fM(j) / f), C0856Dp.m5216constructorimpl(m5312getHeightD9Ej5fM(j) / f));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5310equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).m5322unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5311equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m5312getHeightD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return C0856Dp.m5216constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Stable
    /* renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5313getHeightD9Ej5fM$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m5314getWidthD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return C0856Dp.m5216constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    @Stable
    /* renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5315getWidthD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5316hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m5317minuse_xh8Ic(long j, long j2) {
        return DpKt.m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(m5314getWidthD9Ej5fM(j) - m5314getWidthD9Ej5fM(j2)), C0856Dp.m5216constructorimpl(m5312getHeightD9Ej5fM(j) - m5312getHeightD9Ej5fM(j2)));
    }

    @Stable
    /* renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m5318pluse_xh8Ic(long j, long j2) {
        return DpKt.m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(m5314getWidthD9Ej5fM(j) + m5314getWidthD9Ej5fM(j2)), C0856Dp.m5216constructorimpl(m5312getHeightD9Ej5fM(j) + m5312getHeightD9Ej5fM(j2)));
    }

    @Stable
    /* renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m5320timesGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(m5314getWidthD9Ej5fM(j) * f), C0856Dp.m5216constructorimpl(m5312getHeightD9Ej5fM(j) * f));
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5321toStringimpl(long j) {
        if (!(j != Companion.m5323getUnspecifiedMYxV2XQ())) {
            return "DpSize.Unspecified";
        }
        return ((Object) C0856Dp.m5227toStringimpl(m5314getWidthD9Ej5fM(j))) + " x " + ((Object) C0856Dp.m5227toStringimpl(m5312getHeightD9Ej5fM(j)));
    }

    public boolean equals(Object obj) {
        return m5310equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5316hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m5321toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5322unboximpl() {
        return this.packedValue;
    }

    @Stable
    /* renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m5308divGh9hcWk(long j, float f) {
        return DpKt.m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(m5314getWidthD9Ej5fM(j) / f), C0856Dp.m5216constructorimpl(m5312getHeightD9Ej5fM(j) / f));
    }

    @Stable
    /* renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m5319timesGh9hcWk(long j, float f) {
        return DpKt.m5238DpSizeYgX7TsA(C0856Dp.m5216constructorimpl(m5314getWidthD9Ej5fM(j) * f), C0856Dp.m5216constructorimpl(m5312getHeightD9Ej5fM(j) * f));
    }
}
