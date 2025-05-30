package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Iterator;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentOrderedSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet$Builder<E> {

    @Nullable
    private Object firstElement;

    @NotNull
    private final PersistentHashMapBuilder<E, Links> hashMapBuilder;

    @Nullable
    private Object lastElement;

    @NotNull
    private PersistentOrderedSet<E> set;

    public PersistentOrderedSetBuilder(@NotNull PersistentOrderedSet<E> persistentOrderedSet) {
        Intrinsics.checkNotNullParameter(persistentOrderedSet, "set");
        this.set = persistentOrderedSet;
        this.firstElement = persistentOrderedSet.getFirstElement$runtime_release();
        this.lastElement = this.set.getLastElement$runtime_release();
        this.hashMapBuilder = this.set.getHashMap$runtime_release().builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean add(E e) {
        if (this.hashMapBuilder.containsKey(e)) {
            return false;
        }
        if (isEmpty()) {
            this.firstElement = e;
            this.lastElement = e;
            this.hashMapBuilder.put(e, new Links());
            return true;
        }
        Object obj = this.hashMapBuilder.get(this.lastElement);
        Intrinsics.checkNotNull(obj);
        this.hashMapBuilder.put(this.lastElement, ((Links) obj).withNext(e));
        this.hashMapBuilder.put(e, new Links(this.lastElement));
        this.lastElement = e;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.hashMapBuilder.clear();
        EndOfChain endOfChain = EndOfChain.INSTANCE;
        this.firstElement = endOfChain;
        this.lastElement = endOfChain;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.hashMapBuilder.containsKey(obj);
    }

    @Nullable
    public final Object getFirstElement$runtime_release() {
        return this.firstElement;
    }

    @NotNull
    public final PersistentHashMapBuilder<E, Links> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        Links links = (Links) this.hashMapBuilder.remove(obj);
        if (links == null) {
            return false;
        }
        if (links.getHasPrevious()) {
            Object obj2 = this.hashMapBuilder.get(links.getPrevious());
            Intrinsics.checkNotNull(obj2);
            this.hashMapBuilder.put(links.getPrevious(), ((Links) obj2).withNext(links.getNext()));
        } else {
            this.firstElement = links.getNext();
        }
        if (!links.getHasNext()) {
            this.lastElement = links.getPrevious();
            return true;
        }
        Object obj3 = this.hashMapBuilder.get(links.getNext());
        Intrinsics.checkNotNull(obj3);
        this.hashMapBuilder.put(links.getNext(), ((Links) obj3).withPrevious(links.getPrevious()));
        return true;
    }

    public final void setFirstElement$runtime_release(@Nullable Object obj) {
        this.firstElement = obj;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection$Builder
    @NotNull
    public PersistentSet<E> build() {
        PersistentOrderedSet<E> persistentOrderedSet;
        PersistentHashMap build = this.hashMapBuilder.build();
        if (build == this.set.getHashMap$runtime_release()) {
            CommonFunctionsKt.assert(this.firstElement == this.set.getFirstElement$runtime_release());
            CommonFunctionsKt.assert(this.lastElement == this.set.getLastElement$runtime_release());
            persistentOrderedSet = this.set;
        } else {
            persistentOrderedSet = new PersistentOrderedSet<>(this.firstElement, this.lastElement, build);
        }
        this.set = persistentOrderedSet;
        return persistentOrderedSet;
    }
}
