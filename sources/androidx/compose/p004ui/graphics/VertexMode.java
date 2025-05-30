package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class VertexMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Triangles = m3132constructorimpl(0);
    private static final int TriangleStrip = m3132constructorimpl(1);
    private static final int TriangleFan = m3132constructorimpl(2);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getTriangleFan-c2xauaI, reason: not valid java name */
        public final int m3138getTriangleFanc2xauaI() {
            return VertexMode.TriangleFan;
        }

        /* renamed from: getTriangleStrip-c2xauaI, reason: not valid java name */
        public final int m3139getTriangleStripc2xauaI() {
            return VertexMode.TriangleStrip;
        }

        /* renamed from: getTriangles-c2xauaI, reason: not valid java name */
        public final int m3140getTrianglesc2xauaI() {
            return VertexMode.Triangles;
        }
    }

    private /* synthetic */ VertexMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ VertexMode m3131boximpl(int i) {
        return new VertexMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3132constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3133equalsimpl(int i, Object obj) {
        return (obj instanceof VertexMode) && i == ((VertexMode) obj).m3137unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3134equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3135hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3136toStringimpl(int i) {
        return m3134equalsimpl0(i, Triangles) ? "Triangles" : m3134equalsimpl0(i, TriangleStrip) ? "TriangleStrip" : m3134equalsimpl0(i, TriangleFan) ? "TriangleFan" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3133equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3135hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3136toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3137unboximpl() {
        return this.value;
    }
}
