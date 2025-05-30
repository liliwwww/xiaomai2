package androidx.compose.foundation.lazy.grid;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2<T> implements Comparator {
    final /* synthetic */ LazyGridItemPlacementAnimator this$0;

    public LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        this.this$0 = lazyGridItemPlacementAnimator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues((Integer) LazyGridItemPlacementAnimator.access$getKeyToIndexMap$p(this.this$0).get(((LazyMeasuredItem) t2).getKey()), (Integer) LazyGridItemPlacementAnimator.access$getKeyToIndexMap$p(this.this$0).get(((LazyMeasuredItem) t).getKey()));
    }
}
