package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    /* renamed from: createOutline-LjSzlW0 */
    public Outline mo534createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (((f + f2) + f3) + f4 == 0.0f) {
            return new Outline$Rectangle(SizeKt.toRect-uvyYCjk(j));
        }
        Rect rect = SizeKt.toRect-uvyYCjk(j);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        return new Outline$Rounded(RoundRectKt.RoundRect-ZAM2FJo(rect, CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f : f2, 0.0f, 2, (Object) null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f2 : f, 0.0f, 2, (Object) null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f3 : f4, 0.0f, 2, (Object) null), CornerRadiusKt.CornerRadius$default(layoutDirection == layoutDirection2 ? f4 : f3, 0.0f, 2, (Object) null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) obj;
        return Intrinsics.areEqual(getTopStart(), roundedCornerShape.getTopStart()) && Intrinsics.areEqual(getTopEnd(), roundedCornerShape.getTopEnd()) && Intrinsics.areEqual(getBottomEnd(), roundedCornerShape.getBottomEnd()) && Intrinsics.areEqual(getBottomStart(), roundedCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "RoundedCornerShape(topStart = " + getTopStart() + ", topEnd = " + getTopEnd() + ", bottomEnd = " + getBottomEnd() + ", bottomStart = " + getBottomStart() + ')';
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    @NotNull
    public RoundedCornerShape copy(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
        return new RoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
