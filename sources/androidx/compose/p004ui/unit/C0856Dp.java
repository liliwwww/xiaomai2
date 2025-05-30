package androidx.compose.p004ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* renamed from: androidx.compose.ui.unit.Dp */
/* loaded from: classes.dex */
public final class C0856Dp implements Comparable<C0856Dp> {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float Hairline = m5216constructorimpl(0.0f);
    private static final float Infinity = m5216constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m5216constructorimpl(Float.NaN);
    private final float value;

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.ui.unit.Dp$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m5231getHairlineD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m5232getInfinityD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m5233getUnspecifiedD9Ej5fM$annotations() {
        }

        /* renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m5234getHairlineD9Ej5fM() {
            return C0856Dp.Hairline;
        }

        /* renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m5235getInfinityD9Ej5fM() {
            return C0856Dp.Infinity;
        }

        /* renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m5236getUnspecifiedD9Ej5fM() {
            return C0856Dp.Unspecified;
        }
    }

    private /* synthetic */ C0856Dp(float f) {
        this.value = f;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C0856Dp m5214boximpl(float f) {
        return new C0856Dp(f);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m5216constructorimpl(float f) {
        return f;
    }

    @Stable
    /* renamed from: div-0680j_4, reason: not valid java name */
    public static final float m5217div0680j_4(float f, float f2) {
        return f / f2;
    }

    @Stable
    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m5218divu2uoSUM(float f, float f2) {
        return m5216constructorimpl(f / f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5220equalsimpl(float f, Object obj) {
        return (obj instanceof C0856Dp) && Float.compare(f, ((C0856Dp) obj).m5230unboximpl()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5221equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5222hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    @Stable
    /* renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m5223minus5rwHm24(float f, float f2) {
        return m5216constructorimpl(f - f2);
    }

    @Stable
    /* renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m5224plus5rwHm24(float f, float f2) {
        return m5216constructorimpl(f + f2);
    }

    @Stable
    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m5225timesu2uoSUM(float f, float f2) {
        return m5216constructorimpl(f * f2);
    }

    @Stable
    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5227toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }

    @Stable
    /* renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m5228unaryMinusD9Ej5fM(float f) {
        return m5216constructorimpl(-f);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C0856Dp c0856Dp) {
        return m5229compareTo0680j_4(c0856Dp.m5230unboximpl());
    }

    @Stable
    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m5229compareTo0680j_4(float f) {
        return m5215compareTo0680j_4(this.value, f);
    }

    public boolean equals(Object obj) {
        return m5220equalsimpl(this.value, obj);
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return m5222hashCodeimpl(this.value);
    }

    @Stable
    @NotNull
    public String toString() {
        return m5227toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m5230unboximpl() {
        return this.value;
    }

    @Stable
    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m5215compareTo0680j_4(float f, float f2) {
        return Float.compare(f, f2);
    }

    @Stable
    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m5219divu2uoSUM(float f, int i) {
        return m5216constructorimpl(f / i);
    }

    @Stable
    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m5226timesu2uoSUM(float f, int i) {
        return m5216constructorimpl(f * i);
    }
}
