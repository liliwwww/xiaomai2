package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathNode$RelativeVerticalTo extends PathNode {
    private final float dy;

    public PathNode$RelativeVerticalTo(float f) {
        super(false, false, 3, (DefaultConstructorMarker) null);
        this.dy = f;
    }

    public static /* synthetic */ PathNode$RelativeVerticalTo copy$default(PathNode$RelativeVerticalTo pathNode$RelativeVerticalTo, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathNode$RelativeVerticalTo.dy;
        }
        return pathNode$RelativeVerticalTo.copy(f);
    }

    public final float component1() {
        return this.dy;
    }

    @NotNull
    public final PathNode$RelativeVerticalTo copy(float f) {
        return new PathNode$RelativeVerticalTo(f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PathNode$RelativeVerticalTo) && Float.compare(this.dy, ((PathNode$RelativeVerticalTo) obj).dy) == 0;
    }

    public final float getDy() {
        return this.dy;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.dy);
    }

    @NotNull
    public String toString() {
        return "RelativeVerticalTo(dy=" + this.dy + ')';
    }
}
