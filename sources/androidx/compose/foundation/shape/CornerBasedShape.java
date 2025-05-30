package androidx.compose.foundation.shape;

import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Outline;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
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
    /* renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo1677createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, @NotNull LayoutDirection layoutDirection);

    @Override // androidx.compose.p004ui.graphics.Shape
    @NotNull
    /* renamed from: createOutline-Pq9zytI */
    public final Outline mo1164createOutlinePq9zytI(long j, @NotNull LayoutDirection layoutDirection, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float mo1685toPxTmRCtEA = this.topStart.mo1685toPxTmRCtEA(j, density);
        float mo1685toPxTmRCtEA2 = this.topEnd.mo1685toPxTmRCtEA(j, density);
        float mo1685toPxTmRCtEA3 = this.bottomEnd.mo1685toPxTmRCtEA(j, density);
        float mo1685toPxTmRCtEA4 = this.bottomStart.mo1685toPxTmRCtEA(j, density);
        float m2624getMinDimensionimpl = Size.m2624getMinDimensionimpl(j);
        float f = mo1685toPxTmRCtEA + mo1685toPxTmRCtEA4;
        if (f > m2624getMinDimensionimpl) {
            float f2 = m2624getMinDimensionimpl / f;
            mo1685toPxTmRCtEA *= f2;
            mo1685toPxTmRCtEA4 *= f2;
        }
        float f3 = mo1685toPxTmRCtEA4;
        float f4 = mo1685toPxTmRCtEA2 + mo1685toPxTmRCtEA3;
        if (f4 > m2624getMinDimensionimpl) {
            float f5 = m2624getMinDimensionimpl / f4;
            mo1685toPxTmRCtEA2 *= f5;
            mo1685toPxTmRCtEA3 *= f5;
        }
        if (mo1685toPxTmRCtEA >= 0.0f && mo1685toPxTmRCtEA2 >= 0.0f && mo1685toPxTmRCtEA3 >= 0.0f && f3 >= 0.0f) {
            return mo1677createOutlineLjSzlW0(j, mo1685toPxTmRCtEA, mo1685toPxTmRCtEA2, mo1685toPxTmRCtEA3, f3, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + mo1685toPxTmRCtEA + ", topEnd = " + mo1685toPxTmRCtEA2 + ", bottomEnd = " + mo1685toPxTmRCtEA3 + ", bottomStart = " + f3 + ")!").toString());
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
