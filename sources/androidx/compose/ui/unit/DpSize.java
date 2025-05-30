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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DpSize {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long Unspecified;
    private static final long Zero;
    private final long packedValue;

    static {
        float f = 0;
        Zero = DpKt.DpSize-YgX7TsA(Dp.m2142constructorimpl(f), Dp.m2142constructorimpl(f));
        Dp.Companion companion = Dp.Companion;
        Unspecified = DpKt.DpSize-YgX7TsA(companion.m2162getUnspecifiedD9Ej5fM(), companion.m2162getUnspecifiedD9Ej5fM());
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m2177boximpl(long j) {
        return new DpSize(j);
    }

    @Stable
    /* renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m2178component1D9Ej5fM(long j) {
        return m2189getWidthD9Ej5fM(j);
    }

    @Stable
    /* renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m2179component2D9Ej5fM(long j) {
        return m2187getHeightD9Ej5fM(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2180constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m2181copyDwJknco(long j, float f, float f2) {
        return DpKt.DpSize-YgX7TsA(f, f2);
    }

    /* renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m2182copyDwJknco$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2189getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m2187getHeightD9Ej5fM(j);
        }
        return m2181copyDwJknco(j, f, f2);
    }

    @Stable
    /* renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m2184divGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.DpSize-YgX7TsA(Dp.m2142constructorimpl(m2189getWidthD9Ej5fM(j) / f), Dp.m2142constructorimpl(m2187getHeightD9Ej5fM(j) / f));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2185equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).m2197unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2186equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m2187getHeightD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Dp.m2142constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Stable
    /* renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2188getHeightD9Ej5fM$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m2189getWidthD9Ej5fM(long j) {
        if (!(j != Unspecified)) {
            throw new IllegalStateException("DpSize is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Dp.m2142constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    @Stable
    /* renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2190getWidthD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2191hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    /* renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m2192minuse_xh8Ic(long j, long j2) {
        return DpKt.DpSize-YgX7TsA(Dp.m2142constructorimpl(m2189getWidthD9Ej5fM(j) - m2189getWidthD9Ej5fM(j2)), Dp.m2142constructorimpl(m2187getHeightD9Ej5fM(j) - m2187getHeightD9Ej5fM(j2)));
    }

    @Stable
    /* renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m2193pluse_xh8Ic(long j, long j2) {
        return DpKt.DpSize-YgX7TsA(Dp.m2142constructorimpl(m2189getWidthD9Ej5fM(j) + m2189getWidthD9Ej5fM(j2)), Dp.m2142constructorimpl(m2187getHeightD9Ej5fM(j) + m2187getHeightD9Ej5fM(j2)));
    }

    @Stable
    /* renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m2195timesGh9hcWk(long j, int i) {
        float f = i;
        return DpKt.DpSize-YgX7TsA(Dp.m2142constructorimpl(m2189getWidthD9Ej5fM(j) * f), Dp.m2142constructorimpl(m2187getHeightD9Ej5fM(j) * f));
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2196toStringimpl(long j) {
        if (!(j != Companion.getUnspecified-MYxV2XQ())) {
            return "DpSize.Unspecified";
        }
        return ((Object) Dp.m2153toStringimpl(m2189getWidthD9Ej5fM(j))) + " x " + ((Object) Dp.m2153toStringimpl(m2187getHeightD9Ej5fM(j)));
    }

    public boolean equals(Object obj) {
        return m2185equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2191hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m2196toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2197unboximpl() {
        return this.packedValue;
    }

    @Stable
    /* renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m2183divGh9hcWk(long j, float f) {
        return DpKt.DpSize-YgX7TsA(Dp.m2142constructorimpl(m2189getWidthD9Ej5fM(j) / f), Dp.m2142constructorimpl(m2187getHeightD9Ej5fM(j) / f));
    }

    @Stable
    /* renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m2194timesGh9hcWk(long j, float f) {
        return DpKt.DpSize-YgX7TsA(Dp.m2142constructorimpl(m2189getWidthD9Ej5fM(j) * f), Dp.m2142constructorimpl(m2187getHeightD9Ej5fM(j) * f));
    }
}
