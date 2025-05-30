package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentOrderedMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {

    @Nullable
    private Object firstKey;

    @NotNull
    private final PersistentHashMapBuilder<K, LinkedValue<V>> hashMapBuilder;

    @Nullable
    private Object lastKey;

    @NotNull
    private PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapBuilder(@NotNull PersistentOrderedMap<K, V> persistentOrderedMap) {
        Intrinsics.checkNotNullParameter(persistentOrderedMap, "map");
        this.map = persistentOrderedMap;
        this.firstKey = persistentOrderedMap.getFirstKey$runtime_release();
        this.lastKey = this.map.getLastKey$runtime_release();
        this.hashMapBuilder = this.map.getHashMap$runtime_release().builder();
    }

    @NotNull
    public PersistentMap<K, V> build() {
        PersistentOrderedMap<K, V> persistentOrderedMap;
        PersistentHashMap<K, LinkedValue<V>> build = this.hashMapBuilder.build();
        if (build == this.map.getHashMap$runtime_release()) {
            CommonFunctionsKt.assert(this.firstKey == this.map.getFirstKey$runtime_release());
            CommonFunctionsKt.assert(this.lastKey == this.map.getLastKey$runtime_release());
            persistentOrderedMap = this.map;
        } else {
            persistentOrderedMap = new PersistentOrderedMap<>(this.firstKey, this.lastKey, build);
        }
        this.map = persistentOrderedMap;
        return persistentOrderedMap;
    }

    public void clear() {
        this.hashMapBuilder.clear();
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this.firstKey = endOfChain;
        this.lastKey = endOfChain;
    }

    public boolean containsKey(Object obj) {
        return this.hashMapBuilder.containsKey(obj);
    }

    @Nullable
    public V get(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.hashMapBuilder.get(obj);
        if (linkedValue != null) {
            return (V) linkedValue.getValue();
        }
        return null;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentOrderedMapBuilderEntries(this);
    }

    @Nullable
    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    @NotNull
    public final PersistentHashMapBuilder<K, LinkedValue<V>> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    @NotNull
    public Set<K> getKeys() {
        return new PersistentOrderedMapBuilderKeys(this);
    }

    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @NotNull
    public Collection<V> getValues() {
        return new PersistentOrderedMapBuilderValues(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public V put(K k, V v) {
        LinkedValue linkedValue = (LinkedValue) this.hashMapBuilder.get(k);
        if (linkedValue != null) {
            if (linkedValue.getValue() == v) {
                return v;
            }
            ((PersistentHashMapBuilder<K, LinkedValue<V>>) this.hashMapBuilder).put(k, linkedValue.withValue(v));
            return (V) linkedValue.getValue();
        }
        if (isEmpty()) {
            this.firstKey = k;
            this.lastKey = k;
            ((PersistentHashMapBuilder<K, LinkedValue<V>>) this.hashMapBuilder).put(k, new LinkedValue(v));
            return null;
        }
        Object obj = this.lastKey;
        Object obj2 = this.hashMapBuilder.get(obj);
        Intrinsics.checkNotNull(obj2);
        CommonFunctionsKt.assert(!r2.getHasNext());
        this.hashMapBuilder.put(obj, ((LinkedValue) obj2).withNext(k));
        ((PersistentHashMapBuilder<K, LinkedValue<V>>) this.hashMapBuilder).put(k, new LinkedValue(v, obj));
        this.lastKey = k;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public V remove(Object obj) {
        LinkedValue linkedValue = (LinkedValue) this.hashMapBuilder.remove(obj);
        if (linkedValue == null) {
            return null;
        }
        if (linkedValue.getHasPrevious()) {
            Object obj2 = this.hashMapBuilder.get(linkedValue.getPrevious());
            Intrinsics.checkNotNull(obj2);
            this.hashMapBuilder.put(linkedValue.getPrevious(), ((LinkedValue) obj2).withNext(linkedValue.getNext()));
        } else {
            this.firstKey = linkedValue.getNext();
        }
        if (linkedValue.getHasNext()) {
            Object obj3 = this.hashMapBuilder.get(linkedValue.getNext());
            Intrinsics.checkNotNull(obj3);
            this.hashMapBuilder.put(linkedValue.getNext(), ((LinkedValue) obj3).withPrevious(linkedValue.getPrevious()));
        } else {
            this.lastKey = linkedValue.getPrevious();
        }
        return (V) linkedValue.getValue();
    }

    public final boolean remove(Object obj, Object obj2) {
        LinkedValue linkedValue = (LinkedValue) this.hashMapBuilder.get(obj);
        if (linkedValue == null || !Intrinsics.areEqual(linkedValue.getValue(), obj2)) {
            return false;
        }
        remove(obj);
        return true;
    }
}
