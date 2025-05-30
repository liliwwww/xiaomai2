package androidx.compose.p004ui.platform;

import androidx.compose.p004ui.geometry.CornerRadius;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.RoundRect;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathOperation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m2531getXimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m2531getXimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m2531getXimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m2532getYimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m2532getYimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight() && CornerRadius.m2532getYimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m2532getYimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
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
        path3.mo2690opN5in7k0(path, path2, PathOperation.Companion.m3040getIntersectb3I0S0c());
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
        float m2531getXimpl = CornerRadius.m2531getXimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float m2532getYimpl = CornerRadius.m2532getYimpl(roundRect.m2606getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m2531getXimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs());
        float m2532getYimpl2 = CornerRadius.m2532getYimpl(roundRect.m2607getTopRightCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right2 = roundRect.getRight() - CornerRadius.m2531getXimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m2532getYimpl(roundRect.m2605getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m2532getYimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs());
        float m2531getXimpl2 = CornerRadius.m2531getXimpl(roundRect.m2604getBottomLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        if (f < m2531getXimpl && f2 < m2532getYimpl) {
            return m4561isWithinEllipseVE1yxkc(f, f2, roundRect.m2606getTopLeftCornerRadiuskKHJgLs(), m2531getXimpl, m2532getYimpl);
        }
        if (f < m2531getXimpl2 && f2 > bottom2) {
            return m4561isWithinEllipseVE1yxkc(f, f2, roundRect.m2604getBottomLeftCornerRadiuskKHJgLs(), m2531getXimpl2, bottom2);
        }
        if (f > right && f2 < m2532getYimpl2) {
            return m4561isWithinEllipseVE1yxkc(f, f2, roundRect.m2607getTopRightCornerRadiuskKHJgLs(), right, m2532getYimpl2);
        }
        if (f <= right2 || f2 <= bottom) {
            return true;
        }
        return m4561isWithinEllipseVE1yxkc(f, f2, roundRect.m2605getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    /* renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m4561isWithinEllipseVE1yxkc(float f, float f2, long j, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float m2531getXimpl = CornerRadius.m2531getXimpl(j);
        float m2532getYimpl = CornerRadius.m2532getYimpl(j);
        return ((f5 * f5) / (m2531getXimpl * m2531getXimpl)) + ((f6 * f6) / (m2532getYimpl * m2532getYimpl)) <= 1.0f;
    }
}
