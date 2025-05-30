package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$LineTo extends PathNode {
    private final float x;
    private final float y;

    public PathNode$LineTo(float f, float f2) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.x = f;
        this.y = f2;
    }

    public static /* synthetic */ PathNode$LineTo copy$default(PathNode$LineTo pathNode$LineTo, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$LineTo.x;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$LineTo.y;
        }
        return pathNode$LineTo.copy(f, f2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    @NotNull
    public final PathNode$LineTo copy(float f, float f2) {
        return new PathNode$LineTo(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$LineTo)) {
            return false;
        }
        PathNode$LineTo pathNode$LineTo = (PathNode$LineTo) obj;
        return Float.compare(this.x, pathNode$LineTo.x) == 0 && Float.compare(this.y, pathNode$LineTo.y) == 0;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y);
    }

    @NotNull
    public String toString() {
        return "LineTo(x=" + this.x + ", y=" + this.y + ')';
    }
}
