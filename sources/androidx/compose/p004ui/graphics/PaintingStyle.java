package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class PaintingStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Fill = m3012constructorimpl(0);
    private static final int Stroke = m3012constructorimpl(1);
    private final int value;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getFill-TiuSbCo, reason: not valid java name */
        public final int m3018getFillTiuSbCo() {
            return PaintingStyle.Fill;
        }

        /* renamed from: getStroke-TiuSbCo, reason: not valid java name */
        public final int m3019getStrokeTiuSbCo() {
            return PaintingStyle.Stroke;
        }
    }

    private /* synthetic */ PaintingStyle(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PaintingStyle m3011boximpl(int i) {
        return new PaintingStyle(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3012constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3013equalsimpl(int i, Object obj) {
        return (obj instanceof PaintingStyle) && i == ((PaintingStyle) obj).m3017unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3014equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3015hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3016toStringimpl(int i) {
        return m3014equalsimpl0(i, Fill) ? "Fill" : m3014equalsimpl0(i, Stroke) ? "Stroke" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3013equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3015hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3016toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3017unboximpl() {
        return this.value;
    }
}
