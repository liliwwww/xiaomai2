package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
        public final long m2630getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }

        /* renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m2631getZeroRKDOV3M() {
            return DpOffset.Zero;
        }
    }

    static {
        float f = 0;
        Zero = DpKt.m2581DpOffsetYgX7TsA(Dp.constructor-impl(f), Dp.constructor-impl(f));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.m2581DpOffsetYgX7TsA(companion.getUnspecified-D9Ej5fM(), companion.getUnspecified-D9Ej5fM());
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m2615boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2616constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m2617copytPigGR8(long j, float f, float f2) {
        return DpKt.m2581DpOffsetYgX7TsA(f, f2);
    }

    /* renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m2618copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2621getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m2623getYD9Ej5fM(j);
        }
        return m2617copytPigGR8(j, f, f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2619equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m2629unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2620equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m2621getXD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Dp.constructor-impl(Float.intBitsToFloat((int) (j >> 32)));
    }

    @Stable
    /* renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2622getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m2623getYD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Dp.constructor-impl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Stable
    /* renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2624getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2625hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m2626minusCBMgk4(long j, long j2) {
        return DpKt.m2581DpOffsetYgX7TsA(Dp.constructor-impl(m2621getXD9Ej5fM(j) - m2621getXD9Ej5fM(j2)), Dp.constructor-impl(m2623getYD9Ej5fM(j) - m2623getYD9Ej5fM(j2)));
    }

    @Stable
    /* renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m2627plusCBMgk4(long j, long j2) {
        return DpKt.m2581DpOffsetYgX7TsA(Dp.constructor-impl(m2621getXD9Ej5fM(j) + m2621getXD9Ej5fM(j2)), Dp.constructor-impl(m2623getYD9Ej5fM(j) + m2623getYD9Ej5fM(j2)));
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2628toStringimpl(long j) {
        if (!(j != Companion.m2630getUnspecifiedRKDOV3M())) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) Dp.toString-impl(m2621getXD9Ej5fM(j))) + ", " + ((Object) Dp.toString-impl(m2623getYD9Ej5fM(j))) + ')';
    }

    public boolean equals(Object obj) {
        return m2619equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2625hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m2628toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2629unboximpl() {
        return this.packedValue;
    }
}
