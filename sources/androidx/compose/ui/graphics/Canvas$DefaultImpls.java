package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.kq;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Canvas$DefaultImpls {
    @Deprecated
    /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
    public static void m1030clipRectmtrdDE(@NotNull Canvas canvas, @NotNull Rect rect, int i) {
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
