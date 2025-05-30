package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$CurveTo extends PathNode {
    private final float x1;
    private final float x2;
    private final float x3;
    private final float y1;
    private final float y2;
    private final float y3;

    public PathNode$CurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        super(true, false, 2, (DefaultConstructorMarker) null);
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
        this.x3 = f5;
        this.y3 = f6;
    }

    public static /* synthetic */ PathNode$CurveTo copy$default(PathNode$CurveTo pathNode$CurveTo, float f, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$CurveTo.x1;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$CurveTo.y1;
        }
        float f7 = f2;
        if ((i & 4) != 0) {
            f3 = pathNode$CurveTo.x2;
        }
        float f8 = f3;
        if ((i & 8) != 0) {
            f4 = pathNode$CurveTo.y2;
        }
        float f9 = f4;
        if ((i & 16) != 0) {
            f5 = pathNode$CurveTo.x3;
        }
        float f10 = f5;
        if ((i & 32) != 0) {
            f6 = pathNode$CurveTo.y3;
        }
        return pathNode$CurveTo.copy(f, f7, f8, f9, f10, f6);
    }

    public final float component1() {
        return this.x1;
    }

    public final float component2() {
        return this.y1;
    }

    public final float component3() {
        return this.x2;
    }

    public final float component4() {
        return this.y2;
    }

    public final float component5() {
        return this.x3;
    }

    public final float component6() {
        return this.y3;
    }

    @NotNull
    public final PathNode$CurveTo copy(float f, float f2, float f3, float f4, float f5, float f6) {
        return new PathNode$CurveTo(f, f2, f3, f4, f5, f6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$CurveTo)) {
            return false;
        }
        PathNode$CurveTo pathNode$CurveTo = (PathNode$CurveTo) obj;
        return Float.compare(this.x1, pathNode$CurveTo.x1) == 0 && Float.compare(this.y1, pathNode$CurveTo.y1) == 0 && Float.compare(this.x2, pathNode$CurveTo.x2) == 0 && Float.compare(this.y2, pathNode$CurveTo.y2) == 0 && Float.compare(this.x3, pathNode$CurveTo.x3) == 0 && Float.compare(this.y3, pathNode$CurveTo.y3) == 0;
    }

    public final float getX1() {
        return this.x1;
    }

    public final float getX2() {
        return this.x2;
    }

    public final float getX3() {
        return this.x3;
    }

    public final float getY1() {
        return this.y1;
    }

    public final float getY2() {
        return this.y2;
    }

    public final float getY3() {
        return this.y3;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.x1) * 31) + Float.floatToIntBits(this.y1)) * 31) + Float.floatToIntBits(this.x2)) * 31) + Float.floatToIntBits(this.y2)) * 31) + Float.floatToIntBits(this.x3)) * 31) + Float.floatToIntBits(this.y3);
    }

    @NotNull
    public String toString() {
        return "CurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ", x3=" + this.x3 + ", y3=" + this.y3 + ')';
    }
}
