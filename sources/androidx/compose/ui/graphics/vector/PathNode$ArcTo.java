package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$ArcTo extends PathNode {
    private final float arcStartX;
    private final float arcStartY;
    private final float horizontalEllipseRadius;
    private final boolean isMoreThanHalf;
    private final boolean isPositiveArc;
    private final float theta;
    private final float verticalEllipseRadius;

    public PathNode$ArcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.horizontalEllipseRadius = f;
        this.verticalEllipseRadius = f2;
        this.theta = f3;
        this.isMoreThanHalf = z;
        this.isPositiveArc = z2;
        this.arcStartX = f4;
        this.arcStartY = f5;
    }

    public static /* synthetic */ PathNode$ArcTo copy$default(PathNode$ArcTo pathNode$ArcTo, float f, float f2, float f3, boolean z, boolean z2, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$ArcTo.horizontalEllipseRadius;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$ArcTo.verticalEllipseRadius;
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = pathNode$ArcTo.theta;
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            z = pathNode$ArcTo.isMoreThanHalf;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            z2 = pathNode$ArcTo.isPositiveArc;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            f4 = pathNode$ArcTo.arcStartX;
        }
        float f8 = f4;
        if ((i & 64) != 0) {
            f5 = pathNode$ArcTo.arcStartY;
        }
        return pathNode$ArcTo.copy(f, f6, f7, z3, z4, f8, f5);
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
        return this.arcStartX;
    }

    public final float component7() {
        return this.arcStartY;
    }

    @NotNull
    public final PathNode$ArcTo copy(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        return new PathNode$ArcTo(f, f2, f3, z, z2, f4, f5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$ArcTo)) {
            return false;
        }
        PathNode$ArcTo pathNode$ArcTo = (PathNode$ArcTo) obj;
        return Float.compare(this.horizontalEllipseRadius, pathNode$ArcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, pathNode$ArcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, pathNode$ArcTo.theta) == 0 && this.isMoreThanHalf == pathNode$ArcTo.isMoreThanHalf && this.isPositiveArc == pathNode$ArcTo.isPositiveArc && Float.compare(this.arcStartX, pathNode$ArcTo.arcStartX) == 0 && Float.compare(this.arcStartY, pathNode$ArcTo.arcStartY) == 0;
    }

    public final float getArcStartX() {
        return this.arcStartX;
    }

    public final float getArcStartY() {
        return this.arcStartY;
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
        return ((((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + Float.floatToIntBits(this.arcStartX)) * 31) + Float.floatToIntBits(this.arcStartY);
    }

    public final boolean isMoreThanHalf() {
        return this.isMoreThanHalf;
    }

    public final boolean isPositiveArc() {
        return this.isPositiveArc;
    }

    @NotNull
    public String toString() {
        return "ArcTo(horizontalEllipseRadius=" + this.horizontalEllipseRadius + ", verticalEllipseRadius=" + this.verticalEllipseRadius + ", theta=" + this.theta + ", isMoreThanHalf=" + this.isMoreThanHalf + ", isPositiveArc=" + this.isPositiveArc + ", arcStartX=" + this.arcStartX + ", arcStartY=" + this.arcStartY + ')';
    }
}
