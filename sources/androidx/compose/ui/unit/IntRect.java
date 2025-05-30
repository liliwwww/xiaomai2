package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class IntRect {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final IntRect Zero = new IntRect(0, 0, 0, 0);
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        public static /* synthetic */ void getZero$annotations() {
        }

        @NotNull
        public final IntRect getZero() {
            return IntRect.Zero;
        }
    }

    public IntRect(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public static /* synthetic */ IntRect copy$default(IntRect intRect, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = intRect.left;
        }
        if ((i5 & 2) != 0) {
            i2 = intRect.top;
        }
        if ((i5 & 4) != 0) {
            i3 = intRect.right;
        }
        if ((i5 & 8) != 0) {
            i4 = intRect.bottom;
        }
        return intRect.copy(i, i2, i3, i4);
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getRight$annotations() {
    }

    @Stable
    /* renamed from: getSize-YbymL2g$annotations, reason: not valid java name */
    public static /* synthetic */ void m2661getSizeYbymL2g$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations() {
    }

    @Stable
    public static /* synthetic */ void isEmpty$annotations() {
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.top;
    }

    public final int component3() {
        return this.right;
    }

    public final int component4() {
        return this.bottom;
    }

    /* renamed from: contains--gyyYBs, reason: not valid java name */
    public final boolean m2662containsgyyYBs(long j) {
        return IntOffset.m2643getXimpl(j) >= this.left && IntOffset.m2643getXimpl(j) < this.right && IntOffset.m2644getYimpl(j) >= this.top && IntOffset.m2644getYimpl(j) < this.bottom;
    }

    @NotNull
    public final IntRect copy(int i, int i2, int i3, int i4) {
        return new IntRect(i, i2, i3, i4);
    }

    @Stable
    @NotNull
    public final IntRect deflate(int i) {
        return inflate(-i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntRect)) {
            return false;
        }
        IntRect intRect = (IntRect) obj;
        return this.left == intRect.left && this.top == intRect.top && this.right == intRect.right && this.bottom == intRect.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    /* renamed from: getBottomCenter-nOcc-ac, reason: not valid java name */
    public final long m2663getBottomCenternOccac() {
        return IntOffsetKt.IntOffset(this.left + (getWidth() / 2), this.bottom);
    }

    /* renamed from: getBottomLeft-nOcc-ac, reason: not valid java name */
    public final long m2664getBottomLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.bottom);
    }

    /* renamed from: getBottomRight-nOcc-ac, reason: not valid java name */
    public final long m2665getBottomRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.bottom);
    }

    /* renamed from: getCenter-nOcc-ac, reason: not valid java name */
    public final long m2666getCenternOccac() {
        return IntOffsetKt.IntOffset(this.left + (getWidth() / 2), this.top + (getHeight() / 2));
    }

    /* renamed from: getCenterLeft-nOcc-ac, reason: not valid java name */
    public final long m2667getCenterLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.top + (getHeight() / 2));
    }

    /* renamed from: getCenterRight-nOcc-ac, reason: not valid java name */
    public final long m2668getCenterRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.top + (getHeight() / 2));
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getMaxDimension() {
        return Math.max(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getMinDimension() {
        return Math.min(Math.abs(getWidth()), Math.abs(getHeight()));
    }

    public final int getRight() {
        return this.right;
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m2669getSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public final int getTop() {
        return this.top;
    }

    /* renamed from: getTopCenter-nOcc-ac, reason: not valid java name */
    public final long m2670getTopCenternOccac() {
        return IntOffsetKt.IntOffset(this.left + (getWidth() / 2), this.top);
    }

    /* renamed from: getTopLeft-nOcc-ac, reason: not valid java name */
    public final long m2671getTopLeftnOccac() {
        return IntOffsetKt.IntOffset(this.left, this.top);
    }

    /* renamed from: getTopRight-nOcc-ac, reason: not valid java name */
    public final long m2672getTopRightnOccac() {
        return IntOffsetKt.IntOffset(this.right, this.top);
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @Stable
    @NotNull
    public final IntRect inflate(int i) {
        return new IntRect(this.left - i, this.top - i, this.right + i, this.bottom + i);
    }

    @Stable
    @NotNull
    public final IntRect intersect(@NotNull IntRect intRect) {
        Intrinsics.checkNotNullParameter(intRect, "other");
        return new IntRect(Math.max(this.left, intRect.left), Math.max(this.top, intRect.top), Math.min(this.right, intRect.right), Math.min(this.bottom, intRect.bottom));
    }

    public final boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public final boolean overlaps(@NotNull IntRect intRect) {
        Intrinsics.checkNotNullParameter(intRect, "other");
        return this.right > intRect.left && intRect.right > this.left && this.bottom > intRect.top && intRect.bottom > this.top;
    }

    @NotNull
    public String toString() {
        return "IntRect.fromLTRB(" + this.left + ", " + this.top + ", " + this.right + ", " + this.bottom + ')';
    }

    @Stable
    @NotNull
    public final IntRect translate(int i, int i2) {
        return new IntRect(this.left + i, this.top + i2, this.right + i, this.bottom + i2);
    }

    @Stable
    @NotNull
    /* renamed from: translate--gyyYBs, reason: not valid java name */
    public final IntRect m2673translategyyYBs(long j) {
        return new IntRect(this.left + IntOffset.m2643getXimpl(j), this.top + IntOffset.m2644getYimpl(j), this.right + IntOffset.m2643getXimpl(j), this.bottom + IntOffset.m2644getYimpl(j));
    }
}
