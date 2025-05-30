package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.y51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextPainterKt {
    private static final void clip(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (!textLayoutResult.getHasVisualOverflow() || TextOverflow.m2531equalsimpl0(textLayoutResult.getLayoutInput().m2308getOverflowgIe3tQ8(), TextOverflow.Companion.m2540getVisiblegIe3tQ8())) {
            return;
        }
        y51.d(drawTransform, 0.0f, 0.0f, IntSize.m2685getWidthimpl(textLayoutResult.getSize-YbymL2g()), IntSize.m2684getHeightimpl(textLayoutResult.getSize-YbymL2g()), 0, 16, (Object) null);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-gV6Hb-E, reason: not valid java name */
    public static final void m2309drawTextgV6HbE(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, @NotNull Brush brush, long j, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(brush, "brush");
        if (shadow == null) {
            shadow = textLayoutResult.getLayoutInput().getStyle().getShadow();
        }
        Shadow shadow2 = shadow;
        if (textDecoration == null) {
            textDecoration = textLayoutResult.getLayoutInput().getStyle().getTextDecoration();
        }
        TextDecoration textDecoration2 = textDecoration;
        if (drawStyle == null) {
            drawStyle = textLayoutResult.getLayoutInput().getStyle().getDrawStyle();
        }
        DrawStyle drawStyle2 = drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.getX-impl(j), Offset.getY-impl(j));
        clip(transform, textLayoutResult);
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        if (Float.isNaN(f)) {
            f = textLayoutResult.getLayoutInput().getStyle().getAlpha();
        }
        multiParagraph.paint(canvas, brush, f, shadow2, textDecoration2, drawStyle2);
        drawContext.getCanvas().restore();
        drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-phbL4MM, reason: not valid java name */
    public static final void m2311drawTextphbL4MM(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull AnnotatedString annotatedString, long j, @NotNull TextStyle textStyle, int i, boolean z, int i2, @NotNull List<AnnotatedString.Range<Placeholder>> list, long j2) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        TextLayoutResult textLayoutResult = TextMeasurer.measure-xDpz5zY$default(textMeasurer, annotatedString, textStyle, i, z, i2, list, m2317textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, (FontFamily.Resolver) null, false, 1536, (Object) null);
        DrawContext drawContext = drawScope.getDrawContext();
        long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.getX-impl(j), Offset.getY-impl(j));
        clip(transform, textLayoutResult);
        MultiParagraph.paint-RPmYEkk$default(textLayoutResult.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0L, (Shadow) null, (TextDecoration) null, 14, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-rS5J7As, reason: not valid java name */
    public static final void m2313drawTextrS5J7As(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, long j, long j2, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Shadow shadow2 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration2 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle2 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.getX-impl(j2), Offset.getY-impl(j2));
        clip(transform, textLayoutResult);
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        if (brush != null) {
            if (j == Color.Companion.m1084getUnspecified0d7_KjU()) {
                textLayoutResult.getMultiParagraph().paint(drawScope.getDrawContext().getCanvas(), brush, !Float.isNaN(f) ? f : textLayoutResult.getLayoutInput().getStyle().getAlpha(), shadow2, textDecoration2, drawStyle2);
                drawContext.getCanvas().restore();
                drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
            }
        }
        textLayoutResult.getMultiParagraph().paint-iJQMabo(drawScope.getDrawContext().getCanvas(), TextDrawStyleKt.modulate-DxMtmZc(j != Color.Companion.m1084getUnspecified0d7_KjU() ? j : textLayoutResult.getLayoutInput().getStyle().m2345getColor0d7_KjU(), f), shadow2, textDecoration2, drawStyle2);
        drawContext.getCanvas().restore();
        drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-usLqVg0, reason: not valid java name */
    public static final void m2315drawTextusLqVg0(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull String str, long j, @NotNull TextStyle textStyle, int i, boolean z, int i2, long j2) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        TextLayoutResult textLayoutResult = TextMeasurer.measure-xDpz5zY$default(textMeasurer, new AnnotatedString(str, null, null, 6, null), textStyle, i, z, i2, (List) null, m2317textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, (FontFamily.Resolver) null, false, 1568, (Object) null);
        DrawContext drawContext = drawScope.getDrawContext();
        long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.getX-impl(j), Offset.getY-impl(j));
        clip(transform, textLayoutResult);
        MultiParagraph.paint-RPmYEkk$default(textLayoutResult.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0L, (Shadow) null, (TextDecoration) null, 14, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
    }

    /* renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m2317textLayoutConstraintsv_w8tDc(DrawScope drawScope, long j, long j2) {
        int roundToInt;
        int i;
        int i2;
        Size.Companion companion = Size.Companion;
        boolean z = true;
        int i3 = 0;
        if (((j > companion.getUnspecified-NH-jbRc() ? 1 : (j == companion.getUnspecified-NH-jbRc() ? 0 : -1)) == 0) || Float.isNaN(Size.getWidth-impl(j))) {
            i = MathKt.roundToInt((float) Math.ceil(Size.getWidth-impl(drawScope.getSize-NH-jbRc()) - Offset.getX-impl(j2)));
            roundToInt = 0;
        } else {
            roundToInt = MathKt.roundToInt((float) Math.ceil(Size.getWidth-impl(j)));
            i = roundToInt;
        }
        if (!(j == companion.getUnspecified-NH-jbRc()) && !Float.isNaN(Size.getHeight-impl(j))) {
            z = false;
        }
        if (z) {
            i2 = MathKt.roundToInt((float) Math.ceil(Size.getHeight-impl(drawScope.getSize-NH-jbRc()) - Offset.getY-impl(j2)));
        } else {
            i3 = MathKt.roundToInt((float) Math.ceil(Size.getHeight-impl(j)));
            i2 = i3;
        }
        return ConstraintsKt.Constraints(roundToInt, i, i3, i2);
    }
}
