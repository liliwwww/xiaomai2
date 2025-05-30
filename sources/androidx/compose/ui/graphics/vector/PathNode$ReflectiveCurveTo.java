package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$ReflectiveCurveTo extends PathNode {
    private final float x1;
    private final float x2;
    private final float y1;
    private final float y2;

    public PathNode$ReflectiveCurveTo(float f, float f2, float f3, float f4) {
        super(true, false, 2, (DefaultConstructorMarker) null);
        this.x1 = f;
        this.y1 = f2;
        this.x2 = f3;
        this.y2 = f4;
    }

    public static /* synthetic */ PathNode$ReflectiveCurveTo copy$default(PathNode$ReflectiveCurveTo pathNode$ReflectiveCurveTo, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$ReflectiveCurveTo.x1;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$ReflectiveCurveTo.y1;
        }
        if ((i & 4) != 0) {
            f3 = pathNode$ReflectiveCurveTo.x2;
        }
        if ((i & 8) != 0) {
            f4 = pathNode$ReflectiveCurveTo.y2;
        }
        return pathNode$ReflectiveCurveTo.copy(f, f2, f3, f4);
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

    @NotNull
    public final PathNode$ReflectiveCurveTo copy(float f, float f2, float f3, float f4) {
        return new PathNode$ReflectiveCurveTo(f, f2, f3, f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$ReflectiveCurveTo)) {
            return false;
        }
        PathNode$ReflectiveCurveTo pathNode$ReflectiveCurveTo = (PathNode$ReflectiveCurveTo) obj;
        return Float.compare(this.x1, pathNode$ReflectiveCurveTo.x1) == 0 && Float.compare(this.y1, pathNode$ReflectiveCurveTo.y1) == 0 && Float.compare(this.x2, pathNode$ReflectiveCurveTo.x2) == 0 && Float.compare(this.y2, pathNode$ReflectiveCurveTo.y2) == 0;
    }

    public final float getX1() {
        return this.x1;
    }

    public final float getX2() {
        return this.x2;
    }

    public final float getY1() {
        return this.y1;
    }

    public final float getY2() {
        return this.y2;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.x1) * 31) + Float.floatToIntBits(this.y1)) * 31) + Float.floatToIntBits(this.x2)) * 31) + Float.floatToIntBits(this.y2);
    }

    @NotNull
    public String toString() {
        return "ReflectiveCurveTo(x1=" + this.x1 + ", y1=" + this.y1 + ", x2=" + this.x2 + ", y2=" + this.y2 + ')';
    }
}
