package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DeviceFontFamilyNameFont extends AndroidFont {

    @NotNull
    private final String familyName;
    private final int style;

    @NotNull
    private final FontWeight weight;

    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings) {
        super(FontLoadingStrategy.Companion.getOptionalLocal-PKNRLFQ(), NamedFontLoader.INSTANCE, fontVariation$Settings);
        this.familyName = str;
        this.weight = fontWeight;
        this.style = i;
    }

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation$Settings fontVariation$Settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fontWeight, i, fontVariation$Settings);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceFontFamilyNameFont)) {
            return false;
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) obj;
        return DeviceFontFamilyName.m1911equalsimpl0(this.familyName, deviceFontFamilyNameFont.familyName) && Intrinsics.areEqual(getWeight(), deviceFontFamilyNameFont.getWeight()) && FontStyle.m1927equalsimpl0(mo1915getStyle_LCdwA(), deviceFontFamilyNameFont.mo1915getStyle_LCdwA()) && Intrinsics.areEqual(getVariationSettings(), deviceFontFamilyNameFont.getVariationSettings());
    }

    @Override // androidx.compose.ui.text.font.Font
    /* renamed from: getStyle-_-LCdwA, reason: not valid java name */
    public int mo1915getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    @NotNull
    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((DeviceFontFamilyName.m1912hashCodeimpl(this.familyName) * 31) + getWeight().hashCode()) * 31) + FontStyle.m1928hashCodeimpl(mo1915getStyle_LCdwA())) * 31) + getVariationSettings().hashCode();
    }

    @Nullable
    public final Typeface loadCached(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PlatformTypefacesKt.PlatformTypefaces().m1935optionalOnDeviceFontFamilyByName78DK7lM(this.familyName, getWeight(), mo1915getStyle_LCdwA(), getVariationSettings(), context);
    }

    @NotNull
    public String toString() {
        return "Font(familyName=\"" + ((Object) DeviceFontFamilyName.m1913toStringimpl(this.familyName)) + "\", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m1929toStringimpl(mo1915getStyle_LCdwA())) + ')';
    }
}
