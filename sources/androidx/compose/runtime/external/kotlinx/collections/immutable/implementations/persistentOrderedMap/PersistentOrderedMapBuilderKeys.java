package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Unexpected interfaces in signature: [java.util.Set<K>, kotlin.jvm.internal.markers.KMutableSet] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PersistentOrderedMapBuilderKeys<K, V> extends AbstractMutableSet<K> {

    @NotNull
    private final PersistentOrderedMapBuilder<K, V> builder;

    public PersistentOrderedMapBuilderKeys(@NotNull PersistentOrderedMapBuilder<K, V> persistentOrderedMapBuilder) {
        Intrinsics.checkNotNullParameter(persistentOrderedMapBuilder, "builder");
        this.builder = persistentOrderedMapBuilder;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.builder.clear();
    }

    public boolean contains(Object obj) {
        return this.builder.containsKey(obj);
    }

    public int getSize() {
        return this.builder.size();
    }

    @NotNull
    public Iterator<K> iterator() {
        return new PersistentOrderedMapBuilderKeysIterator(this.builder);
    }

    public boolean remove(Object obj) {
        if (!this.builder.containsKey(obj)) {
            return false;
        }
        this.builder.remove(obj);
        return true;
    }
}
