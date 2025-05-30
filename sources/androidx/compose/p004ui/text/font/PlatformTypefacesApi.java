package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontVariation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@VisibleForTesting
/* loaded from: classes2.dex */
final class PlatformTypefacesApi implements PlatformTypefaces {
    /* renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    private final Typeface m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i) {
        if (FontStyle.m4834equalsimpl0(i, FontStyle.Companion.m4839getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal())) {
            if (str == null || str.length() == 0) {
                Typeface typeface = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
                return typeface;
            }
        }
        int m4789getAndroidTypefaceStyleFO1MlWM = AndroidFontUtils_androidKt.m4789getAndroidTypefaceStyleFO1MlWM(fontWeight, i);
        if (str == null || str.length() == 0) {
            Typeface defaultFromStyle = Typeface.defaultFromStyle(m4789getAndroidTypefaceStyleFO1MlWM);
            Intrinsics.checkNotNullExpressionValue(defaultFromStyle, "{\n            Typeface.d…le(targetStyle)\n        }");
            return defaultFromStyle;
        }
        Typeface create = Typeface.create(str, m4789getAndroidTypefaceStyleFO1MlWM);
        Intrinsics.checkNotNullExpressionValue(create, "{\n            Typeface.c…y, targetStyle)\n        }");
        return create;
    }

    /* renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ Typeface m4861createAndroidTypefaceUsingTypefaceStyleRetOiIg$default(PlatformTypefacesApi platformTypefacesApi, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m4839getNormal_LCdwA();
        }
        return platformTypefacesApi.m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final Typeface m4862loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        Typeface m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg = m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
        if ((Intrinsics.areEqual(m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg, Typeface.create(Typeface.DEFAULT, AndroidFontUtils_androidKt.m4789getAndroidTypefaceStyleFO1MlWM(fontWeight, i))) || Intrinsics.areEqual(m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg, m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i))) ? false : true) {
            return m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg;
        }
        return null;
    }

    @Override // androidx.compose.p004ui.text.font.PlatformTypefaces
    @NotNull
    /* renamed from: createDefault-FO1MlWM */
    public Typeface mo4857createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.p004ui.text.font.PlatformTypefaces
    @NotNull
    /* renamed from: createNamed-RetOiIg */
    public Typeface mo4858createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(genericFontFamily, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Typeface m4862loadNamedFromTypefaceCacheOrNullRetOiIg = m4862loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefacesKt.getWeightSuffixForFallbackFamilyName(genericFontFamily.getName(), fontWeight), fontWeight, i);
        return m4862loadNamedFromTypefaceCacheOrNullRetOiIg == null ? m4860createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.getName(), fontWeight, i) : m4862loadNamedFromTypefaceCacheOrNullRetOiIg;
    }

    @Override // androidx.compose.p004ui.text.font.PlatformTypefaces
    @Nullable
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM */
    public Typeface mo4859optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(str, "familyName");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        FontFamily.Companion companion = FontFamily.Companion;
        return PlatformTypefacesKt.setFontVariationSettings(Intrinsics.areEqual(str, companion.getSansSerif().getName()) ? mo4858createNamedRetOiIg(companion.getSansSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getSerif().getName()) ? mo4858createNamedRetOiIg(companion.getSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getMonospace().getName()) ? mo4858createNamedRetOiIg(companion.getMonospace(), fontWeight, i) : Intrinsics.areEqual(str, companion.getCursive().getName()) ? mo4858createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m4862loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i), settings, context);
    }
}
