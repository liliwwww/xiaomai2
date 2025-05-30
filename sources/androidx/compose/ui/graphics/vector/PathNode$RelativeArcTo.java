package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$RelativeArcTo extends PathNode {
    private final float arcStartDx;
    private final float arcStartDy;
    private final float horizontalEllipseRadius;
    private final boolean isMoreThanHalf;
    private final boolean isPositiveArc;
    private final float theta;
    private final float verticalEllipseRadius;

    public PathNode$RelativeArcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.horizontalEllipseRadius = f;
        this.verticalEllipseRadius = f2;
        this.theta = f3;
        this.isMoreThanHalf = z;
        this.isPositiveArc = z2;
        this.arcStartDx = f4;
        this.arcStartDy = f5;
    }

    public static /* synthetic */ PathNode$RelativeArcTo copy$default(PathNode$RelativeArcTo pathNode$RelativeArcTo, float f, float f2, float f3, boolean z, boolean z2, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$RelativeArcTo.horizontalEllipseRadius;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$RelativeArcTo.verticalEllipseRadius;
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = pathNode$RelativeArcTo.theta;
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            z = pathNode$RelativeArcTo.isMoreThanHalf;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = pathNode$RelativeArcTo.isPositiveArc;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            f4 = pathNode$RelativeArcTo.arcStartDx;
        }
        float f8 = f4;
        if ((i & 64) != 0) {
            f5 = pathNode$RelativeArcTo.arcStartDy;
        }
        return pathNode$RelativeArcTo.copy(f, f6, f7, z3, z4, f8, f5);
    }

    public final float component1() {
        return this.horizontalEllipseRadius;
    }

    public final float component2() {
        return this.verticalEllipseRadius;
    }

    public final float component3() {
        return this.theta;
    }

    public final boolean component4() {
        return this.isMoreThanHalf;
    }

    public final boolean component5() {
        return this.isPositiveArc;
    }

    public final float component6() {
        return this.arcStartDx;
    }

    public final float component7() {
        return this.arcStartDy;
    }

    @NotNull
    public final PathNode$RelativeArcTo copy(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        return new PathNode$RelativeArcTo(f, f2, f3, z, z2, f4, f5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$RelativeArcTo)) {
            return false;
        }
        PathNode$RelativeArcTo pathNode$RelativeArcTo = (PathNode$RelativeArcTo) obj;
        return Float.compare(this.horizontalEllipseRadius, pathNode$RelativeArcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, pathNode$RelativeArcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, pathNode$RelativeArcTo.theta) == 0 && this.isMoreThanHalf == pathNode$RelativeArcTo.isMoreThanHalf && this.isPositiveArc == pathNode$RelativeArcTo.isPositiveArc && Float.compare(this.arcStartDx, pathNode$RelativeArcTo.arcStartDx) == 0 && Float.compare(this.arcStartDy, pathNode$RelativeArcTo.arcStartDy) == 0;
    }

    public final float getArcStartDx() {
        return this.arcStartDx;
    }

    public final float getArcStartDy() {
        return this.arcStartDy;
    }

    public final float getHorizontalEllipseRadius() {
        return this.horizontalEllipseRadius;
    }

    public final float getTheta() {
        return this.theta;
    }

    public final float getVerticalEllipseRadius() {
        return this.verticalEllipseRadius;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((Float.floatToIntBits(this.horizontalEllipseRadius) * 31) + Float.floatToIntBits(this.verticalEllipseRadius)) * 31) + Float.floatToIntBits(this.theta)) * 31;
        boolean z = this.isMoreThanHalf;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (floatToIntBits + i) * 31;
        boolean z2 = this.isPositiveArc;
        return ((((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + Float.floatToIntBits(this.arcStartDx)) * 31) + Float.floatToIntBits(this.arcStartDy);
    }

    public final boolean isMoreThanHalf() {
        return this.isMoreThanHalf;
    }

    public final boolean isPositiveArc() {
        return this.isPositiveArc;
    }

    @NotNull
    public String toString() {
        return "RelativeArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartDx=" + this.arcStartDx + ", arcStartDy=" + this.arcStartDy + ')';
    }
}
