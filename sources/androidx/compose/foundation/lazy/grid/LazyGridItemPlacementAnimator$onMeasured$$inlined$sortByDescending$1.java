package androidx.compose.foundation.lazy.grid;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1<T> implements Comparator {
    final /* synthetic */ Map $previousKeyToIndexMap$inlined;

    public LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(Map map) {
        this.$previousKeyToIndexMap$inlined = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues((Integer) this.$previousKeyToIndexMap$inlined.get(((LazyGridPositionedItem) t2).getKey()), (Integer) this.$previousKeyToIndexMap$inlined.get(((LazyGridPositionedItem) t).getKey()));
    }
}
