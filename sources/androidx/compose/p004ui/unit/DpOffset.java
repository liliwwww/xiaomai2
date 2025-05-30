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
/* loaded from: classes2.dex */
public final class DpOffset {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m5286getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }

        /* renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m5287getZeroRKDOV3M() {
            return DpOffset.Zero;
        }
    }

    static {
        float f = 0;
        Zero = DpKt.m5237DpOffsetYgX7TsA(C0856Dp.m5216constructorimpl(f), C0856Dp.m5216constructorimpl(f));
        C0856Dp.Companion companion = C0856Dp.Companion;
        Unspecified = DpKt.m5237DpOffsetYgX7TsA(companion.m5236getUnspecifiedD9Ej5fM(), companion.m5236getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m5271boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5272constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m5273copytPigGR8(long j, float f, float f2) {
        return DpKt.m5237DpOffsetYgX7TsA(f, f2);
    }

    /* renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m5274copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5277getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m5279getYD9Ej5fM(j);
        }
        return m5273copytPigGR8(j, f, f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5275equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m5285unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5276equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m5277getXD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return C0856Dp.m5216constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    @Stable
    /* renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5278getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m5279getYD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return C0856Dp.m5216constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Stable
    /* renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5280getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5281hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m5282minusCBMgk4(long j, long j2) {
        return DpKt.m5237DpOffsetYgX7TsA(C0856Dp.m5216constructorimpl(m5277getXD9Ej5fM(j) - m5277getXD9Ej5fM(j2)), C0856Dp.m5216constructorimpl(m5279getYD9Ej5fM(j) - m5279getYD9Ej5fM(j2)));
    }

    @Stable
    /* renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m5283plusCBMgk4(long j, long j2) {
        return DpKt.m5237DpOffsetYgX7TsA(C0856Dp.m5216constructorimpl(m5277getXD9Ej5fM(j) + m5277getXD9Ej5fM(j2)), C0856Dp.m5216constructorimpl(m5279getYD9Ej5fM(j) + m5279getYD9Ej5fM(j2)));
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5284toStringimpl(long j) {
        if (!(j != Companion.m5286getUnspecifiedRKDOV3M())) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) C0856Dp.m5227toStringimpl(m5277getXD9Ej5fM(j))) + ", " + ((Object) C0856Dp.m5227toStringimpl(m5279getYD9Ej5fM(j))) + ')';
    }

    public boolean equals(Object obj) {
        return m5275equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5281hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m5284toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5285unboximpl() {
        return this.packedValue;
    }
}
