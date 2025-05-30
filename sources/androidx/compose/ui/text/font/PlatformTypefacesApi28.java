package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(28)
@VisibleForTesting
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2410createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        FontStyle$Companion fontStyle$Companion = FontStyle.Companion;
        if (FontStyle.equals-impl0(i, fontStyle$Companion.m2384getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal())) {
            if (str == null || str.length() == 0) {
                android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
                return typeface;
            }
        }
        android.graphics.Typeface create = android.graphics.Typeface.create(str == null ? android.graphics.Typeface.DEFAULT : android.graphics.Typeface.create(str, 0), fontWeight.getWeight(), FontStyle.equals-impl0(i, fontStyle$Companion.m2383getItalic_LCdwA()));
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            fami…ontStyle.Italic\n        )");
        return create;
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ android.graphics.Typeface m2411createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m2410createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final android.graphics.Typeface m2412loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        android.graphics.Typeface m2410createAndroidTypefaceApi28RetOiIg = m2410createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
        boolean z = FontStyle.equals-impl0(i, FontStyle.Companion.m2383getItalic_LCdwA());
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
        if ((Intrinsics.areEqual(m2410createAndroidTypefaceApi28RetOiIg, typefaceHelperMethodsApi28.create(typeface, fontWeight.getWeight(), z)) || Intrinsics.areEqual(m2410createAndroidTypefaceApi28RetOiIg, m2410createAndroidTypefaceApi28RetOiIg(null, fontWeight, i))) ? false : true) {
            return m2410createAndroidTypefaceApi28RetOiIg;
        }
        return null;
    }

    @NotNull
    /* renamed from: createDefault-FO1MlWM, reason: not valid java name */
    public android.graphics.Typeface m2413createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m2410createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @NotNull
    /* renamed from: createNamed-RetOiIg, reason: not valid java name */
    public android.graphics.Typeface m2414createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(genericFontFamily, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m2410createAndroidTypefaceApi28RetOiIg(genericFontFamily.getName(), fontWeight, i);
    }

    @Nullable
    /* renamed from: optionalOnDeviceFontFamilyByName-78DK7lM, reason: not valid java name */
    public android.graphics.Typeface m2415optionalOnDeviceFontFamilyByName78DK7lM(@NotNull String str, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(str, "familyName");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        Intrinsics.checkNotNullParameter(context, "context");
        FontFamily.Companion companion = FontFamily.Companion;
        return PlatformTypefacesKt.setFontVariationSettings(Intrinsics.areEqual(str, companion.getSansSerif().getName()) ? m2414createNamedRetOiIg(companion.getSansSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getSerif().getName()) ? m2414createNamedRetOiIg(companion.getSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getMonospace().getName()) ? m2414createNamedRetOiIg(companion.getMonospace(), fontWeight, i) : Intrinsics.areEqual(str, companion.getCursive().getName()) ? m2414createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m2412loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i), settings, context);
    }
}
