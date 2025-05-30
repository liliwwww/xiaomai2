package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import kotlin.collections.AbstractMutableCollection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Unexpected interfaces in signature: [java.util.Collection<V>, kotlin.jvm.internal.markers.KMutableCollection] */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PersistentHashMapBuilderValues<K, V> extends AbstractMutableCollection<V> {

    @NotNull
    private final PersistentHashMapBuilder<K, V> builder;

    public PersistentHashMapBuilderValues(@NotNull PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        Intrinsics.checkNotNullParameter(persistentHashMapBuilder, "builder");
        this.builder = persistentHashMapBuilder;
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
        return new PersistentHashMapBuilderValuesIterator(this.builder);
    }
}
