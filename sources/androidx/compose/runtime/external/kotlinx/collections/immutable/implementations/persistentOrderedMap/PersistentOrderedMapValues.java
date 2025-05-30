package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import java.util.Iterator;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentOrderedMapValues<K, V> extends AbstractCollection<V> implements ImmutableCollection<V> {

    @NotNull
    private final PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapValues(@NotNull PersistentOrderedMap<K, V> persistentOrderedMap) {
        Intrinsics.checkNotNullParameter(persistentOrderedMap, "map");
        this.map = persistentOrderedMap;
    }

    public boolean contains(Object obj) {
        return this.map.containsValue(obj);
    }

    public int getSize() {
        return this.map.size();
    }

    @NotNull
    public Iterator<V> iterator() {
        return new PersistentOrderedMapValuesIterator(this.map);
    }
}
