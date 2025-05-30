package androidx.compose.p004ui.semantics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class Role {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Button = m4585constructorimpl(0);
    private static final int Checkbox = m4585constructorimpl(1);
    private static final int Switch = m4585constructorimpl(2);
    private static final int RadioButton = m4585constructorimpl(3);
    private static final int Tab = m4585constructorimpl(4);
    private static final int Image = m4585constructorimpl(5);
    private static final int DropdownList = m4585constructorimpl(6);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getButton-o7Vup1c, reason: not valid java name */
        public final int m4591getButtono7Vup1c() {
            return Role.Button;
        }

        /* renamed from: getCheckbox-o7Vup1c, reason: not valid java name */
        public final int m4592getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* renamed from: getDropdownList-o7Vup1c, reason: not valid java name */
        public final int m4593getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }

        /* renamed from: getImage-o7Vup1c, reason: not valid java name */
        public final int m4594getImageo7Vup1c() {
            return Role.Image;
        }

        /* renamed from: getRadioButton-o7Vup1c, reason: not valid java name */
        public final int m4595getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* renamed from: getSwitch-o7Vup1c, reason: not valid java name */
        public final int m4596getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* renamed from: getTab-o7Vup1c, reason: not valid java name */
        public final int m4597getTabo7Vup1c() {
            return Role.Tab;
        }
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Role m4584boximpl(int i) {
        return new Role(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m4585constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4586equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).m4590unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4587equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4588hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4589toStringimpl(int i) {
        return m4587equalsimpl0(i, Button) ? "Button" : m4587equalsimpl0(i, Checkbox) ? "Checkbox" : m4587equalsimpl0(i, Switch) ? "Switch" : m4587equalsimpl0(i, RadioButton) ? "RadioButton" : m4587equalsimpl0(i, Tab) ? "Tab" : m4587equalsimpl0(i, Image) ? "Image" : m4587equalsimpl0(i, DropdownList) ? "DropdownList" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m4586equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4588hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4589toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4590unboximpl() {
        return this.value;
    }
}
