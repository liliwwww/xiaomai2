package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyStaggeredGridScrollPosition {

    @NotNull
    private final Function2<Integer, Integer, int[]> fillIndices;
    private boolean hadFirstNotEmptyLayout;

    @NotNull
    private final MutableState indices$delegate;

    @Nullable
    private Object lastKnownFirstItemKey;

    @NotNull
    private final MutableState offsets$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridScrollPosition(@NotNull int[] iArr, @NotNull int[] iArr2, @NotNull Function2<? super Integer, ? super Integer, int[]> function2) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(iArr, "initialIndices");
        Intrinsics.checkNotNullParameter(iArr2, "initialOffsets");
        Intrinsics.checkNotNullParameter(function2, "fillIndices");
        this.fillIndices = function2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(iArr, null, 2, null);
        this.indices$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(iArr2, null, 2, null);
        this.offsets$delegate = mutableStateOf$default2;
    }

    private final void update(int[] iArr, int[] iArr2) {
        if (!Arrays.equals(iArr, getIndices())) {
            setIndices(iArr);
        }
        if (Arrays.equals(iArr2, getOffsets())) {
            return;
        }
        setOffsets(iArr2);
    }

    @NotNull
    public final int[] getIndices() {
        return (int[]) this.indices$delegate.getValue();
    }

    @NotNull
    public final int[] getOffsets() {
        return (int[]) this.offsets$delegate.getValue();
    }

    public final void requestPosition(int i, int i2) {
        int[] iArr = (int[]) this.fillIndices.invoke(Integer.valueOf(i), Integer.valueOf(getIndices().length));
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr2[i3] = i2;
        }
        update(iArr, iArr2);
        this.lastKnownFirstItemKey = null;
    }

    public final void setIndices(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.indices$delegate.setValue(iArr);
    }

    public final void setOffsets(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.offsets$delegate.setValue(iArr);
    }

    public final void updateFromMeasureResult(@NotNull LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridMeasureResult, "measureResult");
        int[] firstVisibleItemIndices = lazyStaggeredGridMeasureResult.getFirstVisibleItemIndices();
        if (firstVisibleItemIndices.length == 0) {
            throw new NoSuchElementException();
        }
        int i = firstVisibleItemIndices[0];
        int lastIndex = ArraysKt.getLastIndex(firstVisibleItemIndices);
        if (lastIndex != 0) {
            int i2 = i == -1 ? Integer.MAX_VALUE : i;
            IntIterator it = new IntRange(1, lastIndex).iterator();
            while (it.hasNext()) {
                int i3 = firstVisibleItemIndices[it.nextInt()];
                int i4 = i3 == -1 ? Integer.MAX_VALUE : i3;
                if (i2 > i4) {
                    i = i3;
                    i2 = i4;
                }
            }
        }
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureResult.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                lazyStaggeredGridItemInfo = null;
                break;
            }
            lazyStaggeredGridItemInfo = visibleItemsInfo.get(i5);
            if (lazyStaggeredGridItemInfo.getIndex() == i) {
                break;
            } else {
                i5++;
            }
        }
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2 = lazyStaggeredGridItemInfo;
        this.lastKnownFirstItemKey = lazyStaggeredGridItemInfo2 != null ? lazyStaggeredGridItemInfo2.getKey() : null;
        if (this.hadFirstNotEmptyLayout || lazyStaggeredGridMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                try {
                    update(lazyStaggeredGridMeasureResult.getFirstVisibleItemIndices(), lazyStaggeredGridMeasureResult.getFirstVisibleItemScrollOffsets());
                    Unit unit = Unit.INSTANCE;
                } finally {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                }
            } finally {
                createNonObservableSnapshot.dispose();
            }
        }
    }

    @ExperimentalFoundationApi
    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyLayoutItemProvider lazyLayoutItemProvider) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                Object obj = this.lastKnownFirstItemKey;
                Integer orNull = ArraysKt.getOrNull(getIndices(), 0);
                int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyLayoutItemProvider, obj, orNull != null ? orNull.intValue() : 0);
                if (!ArraysKt.contains(getIndices(), findIndexByKey)) {
                    update((int[]) this.fillIndices.invoke(Integer.valueOf(findIndexByKey), Integer.valueOf(getIndices().length)), getOffsets());
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            createNonObservableSnapshot.dispose();
        }
    }
}
