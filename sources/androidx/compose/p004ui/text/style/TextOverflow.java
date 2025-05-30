package androidx.compose.p004ui.text.style;

import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class TextOverflow {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clip = m5119constructorimpl(1);
    private static final int Ellipsis = m5119constructorimpl(2);
    private static final int Visible = m5119constructorimpl(3);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getClip-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m5125getClipgIe3tQ8$annotations() {
        }

        @Stable
        /* renamed from: getEllipsis-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m5126getEllipsisgIe3tQ8$annotations() {
        }

        @Stable
        /* renamed from: getVisible-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m5127getVisiblegIe3tQ8$annotations() {
        }

        /* renamed from: getClip-gIe3tQ8, reason: not valid java name */
        public final int m5128getClipgIe3tQ8() {
            return TextOverflow.Clip;
        }

        /* renamed from: getEllipsis-gIe3tQ8, reason: not valid java name */
        public final int m5129getEllipsisgIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        /* renamed from: getVisible-gIe3tQ8, reason: not valid java name */
        public final int m5130getVisiblegIe3tQ8() {
            return TextOverflow.Visible;
        }
    }

    private /* synthetic */ TextOverflow(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextOverflow m5118boximpl(int i) {
        return new TextOverflow(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m5119constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5120equalsimpl(int i, Object obj) {
        return (obj instanceof TextOverflow) && i == ((TextOverflow) obj).m5124unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5121equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5122hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5123toStringimpl(int i) {
        return m5121equalsimpl0(i, Clip) ? "Clip" : m5121equalsimpl0(i, Ellipsis) ? "Ellipsis" : m5121equalsimpl0(i, Visible) ? "Visible" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m5120equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5122hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5123toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5124unboximpl() {
        return this.value;
    }
}
