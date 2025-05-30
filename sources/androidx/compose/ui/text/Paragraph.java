package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Paragraph {
    @NotNull
    ResolvedTextDirection getBidiRunDirection(int i);

    @NotNull
    Rect getBoundingBox(int i);

    @NotNull
    Rect getCursorRect(int i);

    boolean getDidExceedMaxLines();

    float getFirstBaseline();

    float getHeight();

    float getHorizontalPosition(int i, boolean z);

    float getLastBaseline();

    float getLineBottom(int i);

    int getLineCount();

    int getLineEnd(int i, boolean z);

    int getLineForOffset(int i);

    int getLineForVerticalPosition(float f);

    float getLineHeight(int i);

    float getLineLeft(int i);

    float getLineRight(int i);

    int getLineStart(int i);

    float getLineTop(int i);

    float getLineWidth(int i);

    float getMaxIntrinsicWidth();

    float getMinIntrinsicWidth();

    /* renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    int m2257getOffsetForPositionk4lQ0M(long j);

    @NotNull
    ResolvedTextDirection getParagraphDirection(int i);

    @NotNull
    Path getPathForRange(int i, int i2);

    @NotNull
    List<Rect> getPlaceholderRects();

    float getWidth();

    /* renamed from: getWordBoundary--jx7JFs, reason: not valid java name */
    long m2258getWordBoundaryjx7JFs(int i);

    boolean isLineEllipsized(int i);

    @ExperimentalTextApi
    void paint(@NotNull Canvas canvas, @NotNull Brush brush, float f, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle);

    /* renamed from: paint-RPmYEkk, reason: not valid java name */
    void m2259paintRPmYEkk(@NotNull Canvas canvas, long j, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration);

    @ExperimentalTextApi
    /* renamed from: paint-iJQMabo, reason: not valid java name */
    void m2260paintiJQMabo(@NotNull Canvas canvas, long j, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle);
}
