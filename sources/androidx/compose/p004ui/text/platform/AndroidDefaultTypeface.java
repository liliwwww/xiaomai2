package androidx.compose.p004ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.p004ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "This path for preloading fonts is not supported")
/* loaded from: classes2.dex */
public final class AndroidDefaultTypeface implements AndroidTypeface {

    @NotNull
    private final FontFamily fontFamily = FontFamily.Companion.getDefault();

    @Override // androidx.compose.p004ui.text.font.Typeface
    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.p004ui.text.platform.AndroidTypeface
    @NotNull
    /* renamed from: getNativeTypeface-PYhJU0U, reason: not valid java name */
    public Typeface mo4961getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        if (Build.VERSION.SDK_INT < 28) {
            Typeface defaultFromStyle = Typeface.defaultFromStyle(AndroidFontUtils_androidKt.m4789getAndroidTypefaceStyleFO1MlWM(fontWeight, i));
            Intrinsics.checkNotNullExpressionValue(defaultFromStyle, "{\n            Typeface.d…)\n            )\n        }");
            return defaultFromStyle;
        }
        TypefaceHelperMethodsApi28 typefaceHelperMethodsApi28 = TypefaceHelperMethodsApi28.INSTANCE;
        Typeface typeface = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(typeface, "DEFAULT");
        return typefaceHelperMethodsApi28.create(typeface, fontWeight.getWeight(), FontStyle.m4834equalsimpl0(i, FontStyle.Companion.m4838getItalic_LCdwA()));
    }
}
