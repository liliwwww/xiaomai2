package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Dp implements Comparable<Dp> {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float Hairline = m2142constructorimpl(0.0f);
    private static final float Infinity = m2142constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m2142constructorimpl(Float.NaN);
    private final float value;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m2157getHairlineD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m2158getInfinityD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m2159getUnspecifiedD9Ej5fM$annotations() {
        }

        /* renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m2160getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m2161getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m2162getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }
    }

    private /* synthetic */ Dp(float f) {
        this.value = f;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Dp m2140boximpl(float f) {
        return new Dp(f);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m2142constructorimpl(float f) {
        return f;
    }

    @Stable
    /* renamed from: div-0680j_4, reason: not valid java name */
    public static final float m2143div0680j_4(float f, float f2) {
        return f / f2;
    }

    @Stable
    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m2144divu2uoSUM(float f, float f2) {
        return m2142constructorimpl(f / f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2146equalsimpl(float f, Object obj) {
        return (obj instanceof Dp) && Float.compare(f, ((Dp) obj).m2156unboximpl()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2147equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2148hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    @Stable
    /* renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m2149minus5rwHm24(float f, float f2) {
        return m2142constructorimpl(f - f2);
    }

    @Stable
    /* renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m2150plus5rwHm24(float f, float f2) {
        return m2142constructorimpl(f + f2);
    }

    @Stable
    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m2151timesu2uoSUM(float f, float f2) {
        return m2142constructorimpl(f * f2);
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2153toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }

    @Stable
    /* renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m2154unaryMinusD9Ej5fM(float f) {
        return m2142constructorimpl(-f);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp dp) {
        return m2155compareTo0680j_4(dp.m2156unboximpl());
    }

    @Stable
    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m2155compareTo0680j_4(float f) {
        return m2141compareTo0680j_4(this.value, f);
    }

    public boolean equals(Object obj) {
        return m2146equalsimpl(this.value, obj);
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return m2148hashCodeimpl(this.value);
    }

    @Stable
    @NotNull
    public String toString() {
        return m2153toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m2156unboximpl() {
        return this.value;
    }

    @Stable
    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m2141compareTo0680j_4(float f, float f2) {
        return Float.compare(f, f2);
    }

    @Stable
    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m2145divu2uoSUM(float f, int i) {
        return m2142constructorimpl(f / i);
    }

    @Stable
    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m2152timesu2uoSUM(float f, int i) {
        return m2142constructorimpl(f * i);
    }
}
