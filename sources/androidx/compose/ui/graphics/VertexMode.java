package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VertexMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Triangles = m1225constructorimpl(0);
    private static final int TriangleStrip = m1225constructorimpl(1);
    private static final int TriangleFan = m1225constructorimpl(2);

    private /* synthetic */ VertexMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ VertexMode m1224boximpl(int i) {
        return new VertexMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1225constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1226equalsimpl(int i, Object obj) {
        return (obj instanceof VertexMode) && i == ((VertexMode) obj).m1230unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1227equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1228hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1229toStringimpl(int i) {
        return m1227equalsimpl0(i, Triangles) ? "Triangles" : m1227equalsimpl0(i, TriangleStrip) ? "TriangleStrip" : m1227equalsimpl0(i, TriangleFan) ? "TriangleFan" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1226equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1228hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1229toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1230unboximpl() {
        return this.value;
    }
}
