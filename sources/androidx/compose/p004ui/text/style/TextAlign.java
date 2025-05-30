package androidx.compose.p004ui.text.style;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class TextAlign {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Left = m5073constructorimpl(1);
    private static final int Right = m5073constructorimpl(2);
    private static final int Center = m5073constructorimpl(3);
    private static final int Justify = m5073constructorimpl(4);
    private static final int Start = m5073constructorimpl(5);
    private static final int End = m5073constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m5079getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m5080getEnde0LSkKk() {
            return TextAlign.End;
        }

        /* renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m5081getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m5082getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m5083getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m5084getStarte0LSkKk() {
            return TextAlign.Start;
        }

        @NotNull
        public final List<TextAlign> values() {
            return CollectionsKt.listOf(new TextAlign[]{TextAlign.m5072boximpl(m5082getLefte0LSkKk()), TextAlign.m5072boximpl(m5083getRighte0LSkKk()), TextAlign.m5072boximpl(m5079getCentere0LSkKk()), TextAlign.m5072boximpl(m5081getJustifye0LSkKk()), TextAlign.m5072boximpl(m5084getStarte0LSkKk()), TextAlign.m5072boximpl(m5080getEnde0LSkKk())});
        }
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m5072boximpl(int i) {
        return new TextAlign(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m5073constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5074equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).m5078unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5075equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5076hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5077toStringimpl(int i) {
        return m5075equalsimpl0(i, Left) ? "Left" : m5075equalsimpl0(i, Right) ? "Right" : m5075equalsimpl0(i, Center) ? "Center" : m5075equalsimpl0(i, Justify) ? "Justify" : m5075equalsimpl0(i, Start) ? "Start" : m5075equalsimpl0(i, End) ? "End" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m5074equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5076hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5077toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m5078unboximpl() {
        return this.value;
    }
}
