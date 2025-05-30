package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class StrokeJoin {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Miter = m1252constructorimpl(0);
    private static final int Round = m1252constructorimpl(1);
    private static final int Bevel = m1252constructorimpl(2);

    private /* synthetic */ StrokeJoin(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StrokeJoin m1251boximpl(int i) {
        return new StrokeJoin(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1252constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1253equalsimpl(int i, Object obj) {
        return (obj instanceof StrokeJoin) && i == ((StrokeJoin) obj).m1257unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1254equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1255hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1256toStringimpl(int i) {
        return m1254equalsimpl0(i, Miter) ? "Miter" : m1254equalsimpl0(i, Round) ? "Round" : m1254equalsimpl0(i, Bevel) ? "Bevel" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1253equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1255hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1256toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1257unboximpl() {
        return this.value;
    }
}
