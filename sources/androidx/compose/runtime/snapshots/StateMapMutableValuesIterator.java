package androidx.compose.runtime.snapshots;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class StateMapMutableValuesIterator<K, V> extends StateMapMutableIterator<K, V> implements Iterator<V>, KMutableIterator {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateMapMutableValuesIterator(@NotNull SnapshotStateMap<K, V> snapshotStateMap, @NotNull Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
        super(snapshotStateMap, it);
        Intrinsics.checkNotNullParameter(snapshotStateMap, "map");
        Intrinsics.checkNotNullParameter(it, "iterator");
    }

    @Override // java.util.Iterator
    public V next() {
        Map.Entry next = getNext();
        if (next == null) {
            throw new IllegalStateException();
        }
        advance();
        return (V) next.getValue();
    }
}
