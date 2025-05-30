package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LazyStaggeredGridSpans {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int MaxCapacity = 131072;
    public static final int Unset = -1;
    private int anchor;

    @NotNull
    private int[] spans = new int[16];

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void ensureCapacity(int i, int i2) {
        if (!(i <= 131072)) {
            throw new IllegalArgumentException(("Requested span capacity " + i + " is larger than max supported: 131072!").toString());
        }
        int[] iArr = this.spans;
        if (iArr.length < i) {
            int length = iArr.length;
            while (length < i) {
                length *= 2;
            }
            this.spans = ArraysKt.copyInto$default(this.spans, new int[length], i2, 0, 0, 12, (Object) null);
        }
    }

    static /* synthetic */ void ensureCapacity$default(LazyStaggeredGridSpans lazyStaggeredGridSpans, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        lazyStaggeredGridSpans.ensureCapacity(i, i2);
    }

    public final void ensureValidIndex(int i) {
        int i2 = this.anchor;
        int i3 = i - i2;
        if (i3 >= 0 && i3 < 131072) {
            ensureCapacity$default(this, i3 + 1, 0, 2, null);
            return;
        }
        int max = Math.max(i - (this.spans.length / 2), 0);
        this.anchor = max;
        int i4 = max - i2;
        if (i4 >= 0) {
            int[] iArr = this.spans;
            if (i4 < iArr.length) {
                ArraysKt.copyInto(iArr, iArr, 0, i4, iArr.length);
            }
            int[] iArr2 = this.spans;
            ArraysKt.fill(iArr2, 0, Math.max(0, iArr2.length - i4), this.spans.length);
            return;
        }
        int i5 = -i4;
        int[] iArr3 = this.spans;
        if (iArr3.length + i5 < 131072) {
            ensureCapacity(iArr3.length + i5 + 1, i5);
            return;
        }
        if (i5 < iArr3.length) {
            ArraysKt.copyInto(iArr3, iArr3, i5, 0, iArr3.length - i5);
        }
        int[] iArr4 = this.spans;
        ArraysKt.fill(iArr4, 0, 0, Math.min(iArr4.length, i5));
    }

    public final int findNextItemIndex(int i, int i2) {
        int upperBound = upperBound();
        for (int i3 = i + 1; i3 < upperBound; i3++) {
            int span = getSpan(i3);
            if (span == i2 || span == -1) {
                return i3;
            }
        }
        return upperBound();
    }

    public final int findPreviousItemIndex(int i, int i2) {
        int span;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
            span = getSpan(i);
            if (span == i2) {
                break;
            }
        } while (span != -1);
        return i;
    }

    public final int getSpan(int i) {
        if (i < lowerBound() || i >= upperBound()) {
            return -1;
        }
        return this.spans[i - this.anchor] - 1;
    }

    public final int lowerBound() {
        return this.anchor;
    }

    public final void reset() {
        ArraysKt.fill$default(this.spans, 0, 0, 0, 6, (Object) null);
    }

    public final void setSpan(int i, int i2) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Negative spans are not supported".toString());
        }
        ensureValidIndex(i);
        this.spans[i - this.anchor] = i2 + 1;
    }

    public final int upperBound() {
        return this.anchor + this.spans.length;
    }
}
