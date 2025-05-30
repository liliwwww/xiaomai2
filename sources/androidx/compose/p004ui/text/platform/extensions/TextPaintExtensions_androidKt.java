package androidx.compose.p004ui.text.platform.extensions;

import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.platform.AndroidTextPaint;
import androidx.compose.p004ui.text.style.TextMotion;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextPaintExtensions_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:52:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d0  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.p004ui.text.SpanStyle applySpanStyle(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.platform.AndroidTextPaint r24, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.text.SpanStyle r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super androidx.compose.p004ui.text.font.FontFamily, ? super androidx.compose.p004ui.text.font.FontWeight, ? super androidx.compose.p004ui.text.font.FontStyle, ? super androidx.compose.p004ui.text.font.FontSynthesis, ? extends android.graphics.Typeface> r26, @org.jetbrains.annotations.NotNull androidx.compose.p004ui.unit.Density r27) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.platform.extensions.TextPaintExtensions_androidKt.applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint, androidx.compose.ui.text.SpanStyle, kotlin.jvm.functions.Function4, androidx.compose.ui.unit.Density):androidx.compose.ui.text.SpanStyle");
    }

    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    public static final boolean hasFontAttributes(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "<this>");
        return (spanStyle.getFontFamily() == null && spanStyle.m4712getFontStyle4Lr2A7w() == null && spanStyle.getFontWeight() == null) ? false : true;
    }

    public static final void setTextMotion(@NotNull AndroidTextPaint androidTextPaint, @Nullable TextMotion textMotion) {
        Intrinsics.checkNotNullParameter(androidTextPaint, "<this>");
        if (textMotion == null) {
            textMotion = TextMotion.Companion.getStatic();
        }
        androidTextPaint.setFlags(textMotion.getSubpixelTextPositioning$ui_text_release() ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int m5107getLinearity4e0Vf04$ui_text_release = textMotion.m5107getLinearity4e0Vf04$ui_text_release();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.Companion;
        if (TextMotion.Linearity.m5111equalsimpl0(m5107getLinearity4e0Vf04$ui_text_release, companion.m5116getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m5111equalsimpl0(m5107getLinearity4e0Vf04$ui_text_release, companion.m5115getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (!TextMotion.Linearity.m5111equalsimpl0(m5107getLinearity4e0Vf04$ui_text_release, companion.m5117getNone4e0Vf04())) {
            androidTextPaint.getFlags();
        } else {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        }
    }
}
