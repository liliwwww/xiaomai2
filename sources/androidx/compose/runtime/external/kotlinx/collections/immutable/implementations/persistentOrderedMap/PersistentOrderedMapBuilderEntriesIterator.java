package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PersistentOrderedMapBuilderEntriesIterator<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {

    @NotNull
    private final PersistentOrderedMapBuilderLinksIterator<K, V> internal;

    public PersistentOrderedMapBuilderEntriesIterator(@NotNull PersistentOrderedMapBuilder<K, V> persistentOrderedMapBuilder) {
        Intrinsics.checkNotNullParameter(persistentOrderedMapBuilder, "map");
        this.internal = new PersistentOrderedMapBuilderLinksIterator<>(persistentOrderedMapBuilder.getFirstKey$runtime_release(), persistentOrderedMapBuilder);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.internal.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.internal.remove();
    }

    @Override // java.util.Iterator
    @NotNull
    public Map.Entry<K, V> next() {
        return new MutableMapEntry(this.internal.getBuilder$runtime_release().getHashMapBuilder$runtime_release(), this.internal.getLastIteratedKey$runtime_release(), this.internal.next());
    }
}
