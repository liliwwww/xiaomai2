package androidx.compose.ui.text.android.animation;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalPlatformTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Segment {
    public static final int $stable = 0;
    private final int bottom;
    private final int endOffset;
    private final int left;
    private final int right;
    private final int startOffset;
    private final int top;

    public Segment(int i, int i2, int i3, int i4, int i5, int i6) {
        this.startOffset = i;
        this.endOffset = i2;
        this.left = i3;
        this.top = i4;
        this.right = i5;
        this.bottom = i6;
    }

    public static /* synthetic */ Segment copy$default(Segment segment, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = segment.startOffset;
        }
        if ((i7 & 2) != 0) {
            i2 = segment.endOffset;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = segment.left;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = segment.top;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = segment.right;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = segment.bottom;
        }
        return segment.copy(i, i8, i9, i10, i11, i6);
    }

    public final int component1() {
        return this.startOffset;
    }

    public final int component2() {
        return this.endOffset;
    }

    public final int component3() {
        return this.left;
    }

    public final int component4() {
        return this.top;
    }

    public final int component5() {
        return this.right;
    }

    public final int component6() {
        return this.bottom;
    }

    @NotNull
    public final Segment copy(int i, int i2, int i3, int i4, int i5, int i6) {
        return new Segment(i, i2, i3, i4, i5, i6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Segment)) {
            return false;
        }
        Segment segment = (Segment) obj;
        return this.startOffset == segment.startOffset && this.endOffset == segment.endOffset && this.left == segment.left && this.top == segment.top && this.right == segment.right && this.bottom == segment.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getEndOffset() {
        return this.endOffset;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getStartOffset() {
        return this.startOffset;
    }

    public final int getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((((((this.startOffset * 31) + this.endOffset) * 31) + this.left) * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @NotNull
    public String toString() {
        return "Segment(startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    }
}
