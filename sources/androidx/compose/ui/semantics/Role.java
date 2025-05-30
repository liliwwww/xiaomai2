package androidx.compose.ui.semantics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Role {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Button = m1807constructorimpl(0);
    private static final int Checkbox = m1807constructorimpl(1);
    private static final int Switch = m1807constructorimpl(2);
    private static final int RadioButton = m1807constructorimpl(3);
    private static final int Tab = m1807constructorimpl(4);
    private static final int Image = m1807constructorimpl(5);
    private static final int DropdownList = m1807constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getButton-o7Vup1c, reason: not valid java name */
        public final int m1813getButtono7Vup1c() {
            return Role.Button;
        }

        /* renamed from: getCheckbox-o7Vup1c, reason: not valid java name */
        public final int m1814getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* renamed from: getDropdownList-o7Vup1c, reason: not valid java name */
        public final int m1815getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }

        /* renamed from: getImage-o7Vup1c, reason: not valid java name */
        public final int m1816getImageo7Vup1c() {
            return Role.Image;
        }

        /* renamed from: getRadioButton-o7Vup1c, reason: not valid java name */
        public final int m1817getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* renamed from: getSwitch-o7Vup1c, reason: not valid java name */
        public final int m1818getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* renamed from: getTab-o7Vup1c, reason: not valid java name */
        public final int m1819getTabo7Vup1c() {
            return Role.Tab;
        }
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Role m1806boximpl(int i) {
        return new Role(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m1807constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1808equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).m1812unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1809equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1810hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1811toStringimpl(int i) {
        return m1809equalsimpl0(i, Button) ? "Button" : m1809equalsimpl0(i, Checkbox) ? "Checkbox" : m1809equalsimpl0(i, Switch) ? "Switch" : m1809equalsimpl0(i, RadioButton) ? "RadioButton" : m1809equalsimpl0(i, Tab) ? "Tab" : m1809equalsimpl0(i, Image) ? "Image" : m1809equalsimpl0(i, DropdownList) ? "DropdownList" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1808equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1810hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1811toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1812unboximpl() {
        return this.value;
    }
}
