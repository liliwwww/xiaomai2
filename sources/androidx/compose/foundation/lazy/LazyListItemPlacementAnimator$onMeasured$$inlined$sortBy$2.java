package androidx.compose.foundation.lazy;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2<T> implements Comparator {
    final /* synthetic */ LazyListItemPlacementAnimator this$0;

    public LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2(LazyListItemPlacementAnimator lazyListItemPlacementAnimator) {
        this.this$0 = lazyListItemPlacementAnimator;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues((Integer) LazyListItemPlacementAnimator.access$getKeyToIndexMap$p(this.this$0).get(((LazyMeasuredItem) t).getKey()), (Integer) LazyListItemPlacementAnimator.access$getKeyToIndexMap$p(this.this$0).get(((LazyMeasuredItem) t2).getKey()));
    }
}
