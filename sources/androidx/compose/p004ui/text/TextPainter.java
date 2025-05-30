package androidx.compose.p004ui.text;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RectKt;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.kq;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class TextPainter {
    public static final int $stable = 0;

    @NotNull
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(@NotNull Canvas canvas, @NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m5121equalsimpl0(textLayoutResult.getLayoutInput().m4720getOverflowgIe3tQ8(), TextOverflow.Companion.m5130getVisiblegIe3tQ8());
        if (z) {
            Rect m2596Recttz77jQw = RectKt.m2596Recttz77jQw(Offset.Companion.m2572getZeroF1C5BW0(), SizeKt.Size(IntSize.m5376getWidthimpl(textLayoutResult.m4724getSizeYbymL2g()), IntSize.m5375getHeightimpl(textLayoutResult.m4724getSizeYbymL2g())));
            canvas.save();
            kq.o(canvas, m2596Recttz77jQw, 0, 2, (Object) null);
        }
        SpanStyle resolveSpanStyleDefaults = SpanStyleKt.resolveSpanStyleDefaults(textLayoutResult.getLayoutInput().getStyle().getSpanStyle$ui_text_release());
        try {
            Brush brush = resolveSpanStyleDefaults.getBrush();
            if (brush != null) {
                textLayoutResult.getMultiParagraph().paint(canvas, brush, resolveSpanStyleDefaults.getAlpha(), resolveSpanStyleDefaults.getShadow(), resolveSpanStyleDefaults.getTextDecoration(), resolveSpanStyleDefaults.getDrawStyle());
            } else {
                textLayoutResult.getMultiParagraph().m4637paintiJQMabo(canvas, resolveSpanStyleDefaults.m4710getColor0d7_KjU(), resolveSpanStyleDefaults.getShadow(), resolveSpanStyleDefaults.getTextDecoration(), resolveSpanStyleDefaults.getDrawStyle());
            }
        } finally {
            if (z) {
                canvas.restore();
            }
        }
    }
}
