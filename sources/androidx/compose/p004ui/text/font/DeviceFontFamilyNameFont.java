package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.p004ui.text.font.FontVariation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class DeviceFontFamilyNameFont extends AndroidFont {

    @NotNull
    private final String familyName;
    private final int style;

    @NotNull
    private final FontWeight weight;

    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.Companion.m4827getOptionalLocalPKNRLFQ(), NamedFontLoader.INSTANCE, settings, null);
        this.familyName = str;
        this.weight = fontWeight;
        this.style = i;
    }

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fontWeight, i, settings);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceFontFamilyNameFont)) {
            return false;
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) obj;
        return DeviceFontFamilyName.m4803equalsimpl0(this.familyName, deviceFontFamilyNameFont.familyName) && Intrinsics.areEqual(getWeight(), deviceFontFamilyNameFont.getWeight()) && FontStyle.m4834equalsimpl0(mo4790getStyle_LCdwA(), deviceFontFamilyNameFont.mo4790getStyle_LCdwA()) && Intrinsics.areEqual(getVariationSettings(), deviceFontFamilyNameFont.getVariationSettings());
    }

    @Override // androidx.compose.p004ui.text.font.Font
    /* renamed from: getStyle-_-LCdwA */
    public int mo4790getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.p004ui.text.font.Font
    @NotNull
    public FontWeight getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((DeviceFontFamilyName.m4804hashCodeimpl(this.familyName) * 31) + getWeight().hashCode()) * 31) + FontStyle.m4835hashCodeimpl(mo4790getStyle_LCdwA())) * 31) + getVariationSettings().hashCode();
    }

    @Nullable
    public final Typeface loadCached(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PlatformTypefacesKt.PlatformTypefaces().mo4859optionalOnDeviceFontFamilyByName78DK7lM(this.familyName, getWeight(), mo4790getStyle_LCdwA(), getVariationSettings(), context);
    }

    @NotNull
    public String toString() {
        return "Font(familyName=\"" + ((Object) DeviceFontFamilyName.m4805toStringimpl(this.familyName)) + "\", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m4836toStringimpl(mo4790getStyle_LCdwA())) + ')';
    }
}
