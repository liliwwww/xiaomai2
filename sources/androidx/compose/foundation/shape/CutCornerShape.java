package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class CutCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CutCornerShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
    }

    @NotNull
    /* renamed from: createOutline-LjSzlW0, reason: not valid java name */
    public Outline m370createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (((f + f2) + f4) + f3 == 0.0f) {
            return new Outline.Rectangle(SizeKt.m924toRectuvyYCjk(j));
        }
        Path Path = AndroidPath_androidKt.Path();
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        float f5 = layoutDirection == layoutDirection2 ? f : f2;
        Path.moveTo(0.0f, f5);
        Path.lineTo(f5, 0.0f);
        if (layoutDirection == layoutDirection2) {
            f = f2;
        }
        Path.lineTo(Size.m903getWidthimpl(j) - f, 0.0f);
        Path.lineTo(Size.m903getWidthimpl(j), f);
        float f6 = layoutDirection == layoutDirection2 ? f3 : f4;
        Path.lineTo(Size.m903getWidthimpl(j), Size.m900getHeightimpl(j) - f6);
        Path.lineTo(Size.m903getWidthimpl(j) - f6, Size.m900getHeightimpl(j));
        if (layoutDirection == layoutDirection2) {
            f3 = f4;
        }
        Path.lineTo(f3, Size.m900getHeightimpl(j));
        Path.lineTo(0.0f, Size.m900getHeightimpl(j) - f3);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CutCornerShape)) {
            return false;
        }
        CutCornerShape cutCornerShape = (CutCornerShape) obj;
        return Intrinsics.areEqual(getTopStart(), cutCornerShape.getTopStart()) && Intrinsics.areEqual(getTopEnd(), cutCornerShape.getTopEnd()) && Intrinsics.areEqual(getBottomEnd(), cutCornerShape.getBottomEnd()) && Intrinsics.areEqual(getBottomStart(), cutCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "CutCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    @NotNull
    public CutCornerShape copy(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
        return new CutCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
