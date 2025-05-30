package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AbsoluteRoundedCornerShape extends CornerBasedShape {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsoluteRoundedCornerShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        super(cornerSize, cornerSize2, cornerSize3, cornerSize4);
        Intrinsics.checkNotNullParameter(cornerSize, "topLeft");
        Intrinsics.checkNotNullParameter(cornerSize2, "topRight");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomRight");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomLeft");
    }

    /* renamed from: toRadius-Bz7bX_o, reason: not valid java name */
    private final long m367toRadiusBz7bX_o(float f) {
        return CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null);
    }

    @NotNull
    /* renamed from: createOutline-LjSzlW0, reason: not valid java name */
    public Outline m368createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return ((((f + f2) + f3) + f4) > 0.0f ? 1 : ((((f + f2) + f3) + f4) == 0.0f ? 0 : -1)) == 0 ? new Outline.Rectangle(SizeKt.m924toRectuvyYCjk(j)) : new Outline.Rounded(RoundRectKt.m886RoundRectZAM2FJo(SizeKt.m924toRectuvyYCjk(j), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f2, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f3, 0.0f, 2, null), CornerRadiusKt.CornerRadius$default(f4, 0.0f, 2, null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbsoluteRoundedCornerShape)) {
            return false;
        }
        AbsoluteRoundedCornerShape absoluteRoundedCornerShape = (AbsoluteRoundedCornerShape) obj;
        return Intrinsics.areEqual(getTopStart(), absoluteRoundedCornerShape.getTopStart()) && Intrinsics.areEqual(getTopEnd(), absoluteRoundedCornerShape.getTopEnd()) && Intrinsics.areEqual(getBottomEnd(), absoluteRoundedCornerShape.getBottomEnd()) && Intrinsics.areEqual(getBottomStart(), absoluteRoundedCornerShape.getBottomStart());
    }

    public int hashCode() {
        return (((((getTopStart().hashCode() * 31) + getTopEnd().hashCode()) * 31) + getBottomEnd().hashCode()) * 31) + getBottomStart().hashCode();
    }

    @NotNull
    public String toString() {
        return "AbsoluteRoundedCornerShape(topLeft = " + getTopStart() + ", topRight = " + getTopEnd() + ", bottomRight = " + getBottomEnd() + ", bottomLeft = " + getBottomStart() + ')';
    }

    @NotNull
    /* renamed from: copy, reason: merged with bridge method [inline-methods] */
    public AbsoluteRoundedCornerShape m369copy(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
        return new AbsoluteRoundedCornerShape(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }
}
