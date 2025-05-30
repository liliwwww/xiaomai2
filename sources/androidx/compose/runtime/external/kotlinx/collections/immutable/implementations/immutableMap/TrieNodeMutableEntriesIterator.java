package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TrieNodeMutableEntriesIterator<K, V> extends TrieNodeBaseIterator<K, V, Map.Entry<K, V>> {

    @NotNull
    private final PersistentHashMapBuilderEntriesIterator<K, V> parentIterator;

    public TrieNodeMutableEntriesIterator(@NotNull PersistentHashMapBuilderEntriesIterator<K, V> persistentHashMapBuilderEntriesIterator) {
        Intrinsics.checkNotNullParameter(persistentHashMapBuilderEntriesIterator, "parentIterator");
        this.parentIterator = persistentHashMapBuilderEntriesIterator;
    }

    @Override // java.util.Iterator
    @NotNull
    public Map.Entry<K, V> next() {
        CommonFunctionsKt.assert(hasNextKey());
        setIndex(getIndex() + 2);
        return new MutableMapEntry(this.parentIterator, getBuffer()[getIndex() - 2], getBuffer()[getIndex() - 1]);
    }
}
