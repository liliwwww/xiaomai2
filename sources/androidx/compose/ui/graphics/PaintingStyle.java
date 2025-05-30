package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PaintingStyle {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Fill = m1176constructorimpl(0);
    private static final int Stroke = m1176constructorimpl(1);
    private final int value;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getFill-TiuSbCo, reason: not valid java name */
        public final int m1182getFillTiuSbCo() {
            return PaintingStyle.Fill;
        }

        /* renamed from: getStroke-TiuSbCo, reason: not valid java name */
        public final int m1183getStrokeTiuSbCo() {
            return PaintingStyle.Stroke;
        }
    }

    private /* synthetic */ PaintingStyle(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PaintingStyle m1175boximpl(int i) {
        return new PaintingStyle(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1176constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1177equalsimpl(int i, Object obj) {
        return (obj instanceof PaintingStyle) && i == ((PaintingStyle) obj).m1181unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1178equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1179hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1180toStringimpl(int i) {
        return m1178equalsimpl0(i, Fill) ? "Fill" : m1178equalsimpl0(i, Stroke) ? "Stroke" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1177equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1179hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1180toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1181unboximpl() {
        return this.value;
    }
}
