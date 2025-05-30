package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentOrderedMapKeys<K, V> extends AbstractSet<K> implements ImmutableSet<K> {

    @NotNull
    private final PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapKeys(@NotNull PersistentOrderedMap<K, V> persistentOrderedMap) {
        Intrinsics.checkNotNullParameter(persistentOrderedMap, "map");
        this.map = persistentOrderedMap;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    public int getSize() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<K> iterator() {
        return new PersistentOrderedMapKeysIterator(this.map);
    }
}
