package androidx.compose.ui.node;

import androidx.compose.ui.node.HitTestResult;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class HitTestResult$SubList<T> implements List<T>, KMappedMarker {
    private final int maxIndex;
    private final int minIndex;
    final /* synthetic */ HitTestResult<T> this$0;

    public HitTestResult$SubList(HitTestResult hitTestResult, int i, int i2) {
        this.this$0 = hitTestResult;
        this.minIndex = i;
        this.maxIndex = i2;
    }

    @Override // java.util.List
    public void add(int i, T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
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
        return (T) HitTestResult.access$getValues$p(this.this$0)[i + this.minIndex];
    }

    public final int getMaxIndex() {
        return this.maxIndex;
    }

    public final int getMinIndex() {
        return this.minIndex;
    }

    public int getSize() {
        return this.maxIndex - this.minIndex;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i = this.minIndex;
        int i2 = this.maxIndex;
        if (i > i2) {
            return -1;
        }
        while (!Intrinsics.areEqual(HitTestResult.access$getValues$p(this.this$0)[i], obj)) {
            if (i == i2) {
                return -1;
            }
            i++;
        }
        return i - this.minIndex;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        HitTestResult<T> hitTestResult = this.this$0;
        int i = this.minIndex;
        return new HitTestResult.HitTestResultIterator(hitTestResult, i, i, this.maxIndex);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.maxIndex;
        int i2 = this.minIndex;
        if (i2 > i) {
            return -1;
        }
        while (!Intrinsics.areEqual(HitTestResult.access$getValues$p(this.this$0)[i], obj)) {
            if (i == i2) {
                return -1;
            }
            i--;
        }
        return i - this.minIndex;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<T> listIterator() {
        HitTestResult<T> hitTestResult = this.this$0;
        int i = this.minIndex;
        return new HitTestResult.HitTestResultIterator(hitTestResult, i, i, this.maxIndex);
    }

    @Override // java.util.List
    public T remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public T set(int i, T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<T> subList(int i, int i2) {
        HitTestResult<T> hitTestResult = this.this$0;
        int i3 = this.minIndex;
        return new HitTestResult$SubList(hitTestResult, i + i3, i3 + i2);
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
    @NotNull
    public ListIterator<T> listIterator(int i) {
        HitTestResult<T> hitTestResult = this.this$0;
        int i2 = this.minIndex;
        return new HitTestResult.HitTestResultIterator(hitTestResult, i + i2, i2, this.maxIndex);
    }
}
