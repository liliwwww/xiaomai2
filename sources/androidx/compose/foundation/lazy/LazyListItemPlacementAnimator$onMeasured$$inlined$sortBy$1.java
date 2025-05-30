package androidx.compose.foundation.lazy;

import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1<T> implements Comparator {
    final /* synthetic */ Map $previousKeyToIndexMap$inlined;

    public LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1(Map map) {
        this.$previousKeyToIndexMap$inlined = map;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues((Integer) this.$previousKeyToIndexMap$inlined.get(((LazyListPositionedItem) t).getKey()), (Integer) this.$previousKeyToIndexMap$inlined.get(((LazyListPositionedItem) t2).getKey()));
    }
}
