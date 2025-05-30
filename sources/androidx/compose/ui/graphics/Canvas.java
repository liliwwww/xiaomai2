package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Canvas {
    /* renamed from: clipPath-mtrdD-E, reason: not valid java name */
    void mo1046clipPathmtrdDE(@NotNull Path path, int i);

    /* renamed from: clipRect-N_I0leg, reason: not valid java name */
    void mo1047clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
    void mo1048clipRectmtrdDE(@NotNull Rect rect, int i);

    /* renamed from: concat-58bKbWc, reason: not valid java name */
    void mo1049concat58bKbWc(@NotNull float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, @NotNull Paint paint);

    void drawArc(@NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint);

    void drawArcRad(@NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint);

    /* renamed from: drawCircle-9KIMszo, reason: not valid java name */
    void mo1050drawCircle9KIMszo(long j, float f, @NotNull Paint paint);

    /* renamed from: drawImage-d-4ec7I, reason: not valid java name */
    void mo1051drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j, @NotNull Paint paint);

    /* renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    void mo1052drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @NotNull Paint paint);

    /* renamed from: drawLine-Wko1d7g, reason: not valid java name */
    void mo1053drawLineWko1d7g(long j, long j2, @NotNull Paint paint);

    void drawOval(float f, float f2, float f3, float f4, @NotNull Paint paint);

    void drawOval(@NotNull Rect rect, @NotNull Paint paint);

    void drawPath(@NotNull Path path, @NotNull Paint paint);

    /* renamed from: drawPoints-O7TthRY, reason: not valid java name */
    void mo1054drawPointsO7TthRY(int i, @NotNull List<Offset> list, @NotNull Paint paint);

    /* renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    void mo1055drawRawPointsO7TthRY(int i, @NotNull float[] fArr, @NotNull Paint paint);

    void drawRect(float f, float f2, float f3, float f4, @NotNull Paint paint);

    void drawRect(@NotNull Rect rect, @NotNull Paint paint);

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, @NotNull Paint paint);

    /* renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    void mo1056drawVerticesTPEHhCM(@NotNull Vertices vertices, int i, @NotNull Paint paint);

    void enableZ();

    void restore();

    void rotate(float f);

    void save();

    void saveLayer(@NotNull Rect rect, @NotNull Paint paint);

    void scale(float f, float f2);

    void skew(float f, float f2);

    void skewRad(float f, float f2);

    void translate(float f, float f2);
}
