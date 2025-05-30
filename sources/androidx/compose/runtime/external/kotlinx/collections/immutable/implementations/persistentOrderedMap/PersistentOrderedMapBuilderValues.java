package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import kotlin.collections.AbstractMutableCollection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Unexpected interfaces in signature: [java.util.Collection<V>, kotlin.jvm.internal.markers.KMutableCollection] */
/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PersistentOrderedMapBuilderValues<K, V> extends AbstractMutableCollection<V> {

    @NotNull
    private final PersistentOrderedMapBuilder<K, V> builder;

    public PersistentOrderedMapBuilderValues(@NotNull PersistentOrderedMapBuilder<K, V> persistentOrderedMapBuilder) {
        Intrinsics.checkNotNullParameter(persistentOrderedMapBuilder, "builder");
        this.builder = persistentOrderedMapBuilder;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.builder.clear();
    }

    public boolean contains(Object obj) {
        return this.builder.containsValue(obj);
    }

    public int getSize() {
        return this.builder.size();
    }

    @NotNull
    public Iterator<V> iterator() {
        return new PersistentOrderedMapBuilderValuesIterator(this.builder);
    }
}
