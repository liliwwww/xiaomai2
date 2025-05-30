package androidx.compose.p004ui.graphics.colorspace;

import androidx.compose.runtime.Immutable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class RenderIntent {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Perceptual = m3165constructorimpl(0);
    private static final int Relative = m3165constructorimpl(1);
    private static final int Saturation = m3165constructorimpl(2);
    private static final int Absolute = m3165constructorimpl(3);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAbsolute-uksYyKA, reason: not valid java name */
        public final int m3171getAbsoluteuksYyKA() {
            return RenderIntent.Absolute;
        }

        /* renamed from: getPerceptual-uksYyKA, reason: not valid java name */
        public final int m3172getPerceptualuksYyKA() {
            return RenderIntent.Perceptual;
        }

        /* renamed from: getRelative-uksYyKA, reason: not valid java name */
        public final int m3173getRelativeuksYyKA() {
            return RenderIntent.Relative;
        }

        /* renamed from: getSaturation-uksYyKA, reason: not valid java name */
        public final int m3174getSaturationuksYyKA() {
            return RenderIntent.Saturation;
        }
    }

    private /* synthetic */ RenderIntent(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RenderIntent m3164boximpl(int i) {
        return new RenderIntent(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3165constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3166equalsimpl(int i, Object obj) {
        return (obj instanceof RenderIntent) && i == ((RenderIntent) obj).m3170unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3167equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3168hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3169toStringimpl(int i) {
        return m3167equalsimpl0(i, Perceptual) ? "Perceptual" : m3167equalsimpl0(i, Relative) ? "Relative" : m3167equalsimpl0(i, Saturation) ? ExifInterface.TAG_SATURATION : m3167equalsimpl0(i, Absolute) ? "Absolute" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3166equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3168hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3169toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3170unboximpl() {
        return this.value;
    }
}
