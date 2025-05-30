package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$VerticalTo extends PathNode {
    private final float y;

    public PathNode$VerticalTo(float f) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.y = f;
    }

    public static /* synthetic */ PathNode$VerticalTo copy$default(PathNode$VerticalTo pathNode$VerticalTo, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$VerticalTo.y;
        }
        return pathNode$VerticalTo.copy(f);
    }

    public final float component1() {
        return this.y;
    }

    @NotNull
    public final PathNode$VerticalTo copy(float f) {
        return new PathNode$VerticalTo(f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PathNode$VerticalTo) && Float.compare(this.y, ((PathNode$VerticalTo) obj).y) == 0;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.y);
    }

    @NotNull
    public String toString() {
        return "VerticalTo(y=" + this.y + ')';
    }
}
