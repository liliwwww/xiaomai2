package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyGridScrollPosition {
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
    public LazyGridScrollPosition() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollPosition.<init>():void");
    }

    public LazyGridScrollPosition(int i, int i2) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ItemIndex.m439boximpl(ItemIndex.m441constructorimpl(i)), null, 2, null);
        this.index$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i2), null, 2, null);
        this.scrollOffset$delegate = mutableStateOf$default2;
    }

    /* renamed from: setIndex-YGsSkvE, reason: not valid java name */
    private final void m463setIndexYGsSkvE(int i) {
        this.index$delegate.setValue(ItemIndex.m439boximpl(i));
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i));
    }

    /* renamed from: update-yO3Fmg4, reason: not valid java name */
    private final void m464updateyO3Fmg4(int i, int i2) {
        if (!(((float) i) >= 0.0f)) {
            throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
        }
        if (!ItemIndex.m444equalsimpl0(i, m465getIndexVZbfaAc())) {
            m463setIndexYGsSkvE(i);
        }
        if (i2 != getScrollOffset()) {
            setScrollOffset(i2);
        }
    }

    /* renamed from: getIndex-VZbfaAc, reason: not valid java name */
    public final int m465getIndexVZbfaAc() {
        return ((ItemIndex) this.index$delegate.getValue()).m451unboximpl();
    }

    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* renamed from: requestPosition-yO3Fmg4, reason: not valid java name */
    public final void m466requestPositionyO3Fmg4(int i, int i2) {
        m464updateyO3Fmg4(i, i2);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateFromMeasureResult(@NotNull LazyGridMeasureResult lazyGridMeasureResult) {
        LazyMeasuredItem[] items;
        LazyMeasuredItem lazyMeasuredItem;
        LazyMeasuredItem[] items2;
        LazyMeasuredItem lazyMeasuredItem2;
        Intrinsics.checkNotNullParameter(lazyGridMeasureResult, "measureResult");
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        this.lastKnownFirstItemKey = (firstVisibleLine == null || (items2 = firstVisibleLine.getItems()) == null || (lazyMeasuredItem2 = (LazyMeasuredItem) ArraysKt.firstOrNull(items2)) == null) ? null : lazyMeasuredItem2.getKey();
        if (this.hadFirstNotEmptyLayout || lazyGridMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleLineScrollOffset = lazyGridMeasureResult.getFirstVisibleLineScrollOffset();
            int i = 0;
            if (!(((float) firstVisibleLineScrollOffset) >= 0.0f)) {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleLineScrollOffset + ')').toString());
            }
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                try {
                    LazyMeasuredLine firstVisibleLine2 = lazyGridMeasureResult.getFirstVisibleLine();
                    if (firstVisibleLine2 != null && (items = firstVisibleLine2.getItems()) != null && (lazyMeasuredItem = (LazyMeasuredItem) ArraysKt.firstOrNull(items)) != null) {
                        i = lazyMeasuredItem.getIndex-VZbfaAc();
                    }
                    m464updateyO3Fmg4(ItemIndex.m441constructorimpl(i), firstVisibleLineScrollOffset);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                }
            } finally {
                createNonObservableSnapshot.dispose();
            }
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyGridItemProvider lazyGridItemProvider) {
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                m464updateyO3Fmg4(ItemIndex.m441constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(lazyGridItemProvider, this.lastKnownFirstItemKey, m465getIndexVZbfaAc())), getScrollOffset());
                Unit unit = Unit.INSTANCE;
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } finally {
            createNonObservableSnapshot.dispose();
        }
    }

    public /* synthetic */ LazyGridScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
