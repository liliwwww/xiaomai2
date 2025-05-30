package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyListScrollPosition {
    private boolean hadFirstNotEmptyLayout;

    @NotNull
    private final MutableState index$delegate;

    @Nullable
    private Object lastKnownFirstItemKey;

    @NotNull
    private final MutableState scrollOffset$delegate;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public LazyListScrollPosition() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListScrollPosition.<init>():void");
    }

    public LazyListScrollPosition(int i, int i2) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DataIndex.box-impl(DataIndex.constructor-impl(i)), null, 2, null);
        this.index$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i2), null, 2, null);
        this.scrollOffset$delegate = mutableStateOf$default2;
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i));
    }

    /* renamed from: update-AhXoVpI, reason: not valid java name */
    private final void m431updateAhXoVpI(int i, int i2) {
        if (!(((float) i) >= 0.0f)) {
            throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
        }
        if (!DataIndex.equals-impl0(i, m432getIndexjQJCoq8())) {
            m434setIndexZjPyQlc(i);
        }
        if (i2 != getScrollOffset()) {
            setScrollOffset(i2);
        }
    }

    /* renamed from: getIndex-jQJCoq8, reason: not valid java name */
    public final int m432getIndexjQJCoq8() {
        return ((DataIndex) this.index$delegate.getValue()).unbox-impl();
    }

    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* renamed from: requestPosition-AhXoVpI, reason: not valid java name */
    public final void m433requestPositionAhXoVpI(int i, int i2) {
        m431updateAhXoVpI(i, i2);
        this.lastKnownFirstItemKey = null;
    }

    /* renamed from: setIndex-ZjPyQlc, reason: not valid java name */
    public final void m434setIndexZjPyQlc(int i) {
        this.index$delegate.setValue(DataIndex.box-impl(i));
    }

    public final void updateFromMeasureResult(@NotNull LazyListMeasureResult lazyListMeasureResult) {
        Intrinsics.checkNotNullParameter(lazyListMeasureResult, "measureResult");
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        this.lastKnownFirstItemKey = firstVisibleItem != null ? firstVisibleItem.getKey() : null;
        if (this.hadFirstNotEmptyLayout || lazyListMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleItemScrollOffset = lazyListMeasureResult.getFirstVisibleItemScrollOffset();
            if (!(((float) firstVisibleItemScrollOffset) >= 0.0f)) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleItemScrollOffset + ')').toString());
            }
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                try {
                    LazyMeasuredItem firstVisibleItem2 = lazyListMeasureResult.getFirstVisibleItem();
                    m431updateAhXoVpI(DataIndex.constructor-impl(firstVisibleItem2 != null ? firstVisibleItem2.getIndex() : 0), firstVisibleItemScrollOffset);
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
    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyListItemProvider lazyListItemProvider) {
        Intrinsics.checkNotNullParameter(lazyListItemProvider, "itemProvider");
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                m431updateAhXoVpI(DataIndex.constructor-impl(LazyLayoutItemProviderKt.findIndexByKey(lazyListItemProvider, this.lastKnownFirstItemKey, m432getIndexjQJCoq8())), getScrollOffset());
                Unit unit = Unit.INSTANCE;
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            createNonObservableSnapshot.dispose();
        }
    }

    public /* synthetic */ LazyListScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
