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
public final class MutableVector$SubList<T> implements List<T>, KMutableList {
    private int end;

    @NotNull
    private final List<T> list;
    private final int start;

    public MutableVector$SubList(@NotNull List<T> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.start = i;
        this.end = i2;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        List<T> list = this.list;
        int i = this.end;
        this.end = i + 1;
        list.add(i, t);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.list.addAll(i + this.start, collection);
        this.end += collection.size();
        return collection.size() > 0;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        int i = this.end - 1;
        int i2 = this.start;
        if (i2 <= i) {
            while (true) {
                this.list.remove(i);
                if (i == i2) {
                    break;
                } else {
                    i--;
                }
            }
        }
        this.end = this.start;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        int i = this.end;
        for (int i2 = this.start; i2 < i; i2++) {
            if (Intrinsics.areEqual(this.list.get(i2), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public T get(int i) {
        MutableVectorKt.access$checkIndex(this, i);
        return this.list.get(i + this.start);
    }

    public int getSize() {
        return this.end - this.start;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i = this.end;
        for (int i2 = this.start; i2 < i; i2++) {
            if (Intrinsics.areEqual(this.list.get(i2), obj)) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.end == this.start;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new MutableVector.VectorListIterator(this, 0);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.end - 1;
        int i2 = this.start;
        if (i2 > i) {
            return -1;
        }
        while (!Intrinsics.areEqual(this.list.get(i), obj)) {
            if (i == i2) {
                return -1;
            }
            i--;
        }
        return i - this.start;
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
        int i = this.end;
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return i != this.end;
    }

    public T removeAt(int i) {
        MutableVectorKt.access$checkIndex(this, i);
        this.end--;
        return this.list.remove(i + this.start);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        int i = this.end;
        int i2 = i - 1;
        int i3 = this.start;
        if (i3 <= i2) {
            while (true) {
                if (!collection.contains(this.list.get(i2))) {
                    this.list.remove(i2);
                    this.end--;
                }
                if (i2 == i3) {
                    break;
                }
                i2--;
            }
        }
        return i != this.end;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        MutableVectorKt.access$checkIndex(this, i);
        return this.list.set(i + this.start, t);
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
        this.list.add(i + this.start, t);
        this.end++;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator(int i) {
        return new MutableVector.VectorListIterator(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int i = this.end;
        for (int i2 = this.start; i2 < i; i2++) {
            if (Intrinsics.areEqual(this.list.get(i2), obj)) {
                this.list.remove(i2);
                this.end--;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        this.list.addAll(this.end, collection);
        this.end += collection.size();
        return collection.size() > 0;
    }
}
