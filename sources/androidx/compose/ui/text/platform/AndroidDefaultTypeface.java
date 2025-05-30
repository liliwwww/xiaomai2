package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "This path for preloading fonts is not supported")
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidDefaultTypeface implements AndroidTypeface {

    @NotNull
    private final FontFamily fontFamily = FontFamily.Companion.getDefault();

    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @NotNull
    /* renamed from: getNativeTypeface-PYhJU0U, reason: not valid java name */
    public Typeface m2459getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        if (Build.VERSION.SDK_INT < 28) {
            Typeface defaultFromStyle = Typeface.defaultFromStyle(AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(fontWeight, i));
            Intrinsics.checkNotNullExpressionValue(defaultFromStyle, "{\n            Typeface.d…)\n            )\n        }");
            return defaultFromStyle;
        }
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        Typeface typeface = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
        return typefaceHelperMethodsApi28.create(typeface, fontWeight.getWeight(), FontStyle.equals-impl0(i, FontStyle.Companion.m2383getItalic_LCdwA()));
    }
}
