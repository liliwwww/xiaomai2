package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentHashSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet$Builder<E> {
    private int modCount;

    @NotNull
    private TrieNode<E> node;

    @NotNull
    private MutabilityOwnership ownership;

    @NotNull
    private PersistentHashSet<E> set;
    private int size;

    public PersistentHashSetBuilder(@NotNull PersistentHashSet<E> persistentHashSet) {
        Intrinsics.checkNotNullParameter(persistentHashSet, "set");
        this.set = persistentHashSet;
        this.ownership = new MutabilityOwnership();
        this.node = this.set.getNode$runtime_release();
        this.size = this.set.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(E e) {
        int size = size();
        this.node = this.node.mutableAdd(e != null ? e.hashCode() : 0, e, 0, this);
        return size != size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentHashSet<E> persistentHashSet = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSet == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSet = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSet == null) {
            return super/*java.util.AbstractSet*/.addAll(collection);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, (DefaultConstructorMarker) null);
        int size = size();
        TrieNode<E> mutableAddAll = this.node.mutableAddAll(persistentHashSet.getNode$runtime_release(), 0, deltaCounter, this);
        int size2 = (collection.size() + size) - deltaCounter.getCount();
        if (size != size2) {
            this.node = mutableAddAll;
            setSize(size2);
        }
        return size != size();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        TrieNode<E> eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = eMPTY$runtime_release;
        setSize(0);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.node.contains(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return collection instanceof PersistentHashSet ? this.node.containsAll(((PersistentHashSet) collection).getNode$runtime_release(), 0) : collection instanceof PersistentHashSetBuilder ? this.node.containsAll(((PersistentHashSetBuilder) collection).node, 0) : super/*java.util.AbstractSet*/.containsAll(collection);
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    @NotNull
    public final TrieNode<E> getNode$runtime_release() {
        return this.node;
    }

    @NotNull
    public final MutabilityOwnership getOwnership$runtime_release() {
        return this.ownership;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new PersistentHashSetMutableIterator(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int size = size();
        this.node = this.node.mutableRemove(obj != null ? obj.hashCode() : 0, obj, 0, this);
        return size != size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentHashSet<E> persistentHashSet = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSet == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSet = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSet == null) {
            return super/*java.util.AbstractSet*/.removeAll(collection);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, (DefaultConstructorMarker) null);
        int size = size();
        Object mutableRemoveAll = this.node.mutableRemoveAll(persistentHashSet.getNode$runtime_release(), 0, deltaCounter, this);
        int count = size - deltaCounter.getCount();
        if (count == 0) {
            clear();
        } else if (count != size) {
            Intrinsics.checkNotNull(mutableRemoveAll, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            this.node = (TrieNode) mutableRemoveAll;
            setSize(count);
        }
        return size != size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentHashSet<E> persistentHashSet = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSet == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSet = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSet == null) {
            return super/*java.util.AbstractSet*/.retainAll(collection);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, (DefaultConstructorMarker) null);
        int size = size();
        Object mutableRetainAll = this.node.mutableRetainAll(persistentHashSet.getNode$runtime_release(), 0, deltaCounter, this);
        int count = deltaCounter.getCount();
        if (count == 0) {
            clear();
        } else if (count != size) {
            Intrinsics.checkNotNull(mutableRetainAll, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            this.node = (TrieNode) mutableRetainAll;
            setSize(count);
        }
        return size != size();
    }

    public void setSize(int i) {
        this.size = i;
        this.modCount++;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder
    @NotNull
    public PersistentHashSet<E> build() {
        PersistentHashSet<E> persistentHashSet;
        if (this.node == this.set.getNode$runtime_release()) {
            persistentHashSet = this.set;
        } else {
            this.ownership = new MutabilityOwnership();
            persistentHashSet = new PersistentHashSet<>(this.node, size());
        }
        this.set = persistentHashSet;
        return persistentHashSet;
    }
}
