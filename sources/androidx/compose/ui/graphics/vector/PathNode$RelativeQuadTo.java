package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$RelativeQuadTo extends PathNode {
    private final float dx1;
    private final float dx2;
    private final float dy1;
    private final float dy2;

    public PathNode$RelativeQuadTo(float f, float f2, float f3, float f4) {
        super(false, true, 1, (DefaultConstructorMarker) null);
        this.dx1 = f;
        this.dy1 = f2;
        this.dx2 = f3;
        this.dy2 = f4;
    }

    public static /* synthetic */ PathNode$RelativeQuadTo copy$default(PathNode$RelativeQuadTo pathNode$RelativeQuadTo, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$RelativeQuadTo.dx1;
        }
        if ((i & 2) != 0) {
            f2 = pathNode$RelativeQuadTo.dy1;
        }
        if ((i & 4) != 0) {
            f3 = pathNode$RelativeQuadTo.dx2;
        }
        if ((i & 8) != 0) {
            f4 = pathNode$RelativeQuadTo.dy2;
        }
        return pathNode$RelativeQuadTo.copy(f, f2, f3, f4);
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

    @NotNull
    public final PathNode$RelativeQuadTo copy(float f, float f2, float f3, float f4) {
        return new PathNode$RelativeQuadTo(f, f2, f3, f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathNode$RelativeQuadTo)) {
            return false;
        }
        PathNode$RelativeQuadTo pathNode$RelativeQuadTo = (PathNode$RelativeQuadTo) obj;
        return Float.compare(this.dx1, pathNode$RelativeQuadTo.dx1) == 0 && Float.compare(this.dy1, pathNode$RelativeQuadTo.dy1) == 0 && Float.compare(this.dx2, pathNode$RelativeQuadTo.dx2) == 0 && Float.compare(this.dy2, pathNode$RelativeQuadTo.dy2) == 0;
    }

    public final float getDx1() {
        return this.dx1;
    }

    public final float getDx2() {
        return this.dx2;
    }

    public final float getDy1() {
        return this.dy1;
    }

    public final float getDy2() {
        return this.dy2;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.dx1) * 31) + Float.floatToIntBits(this.dy1)) * 31) + Float.floatToIntBits(this.dx2)) * 31) + Float.floatToIntBits(this.dy2);
    }

    @NotNull
    public String toString() {
        return "RelativeQuadTo(dx1=" + this.dx1 + ", dy1=" + this.dy1 + ", dx2=" + this.dx2 + ", dy2=" + this.dy2 + ')';
    }
}
