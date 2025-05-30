package androidx.compose.ui.text.style;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextAlign {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Left = m2500constructorimpl(1);
    private static final int Right = m2500constructorimpl(2);
    private static final int Center = m2500constructorimpl(3);
    private static final int Justify = m2500constructorimpl(4);
    private static final int Start = m2500constructorimpl(5);
    private static final int End = m2500constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m2506getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m2507getEnde0LSkKk() {
            return TextAlign.End;
        }

        /* renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m2508getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m2509getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m2510getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m2511getStarte0LSkKk() {
            return TextAlign.Start;
        }

        @NotNull
        public final List<TextAlign> values() {
            return CollectionsKt.listOf(new TextAlign[]{TextAlign.m2499boximpl(m2509getLefte0LSkKk()), TextAlign.m2499boximpl(m2510getRighte0LSkKk()), TextAlign.m2499boximpl(m2506getCentere0LSkKk()), TextAlign.m2499boximpl(m2508getJustifye0LSkKk()), TextAlign.m2499boximpl(m2511getStarte0LSkKk()), TextAlign.m2499boximpl(m2507getEnde0LSkKk())});
        }
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m2499boximpl(int i) {
        return new TextAlign(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2500constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2501equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).m2505unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2502equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2503hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2504toStringimpl(int i) {
        return m2502equalsimpl0(i, Left) ? "Left" : m2502equalsimpl0(i, Right) ? "Right" : m2502equalsimpl0(i, Center) ? "Center" : m2502equalsimpl0(i, Justify) ? "Justify" : m2502equalsimpl0(i, Start) ? "Start" : m2502equalsimpl0(i, End) ? "End" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2501equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2503hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2504toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2505unboximpl() {
        return this.value;
    }
}
