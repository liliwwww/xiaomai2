package androidx.compose.p004ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import androidx.compose.p004ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.font.GenericFontFamily;
import androidx.compose.p004ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Deprecated(message = "This path for preloading loading fonts is not supported.")
/* loaded from: classes2.dex */
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
    private final Typeface m4962buildStyledTypefaceFO1MlWM(FontWeight fontWeight, int i) {
        return Build.VERSION.SDK_INT < 28 ? Typeface.create(this.nativeTypeface, AndroidFontUtils_androidKt.m4789getAndroidTypefaceStyleFO1MlWM(fontWeight, i)) : TypefaceHelperMethodsApi28.INSTANCE.create(this.nativeTypeface, fontWeight.getWeight(), FontStyle.m4834equalsimpl0(i, FontStyle.Companion.m4838getItalic_LCdwA()));
    }

    @Override // androidx.compose.p004ui.text.font.Typeface
    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Override // androidx.compose.p004ui.text.platform.AndroidTypeface
    @NotNull
    /* renamed from: getNativeTypeface-PYhJU0U */
    public Typeface mo4961getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        Typeface m4962buildStyledTypefaceFO1MlWM = m4962buildStyledTypefaceFO1MlWM(fontWeight, i);
        Intrinsics.checkNotNullExpressionValue(m4962buildStyledTypefaceFO1MlWM, "buildStyledTypeface(fontWeight, fontStyle)");
        return m4962buildStyledTypefaceFO1MlWM;
    }
}
