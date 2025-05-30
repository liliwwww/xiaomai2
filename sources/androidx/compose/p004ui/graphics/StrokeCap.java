package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class StrokeCap {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Butt = m3086constructorimpl(0);
    private static final int Round = m3086constructorimpl(1);
    private static final int Square = m3086constructorimpl(2);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getButt-KaPHkGw, reason: not valid java name */
        public final int m3092getButtKaPHkGw() {
            return StrokeCap.Butt;
        }

        /* renamed from: getRound-KaPHkGw, reason: not valid java name */
        public final int m3093getRoundKaPHkGw() {
            return StrokeCap.Round;
        }

        /* renamed from: getSquare-KaPHkGw, reason: not valid java name */
        public final int m3094getSquareKaPHkGw() {
            return StrokeCap.Square;
        }
    }

    private /* synthetic */ StrokeCap(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StrokeCap m3085boximpl(int i) {
        return new StrokeCap(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3086constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3087equalsimpl(int i, Object obj) {
        return (obj instanceof StrokeCap) && i == ((StrokeCap) obj).m3091unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3088equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3089hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3090toStringimpl(int i) {
        return m3088equalsimpl0(i, Butt) ? "Butt" : m3088equalsimpl0(i, Round) ? "Round" : m3088equalsimpl0(i, Square) ? "Square" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3087equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3089hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3090toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3091unboximpl() {
        return this.value;
    }
}
