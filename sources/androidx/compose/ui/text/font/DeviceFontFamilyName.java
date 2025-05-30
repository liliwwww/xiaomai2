package androidx.compose.ui.text.font;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DeviceFontFamilyName {

    @NotNull
    private final String name;

    private /* synthetic */ DeviceFontFamilyName(String str) {
        this.name = str;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DeviceFontFamilyName m1908boximpl(String str) {
        return new DeviceFontFamilyName(str);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static String m1909constructorimpl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (str.length() > 0) {
            return str;
        }
        throw new IllegalArgumentException("name may not be empty".toString());
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1910equalsimpl(String str, Object obj) {
        return (obj instanceof DeviceFontFamilyName) && Intrinsics.areEqual(str, ((DeviceFontFamilyName) obj).m1914unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1911equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1912hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1913toStringimpl(String str) {
        return "DeviceFontFamilyName(name=" + str + ')';
    }

    public boolean equals(Object obj) {
        return m1910equalsimpl(this.name, obj);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return m1912hashCodeimpl(this.name);
    }

    public String toString() {
        return m1913toStringimpl(this.name);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m1914unboximpl() {
        return this.name;
    }
}
