package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PathParser$PathPoint {
    private float x;
    private float y;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PathParser$PathPoint() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.PathParser$PathPoint.<init>():void");
    }

    public PathParser$PathPoint(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public static /* synthetic */ PathParser$PathPoint copy$default(PathParser$PathPoint pathParser$PathPoint, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = pathParser$PathPoint.x;
        }
        if ((i & 2) != 0) {
            f2 = pathParser$PathPoint.y;
        }
        return pathParser$PathPoint.copy(f, f2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    @NotNull
    public final PathParser$PathPoint copy(float f, float f2) {
        return new PathParser$PathPoint(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathParser$PathPoint)) {
            return false;
        }
        PathParser$PathPoint pathParser$PathPoint = (PathParser$PathPoint) obj;
        return Float.compare(this.x, pathParser$PathPoint.x) == 0 && Float.compare(this.y, pathParser$PathPoint.y) == 0;
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

    public final void reset() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public final void setX(float f) {
        this.x = f;
    }

    public final void setY(float f) {
        this.y = f;
    }

    @NotNull
    public String toString() {
        return "PathPoint(x=" + this.x + ", y=" + this.y + ')';
    }

    public /* synthetic */ PathParser$PathPoint(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
    }
}
