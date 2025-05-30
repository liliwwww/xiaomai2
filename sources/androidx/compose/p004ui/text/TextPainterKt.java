package androidx.compose.p004ui.text;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.drawscope.DrawContext;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.DrawTransform;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextDrawStyleKt;
import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntSize;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.y51;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TextPainterKt {
    private static final void clip(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (!textLayoutResult.getHasVisualOverflow() || TextOverflow.m5121equalsimpl0(textLayoutResult.getLayoutInput().m4720getOverflowgIe3tQ8(), TextOverflow.Companion.m5130getVisiblegIe3tQ8())) {
            return;
        }
        y51.d(drawTransform, 0.0f, 0.0f, IntSize.m5376getWidthimpl(textLayoutResult.m4724getSizeYbymL2g()), IntSize.m5375getHeightimpl(textLayoutResult.m4724getSizeYbymL2g()), 0, 16, (Object) null);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-gV6Hb-E, reason: not valid java name */
    public static final void m4728drawTextgV6HbE(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, @NotNull Brush brush, long j, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
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
        long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
        clip(transform, textLayoutResult);
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        if (Float.isNaN(f)) {
            f = textLayoutResult.getLayoutInput().getStyle().getAlpha();
        }
        multiParagraph.paint(canvas, brush, f, shadow2, textDecoration2, drawStyle2);
        drawContext.getCanvas().restore();
        drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-phbL4MM, reason: not valid java name */
    public static final void m4730drawTextphbL4MM(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull AnnotatedString annotatedString, long j, @NotNull TextStyle textStyle, int i, boolean z, int i2, @NotNull List<AnnotatedString.Range<Placeholder>> list, long j2) {
        TextLayoutResult m4727measurexDpz5zY;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        m4727measurexDpz5zY = textMeasurer.m4727measurexDpz5zY(annotatedString, (r26 & 2) != 0 ? TextStyle.Companion.getDefault() : textStyle, (r26 & 4) != 0 ? TextOverflow.Companion.m5128getClipgIe3tQ8() : i, (r26 & 8) != 0 ? true : z, (r26 & 16) != 0 ? Integer.MAX_VALUE : i2, (r26 & 32) != 0 ? CollectionsKt.emptyList() : list, (r26 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : m4736textLayoutConstraintsv_w8tDc(drawScope, j2, j), (r26 & 128) != 0 ? textMeasurer.fallbackLayoutDirection : drawScope.getLayoutDirection(), (r26 & 256) != 0 ? textMeasurer.fallbackDensity : drawScope, (r26 & 512) != 0 ? textMeasurer.fallbackFontFamilyResolver : null, (r26 & 1024) != 0 ? false : false);
        DrawContext drawContext = drawScope.getDrawContext();
        long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
        clip(transform, m4727measurexDpz5zY);
        MultiParagraph.m4632paintRPmYEkk$default(m4727measurexDpz5zY.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0L, null, null, 14, null);
        drawContext.getCanvas().restore();
        drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-rS5J7As, reason: not valid java name */
    public static final void m4732drawTextrS5J7As(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, long j, long j2, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Shadow shadow2 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration2 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle2 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2));
        clip(transform, textLayoutResult);
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        if (brush != null) {
            if (j == Color.Companion.m2823getUnspecified0d7_KjU()) {
                textLayoutResult.getMultiParagraph().paint(drawScope.getDrawContext().getCanvas(), brush, !Float.isNaN(f) ? f : textLayoutResult.getLayoutInput().getStyle().getAlpha(), shadow2, textDecoration2, drawStyle2);
                drawContext.getCanvas().restore();
                drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
            }
        }
        textLayoutResult.getMultiParagraph().m4637paintiJQMabo(drawScope.getDrawContext().getCanvas(), TextDrawStyleKt.m5097modulateDxMtmZc(j != Color.Companion.m2823getUnspecified0d7_KjU() ? j : textLayoutResult.getLayoutInput().getStyle().m4767getColor0d7_KjU(), f), shadow2, textDecoration2, drawStyle2);
        drawContext.getCanvas().restore();
        drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-usLqVg0, reason: not valid java name */
    public static final void m4734drawTextusLqVg0(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull String str, long j, @NotNull TextStyle textStyle, int i, boolean z, int i2, long j2) {
        TextLayoutResult m4727measurexDpz5zY;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        m4727measurexDpz5zY = textMeasurer.m4727measurexDpz5zY(new AnnotatedString(str, null, null, 6, null), (r26 & 2) != 0 ? TextStyle.Companion.getDefault() : textStyle, (r26 & 4) != 0 ? TextOverflow.Companion.m5128getClipgIe3tQ8() : i, (r26 & 8) != 0 ? true : z, (r26 & 16) != 0 ? Integer.MAX_VALUE : i2, (r26 & 32) != 0 ? CollectionsKt.emptyList() : null, (r26 & 64) != 0 ? ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null) : m4736textLayoutConstraintsv_w8tDc(drawScope, j2, j), (r26 & 128) != 0 ? textMeasurer.fallbackLayoutDirection : drawScope.getLayoutDirection(), (r26 & 256) != 0 ? textMeasurer.fallbackDensity : drawScope, (r26 & 512) != 0 ? textMeasurer.fallbackFontFamilyResolver : null, (r26 & 1024) != 0 ? false : false);
        DrawContext drawContext = drawScope.getDrawContext();
        long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
        clip(transform, m4727measurexDpz5zY);
        MultiParagraph.m4632paintRPmYEkk$default(m4727measurexDpz5zY.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0L, null, null, 14, null);
        drawContext.getCanvas().restore();
        drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
    }

    /* renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m4736textLayoutConstraintsv_w8tDc(DrawScope drawScope, long j, long j2) {
        int roundToInt;
        int i;
        int i2;
        Size.Companion companion = Size.Companion;
        boolean z = true;
        int i3 = 0;
        if (((j > companion.m2633getUnspecifiedNHjbRc() ? 1 : (j == companion.m2633getUnspecifiedNHjbRc() ? 0 : -1)) == 0) || Float.isNaN(Size.m2625getWidthimpl(j))) {
            i = MathKt.roundToInt((float) Math.ceil(Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc()) - Offset.m2556getXimpl(j2)));
            roundToInt = 0;
        } else {
            roundToInt = MathKt.roundToInt((float) Math.ceil(Size.m2625getWidthimpl(j)));
            i = roundToInt;
        }
        if (!(j == companion.m2633getUnspecifiedNHjbRc()) && !Float.isNaN(Size.m2622getHeightimpl(j))) {
            z = false;
        }
        if (z) {
            i2 = MathKt.roundToInt((float) Math.ceil(Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc()) - Offset.m2557getYimpl(j2)));
        } else {
            i3 = MathKt.roundToInt((float) Math.ceil(Size.m2622getHeightimpl(j)));
            i2 = i3;
        }
        return ConstraintsKt.Constraints(roundToInt, i, i3, i2);
    }
}
