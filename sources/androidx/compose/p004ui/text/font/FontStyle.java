package androidx.compose.p004ui.text.font;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class FontStyle {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Normal = m4832constructorimpl(0);
    private static final int Italic = m4832constructorimpl(1);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getItalic-_-LCdwA, reason: not valid java name */
        public final int m4838getItalic_LCdwA() {
            return FontStyle.Italic;
        }

        /* renamed from: getNormal-_-LCdwA, reason: not valid java name */
        public final int m4839getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        @NotNull
        public final List<FontStyle> values() {
            return CollectionsKt.listOf(new FontStyle[]{FontStyle.m4831boximpl(m4839getNormal_LCdwA()), FontStyle.m4831boximpl(m4838getItalic_LCdwA())});
        }
    }

    private /* synthetic */ FontStyle(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontStyle m4831boximpl(int i) {
        return new FontStyle(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4832constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4833equalsimpl(int i, Object obj) {
        return (obj instanceof FontStyle) && i == ((FontStyle) obj).m4837unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4834equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4835hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4836toStringimpl(int i) {
        return m4834equalsimpl0(i, Normal) ? "Normal" : m4834equalsimpl0(i, Italic) ? "Italic" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m4833equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m4835hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4836toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4837unboximpl() {
        return this.value;
    }
}
