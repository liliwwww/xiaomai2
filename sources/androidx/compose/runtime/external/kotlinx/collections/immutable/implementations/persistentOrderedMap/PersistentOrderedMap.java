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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentOrderedMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final PersistentOrderedMap EMPTY;

    @Nullable
    private final Object firstKey;

    @NotNull
    private final PersistentHashMap<K, LinkedValue<V>> hashMap;

    @Nullable
    private final Object lastKey;

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

    @NotNull
    public PersistentMap.Builder<K, V> builder() {
        return new PersistentOrderedMapBuilder(this);
    }

    @NotNull
    public PersistentMap<K, V> clear() {
        return Companion.emptyOf$runtime_release();
    }

    public boolean containsKey(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    public final /* bridge */ ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Nullable
    public V get(Object obj) {
        LinkedValue<V> linkedValue = this.hashMap.get(obj);
        if (linkedValue != null) {
            return (V) linkedValue.getValue();
        }
        return null;
    }

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

    public final /* bridge */ ImmutableSet<K> keySet() {
        return m789getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentMap put(Object obj, Object obj2) {
        return m791put((PersistentOrderedMap<K, V>) obj, obj2);
    }

    @NotNull
    public PersistentMap<K, V> putAll(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "m");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate, V of androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder builder = builder();
        builder.putAll(map);
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentMap remove(Object obj) {
        return m792remove((PersistentOrderedMap<K, V>) obj);
    }

    public final /* bridge */ ImmutableCollection<V> values() {
        return m790getValues();
    }

    @PublishedApi
    @NotNull
    /* renamed from: getEntries, reason: collision with other method in class */
    public final Set<Map.Entry<K, V>> m788getEntries() {
        return createEntries();
    }

    @NotNull
    /* renamed from: getKeys, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<K> m789getKeys() {
        return new PersistentOrderedMapKeys(this);
    }

    @NotNull
    /* renamed from: getValues, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> m790getValues() {
        return new PersistentOrderedMapValues(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: put, reason: collision with other method in class */
    public PersistentOrderedMap<K, V> m791put(K k, V v) {
        if (isEmpty()) {
            return new PersistentOrderedMap<>(k, k, this.hashMap.m777put((PersistentHashMap<K, LinkedValue<V>>) k, (K) new LinkedValue<>(v)));
        }
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue != null) {
            if (linkedValue.getValue() == v) {
                return this;
            }
            return new PersistentOrderedMap<>(this.firstKey, this.lastKey, this.hashMap.m777put((PersistentHashMap<K, LinkedValue<V>>) k, (K) linkedValue.withValue(v)));
        }
        Object obj = this.lastKey;
        LinkedValue<V> linkedValue2 = this.hashMap.get(obj);
        Intrinsics.checkNotNull(linkedValue2);
        return new PersistentOrderedMap<>(this.firstKey, k, this.hashMap.m777put((PersistentHashMap<K, LinkedValue<V>>) obj, (Object) linkedValue2.withNext(k)).m777put((PersistentHashMap) k, (K) new LinkedValue(v, obj)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentMap remove(Object obj, Object obj2) {
        return m793remove((PersistentOrderedMap<K, V>) obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @NotNull
    /* renamed from: remove, reason: collision with other method in class */
    public PersistentOrderedMap<K, V> m792remove(K k) {
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue == null) {
            return this;
        }
        PersistentHashMap<K, LinkedValue<V>> m778remove = this.hashMap.m778remove((PersistentHashMap<K, LinkedValue<V>>) k);
        ?? r5 = m778remove;
        if (linkedValue.getHasPrevious()) {
            Object obj = m778remove.get(linkedValue.getPrevious());
            Intrinsics.checkNotNull(obj);
            r5 = (PersistentHashMap<K, LinkedValue<V>>) m778remove.m777put((PersistentHashMap<K, LinkedValue<V>>) linkedValue.getPrevious(), (Object) ((LinkedValue) obj).withNext(linkedValue.getNext()));
        }
        PersistentHashMap persistentHashMap = r5;
        if (linkedValue.getHasNext()) {
            Object obj2 = r5.get(linkedValue.getNext());
            Intrinsics.checkNotNull(obj2);
            persistentHashMap = r5.m777put(linkedValue.getNext(), ((LinkedValue) obj2).withPrevious(linkedValue.getPrevious()));
        }
        return new PersistentOrderedMap<>(!linkedValue.getHasPrevious() ? linkedValue.getNext() : this.firstKey, !linkedValue.getHasNext() ? linkedValue.getPrevious() : this.lastKey, persistentHashMap);
    }

    @NotNull
    /* renamed from: remove, reason: collision with other method in class */
    public PersistentOrderedMap<K, V> m793remove(K k, V v) {
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue != null && Intrinsics.areEqual(linkedValue.getValue(), v)) {
            return m792remove((PersistentOrderedMap<K, V>) k);
        }
        return this;
    }
}
