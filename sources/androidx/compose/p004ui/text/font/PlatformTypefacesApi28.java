package androidx.compose.p004ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontVariation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(28)
@VisibleForTesting
/* loaded from: classes2.dex */
final class PlatformTypefacesApi28 implements PlatformTypefaces {
    /* renamed from: createAndroidTypefaceApi28-RetOiIg, reason: not valid java name */
    private final Typeface m4863createAndroidTypefaceApi28RetOiIg(String str, FontWeight fontWeight, int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        if (FontStyle.m4834equalsimpl0(i, companion.m4839getNormal_LCdwA()) && Intrinsics.areEqual(fontWeight, FontWeight.Companion.getNormal())) {
            if (str == null || str.length() == 0) {
                Typeface typeface = Typeface.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
                return typeface;
            }
        }
        Typeface create = Typeface.create(str == null ? Typeface.DEFAULT : Typeface.create(str, 0), fontWeight.getWeight(), FontStyle.m4834equalsimpl0(i, companion.m4838getItalic_LCdwA()));
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            fami…ontStyle.Italic\n        )");
        return create;
    }

    /* renamed from: createAndroidTypefaceApi28-RetOiIg$default, reason: not valid java name */
    static /* synthetic */ Typeface m4864createAndroidTypefaceApi28RetOiIg$default(PlatformTypefacesApi28 platformTypefacesApi28, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return platformTypefacesApi28.m4863createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
    }

    /* renamed from: loadNamedFromTypefaceCacheOrNull-RetOiIg, reason: not valid java name */
    private final Typeface m4865loadNamedFromTypefaceCacheOrNullRetOiIg(String str, FontWeight fontWeight, int i) {
        if (str.length() == 0) {
            return null;
        }
        Typeface m4863createAndroidTypefaceApi28RetOiIg = m4863createAndroidTypefaceApi28RetOiIg(str, fontWeight, i);
        boolean m4834equalsimpl0 = FontStyle.m4834equalsimpl0(i, FontStyle.Companion.m4838getItalic_LCdwA());
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        Typeface typeface = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
        if ((Intrinsics.areEqual(m4863createAndroidTypefaceApi28RetOiIg, typefaceHelperMethodsApi28.create(typeface, fontWeight.getWeight(), m4834equalsimpl0)) || Intrinsics.areEqual(m4863createAndroidTypefaceApi28RetOiIg, m4863createAndroidTypefaceApi28RetOiIg(null, fontWeight, i))) ? false : true) {
            return m4863createAndroidTypefaceApi28RetOiIg;
        }
        return null;
    }

    @Override // androidx.compose.p004ui.text.font.PlatformTypefaces
    @NotNull
    /* renamed from: createDefault-FO1MlWM */
    public Typeface mo4857createDefaultFO1MlWM(@NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m4863createAndroidTypefaceApi28RetOiIg(null, fontWeight, i);
    }

    @Override // androidx.compose.p004ui.text.font.PlatformTypefaces
    @NotNull
    /* renamed from: createNamed-RetOiIg */
    public Typeface mo4858createNamedRetOiIg(@NotNull GenericFontFamily genericFontFamily, @NotNull FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(genericFontFamily, "name");
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return m4863createAndroidTypefaceApi28RetOiIg(genericFontFamily.getName(), fontWeight, i);
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
        return PlatformTypefacesKt.setFontVariationSettings(Intrinsics.areEqual(str, companion.getSansSerif().getName()) ? mo4858createNamedRetOiIg(companion.getSansSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getSerif().getName()) ? mo4858createNamedRetOiIg(companion.getSerif(), fontWeight, i) : Intrinsics.areEqual(str, companion.getMonospace().getName()) ? mo4858createNamedRetOiIg(companion.getMonospace(), fontWeight, i) : Intrinsics.areEqual(str, companion.getCursive().getName()) ? mo4858createNamedRetOiIg(companion.getCursive(), fontWeight, i) : m4865loadNamedFromTypefaceCacheOrNullRetOiIg(str, fontWeight, i), settings, context);
    }
}
