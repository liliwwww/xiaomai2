package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.getX-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.getX-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.getX-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.getY-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.getY-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight() && CornerRadius.getY-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs()) + CornerRadius.getY-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
    }

    public static final boolean isInOutline(@NotNull Outline outline, float f, float f2, @Nullable Path path, @Nullable Path path2) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f, f2);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f, f2, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f, f2, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f2, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f2, path, path2);
    }

    private static final boolean isInPath(Path path, float f, float f2, Path path2, Path path3) {
        Rect rect = new Rect(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        path2.addRect(rect);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.op-N5in7k0(path, path2, PathOperation.Companion.m1185getIntersectb3I0S0c());
        boolean isEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !isEmpty;
    }

    private static final boolean isInRectangle(Rect rect, float f, float f2) {
        return rect.getLeft() <= f && f < rect.getRight() && rect.getTop() <= f2 && f2 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f, float f2, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f < roundRect.getLeft() || f >= roundRect.getRight() || f2 < roundRect.getTop() || f2 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect(roundRect);
            return isInPath(Path, f, f2, path, path2);
        }
        float f3 = CornerRadius.getX-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float f4 = CornerRadius.getY-impl(roundRect.m884getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.getX-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs());
        float f5 = CornerRadius.getY-impl(roundRect.m885getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.getX-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.getY-impl(roundRect.m883getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.getY-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs());
        float f6 = CornerRadius.getX-impl(roundRect.m882getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f < f3 && f2 < f4) {
            return m1791isWithinEllipseVE1yxkc(f, f2, roundRect.m884getTopLeftCornerRadiuskKHJgLs(), f3, f4);
        }
        if (f < f6 && f2 > bottom2) {
            return m1791isWithinEllipseVE1yxkc(f, f2, roundRect.m882getBottomLeftCornerRadiuskKHJgLs(), f6, bottom2);
        }
        if (f > right && f2 < f5) {
            return m1791isWithinEllipseVE1yxkc(f, f2, roundRect.m885getTopRightCornerRadiuskKHJgLs(), right, f5);
        }
        if (f <= right2 || f2 <= bottom) {
            return true;
        }
        return m1791isWithinEllipseVE1yxkc(f, f2, roundRect.m883getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    /* renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m1791isWithinEllipseVE1yxkc(float f, float f2, long j, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float f7 = CornerRadius.getX-impl(j);
        float f8 = CornerRadius.getY-impl(j);
        return ((f5 * f5) / (f7 * f7)) + ((f6 * f6) / (f8 * f8)) <= 1.0f;
    }
}
