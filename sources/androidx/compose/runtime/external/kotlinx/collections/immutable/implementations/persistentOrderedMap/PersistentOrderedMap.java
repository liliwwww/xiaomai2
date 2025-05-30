package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Map;
import java.util.Set;
import kotlin.PublishedApi;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PersistentOrderedMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PersistentOrderedMap EMPTY;

    @Nullable
    private final Object firstKey;

    @NotNull
    private final PersistentHashMap<K, LinkedValue<V>> hashMap;

    @Nullable
    private final Object lastKey;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <K, V> PersistentOrderedMap<K, V> emptyOf$runtime_release() {
            PersistentOrderedMap<K, V> persistentOrderedMap = PersistentOrderedMap.EMPTY;
            Intrinsics.checkNotNull(persistentOrderedMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf>");
            return persistentOrderedMap;
        }
    }

    static {
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        EMPTY = new PersistentOrderedMap(endOfChain, endOfChain, PersistentHashMap.Companion.emptyOf$runtime_release());
    }

    public PersistentOrderedMap(@Nullable Object obj, @Nullable Object obj2, @NotNull PersistentHashMap<K, LinkedValue<V>> persistentHashMap) {
        Intrinsics.checkNotNullParameter(persistentHashMap, "hashMap");
        this.firstKey = obj;
        this.lastKey = obj2;
        this.hashMap = persistentHashMap;
    }

    private final ImmutableSet<Map.Entry<K, V>> createEntries() {
        return new PersistentOrderedMapEntries(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    @NotNull
    public PersistentMap.Builder<K, V> builder() {
        return new PersistentOrderedMapBuilder(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    @NotNull
    public PersistentMap<K, V> clear() {
        return Companion.emptyOf$runtime_release();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        LinkedValue<V> linkedValue = this.hashMap.get(obj);
        if (linkedValue != null) {
            return linkedValue.getValue();
        }
        return null;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    @Nullable
    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    @NotNull
    public final PersistentHashMap<K, LinkedValue<V>> getHashMap$runtime_release() {
        return this.hashMap;
    }

    @Nullable
    public final Object getLastKey$runtime_release() {
        return this.lastKey;
    }

    public int getSize() {
        return this.hashMap.size();
    }

    @Override // java.util.Map
    public final /* bridge */ ImmutableSet<K> keySet() {
        return m2430getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    public /* bridge */ /* synthetic */ PersistentMap put(Object obj, Object obj2) {
        return put((PersistentOrderedMap<K, V>) obj, obj2);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    @NotNull
    public PersistentMap<K, V> putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "m");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<K, V> builder = builder();
        builder.putAll(map);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    public /* bridge */ /* synthetic */ PersistentMap remove(Object obj) {
        return remove((PersistentOrderedMap<K, V>) obj);
    }

    @Override // java.util.Map
    public final /* bridge */ ImmutableCollection<V> values() {
        return m2431getValues();
    }

    @PublishedApi
    @NotNull
    /* renamed from: getEntries, reason: collision with other method in class */
    public final Set<Map.Entry<K, V>> m2429getEntries() {
        return createEntries();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    /* renamed from: getKeys, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<K> m2430getKeys() {
        return new PersistentOrderedMapKeys(this);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    @NotNull
    /* renamed from: getValues, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> m2431getValues() {
        return new PersistentOrderedMapValues(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    @NotNull
    public PersistentOrderedMap<K, V> put(K k, V v) {
        if (isEmpty()) {
            return new PersistentOrderedMap<>(k, k, this.hashMap.put((PersistentHashMap<K, LinkedValue<V>>) k, (K) new LinkedValue<>(v)));
        }
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue != null) {
            if (linkedValue.getValue() == v) {
                return this;
            }
            return new PersistentOrderedMap<>(this.firstKey, this.lastKey, this.hashMap.put((PersistentHashMap<K, LinkedValue<V>>) k, (K) linkedValue.withValue(v)));
        }
        Object obj = this.lastKey;
        LinkedValue<V> linkedValue2 = this.hashMap.get(obj);
        Intrinsics.checkNotNull(linkedValue2);
        return new PersistentOrderedMap<>(this.firstKey, k, this.hashMap.put((PersistentHashMap<K, LinkedValue<V>>) obj, (Object) linkedValue2.withNext(k)).put((PersistentHashMap) k, (K) new LinkedValue(v, obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    public /* bridge */ /* synthetic */ PersistentMap remove(Object obj, Object obj2) {
        return remove((PersistentOrderedMap<K, V>) obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    @NotNull
    public PersistentOrderedMap<K, V> remove(K k) {
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue == null) {
            return this;
        }
        PersistentHashMap<K, LinkedValue<V>> remove = this.hashMap.remove((PersistentHashMap<K, LinkedValue<V>>) k);
        ?? r5 = remove;
        if (linkedValue.getHasPrevious()) {
            Object obj = remove.get(linkedValue.getPrevious());
            Intrinsics.checkNotNull(obj);
            r5 = (PersistentHashMap<K, LinkedValue<V>>) remove.put((PersistentHashMap<K, LinkedValue<V>>) linkedValue.getPrevious(), (Object) ((LinkedValue) obj).withNext(linkedValue.getNext()));
        }
        PersistentHashMap persistentHashMap = r5;
        if (linkedValue.getHasNext()) {
            Object obj2 = r5.get(linkedValue.getNext());
            Intrinsics.checkNotNull(obj2);
            persistentHashMap = r5.put(linkedValue.getNext(), ((LinkedValue) obj2).withPrevious(linkedValue.getPrevious()));
        }
        return new PersistentOrderedMap<>(!linkedValue.getHasPrevious() ? linkedValue.getNext() : this.firstKey, !linkedValue.getHasNext() ? linkedValue.getPrevious() : this.lastKey, persistentHashMap);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap, java.util.Map
    @NotNull
    public PersistentOrderedMap<K, V> remove(K k, V v) {
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue != null && Intrinsics.areEqual(linkedValue.getValue(), v)) {
            return remove((PersistentOrderedMap<K, V>) k);
        }
        return this;
    }
}
