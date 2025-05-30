package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
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
public final class PersistentHashMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final PersistentHashMap EMPTY = new PersistentHashMap(TrieNode.Companion.getEMPTY$runtime_release(), 0);

    @NotNull
    private final TrieNode<K, V> node;
    private final int size;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <K, V> PersistentHashMap<K, V> emptyOf$runtime_release() {
            PersistentHashMap<K, V> persistentHashMap = PersistentHashMap.EMPTY;
            Intrinsics.checkNotNull(persistentHashMap, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion.emptyOf>");
            return persistentHashMap;
        }
    }

    public PersistentHashMap(@NotNull TrieNode<K, V> trieNode, int i) {
        Intrinsics.checkNotNullParameter(trieNode, "node");
        this.node = trieNode;
        this.size = i;
    }

    private final ImmutableSet<Map.Entry<K, V>> createEntries() {
        return new PersistentHashMapEntries(this);
    }

    @NotNull
    public PersistentMap<K, V> clear() {
        return Companion.emptyOf$runtime_release();
    }

    public boolean containsKey(Object obj) {
        return this.node.containsKey(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    public final /* bridge */ ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Nullable
    public V get(Object obj) {
        return this.node.get(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @NotNull
    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    @NotNull
    public final TrieNode<K, V> getNode$runtime_release() {
        return this.node;
    }

    public int getSize() {
        return this.size;
    }

    public final /* bridge */ ImmutableSet<K> keySet() {
        return m775getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentMap put(Object obj, Object obj2) {
        return m777put((PersistentHashMap<K, V>) obj, obj2);
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
        return m778remove((PersistentHashMap<K, V>) obj);
    }

    public final /* bridge */ ImmutableCollection<V> values() {
        return m776getValues();
    }

    @NotNull
    public PersistentHashMapBuilder<K, V> builder() {
        return new PersistentHashMapBuilder<>(this);
    }

    @PublishedApi
    @NotNull
    /* renamed from: getEntries, reason: collision with other method in class */
    public final Set<Map.Entry<K, V>> m774getEntries() {
        return createEntries();
    }

    @NotNull
    /* renamed from: getKeys, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<K> m775getKeys() {
        return new PersistentHashMapKeys(this);
    }

    @NotNull
    /* renamed from: getValues, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> m776getValues() {
        return new PersistentHashMapValues(this);
    }

    @NotNull
    /* renamed from: put, reason: collision with other method in class */
    public PersistentHashMap<K, V> m777put(K k, V v) {
        TrieNode.ModificationResult<K, V> put = this.node.put(k != null ? k.hashCode() : 0, k, v, 0);
        return put == null ? this : new PersistentHashMap<>(put.getNode(), size() + put.getSizeDelta());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentMap remove(Object obj, Object obj2) {
        return m779remove((PersistentHashMap<K, V>) obj, obj2);
    }

    @NotNull
    /* renamed from: remove, reason: collision with other method in class */
    public PersistentHashMap<K, V> m778remove(K k) {
        TrieNode<K, V> remove = this.node.remove(k != null ? k.hashCode() : 0, k, 0);
        if (this.node == remove) {
            return this;
        }
        if (remove == null) {
            return Companion.emptyOf$runtime_release();
        }
        return new PersistentHashMap<>(remove, size() - 1);
    }

    @NotNull
    /* renamed from: remove, reason: collision with other method in class */
    public PersistentHashMap<K, V> m779remove(K k, V v) {
        TrieNode<K, V> remove = this.node.remove(k != null ? k.hashCode() : 0, k, v, 0);
        if (this.node == remove) {
            return this;
        }
        if (remove == null) {
            return Companion.emptyOf$runtime_release();
        }
        return new PersistentHashMap<>(remove, size() - 1);
    }
}
