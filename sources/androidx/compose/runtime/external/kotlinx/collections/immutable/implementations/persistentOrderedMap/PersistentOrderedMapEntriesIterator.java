package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PersistentOrderedMapEntriesIterator<K, V> implements Iterator<Map.Entry<? extends K, ? extends V>>, KMappedMarker {

    @NotNull
    private final PersistentOrderedMapLinksIterator<K, V> internal;

    public PersistentOrderedMapEntriesIterator(@NotNull PersistentOrderedMap<K, V> persistentOrderedMap) {
        Intrinsics.checkNotNullParameter(persistentOrderedMap, "map");
        this.internal = new PersistentOrderedMapLinksIterator<>(persistentOrderedMap.getFirstKey$runtime_release(), persistentOrderedMap.getHashMap$runtime_release());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.internal.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    @NotNull
    public Map.Entry<K, V> next() {
        return new MapEntry(this.internal.getNextKey$runtime_release(), this.internal.next().getValue());
    }
}
