package androidx.compose.ui.text.style;

import androidx.compose.runtime.Stable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextOverflow {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clip = m2529constructorimpl(1);
    private static final int Ellipsis = m2529constructorimpl(2);
    private static final int Visible = m2529constructorimpl(3);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        /* renamed from: getClip-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m2535getClipgIe3tQ8$annotations() {
        }

        @Stable
        /* renamed from: getEllipsis-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m2536getEllipsisgIe3tQ8$annotations() {
        }

        @Stable
        /* renamed from: getVisible-gIe3tQ8$annotations, reason: not valid java name */
        public static /* synthetic */ void m2537getVisiblegIe3tQ8$annotations() {
        }

        /* renamed from: getClip-gIe3tQ8, reason: not valid java name */
        public final int m2538getClipgIe3tQ8() {
            return TextOverflow.Clip;
        }

        /* renamed from: getEllipsis-gIe3tQ8, reason: not valid java name */
        public final int m2539getEllipsisgIe3tQ8() {
            return TextOverflow.Ellipsis;
        }

        /* renamed from: getVisible-gIe3tQ8, reason: not valid java name */
        public final int m2540getVisiblegIe3tQ8() {
            return TextOverflow.Visible;
        }
    }

    private /* synthetic */ TextOverflow(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextOverflow m2528boximpl(int i) {
        return new TextOverflow(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2529constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2530equalsimpl(int i, Object obj) {
        return (obj instanceof TextOverflow) && i == ((TextOverflow) obj).m2534unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2531equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2532hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2533toStringimpl(int i) {
        return m2531equalsimpl0(i, Clip) ? "Clip" : m2531equalsimpl0(i, Ellipsis) ? "Ellipsis" : m2531equalsimpl0(i, Visible) ? "Visible" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2530equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2532hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2533toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2534unboximpl() {
        return this.value;
    }
}
