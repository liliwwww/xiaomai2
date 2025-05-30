package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MutableIntervalList<T> implements IntervalList<T> {
    public static final int $stable = 8;

    @NotNull
    private final MutableVector<IntervalList.Interval<T>> intervals = new MutableVector<>(new IntervalList.Interval[16], 0);

    @Nullable
    private IntervalList.Interval<? extends T> lastInterval;
    private int size;

    private final void checkIndexBounds(int i) {
        boolean z = false;
        if (i >= 0 && i < getSize()) {
            z = true;
        }
        if (z) {
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i + ", size " + getSize());
    }

    private final boolean contains(IntervalList.Interval<? extends T> interval, int i) {
        return i < interval.getStartIndex() + interval.getSize() && interval.getStartIndex() <= i;
    }

    private final IntervalList.Interval<T> getIntervalForIndex(int i) {
        int binarySearch;
        IntervalList.Interval<? extends T> interval = this.lastInterval;
        if (interval != null && contains(interval, i)) {
            return interval;
        }
        MutableVector<IntervalList.Interval<T>> mutableVector = this.intervals;
        binarySearch = IntervalListKt.binarySearch(mutableVector, i);
        IntervalList.Interval interval2 = (IntervalList.Interval<? extends T>) mutableVector.getContent()[binarySearch];
        this.lastInterval = interval2;
        return interval2;
    }

    public final void addInterval(int i, T t) {
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("size should be >=0, but was " + i).toString());
        }
        if (i == 0) {
            return;
        }
        IntervalList.Interval<T> interval = new IntervalList.Interval<>(getSize(), i, t);
        this.size = getSize() + i;
        this.intervals.add(interval);
    }

    public void forEach(int i, int i2, @NotNull Function1<? super IntervalList.Interval<? extends T>, Unit> function1) {
        int binarySearch;
        Intrinsics.checkNotNullParameter(function1, "block");
        checkIndexBounds(i);
        checkIndexBounds(i2);
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("toIndex (" + i2 + ") should be not smaller than fromIndex (" + i + ')').toString());
        }
        binarySearch = IntervalListKt.binarySearch(this.intervals, i);
        int startIndex = this.intervals.getContent()[binarySearch].getStartIndex();
        while (startIndex <= i2) {
            IntervalList.Interval<T> interval = this.intervals.getContent()[binarySearch];
            function1.invoke(interval);
            startIndex += interval.getSize();
            binarySearch++;
        }
    }

    @NotNull
    public IntervalList.Interval<T> get(int i) {
        checkIndexBounds(i);
        return getIntervalForIndex(i);
    }

    public int getSize() {
        return this.size;
    }
}
