package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$RelativeCurveTo extends PathNode {
    private final float dx1;
    private final float dx2;
    private final float dx3;
    private final float dy1;
    private final float dy2;
    private final float dy3;

    public PathNode$RelativeCurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        super(true, false, 2, (DefaultConstructorMarker) null);
        this.dx1 = f;
        this.dy1 = f2;
        this.dx2 = f3;
        this.dy2 = f4;
        this.dx3 = f5;
        this.dy3 = f6;
    }

    public static /* synthetic */ PathNode$RelativeCurveTo copy$default(PathNode$RelativeCurveTo pathNode$RelativeCurveTo, float f, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$RelativeCurveTo.dx1;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$RelativeCurveTo.dy1;
        }
        float f7 = f2;
        if ((i & 4) != 0) {
            f3 = pathNode$RelativeCurveTo.dx2;
        }
        float f8 = f3;
        if ((i & 8) != 0) {
            f4 = pathNode$RelativeCurveTo.dy2;
        }
        float f9 = f4;
        if ((i & 16) != 0) {
            f5 = pathNode$RelativeCurveTo.dx3;
        }
        float f10 = f5;
        if ((i & 32) != 0) {
            f6 = pathNode$RelativeCurveTo.dy3;
        }
        return pathNode$RelativeCurveTo.copy(f, f7, f8, f9, f10, f6);
    }

    public final float component1() {
        return this.dx1;
    }

    public final float component2() {
        return this.dy1;
    }

    public final float component3() {
        return this.dx2;
    }

    public final float component4() {
        return this.dy2;
    }

    public final float component5() {
        return this.dx3;
    }

    public final float component6() {
        return this.dy3;
    }

    @NotNull
    public final PathNode$RelativeCurveTo copy(float f, float f2, float f3, float f4, float f5, float f6) {
        return new PathNode$RelativeCurveTo(f, f2, f3, f4, f5, f6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$RelativeCurveTo)) {
            return false;
        }
        PathNode$RelativeCurveTo pathNode$RelativeCurveTo = (PathNode$RelativeCurveTo) obj;
        return Float.compare(this.dx1, pathNode$RelativeCurveTo.dx1) == 0 && Float.compare(this.dy1, pathNode$RelativeCurveTo.dy1) == 0 && Float.compare(this.dx2, pathNode$RelativeCurveTo.dx2) == 0 && Float.compare(this.dy2, pathNode$RelativeCurveTo.dy2) == 0 && Float.compare(this.dx3, pathNode$RelativeCurveTo.dx3) == 0 && Float.compare(this.dy3, pathNode$RelativeCurveTo.dy3) == 0;
    }

    public final float getDx1() {
        return this.dx1;
    }

    public final float getDx2() {
        return this.dx2;
    }

    public final float getDx3() {
        return this.dx3;
    }

    public final float getDy1() {
        return this.dy1;
    }

    public final float getDy2() {
        return this.dy2;
    }

    public final float getDy3() {
        return this.dy3;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2)) * 31) + Float.floatToIntBits(this.dx3)) * 31) + Float.floatToIntBits(this.dy3);
    }

    @NotNull
    public String toString() {
        return "RelativeCurveTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ", dx3=" + this.dx3 + ", dy3=" + this.dy3 + ')';
    }
}
