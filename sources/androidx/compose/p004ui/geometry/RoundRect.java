package androidx.compose.p004ui.geometry;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public final class RoundRect {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final RoundRect Zero = RoundRectKt.m2610RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m2541getZerokKHJgLs());

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

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        @NotNull
        public final RoundRect getZero() {
            return RoundRect.Zero;
        }
    }

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
        float minRadius = minRadius(minRadius(minRadius(minRadius(1.0f, CornerRadius.m2532getYimpl(this.bottomLeftCornerRadius), CornerRadius.m2532getYimpl(this.topLeftCornerRadius), getHeight()), CornerRadius.m2531getXimpl(this.topLeftCornerRadius), CornerRadius.m2531getXimpl(this.topRightCornerRadius), getWidth()), CornerRadius.m2532getYimpl(this.topRightCornerRadius), CornerRadius.m2532getYimpl(this.bottomRightCornerRadius), getHeight()), CornerRadius.m2531getXimpl(this.bottomRightCornerRadius), CornerRadius.m2531getXimpl(this.bottomLeftCornerRadius), getWidth());
        RoundRect roundRect2 = new RoundRect(this.left * minRadius, this.top * minRadius, this.right * minRadius, this.bottom * minRadius, CornerRadiusKt.CornerRadius(CornerRadius.m2531getXimpl(this.topLeftCornerRadius) * minRadius, CornerRadius.m2532getYimpl(this.topLeftCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2531getXimpl(this.topRightCornerRadius) * minRadius, CornerRadius.m2532getYimpl(this.topRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2531getXimpl(this.bottomRightCornerRadius) * minRadius, CornerRadius.m2532getYimpl(this.bottomRightCornerRadius) * minRadius), CornerRadiusKt.CornerRadius(CornerRadius.m2531getXimpl(this.bottomLeftCornerRadius) * minRadius, CornerRadius.m2532getYimpl(this.bottomLeftCornerRadius) * minRadius), null);
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
    public final long m2598component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: component6-kKHJgLs, reason: not valid java name */
    public final long m2599component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: component7-kKHJgLs, reason: not valid java name */
    public final long m2600component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: component8-kKHJgLs, reason: not valid java name */
    public final long m2601component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m2602containsk4lQ0M(long j) {
        float m2556getXimpl;
        float m2557getYimpl;
        float m2531getXimpl;
        float m2532getYimpl;
        if (Offset.m2556getXimpl(j) < this.left || Offset.m2556getXimpl(j) >= this.right || Offset.m2557getYimpl(j) < this.top || Offset.m2557getYimpl(j) >= this.bottom) {
            return false;
        }
        RoundRect scaledRadiiRect = scaledRadiiRect();
        if (Offset.m2556getXimpl(j) < this.left + CornerRadius.m2531getXimpl(scaledRadiiRect.topLeftCornerRadius) && Offset.m2557getYimpl(j) < this.top + CornerRadius.m2532getYimpl(scaledRadiiRect.topLeftCornerRadius)) {
            m2556getXimpl = (Offset.m2556getXimpl(j) - this.left) - CornerRadius.m2531getXimpl(scaledRadiiRect.topLeftCornerRadius);
            m2557getYimpl = (Offset.m2557getYimpl(j) - this.top) - CornerRadius.m2532getYimpl(scaledRadiiRect.topLeftCornerRadius);
            m2531getXimpl = CornerRadius.m2531getXimpl(scaledRadiiRect.topLeftCornerRadius);
            m2532getYimpl = CornerRadius.m2532getYimpl(scaledRadiiRect.topLeftCornerRadius);
        } else if (Offset.m2556getXimpl(j) > this.right - CornerRadius.m2531getXimpl(scaledRadiiRect.topRightCornerRadius) && Offset.m2557getYimpl(j) < this.top + CornerRadius.m2532getYimpl(scaledRadiiRect.topRightCornerRadius)) {
            m2556getXimpl = (Offset.m2556getXimpl(j) - this.right) + CornerRadius.m2531getXimpl(scaledRadiiRect.topRightCornerRadius);
            m2557getYimpl = (Offset.m2557getYimpl(j) - this.top) - CornerRadius.m2532getYimpl(scaledRadiiRect.topRightCornerRadius);
            m2531getXimpl = CornerRadius.m2531getXimpl(scaledRadiiRect.topRightCornerRadius);
            m2532getYimpl = CornerRadius.m2532getYimpl(scaledRadiiRect.topRightCornerRadius);
        } else if (Offset.m2556getXimpl(j) > this.right - CornerRadius.m2531getXimpl(scaledRadiiRect.bottomRightCornerRadius) && Offset.m2557getYimpl(j) > this.bottom - CornerRadius.m2532getYimpl(scaledRadiiRect.bottomRightCornerRadius)) {
            m2556getXimpl = (Offset.m2556getXimpl(j) - this.right) + CornerRadius.m2531getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            m2557getYimpl = (Offset.m2557getYimpl(j) - this.bottom) + CornerRadius.m2532getYimpl(scaledRadiiRect.bottomRightCornerRadius);
            m2531getXimpl = CornerRadius.m2531getXimpl(scaledRadiiRect.bottomRightCornerRadius);
            m2532getYimpl = CornerRadius.m2532getYimpl(scaledRadiiRect.bottomRightCornerRadius);
        } else {
            if (Offset.m2556getXimpl(j) >= this.left + CornerRadius.m2531getXimpl(scaledRadiiRect.bottomLeftCornerRadius) || Offset.m2557getYimpl(j) <= this.bottom - CornerRadius.m2532getYimpl(scaledRadiiRect.bottomLeftCornerRadius)) {
                return true;
            }
            m2556getXimpl = (Offset.m2556getXimpl(j) - this.left) - CornerRadius.m2531getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            m2557getYimpl = (Offset.m2557getYimpl(j) - this.bottom) + CornerRadius.m2532getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
            m2531getXimpl = CornerRadius.m2531getXimpl(scaledRadiiRect.bottomLeftCornerRadius);
            m2532getYimpl = CornerRadius.m2532getYimpl(scaledRadiiRect.bottomLeftCornerRadius);
        }
        float f = m2556getXimpl / m2531getXimpl;
        float f2 = m2557getYimpl / m2532getYimpl;
        return (f * f) + (f2 * f2) <= 1.0f;
    }

    @NotNull
    /* renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m2603copyMDFrsts(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
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
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m2530equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m2530equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m2530equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m2530equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m2604getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m2605getBottomRightCornerRadiuskKHJgLs() {
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
    public final long m2606getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m2607getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((((((((((Float.floatToIntBits(this.left) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.right)) * 31) + Float.floatToIntBits(this.bottom)) * 31) + CornerRadius.m2533hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m2533hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m2533hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m2533hashCodeimpl(this.bottomLeftCornerRadius);
    }

    @NotNull
    public String toString() {
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m2530equalsimpl0(j, j2) || !CornerRadius.m2530equalsimpl0(j2, j3) || !CornerRadius.m2530equalsimpl0(j3, j4)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.m2537toStringimpl(j)) + ", topRight=" + ((Object) CornerRadius.m2537toStringimpl(j2)) + ", bottomRight=" + ((Object) CornerRadius.m2537toStringimpl(j3)) + ", bottomLeft=" + ((Object) CornerRadius.m2537toStringimpl(j4)) + ')';
        }
        if (CornerRadius.m2531getXimpl(j) == CornerRadius.m2532getYimpl(j)) {
            return "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2531getXimpl(j), 1) + ')';
        }
        return "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2531getXimpl(j), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2532getYimpl(j), 1) + ')';
    }

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, (i & 16) != 0 ? CornerRadius.Companion.m2541getZerokKHJgLs() : j, (i & 32) != 0 ? CornerRadius.Companion.m2541getZerokKHJgLs() : j2, (i & 64) != 0 ? CornerRadius.Companion.m2541getZerokKHJgLs() : j3, (i & 128) != 0 ? CornerRadius.Companion.m2541getZerokKHJgLs() : j4, null);
    }
}
