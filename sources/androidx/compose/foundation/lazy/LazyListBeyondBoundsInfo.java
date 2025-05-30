package androidx.compose.foundation.lazy;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyListBeyondBoundsInfo {

    @NotNull
    private final MutableVector<Interval> beyondBoundsItems = new MutableVector<>(new Interval[16], 0);

    /* compiled from: Taobao */
    public static final class Interval {
        private final int end;
        private final int start;

        public Interval(int i, int i2) {
            this.start = i;
            this.end = i2;
            if (!(i >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i2 >= i)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        public static /* synthetic */ Interval copy$default(Interval interval, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = interval.start;
            }
            if ((i3 & 2) != 0) {
                i2 = interval.end;
            }
            return interval.copy(i, i2);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        @NotNull
        public final Interval copy(int i, int i2) {
            return new Interval(i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.start == interval.start && this.end == interval.end;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (this.start * 31) + this.end;
        }

        @NotNull
        public String toString() {
            return "Interval(start=" + this.start + ", end=" + this.end + ')';
        }
    }

    @NotNull
    public final Interval addInterval(int i, int i2) {
        Interval interval = new Interval(i, i2);
        this.beyondBoundsItems.add(interval);
        return interval;
    }

    public final int getEnd() {
        int end = ((Interval) this.beyondBoundsItems.first()).getEnd();
        MutableVector<Interval> mutableVector = this.beyondBoundsItems;
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                Interval interval = (Interval) content[i];
                if (interval.getEnd() > end) {
                    end = interval.getEnd();
                }
                i++;
            } while (i < size);
        }
        return end;
    }

    public final int getStart() {
        int start = ((Interval) this.beyondBoundsItems.first()).getStart();
        MutableVector<Interval> mutableVector = this.beyondBoundsItems;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i = 0;
            do {
                Interval interval = (Interval) content[i];
                if (interval.getStart() < start) {
                    start = interval.getStart();
                }
                i++;
            } while (i < size);
        }
        if (start >= 0) {
            return start;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean hasIntervals() {
        return this.beyondBoundsItems.isNotEmpty();
    }

    public final void removeInterval(@NotNull Interval interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        this.beyondBoundsItems.remove(interval);
    }
}
