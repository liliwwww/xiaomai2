package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@VisibleForTesting
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PlatformTypefacesApi implements PlatformTypefaces {
    /* renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i) {
        if (FontStyle.equals-impl0(i, FontStyle.Companion.m2384getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal())) {
            if (str == null || str.length() == 0) {
                android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
                return typeface;
            }
        }
        int i2 = AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(fontWeight, i);
        if (str == null || str.length() == 0) {
            android.graphics.Typeface defaultFromStyle = android.graphics.Typeface.defaultFromStyle(i2);
            Intrinsics.checkNotNullExpressionValue(defaultFromStyle, "{\n            Typeface.d…le(targetStyle)\n        }");
            return defaultFromStyle;
        }
        android.graphics.Typeface create = android.graphics.Typeface.create(str, i2);
        Intrinsics.checkNotNullExpressionValue(create, "{\n            Typeface.c…y, targetStyle)\n        }");
        return create;
    }

    /* renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m2405createAndroidTypefaceUsingTypefaceStyleRetOiIg$default(PlatformTypefacesApi platformTypefacesApi, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m2384getNormal_LCdwA();
        }
        return platformTypefacesApi.m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2406loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg = m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg(str, fontWeight, i);
        if ((Intrinsics.areEqual(m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg, android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(fontWeight, i))) || Intrinsics.areEqual(m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg, m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i))) ? false : true) {
            return m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg;
        }
        return null;
    }

    @NotNull
    /* renamed from: createDefault-FO1MlWM, reason: not valid java name */
    public android.graphics.Typeface m2407createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i);
    }

    @NotNull
    /* renamed from: createNamed-RetOiIg, reason: not valid java name */
    public android.graphics.Typeface m2408createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(genericFontFamily, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        android.graphics.Typeface m2406loadNamedFromTypefaceCacheOrNullRetOiIg = m2406loadNamedFromTypefaceCacheOrNullRetOiIg(PlatformTypefacesKt.getWeightSuffixForFallbackFamilyName(genericFontFamily.getName(), fontWeight), fontWeight, i);
        return m2406loadNamedFromTypefaceCacheOrNullRetOiIg == null ? m2404createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.getName(), fontWeight, i) : m2406loadNamedFromTypefaceCacheOrNullRetOiIg;
    }

    @Nullable
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM, reason: not valid java name */
    public android.graphics.Typeface m2409optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(str, "familyName");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        FontFamily.Companion companion = FontFamily.Companion;
        return PlatformTypefacesKt.setFontVariationSettings(Intrinsics.areEqual(str, companion.getSansSerif().getName()) ? m2408createNamedRetOiIg(companion.getSansSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getSerif().getName()) ? m2408createNamedRetOiIg(companion.getSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getMonospace().getName()) ? m2408createNamedRetOiIg(companion.getMonospace(), fontWeight, i) : Intrinsics.areEqual(str, companion.getCursive().getName()) ? m2408createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m2406loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i), settings, context);
    }
}
