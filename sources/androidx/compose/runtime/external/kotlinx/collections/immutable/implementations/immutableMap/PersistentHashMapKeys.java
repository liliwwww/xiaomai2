package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Iterator;
import kotlin.collections.AbstractSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentHashMapKeys<K, V> extends AbstractSet<K> implements ImmutableSet<K> {

    @NotNull
    private final PersistentHashMap<K, V> map;

    public PersistentHashMapKeys(@NotNull PersistentHashMap<K, V> persistentHashMap) {
        Intrinsics.checkNotNullParameter(persistentHashMap, "map");
        this.map = persistentHashMap;
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
        return new PersistentHashMapKeysIterator(this.map.getNode$runtime_release());
    }
}
