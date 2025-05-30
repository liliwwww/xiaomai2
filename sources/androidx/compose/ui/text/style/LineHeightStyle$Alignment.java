package androidx.compose.ui.text.style;

import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LineHeightStyle$Alignment {
    private final float topRatio;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final float Top = m2040constructorimpl(0.0f);
    private static final float Center = m2040constructorimpl(0.5f);
    private static final float Proportional = m2040constructorimpl(-1.0f);
    private static final float Bottom = m2040constructorimpl(1.0f);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBottom-PIaL0Z0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2046getBottomPIaL0Z0$annotations() {
        }

        /* renamed from: getCenter-PIaL0Z0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2047getCenterPIaL0Z0$annotations() {
        }

        /* renamed from: getProportional-PIaL0Z0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2048getProportionalPIaL0Z0$annotations() {
        }

        /* renamed from: getTop-PIaL0Z0$annotations, reason: not valid java name */
        public static /* synthetic */ void m2049getTopPIaL0Z0$annotations() {
        }

        /* renamed from: getBottom-PIaL0Z0, reason: not valid java name */
        public final float m2050getBottomPIaL0Z0() {
            return LineHeightStyle$Alignment.Bottom;
        }

        /* renamed from: getCenter-PIaL0Z0, reason: not valid java name */
        public final float m2051getCenterPIaL0Z0() {
            return LineHeightStyle$Alignment.Center;
        }

        /* renamed from: getProportional-PIaL0Z0, reason: not valid java name */
        public final float m2052getProportionalPIaL0Z0() {
            return LineHeightStyle$Alignment.Proportional;
        }

        /* renamed from: getTop-PIaL0Z0, reason: not valid java name */
        public final float m2053getTopPIaL0Z0() {
            return LineHeightStyle$Alignment.Top;
        }
    }

    @ExperimentalTextApi
    private /* synthetic */ LineHeightStyle$Alignment(float f) {
        this.topRatio = f;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineHeightStyle$Alignment m2039boximpl(float f) {
        return new LineHeightStyle$Alignment(f);
    }

    @ExperimentalTextApi
    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m2040constructorimpl(float f) {
        boolean z = true;
        if (!(0.0f <= f && f <= 1.0f)) {
            if (!(f == -1.0f)) {
                z = false;
            }
        }
        if (z) {
            return f;
        }
        throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2041equalsimpl(float f, Object obj) {
        return (obj instanceof LineHeightStyle$Alignment) && Float.compare(f, ((LineHeightStyle$Alignment) obj).m2045unboximpl()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2042equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2043hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2044toStringimpl(float f) {
        if (f == Top) {
            return "LineHeightStyle.Alignment.Top";
        }
        if (f == Center) {
            return "LineHeightStyle.Alignment.Center";
        }
        if (f == Proportional) {
            return "LineHeightStyle.Alignment.Proportional";
        }
        if (f == Bottom) {
            return "LineHeightStyle.Alignment.Bottom";
        }
        return "LineHeightStyle.Alignment(topPercentage = " + f + ')';
    }

    public boolean equals(Object obj) {
        return m2041equalsimpl(this.topRatio, obj);
    }

    public int hashCode() {
        return m2043hashCodeimpl(this.topRatio);
    }

    @NotNull
    public String toString() {
        return m2044toStringimpl(this.topRatio);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m2045unboximpl() {
        return this.topRatio;
    }
}
