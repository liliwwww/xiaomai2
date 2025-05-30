package androidx.compose.ui.graphics.colorspace;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RenderIntent {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int Perceptual = m1248constructorimpl(0);
    private static final int Relative = m1248constructorimpl(1);
    private static final int Saturation = m1248constructorimpl(2);
    private static final int Absolute = m1248constructorimpl(3);

    private /* synthetic */ RenderIntent(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RenderIntent m1247boximpl(int i) {
        return new RenderIntent(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1248constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1249equalsimpl(int i, Object obj) {
        return (obj instanceof RenderIntent) && i == ((RenderIntent) obj).m1253unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1250equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1251hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1252toStringimpl(int i) {
        return m1250equalsimpl0(i, Perceptual) ? "Perceptual" : m1250equalsimpl0(i, Relative) ? "Relative" : m1250equalsimpl0(i, Saturation) ? "Saturation" : m1250equalsimpl0(i, Absolute) ? "Absolute" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1249equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1251hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1252toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1253unboximpl() {
        return this.value;
    }
}
