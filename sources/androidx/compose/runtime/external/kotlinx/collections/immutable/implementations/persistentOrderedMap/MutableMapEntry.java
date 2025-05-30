package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.MapEntry;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMutableMap$Entry] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MutableMapEntry<K, V> extends MapEntry<K, V> implements Map.Entry<K, V> {

    @NotNull
    private LinkedValue<V> links;

    @NotNull
    private final Map<K, LinkedValue<V>> mutableMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(@NotNull Map<K, LinkedValue<V>> map, K k, @NotNull LinkedValue<V> linkedValue) {
        super(k, linkedValue.getValue());
        Intrinsics.checkNotNullParameter(map, "mutableMap");
        Intrinsics.checkNotNullParameter(linkedValue, "links");
        this.mutableMap = map;
        this.links = linkedValue;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return (V) this.links.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map.Entry
    public V setValue(V v) {
        V v2 = (V) this.links.getValue();
        this.links = this.links.withValue(v);
        this.mutableMap.put(getKey(), this.links);
        return v2;
    }
}
