package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "This path for preloading loading fonts is not supported.")
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidGenericFontFamilyTypeface implements AndroidTypeface {

    @NotNull
    private final FontFamily fontFamily;

    @NotNull
    private final Typeface nativeTypeface;

    public AndroidGenericFontFamilyTypeface(@NotNull GenericFontFamily genericFontFamily) {
        Intrinsics.checkNotNullParameter(genericFontFamily, "fontFamily");
        this.fontFamily = genericFontFamily;
        Typeface create = Typeface.create(genericFontFamily.getName(), 0);
        Intrinsics.checkNotNull(create);
        this.nativeTypeface = create;
    }

    /* renamed from: buildStyledTypeface-FO1MlWM, reason: not valid java name */
    private final Typeface m2461buildStyledTypefaceFO1MlWM(FontWeight fontWeight, int i) {
        return Build.VERSION.SDK_INT < 28 ? Typeface.create(this.nativeTypeface, AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(fontWeight, i)) : TypefaceHelperMethodsApi28.INSTANCE.create(this.nativeTypeface, fontWeight.getWeight(), FontStyle.equals-impl0(i, FontStyle.Companion.m2383getItalic_LCdwA()));
    }

    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @NotNull
    /* renamed from: getNativeTypeface-PYhJU0U, reason: not valid java name */
    public Typeface m2462getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Typeface m2461buildStyledTypefaceFO1MlWM = m2461buildStyledTypefaceFO1MlWM(fontWeight, i);
        Intrinsics.checkNotNullExpressionValue(m2461buildStyledTypefaceFO1MlWM, "buildStyledTypeface(fontWeight, fontStyle)");
        return m2461buildStyledTypefaceFO1MlWM;
    }
}
