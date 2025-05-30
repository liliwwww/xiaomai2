package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PersistentHashMapValues<K, V> extends AbstractCollection<V> implements ImmutableCollection<V> {

    @NotNull
    private final PersistentHashMap<K, V> map;

    public PersistentHashMapValues(@NotNull PersistentHashMap<K, V> persistentHashMap) {
        Intrinsics.checkNotNullParameter(persistentHashMap, "map");
        this.map = persistentHashMap;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsValue(obj);
    }

    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<V> iterator() {
        return new PersistentHashMapValuesIterator(this.map.getNode$runtime_release());
    }
}
