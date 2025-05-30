package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TypographyKt {

    @NotNull
    private static final ProvidableCompositionLocal<Typography> LocalTypography = CompositionLocalKt.staticCompositionLocalOf(LocalTypography.1.INSTANCE);

    @NotNull
    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        TextStyle m2339copyHL5avdY;
        if (textStyle.getFontFamily() != null) {
            return textStyle;
        }
        m2339copyHL5avdY = textStyle.m2339copyHL5avdY((r42 & 1) != 0 ? textStyle.spanStyle.m2299getColor0d7_KjU() : 0L, (r42 & 2) != 0 ? textStyle.spanStyle.m2300getFontSizeXSAIIZE() : 0L, (r42 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (r42 & 8) != 0 ? textStyle.spanStyle.m2301getFontStyle4Lr2A7w() : null, (r42 & 16) != 0 ? textStyle.spanStyle.m2302getFontSynthesisZQGJjVo() : null, (r42 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (r42 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (r42 & 128) != 0 ? textStyle.spanStyle.m2303getLetterSpacingXSAIIZE() : 0L, (r42 & 256) != 0 ? textStyle.spanStyle.m2298getBaselineShift5SSeXJ0() : null, (r42 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (r42 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? textStyle.spanStyle.getLocaleList() : null, (r42 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? textStyle.spanStyle.m2297getBackground0d7_KjU() : 0L, (r42 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (r42 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? textStyle.spanStyle.getShadow() : null, (r42 & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? textStyle.paragraphStyle.m2274getTextAlignbuA522U() : null, (r42 & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? textStyle.paragraphStyle.m2275getTextDirectionmmuk1to() : null, (r42 & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? textStyle.paragraphStyle.m2273getLineHeightXSAIIZE() : 0L, (r42 & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) != 0 ? textStyle.paragraphStyle.getTextIndent() : null);
        return m2339copyHL5avdY;
    }
}
