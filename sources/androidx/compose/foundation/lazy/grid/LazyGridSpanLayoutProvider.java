package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyGridSpanLayoutProvider {

    @NotNull
    private final ArrayList<Bucket> buckets;

    @NotNull
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex;

    @NotNull
    private final LazyGridItemProvider itemProvider;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;

    @NotNull
    private List<GridItemSpan> previousDefaultSpans;
    private int slotsPerLine;

    /* compiled from: Taobao */
    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {

        @NotNull
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        @Override // androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxCurrentLineSpan(int i) {
            maxCurrentLineSpan = i;
        }

        public void setMaxLineSpan(int i) {
            maxLineSpan = i;
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;

        @NotNull
        private final List<GridItemSpan> spans;

        public LineConfiguration(int i, @NotNull List<GridItemSpan> list) {
            Intrinsics.checkNotNullParameter(list, "spans");
            this.firstItemIndex = i;
            this.spans = list;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        @NotNull
        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }
    }

    public LazyGridSpanLayoutProvider(@NotNull LazyGridItemProvider lazyGridItemProvider) {
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        this.itemProvider = lazyGridItemProvider;
        ArrayList<Bucket> arrayList = new ArrayList<>();
        arrayList.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.buckets = arrayList;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.previousDefaultSpans = CollectionsKt.emptyList();
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((getTotalSize() * 1.0d) / this.slotsPerLine)) + 1;
    }

    private final List<GridItemSpan> getDefaultSpans(int i) {
        if (i == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(GridItemSpan.box-impl(LazyGridSpanKt.GridItemSpan(1)));
        }
        this.previousDefaultSpans = arrayList;
        return arrayList;
    }

    private final void invalidateCache() {
        this.buckets.clear();
        this.buckets.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    private final int spanOf(int i, int i2) {
        LazyGridItemProvider lazyGridItemProvider = this.itemProvider;
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.INSTANCE;
        lazyGridItemSpanScopeImpl.setMaxCurrentLineSpan(i2);
        lazyGridItemSpanScopeImpl.setMaxLineSpan(this.slotsPerLine);
        return RangesKt.coerceIn(GridItemSpan.getCurrentLineSpan-impl(lazyGridItemProvider.getSpan-_-orMbw(lazyGridItemSpanScopeImpl, i)), 1, this.slotsPerLine);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[ADDED_TO_REGION, LOOP:0: B:26:0x00b0->B:54:0x00b0, LOOP_START, PHI: r2 r4 r5
  0x00b0: PHI (r2v10 int) = (r2v9 int), (r2v14 int) binds: [B:25:0x00ae, B:54:0x00b0] A[DONT_GENERATE, DONT_INLINE]
  0x00b0: PHI (r4v6 int) = (r4v5 int), (r4v7 int) binds: [B:25:0x00ae, B:54:0x00b0] A[DONT_GENERATE, DONT_INLINE]
  0x00b0: PHI (r5v6 int) = (r5v5 int), (r5v14 int) binds: [B:25:0x00ae, B:54:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ab  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration getLineConfiguration(int r12) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.getLineConfiguration(int):androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration");
    }

    /* renamed from: getLineIndexOfItem--_Ze7BM, reason: not valid java name */
    public final int m467getLineIndexOfItem_Ze7BM(final int i) {
        if (getTotalSize() <= 0) {
            return LineIndex.m475constructorimpl(0);
        }
        if (!(i < getTotalSize())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!this.itemProvider.getHasCustomSpans()) {
            return LineIndex.m475constructorimpl(i / this.slotsPerLine);
        }
        int binarySearch$default = CollectionsKt.binarySearch$default(this.buckets, 0, 0, new Function1<Bucket, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Integer invoke(@NotNull LazyGridSpanLayoutProvider.Bucket bucket) {
                Intrinsics.checkNotNullParameter(bucket, "it");
                return Integer.valueOf(bucket.getFirstItemIndex() - i);
            }
        }, 3, (Object) null);
        if (binarySearch$default < 0) {
            binarySearch$default = (-binarySearch$default) - 2;
        }
        int bucketSize = getBucketSize() * binarySearch$default;
        int firstItemIndex = this.buckets.get(binarySearch$default).getFirstItemIndex();
        if (!(firstItemIndex <= i)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = 0;
        while (firstItemIndex < i) {
            int i3 = firstItemIndex + 1;
            int spanOf = spanOf(firstItemIndex, this.slotsPerLine - i2);
            i2 += spanOf;
            int i4 = this.slotsPerLine;
            if (i2 >= i4) {
                if (i2 == i4) {
                    bucketSize++;
                    i2 = 0;
                } else {
                    bucketSize++;
                    i2 = spanOf;
                }
            }
            if (bucketSize % getBucketSize() == 0 && bucketSize / getBucketSize() >= this.buckets.size()) {
                this.buckets.add(new Bucket(i3 - (i2 > 0 ? 1 : 0), 0, 2, (DefaultConstructorMarker) null));
            }
            firstItemIndex = i3;
        }
        if (i2 + spanOf(i, this.slotsPerLine - i2) > this.slotsPerLine) {
            bucketSize++;
        }
        return LineIndex.m475constructorimpl(bucketSize);
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final int getTotalSize() {
        return this.itemProvider.getItemCount();
    }

    public final void setSlotsPerLine(int i) {
        if (i != this.slotsPerLine) {
            this.slotsPerLine = i;
            invalidateCache();
        }
    }
}
