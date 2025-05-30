package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.zn3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class OutlineKt {
    public static final void addOutline(@NotNull Path path, @NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (outline instanceof Outline$Rectangle) {
            path.addRect(((Outline$Rectangle) outline).getRect());
        } else if (outline instanceof Outline$Rounded) {
            path.addRoundRect(((Outline$Rounded) outline).getRoundRect());
        } else {
            if (!(outline instanceof Outline$Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            zn3.c(path, ((Outline$Generic) outline).getPath(), 0L, 2, (Object) null);
        }
    }

    public static final void drawOutline(@NotNull Canvas canvas, @NotNull Outline outline, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (outline instanceof Outline$Rectangle) {
            canvas.drawRect(((Outline$Rectangle) outline).getRect(), paint);
            return;
        }
        if (!(outline instanceof Outline$Rounded)) {
            if (!(outline instanceof Outline$Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            canvas.drawPath(((Outline$Generic) outline).getPath(), paint);
        } else {
            Outline$Rounded outline$Rounded = (Outline$Rounded) outline;
            Path roundRectPath$ui_graphics_release = outline$Rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                canvas.drawPath(roundRectPath$ui_graphics_release, paint);
            } else {
                canvas.drawRoundRect(outline$Rounded.getRoundRect().getLeft(), outline$Rounded.getRoundRect().getTop(), outline$Rounded.getRoundRect().getRight(), outline$Rounded.getRoundRect().getBottom(), CornerRadius.m1006getXimpl(outline$Rounded.getRoundRect().getBottomLeftCornerRadius-kKHJgLs()), CornerRadius.m1007getYimpl(outline$Rounded.getRoundRect().getBottomLeftCornerRadius-kKHJgLs()), paint);
            }
        }
    }

    /* renamed from: drawOutline-hn5TExg, reason: not valid java name */
    public static final void m1156drawOutlinehn5TExg(@NotNull DrawScope drawScope, @NotNull Outline outline, @NotNull Brush brush, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Path path;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        if (outline instanceof Outline$Rectangle) {
            Rect rect = ((Outline$Rectangle) outline).getRect();
            drawScope.drawRect-AsUm42w(brush, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline instanceof Outline$Rounded) {
            Outline$Rounded outline$Rounded = (Outline$Rounded) outline;
            path = outline$Rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = outline$Rounded.getRoundRect();
                drawScope.drawRoundRect-ZuiqVtQ(brush, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1006getXimpl(roundRect.getBottomLeftCornerRadius-kKHJgLs()), 0.0f, 2, (Object) null), f, drawStyle, colorFilter, i);
                return;
            }
        } else {
            if (!(outline instanceof Outline$Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            path = ((Outline$Generic) outline).getPath();
        }
        drawScope.drawPath-GBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawOutline-hn5TExg$default, reason: not valid java name */
    public static /* synthetic */ void m1157drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        float f2 = (i2 & 4) != 0 ? 1.0f : f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
        }
        m1156drawOutlinehn5TExg(drawScope, outline, brush, f2, drawStyle2, colorFilter2, i);
    }

    /* renamed from: drawOutline-wDX37Ww, reason: not valid java name */
    public static final void m1158drawOutlinewDX37Ww(@NotNull DrawScope drawScope, @NotNull Outline outline, long j, float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i) {
        Path path;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        if (outline instanceof Outline$Rectangle) {
            Rect rect = ((Outline$Rectangle) outline).getRect();
            drawScope.drawRect-n-J9OG0(j, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline instanceof Outline$Rounded) {
            Outline$Rounded outline$Rounded = (Outline$Rounded) outline;
            path = outline$Rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = outline$Rounded.getRoundRect();
                drawScope.drawRoundRect-u-Aw5IA(j, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m1006getXimpl(roundRect.getBottomLeftCornerRadius-kKHJgLs()), 0.0f, 2, (Object) null), drawStyle, f, colorFilter, i);
                return;
            }
        } else {
            if (!(outline instanceof Outline$Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            path = ((Outline$Generic) outline).getPath();
        }
        drawScope.drawPath-LG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    private static final void drawOutlineHelper(DrawScope drawScope, Outline outline, Function2<? super DrawScope, ? super Rect, Unit> function2, Function2<? super DrawScope, ? super RoundRect, Unit> function22, Function2<? super DrawScope, ? super Path, Unit> function23) {
        if (outline instanceof Outline$Rectangle) {
            function2.invoke(drawScope, ((Outline$Rectangle) outline).getRect());
            return;
        }
        if (!(outline instanceof Outline$Rounded)) {
            if (!(outline instanceof Outline$Generic)) {
                throw new NoWhenBranchMatchedException();
            }
            function23.invoke(drawScope, ((Outline$Generic) outline).getPath());
        } else {
            Outline$Rounded outline$Rounded = (Outline$Rounded) outline;
            Path roundRectPath$ui_graphics_release = outline$Rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                function23.invoke(drawScope, roundRectPath$ui_graphics_release);
            } else {
                function22.invoke(drawScope, outline$Rounded.getRoundRect());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            long r0 = r6.getBottomLeftCornerRadius-kKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1006getXimpl(r0)
            long r1 = r6.getBottomRightCornerRadius-kKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m1006getXimpl(r1)
            r2 = 1
            r3 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L18
            r0 = 1
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == 0) goto L4f
            long r0 = r6.getBottomRightCornerRadius-kKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1006getXimpl(r0)
            long r4 = r6.getTopRightCornerRadius-kKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m1006getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L31
            r0 = 1
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L4f
            long r0 = r6.getTopRightCornerRadius-kKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m1006getXimpl(r0)
            long r4 = r6.getTopLeftCornerRadius-kKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m1006getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L4a
            r0 = 1
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r0 == 0) goto L4f
            r0 = 1
            goto L50
        L4f:
            r0 = 0
        L50:
            long r4 = r6.getBottomLeftCornerRadius-kKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m1007getYimpl(r4)
            long r4 = r6.getBottomRightCornerRadius-kKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m1007getYimpl(r4)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L66
            r1 = 1
            goto L67
        L66:
            r1 = 0
        L67:
            if (r1 == 0) goto L9d
            long r4 = r6.getBottomRightCornerRadius-kKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m1007getYimpl(r4)
            long r4 = r6.getTopRightCornerRadius-kKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m1007getYimpl(r4)
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L7f
            r1 = 1
            goto L80
        L7f:
            r1 = 0
        L80:
            if (r1 == 0) goto L9d
            long r4 = r6.getTopRightCornerRadius-kKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m1007getYimpl(r4)
            long r4 = r6.getTopLeftCornerRadius-kKHJgLs()
            float r6 = androidx.compose.ui.geometry.CornerRadius.m1007getYimpl(r4)
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 != 0) goto L98
            r6 = 1
            goto L99
        L98:
            r6 = 0
        L99:
            if (r6 == 0) goto L9d
            r6 = 1
            goto L9e
        L9d:
            r6 = 0
        L9e:
            if (r0 == 0) goto La3
            if (r6 == 0) goto La3
            goto La4
        La3:
            r2 = 0
        La4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.OutlineKt.hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }
}
