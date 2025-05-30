package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class FilterQuality {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int None = m2875constructorimpl(0);
    private static final int Low = m2875constructorimpl(1);
    private static final int Medium = m2875constructorimpl(2);
    private static final int High = m2875constructorimpl(3);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHigh-f-v9h1I, reason: not valid java name */
        public final int m2881getHighfv9h1I() {
            return FilterQuality.High;
        }

        /* renamed from: getLow-f-v9h1I, reason: not valid java name */
        public final int m2882getLowfv9h1I() {
            return FilterQuality.Low;
        }

        /* renamed from: getMedium-f-v9h1I, reason: not valid java name */
        public final int m2883getMediumfv9h1I() {
            return FilterQuality.Medium;
        }

        /* renamed from: getNone-f-v9h1I, reason: not valid java name */
        public final int m2884getNonefv9h1I() {
            return FilterQuality.None;
        }
    }

    private /* synthetic */ FilterQuality(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FilterQuality m2874boximpl(int i) {
        return new FilterQuality(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2875constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2876equalsimpl(int i, Object obj) {
        return (obj instanceof FilterQuality) && i == ((FilterQuality) obj).m2880unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2877equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2878hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2879toStringimpl(int i) {
        return m2877equalsimpl0(i, None) ? "None" : m2877equalsimpl0(i, Low) ? "Low" : m2877equalsimpl0(i, Medium) ? "Medium" : m2877equalsimpl0(i, High) ? "High" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m2876equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m2878hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2879toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2880unboximpl() {
        return this.value;
    }
}
