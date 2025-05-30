package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ImageBitmapConfig {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Argb8888 = m1140constructorimpl(0);
    private static final int Alpha8 = m1140constructorimpl(1);
    private static final int Rgb565 = m1140constructorimpl(2);
    private static final int F16 = m1140constructorimpl(3);
    private static final int Gpu = m1140constructorimpl(4);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAlpha8-_sVssgQ, reason: not valid java name */
        public final int m1146getAlpha8_sVssgQ() {
            return ImageBitmapConfig.Alpha8;
        }

        /* renamed from: getArgb8888-_sVssgQ, reason: not valid java name */
        public final int m1147getArgb8888_sVssgQ() {
            return ImageBitmapConfig.Argb8888;
        }

        /* renamed from: getF16-_sVssgQ, reason: not valid java name */
        public final int m1148getF16_sVssgQ() {
            return ImageBitmapConfig.F16;
        }

        /* renamed from: getGpu-_sVssgQ, reason: not valid java name */
        public final int m1149getGpu_sVssgQ() {
            return ImageBitmapConfig.Gpu;
        }

        /* renamed from: getRgb565-_sVssgQ, reason: not valid java name */
        public final int m1150getRgb565_sVssgQ() {
            return ImageBitmapConfig.Rgb565;
        }
    }

    private /* synthetic */ ImageBitmapConfig(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImageBitmapConfig m1139boximpl(int i) {
        return new ImageBitmapConfig(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1140constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1141equalsimpl(int i, Object obj) {
        return (obj instanceof ImageBitmapConfig) && i == ((ImageBitmapConfig) obj).m1145unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1142equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1143hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1144toStringimpl(int i) {
        return m1142equalsimpl0(i, Argb8888) ? "Argb8888" : m1142equalsimpl0(i, Alpha8) ? "Alpha8" : m1142equalsimpl0(i, Rgb565) ? "Rgb565" : m1142equalsimpl0(i, F16) ? "F16" : m1142equalsimpl0(i, Gpu) ? "Gpu" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1141equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1143hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1144toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1145unboximpl() {
        return this.value;
    }
}
