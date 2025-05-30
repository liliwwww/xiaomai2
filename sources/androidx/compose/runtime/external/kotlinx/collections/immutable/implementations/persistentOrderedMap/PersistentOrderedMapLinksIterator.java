package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class PersistentOrderedMapLinksIterator<K, V> implements Iterator<LinkedValue<V>>, KMappedMarker {

    @NotNull
    private final Map<K, LinkedValue<V>> hashMap;
    private int index;

    @Nullable
    private Object nextKey;

    public PersistentOrderedMapLinksIterator(@Nullable Object obj, @NotNull Map<K, LinkedValue<V>> map) {
        Intrinsics.checkNotNullParameter(map, "hashMap");
        this.nextKey = obj;
        this.hashMap = map;
    }

    public final int getIndex$runtime_release() {
        return this.index;
    }

    @Nullable
    public final Object getNextKey$runtime_release() {
        return this.nextKey;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.hashMap.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex$runtime_release(int i) {
        this.index = i;
    }

    public final void setNextKey$runtime_release(@Nullable Object obj) {
        this.nextKey = obj;
    }

    @Override // java.util.Iterator
    @NotNull
    public LinkedValue<V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        LinkedValue<V> linkedValue = this.hashMap.get(this.nextKey);
        if (linkedValue != null) {
            LinkedValue<V> linkedValue2 = linkedValue;
            this.index++;
            this.nextKey = linkedValue2.getNext();
            return linkedValue2;
        }
        throw new ConcurrentModificationException("Hash code of a key (" + this.nextKey + ") has changed after it was added to the persistent map.");
    }
}
