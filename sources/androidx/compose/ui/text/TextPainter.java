package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.kq;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextPainter {
    public static final int $stable = 0;

    @NotNull
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(@NotNull Canvas canvas, @NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m2531equalsimpl0(textLayoutResult.getLayoutInput().m2308getOverflowgIe3tQ8(), TextOverflow.Companion.m2540getVisiblegIe3tQ8());
        if (z) {
            Rect rect = RectKt.Rect-tz77jQw(Offset.Companion.m1024getZeroF1C5BW0(), SizeKt.Size(IntSize.m2685getWidthimpl(textLayoutResult.getSize-YbymL2g()), IntSize.m2684getHeightimpl(textLayoutResult.getSize-YbymL2g())));
            canvas.save();
            kq.o(canvas, rect, 0, 2, (Object) null);
        }
        SpanStyle resolveSpanStyleDefaults = SpanStyleKt.resolveSpanStyleDefaults(textLayoutResult.getLayoutInput().getStyle().getSpanStyle$ui_text_release());
        try {
            Brush brush = resolveSpanStyleDefaults.getBrush();
            if (brush != null) {
                textLayoutResult.getMultiParagraph().paint(canvas, brush, resolveSpanStyleDefaults.getAlpha(), resolveSpanStyleDefaults.getShadow(), resolveSpanStyleDefaults.getTextDecoration(), resolveSpanStyleDefaults.getDrawStyle());
            } else {
                textLayoutResult.getMultiParagraph().paint-iJQMabo(canvas, resolveSpanStyleDefaults.m2299getColor0d7_KjU(), resolveSpanStyleDefaults.getShadow(), resolveSpanStyleDefaults.getTextDecoration(), resolveSpanStyleDefaults.getDrawStyle());
            }
        } finally {
            if (z) {
                canvas.restore();
            }
        }
    }
}
