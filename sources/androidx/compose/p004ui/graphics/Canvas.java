package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Rect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.kq;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Canvas {

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
        public static void m2765clipRectmtrdDE(@NotNull Canvas canvas, @NotNull Rect rect, int i) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            kq.g(canvas, rect, i);
        }

        @Deprecated
        public static void drawArc(@NotNull Canvas canvas, @NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(paint, "paint");
            kq.h(canvas, rect, f, f2, z, paint);
        }

        @Deprecated
        public static void drawArcRad(@NotNull Canvas canvas, @NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(paint, "paint");
            kq.i(canvas, rect, f, f2, z, paint);
        }

        @Deprecated
        public static void drawOval(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(paint, "paint");
            kq.j(canvas, rect, paint);
        }

        @Deprecated
        public static void drawRect(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            Intrinsics.checkNotNullParameter(paint, "paint");
            kq.k(canvas, rect, paint);
        }

        @Deprecated
        public static void skewRad(@NotNull Canvas canvas, float f, float f2) {
            kq.l(canvas, f, f2);
        }
    }

    /* renamed from: clipPath-mtrdD-E */
    void mo2650clipPathmtrdDE(@NotNull Path path, int i);

    /* renamed from: clipRect-N_I0leg */
    void mo2651clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* renamed from: clipRect-mtrdD-E */
    void mo2652clipRectmtrdDE(@NotNull Rect rect, int i);

    /* renamed from: concat-58bKbWc */
    void mo2653concat58bKbWc(@NotNull float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, @NotNull Paint paint);

    void drawArc(@NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint);

    void drawArcRad(@NotNull Rect rect, float f, float f2, boolean z, @NotNull Paint paint);

    /* renamed from: drawCircle-9KIMszo */
    void mo2654drawCircle9KIMszo(long j, float f, @NotNull Paint paint);

    /* renamed from: drawImage-d-4ec7I */
    void mo2655drawImaged4ec7I(@NotNull ImageBitmap imageBitmap, long j, @NotNull Paint paint);

    /* renamed from: drawImageRect-HPBpro0 */
    void mo2656drawImageRectHPBpro0(@NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j4, @NotNull Paint paint);

    /* renamed from: drawLine-Wko1d7g */
    void mo2657drawLineWko1d7g(long j, long j2, @NotNull Paint paint);

    void drawOval(float f, float f2, float f3, float f4, @NotNull Paint paint);

    void drawOval(@NotNull Rect rect, @NotNull Paint paint);

    void drawPath(@NotNull Path path, @NotNull Paint paint);

    /* renamed from: drawPoints-O7TthRY */
    void mo2658drawPointsO7TthRY(int i, @NotNull List<Offset> list, @NotNull Paint paint);

    /* renamed from: drawRawPoints-O7TthRY */
    void mo2659drawRawPointsO7TthRY(int i, @NotNull float[] fArr, @NotNull Paint paint);

    void drawRect(float f, float f2, float f3, float f4, @NotNull Paint paint);

    void drawRect(@NotNull Rect rect, @NotNull Paint paint);

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, @NotNull Paint paint);

    /* renamed from: drawVertices-TPEHhCM */
    void mo2660drawVerticesTPEHhCM(@NotNull Vertices vertices, int i, @NotNull Paint paint);

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
