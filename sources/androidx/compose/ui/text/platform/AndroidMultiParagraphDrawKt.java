package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidMultiParagraphDrawKt {
    public static final void drawMultiParagraph(@NotNull MultiParagraph multiParagraph, @NotNull Canvas canvas, @NotNull Brush brush, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(multiParagraph, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        canvas.save();
        if (multiParagraph.getParagraphInfoList$ui_text_release().size() <= 1) {
            drawParagraphs(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle);
        } else if (brush instanceof SolidColor) {
            drawParagraphs(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle);
        } else if (brush instanceof ShaderBrush) {
            List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
            int size = paragraphInfoList$ui_text_release.size();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i = 0; i < size; i++) {
                ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i);
                f3 += paragraphInfo.getParagraph().getHeight();
                f2 = Math.max(f2, paragraphInfo.getParagraph().getWidth());
            }
            Shader mo1027createShaderuvyYCjk = ((ShaderBrush) brush).mo1027createShaderuvyYCjk(SizeKt.Size(f2, f3));
            Matrix matrix = new Matrix();
            mo1027createShaderuvyYCjk.getLocalMatrix(matrix);
            List<ParagraphInfo> paragraphInfoList$ui_text_release2 = multiParagraph.getParagraphInfoList$ui_text_release();
            int size2 = paragraphInfoList$ui_text_release2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ParagraphInfo paragraphInfo2 = paragraphInfoList$ui_text_release2.get(i2);
                paragraphInfo2.getParagraph().paint(canvas, BrushKt.ShaderBrush(mo1027createShaderuvyYCjk), f, shadow, textDecoration, drawStyle);
                canvas.translate(0.0f, paragraphInfo2.getParagraph().getHeight());
                matrix.setTranslate(0.0f, -paragraphInfo2.getParagraph().getHeight());
                mo1027createShaderuvyYCjk.setLocalMatrix(matrix);
            }
        }
        canvas.restore();
    }

    private static final void drawParagraphs(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        List<ParagraphInfo> paragraphInfoList$ui_text_release = multiParagraph.getParagraphInfoList$ui_text_release();
        int size = paragraphInfoList$ui_text_release.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = paragraphInfoList$ui_text_release.get(i);
            paragraphInfo.getParagraph().paint(canvas, brush, f, shadow, textDecoration, drawStyle);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
    }
}
