package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$RelativeMoveTo extends PathNode {
    private final float dx;
    private final float dy;

    public PathNode$RelativeMoveTo(float f, float f2) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.dx = f;
        this.dy = f2;
    }

    public static /* synthetic */ PathNode$RelativeMoveTo copy$default(PathNode$RelativeMoveTo pathNode$RelativeMoveTo, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$RelativeMoveTo.dx;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$RelativeMoveTo.dy;
        }
        return pathNode$RelativeMoveTo.copy(f, f2);
    }

    public final float component1() {
        return this.dx;
    }

    public final float component2() {
        return this.dy;
    }

    @NotNull
    public final PathNode$RelativeMoveTo copy(float f, float f2) {
        return new PathNode$RelativeMoveTo(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$RelativeMoveTo)) {
            return false;
        }
        PathNode$RelativeMoveTo pathNode$RelativeMoveTo = (PathNode$RelativeMoveTo) obj;
        return Float.compare(this.dx, pathNode$RelativeMoveTo.dx) == 0 && Float.compare(this.dy, pathNode$RelativeMoveTo.dy) == 0;
    }

    public final float getDx() {
        return this.dx;
    }

    public final float getDy() {
        return this.dy;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.dx) * 31) + Float.floatToIntBits(this.dy);
    }

    @NotNull
    public String toString() {
        return "RelativeMoveTo(dx=" + this.dx + ", dy=" + this.dy + ')';
    }
}
