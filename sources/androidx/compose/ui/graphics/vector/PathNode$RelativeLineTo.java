package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$RelativeLineTo extends PathNode {
    private final float dx;
    private final float dy;

    public PathNode$RelativeLineTo(float f, float f2) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.dx = f;
        this.dy = f2;
    }

    public static /* synthetic */ PathNode$RelativeLineTo copy$default(PathNode$RelativeLineTo pathNode$RelativeLineTo, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$RelativeLineTo.dx;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$RelativeLineTo.dy;
        }
        return pathNode$RelativeLineTo.copy(f, f2);
    }

    public final float component1() {
        return this.dx;
    }

    public final float component2() {
        return this.dy;
    }

    @NotNull
    public final PathNode$RelativeLineTo copy(float f, float f2) {
        return new PathNode$RelativeLineTo(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$RelativeLineTo)) {
            return false;
        }
        PathNode$RelativeLineTo pathNode$RelativeLineTo = (PathNode$RelativeLineTo) obj;
        return Float.compare(this.dx, pathNode$RelativeLineTo.dx) == 0 && Float.compare(this.dy, pathNode$RelativeLineTo.dy) == 0;
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
        return "RelativeLineTo(dx=" + this.dx + ", dy=" + this.dy + ')';
    }
}
