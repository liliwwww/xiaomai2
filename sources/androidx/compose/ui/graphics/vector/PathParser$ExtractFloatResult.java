package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PathParser$ExtractFloatResult {
    private int endPosition;
    private boolean endWithNegativeOrDot;

    /* JADX WARN: Multi-variable type inference failed */
    public PathParser$ExtractFloatResult() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public PathParser$ExtractFloatResult(int i, boolean z) {
        this.endPosition = i;
        this.endWithNegativeOrDot = z;
    }

    public static /* synthetic */ PathParser$ExtractFloatResult copy$default(PathParser$ExtractFloatResult pathParser$ExtractFloatResult, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pathParser$ExtractFloatResult.endPosition;
        }
        if ((i2 & 2) != 0) {
            z = pathParser$ExtractFloatResult.endWithNegativeOrDot;
        }
        return pathParser$ExtractFloatResult.copy(i, z);
    }

    public final int component1() {
        return this.endPosition;
    }

    public final boolean component2() {
        return this.endWithNegativeOrDot;
    }

    @NotNull
    public final PathParser$ExtractFloatResult copy(int i, boolean z) {
        return new PathParser$ExtractFloatResult(i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathParser$ExtractFloatResult)) {
            return false;
        }
        PathParser$ExtractFloatResult pathParser$ExtractFloatResult = (PathParser$ExtractFloatResult) obj;
        return this.endPosition == pathParser$ExtractFloatResult.endPosition && this.endWithNegativeOrDot == pathParser$ExtractFloatResult.endWithNegativeOrDot;
    }

    public final int getEndPosition() {
        return this.endPosition;
    }

    public final boolean getEndWithNegativeOrDot() {
        return this.endWithNegativeOrDot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.endPosition * 31;
        boolean z = this.endWithNegativeOrDot;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return i + i2;
    }

    public final void setEndPosition(int i) {
        this.endPosition = i;
    }

    public final void setEndWithNegativeOrDot(boolean z) {
        this.endWithNegativeOrDot = z;
    }

    @NotNull
    public String toString() {
        return "ExtractFloatResult(endPosition=" + this.endPosition + ", endWithNegativeOrDot=" + this.endWithNegativeOrDot + ')';
    }

    public /* synthetic */ PathParser$ExtractFloatResult(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z);
    }
}
