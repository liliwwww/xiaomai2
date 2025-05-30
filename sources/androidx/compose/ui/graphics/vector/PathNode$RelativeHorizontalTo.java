package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$RelativeHorizontalTo extends PathNode {
    private final float dx;

    public PathNode$RelativeHorizontalTo(float f) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.dx = f;
    }

    public static /* synthetic */ PathNode$RelativeHorizontalTo copy$default(PathNode$RelativeHorizontalTo pathNode$RelativeHorizontalTo, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$RelativeHorizontalTo.dx;
        }
        return pathNode$RelativeHorizontalTo.copy(f);
    }

    public final float component1() {
        return this.dx;
    }

    @NotNull
    public final PathNode$RelativeHorizontalTo copy(float f) {
        return new PathNode$RelativeHorizontalTo(f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PathNode$RelativeHorizontalTo) && Float.compare(this.dx, ((PathNode$RelativeHorizontalTo) obj).dx) == 0;
    }

    public final float getDx() {
        return this.dx;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.dx);
    }

    @NotNull
    public String toString() {
        return "RelativeHorizontalTo(dx=" + this.dx + ')';
    }
}
