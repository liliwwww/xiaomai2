package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BaselineShift {
    private final float multiplier;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float Superscript = m2001constructorimpl(0.5f);
    private static final float Subscript = m2001constructorimpl(-0.5f);
    private static final float None = m2001constructorimpl(0.0f);

    private /* synthetic */ BaselineShift(float f) {
        this.multiplier = f;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BaselineShift m2000boximpl(float f) {
        return new BaselineShift(f);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m2001constructorimpl(float f) {
        return f;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2002equalsimpl(float f, Object obj) {
        return (obj instanceof BaselineShift) && Float.compare(f, ((BaselineShift) obj).m2006unboximpl()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2003equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2004hashCodeimpl(float f) {
        return Float.floatToIntBits(f);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2005toStringimpl(float f) {
        return "BaselineShift(multiplier=" + f + ')';
    }

    public boolean equals(Object obj) {
        return m2002equalsimpl(this.multiplier, obj);
    }

    public final float getMultiplier() {
        return this.multiplier;
    }

    public int hashCode() {
        return m2004hashCodeimpl(this.multiplier);
    }

    public String toString() {
        return m2005toStringimpl(this.multiplier);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m2006unboximpl() {
        return this.multiplier;
    }
}
