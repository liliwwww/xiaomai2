package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Strings {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NavigationMenu = m812constructorimpl(0);
    private static final int CloseDrawer = m812constructorimpl(1);
    private static final int CloseSheet = m812constructorimpl(2);
    private static final int DefaultErrorMessage = m812constructorimpl(3);
    private static final int ExposedDropdownMenu = m812constructorimpl(4);
    private static final int SliderRangeStart = m812constructorimpl(5);
    private static final int SliderRangeEnd = m812constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCloseDrawer-UdPEhr4, reason: not valid java name */
        public final int m818getCloseDrawerUdPEhr4() {
            return Strings.CloseDrawer;
        }

        /* renamed from: getCloseSheet-UdPEhr4, reason: not valid java name */
        public final int m819getCloseSheetUdPEhr4() {
            return Strings.CloseSheet;
        }

        /* renamed from: getDefaultErrorMessage-UdPEhr4, reason: not valid java name */
        public final int m820getDefaultErrorMessageUdPEhr4() {
            return Strings.DefaultErrorMessage;
        }

        /* renamed from: getExposedDropdownMenu-UdPEhr4, reason: not valid java name */
        public final int m821getExposedDropdownMenuUdPEhr4() {
            return Strings.ExposedDropdownMenu;
        }

        /* renamed from: getNavigationMenu-UdPEhr4, reason: not valid java name */
        public final int m822getNavigationMenuUdPEhr4() {
            return Strings.NavigationMenu;
        }

        /* renamed from: getSliderRangeEnd-UdPEhr4, reason: not valid java name */
        public final int m823getSliderRangeEndUdPEhr4() {
            return Strings.SliderRangeEnd;
        }

        /* renamed from: getSliderRangeStart-UdPEhr4, reason: not valid java name */
        public final int m824getSliderRangeStartUdPEhr4() {
            return Strings.SliderRangeStart;
        }
    }

    private /* synthetic */ Strings(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Strings m811boximpl(int i) {
        return new Strings(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m812constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m813equalsimpl(int i, Object obj) {
        return (obj instanceof Strings) && i == ((Strings) obj).m817unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m814equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m815hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m816toStringimpl(int i) {
        return "Strings(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m813equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m815hashCodeimpl(this.value);
    }

    public String toString() {
        return m816toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m817unboximpl() {
        return this.value;
    }
}
