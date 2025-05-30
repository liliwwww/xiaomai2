package androidx.compose.p004ui.graphics.colorspace;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class WhitePoint {

    /* renamed from: x */
    private final float f128x;

    /* renamed from: y */
    private final float f129y;

    public WhitePoint(float f, float f2) {
        this.f128x = f;
        this.f129y = f2;
    }

    public static /* synthetic */ WhitePoint copy$default(WhitePoint whitePoint, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = whitePoint.f128x;
        }
        if ((i & 2) != 0) {
            f2 = whitePoint.f129y;
        }
        return whitePoint.copy(f, f2);
    }

    public final float component1() {
        return this.f128x;
    }

    public final float component2() {
        return this.f129y;
    }

    @NotNull
    public final WhitePoint copy(float f, float f2) {
        return new WhitePoint(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) obj;
        return Float.compare(this.f128x, whitePoint.f128x) == 0 && Float.compare(this.f129y, whitePoint.f129y) == 0;
    }

    public final float getX() {
        return this.f128x;
    }

    public final float getY() {
        return this.f129y;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f128x) * 31) + Float.floatToIntBits(this.f129y);
    }

    @NotNull
    public String toString() {
        return "WhitePoint(x=" + this.f128x + ", y=" + this.f129y + ')';
    }

    @NotNull
    public final float[] toXyz$ui_graphics_release() {
        float f = this.f128x;
        float f2 = this.f129y;
        return new float[]{f / f2, 1.0f, ((1.0f - f) - f2) / f2};
    }

    public WhitePoint(float f, float f2, float f3) {
        this(f, f2, f3, f + f2 + f3);
    }

    private WhitePoint(float f, float f2, float f3, float f4) {
        this(f / f4, f2 / f4);
    }
}
