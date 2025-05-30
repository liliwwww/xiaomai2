package androidx.compose.foundation.shape;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class CornerBasedShape implements Shape {
    public static final int $stable = 0;

    @NotNull
    private final CornerSize bottomEnd;

    @NotNull
    private final CornerSize bottomStart;

    @NotNull
    private final CornerSize topEnd;

    @NotNull
    private final CornerSize topStart;

    public CornerBasedShape(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4) {
        Intrinsics.checkNotNullParameter(cornerSize, "topStart");
        Intrinsics.checkNotNullParameter(cornerSize2, "topEnd");
        Intrinsics.checkNotNullParameter(cornerSize3, "bottomEnd");
        Intrinsics.checkNotNullParameter(cornerSize4, "bottomStart");
        this.topStart = cornerSize;
        this.topEnd = cornerSize2;
        this.bottomEnd = cornerSize3;
        this.bottomStart = cornerSize4;
    }

    public static /* synthetic */ CornerBasedShape copy$default(CornerBasedShape cornerBasedShape, CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i & 1) != 0) {
            cornerSize = cornerBasedShape.topStart;
        }
        if ((i & 2) != 0) {
            cornerSize2 = cornerBasedShape.topEnd;
        }
        if ((i & 4) != 0) {
            cornerSize3 = cornerBasedShape.bottomEnd;
        }
        if ((i & 8) != 0) {
            cornerSize4 = cornerBasedShape.bottomStart;
        }
        return cornerBasedShape.copy(cornerSize, cornerSize2, cornerSize3, cornerSize4);
    }

    @NotNull
    public final CornerBasedShape copy(@NotNull CornerSize cornerSize) {
        Intrinsics.checkNotNullParameter(cornerSize, "all");
        return copy(cornerSize, cornerSize, cornerSize, cornerSize);
    }

    @NotNull
    public abstract CornerBasedShape copy(@NotNull CornerSize cornerSize, @NotNull CornerSize cornerSize2, @NotNull CornerSize cornerSize3, @NotNull CornerSize cornerSize4);

    @NotNull
    /* renamed from: createOutline-LjSzlW0, reason: not valid java name */
    public abstract Outline mo534createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, @NotNull LayoutDirection layoutDirection);

    @NotNull
    /* renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public final Outline m535createOutlinePq9zytI(long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float mo536toPxTmRCtEA = this.topStart.mo536toPxTmRCtEA(j, density);
        float mo536toPxTmRCtEA2 = this.topEnd.mo536toPxTmRCtEA(j, density);
        float mo536toPxTmRCtEA3 = this.bottomEnd.mo536toPxTmRCtEA(j, density);
        float mo536toPxTmRCtEA4 = this.bottomStart.mo536toPxTmRCtEA(j, density);
        float f = Size.getMinDimension-impl(j);
        float f2 = mo536toPxTmRCtEA + mo536toPxTmRCtEA4;
        if (f2 > f) {
            float f3 = f / f2;
            mo536toPxTmRCtEA *= f3;
            mo536toPxTmRCtEA4 *= f3;
        }
        float f4 = mo536toPxTmRCtEA4;
        float f5 = mo536toPxTmRCtEA2 + mo536toPxTmRCtEA3;
        if (f5 > f) {
            float f6 = f / f5;
            mo536toPxTmRCtEA2 *= f6;
            mo536toPxTmRCtEA3 *= f6;
        }
        if (mo536toPxTmRCtEA >= 0.0f && mo536toPxTmRCtEA2 >= 0.0f && mo536toPxTmRCtEA3 >= 0.0f && f4 >= 0.0f) {
            return mo534createOutlineLjSzlW0(j, mo536toPxTmRCtEA, mo536toPxTmRCtEA2, mo536toPxTmRCtEA3, f4, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + mo536toPxTmRCtEA + ", topEnd = " + mo536toPxTmRCtEA2 + ", bottomEnd = " + mo536toPxTmRCtEA3 + ", bottomStart = " + f4 + ")!").toString());
    }

    @NotNull
    public final CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    @NotNull
    public final CornerSize getBottomStart() {
        return this.bottomStart;
    }

    @NotNull
    public final CornerSize getTopEnd() {
        return this.topEnd;
    }

    @NotNull
    public final CornerSize getTopStart() {
        return this.topStart;
    }
}
