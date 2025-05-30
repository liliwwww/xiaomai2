package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class Strings {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NavigationMenu = m2227constructorimpl(0);
    private static final int CloseDrawer = m2227constructorimpl(1);
    private static final int CloseSheet = m2227constructorimpl(2);
    private static final int DefaultErrorMessage = m2227constructorimpl(3);
    private static final int ExposedDropdownMenu = m2227constructorimpl(4);
    private static final int SliderRangeStart = m2227constructorimpl(5);
    private static final int SliderRangeEnd = m2227constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCloseDrawer-UdPEhr4, reason: not valid java name */
        public final int m2233getCloseDrawerUdPEhr4() {
            return Strings.CloseDrawer;
        }

        /* renamed from: getCloseSheet-UdPEhr4, reason: not valid java name */
        public final int m2234getCloseSheetUdPEhr4() {
            return Strings.CloseSheet;
        }

        /* renamed from: getDefaultErrorMessage-UdPEhr4, reason: not valid java name */
        public final int m2235getDefaultErrorMessageUdPEhr4() {
            return Strings.DefaultErrorMessage;
        }

        /* renamed from: getExposedDropdownMenu-UdPEhr4, reason: not valid java name */
        public final int m2236getExposedDropdownMenuUdPEhr4() {
            return Strings.ExposedDropdownMenu;
        }

        /* renamed from: getNavigationMenu-UdPEhr4, reason: not valid java name */
        public final int m2237getNavigationMenuUdPEhr4() {
            return Strings.NavigationMenu;
        }

        /* renamed from: getSliderRangeEnd-UdPEhr4, reason: not valid java name */
        public final int m2238getSliderRangeEndUdPEhr4() {
            return Strings.SliderRangeEnd;
        }

        /* renamed from: getSliderRangeStart-UdPEhr4, reason: not valid java name */
        public final int m2239getSliderRangeStartUdPEhr4() {
            return Strings.SliderRangeStart;
        }
    }

    private /* synthetic */ Strings(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Strings m2226boximpl(int i) {
        return new Strings(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2227constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2228equalsimpl(int i, Object obj) {
        return (obj instanceof Strings) && i == ((Strings) obj).m2232unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2229equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2230hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2231toStringimpl(int i) {
        return "Strings(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m2228equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2230hashCodeimpl(this.value);
    }

    public String toString() {
        return m2231toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2232unboximpl() {
        return this.value;
    }
}
