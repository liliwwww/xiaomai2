package androidx.compose.ui.geometry;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RoundRect {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final RoundRect Zero = RoundRectKt.m888RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.getZero-kKHJgLs());

    @Nullable
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    private RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, j, j2, j3, j4);
    }

    @NotNull
    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    private final float minRadius(float f, float f2, float f3, float f4) {
        float f5 = f2 + f3;
        if (f5 > f4) {
            return !((f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1)) == 0) ? Math.min(f, f4 / f5) : f;
        }
        return f;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float minRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.getY-impl(this.bottomLeftCornerRadius), CornerRadius.getY-impl(this.topLeftCornerRadius), getHeight()), CornerRadius.getX-impl(this.topLeftCornerRadius), CornerRadius.getX-impl(this.topRightCornerRadius), getWidth()), CornerRadius.getY-impl(this.topRightCornerRadius), CornerRadius.getY-impl(this.bottomRightCornerRadius), getHeight()), CornerRadius.getX-impl(this.bottomRightCornerRadius), CornerRadius.getX-impl(this.bottomLeftCornerRadius), getWidth());
        RoundRect roundRect2 = new RoundRect(this.left * minRadius, this.top * minRadius, this.right * minRadius, this.bottom * minRadius, CornerRadiusKt.CornerRadius(CornerRadius.getX-impl(this.topLeftCornerRadius) * minRadius, CornerRadius.getY-impl(this.topLeftCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.getX-impl(this.topRightCornerRadius) * minRadius, CornerRadius.getY-impl(this.topRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.getX-impl(this.bottomRightCornerRadius) * minRadius, CornerRadius.getY-impl(this.bottomRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.getX-impl(this.bottomLeftCornerRadius) * minRadius, CornerRadius.getY-impl(this.bottomLeftCornerRadius) * minRadius), null);
        this._scaledRadiiRect = roundRect2;
        return roundRect2;
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* renamed from: component5-kKHJgLs, reason: not valid java name */
    public final long m876component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: component6-kKHJgLs, reason: not valid java name */
    public final long m877component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: component7-kKHJgLs, reason: not valid java name */
    public final long m878component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: component8-kKHJgLs, reason: not valid java name */
    public final long m879component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m880containsk4lQ0M(long j) {
        float m848getXimpl;
        float m849getYimpl;
        float f;
        float f2;
        if (Offset.m848getXimpl(j) < this.left || Offset.m848getXimpl(j) >= this.right || Offset.m849getYimpl(j) < this.top || Offset.m849getYimpl(j) >= this.bottom) {
            return false;
        }
        RoundRect scaledRadiiRect = scaledRadiiRect();
        if (Offset.m848getXimpl(j) < this.left + CornerRadius.getX-impl(scaledRadiiRect.topLeftCornerRadius) && Offset.m849getYimpl(j) < this.top + CornerRadius.getY-impl(scaledRadiiRect.topLeftCornerRadius)) {
            m848getXimpl = (Offset.m848getXimpl(j) - this.left) - CornerRadius.getX-impl(scaledRadiiRect.topLeftCornerRadius);
            m849getYimpl = (Offset.m849getYimpl(j) - this.top) - CornerRadius.getY-impl(scaledRadiiRect.topLeftCornerRadius);
            f = CornerRadius.getX-impl(scaledRadiiRect.topLeftCornerRadius);
            f2 = CornerRadius.getY-impl(scaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m848getXimpl(j) > this.right - CornerRadius.getX-impl(scaledRadiiRect.topRightCornerRadius) && Offset.m849getYimpl(j) < this.top + CornerRadius.getY-impl(scaledRadiiRect.topRightCornerRadius)) {
            m848getXimpl = (Offset.m848getXimpl(j) - this.right) + CornerRadius.getX-impl(scaledRadiiRect.topRightCornerRadius);
            m849getYimpl = (Offset.m849getYimpl(j) - this.top) - CornerRadius.getY-impl(scaledRadiiRect.topRightCornerRadius);
            f = CornerRadius.getX-impl(scaledRadiiRect.topRightCornerRadius);
            f2 = CornerRadius.getY-impl(scaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m848getXimpl(j) > this.right - CornerRadius.getX-impl(scaledRadiiRect.bottomRightCornerRadius) && Offset.m849getYimpl(j) > this.bottom - CornerRadius.getY-impl(scaledRadiiRect.bottomRightCornerRadius)) {
            m848getXimpl = (Offset.m848getXimpl(j) - this.right) + CornerRadius.getX-impl(scaledRadiiRect.bottomRightCornerRadius);
            m849getYimpl = (Offset.m849getYimpl(j) - this.bottom) + CornerRadius.getY-impl(scaledRadiiRect.bottomRightCornerRadius);
            f = CornerRadius.getX-impl(scaledRadiiRect.bottomRightCornerRadius);
            f2 = CornerRadius.getY-impl(scaledRadiiRect.bottomRightCornerRadius);
        } else {
            if (Offset.m848getXimpl(j) >= this.left + CornerRadius.getX-impl(scaledRadiiRect.bottomLeftCornerRadius) || Offset.m849getYimpl(j) <= this.bottom - CornerRadius.getY-impl(scaledRadiiRect.bottomLeftCornerRadius)) {
                return true;
            }
            m848getXimpl = (Offset.m848getXimpl(j) - this.left) - CornerRadius.getX-impl(scaledRadiiRect.bottomLeftCornerRadius);
            m849getYimpl = (Offset.m849getYimpl(j) - this.bottom) + CornerRadius.getY-impl(scaledRadiiRect.bottomLeftCornerRadius);
            f = CornerRadius.getX-impl(scaledRadiiRect.bottomLeftCornerRadius);
            f2 = CornerRadius.getY-impl(scaledRadiiRect.bottomLeftCornerRadius);
        }
        float f3 = m848getXimpl / f;
        float f4 = m849getYimpl / f2;
        return (f3 * f3) + (f4 * f4) <= 1.0f;
    }

    @NotNull
    /* renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m881copyMDFrsts(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        return new RoundRect(f, f2, f3, f4, j, j2, j3, j4, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.equals-impl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.equals-impl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.equals-impl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.equals-impl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m882getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m883getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    /* renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m884getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m885getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + CornerRadius.hashCode-impl(this.topLeftCornerRadius)) * 31) + CornerRadius.hashCode-impl(this.topRightCornerRadius)) * 31) + CornerRadius.hashCode-impl(this.bottomRightCornerRadius)) * 31) + CornerRadius.hashCode-impl(this.bottomLeftCornerRadius);
    }

    @NotNull
    public String toString() {
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.equals-impl0(j, j2) || !CornerRadius.equals-impl0(j2, j3) || !CornerRadius.equals-impl0(j3, j4)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.toString-impl(j)) + ", topRight=" + ((Object) CornerRadius.toString-impl(j2)) + ", bottomRight=" + ((Object) CornerRadius.toString-impl(j3)) + ", bottomLeft=" + ((Object) CornerRadius.toString-impl(j4)) + ')';
        }
        if (CornerRadius.getX-impl(j) == CornerRadius.getY-impl(j)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.getX-impl(j), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.getX-impl(j), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.getY-impl(j), 1) + ')';
    }

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, (i & 16) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : j, (i & 32) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : j2, (i & 64) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : j3, (i & 128) != 0 ? CornerRadius.Companion.getZero-kKHJgLs() : j4, null);
    }
}
