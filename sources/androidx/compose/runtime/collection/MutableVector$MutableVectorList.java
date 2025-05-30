package androidx.compose.runtime.collection;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class MutableVector$MutableVectorList<T> implements List<T>, KMutableList {

    @NotNull
    private final MutableVector<T> vector;

    public MutableVector$MutableVectorList(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "vector");
        this.vector = mutableVector;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        return this.vector.add(t);
    }

    @Override // java.util.List
    public boolean addAll(int i, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.vector.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.vector.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.vector.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.vector.containsAll(collection);
    }

    @Override // java.util.List
    public T get(int i) {
        MutableVectorKt.access$checkIndex(this, i);
        return (T) this.vector.getContent()[i];
    }

    public int getSize() {
        return this.vector.getSize();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.vector.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.vector.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new MutableVector.VectorListIterator(this, 0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.vector.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        return new MutableVector.VectorListIterator(this, 0);
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.vector.removeAll(collection);
    }

    public T removeAt(int i) {
        MutableVectorKt.access$checkIndex(this, i);
        return (T) this.vector.removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.vector.retainAll(collection);
    }

    @Override // java.util.List
    public T set(int i, T t) {
        MutableVectorKt.access$checkIndex(this, i);
        return (T) this.vector.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    @NotNull
    public List<T> subList(int i, int i2) {
        MutableVectorKt.access$checkSubIndex(this, i, i2);
        return new MutableVector$SubList(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.util.List
    public void add(int i, T t) {
        this.vector.add(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.vector.addAll(collection);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i) {
        return new MutableVector.VectorListIterator(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.vector.remove(obj);
    }
}
