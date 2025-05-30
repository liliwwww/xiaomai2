package androidx.compose.runtime.collection;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;

    @NotNull
    private T[] content;

    @Nullable
    private List<T> list;
    private int size;

    /* compiled from: Taobao */
    private static final class VectorListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private int index;

        @NotNull
        private final List<T> list;

        public VectorListIterator(@NotNull List<T> list, int i) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
            this.index = i;
        }

        @Override // java.util.ListIterator
        public void add(T t) {
            this.list.add(this.index, t);
            this.index++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.list.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i = this.index;
            this.index = i + 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public T previous() {
            int i = this.index - 1;
            this.index = i;
            return this.list.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i = this.index - 1;
            this.index = i;
            this.list.remove(i);
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            this.list.set(this.index, t);
        }
    }

    @PublishedApi
    public MutableVector(@NotNull T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "content");
        this.content = tArr;
        this.size = i;
    }

    @PublishedApi
    public static /* synthetic */ void getContent$annotations() {
    }

    public final boolean add(T t) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i = this.size;
        tArr[i] = t;
        this.size = i + 1;
        return true;
    }

    public final boolean addAll(int i, @NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "elements");
        if (list.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + list.size());
        T[] tArr = this.content;
        if (i != this.size) {
            ArraysKt.copyInto(tArr, tArr, list.size() + i, i, this.size);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            tArr[i + i2] = list.get(i2);
        }
        this.size += list.size();
        return true;
    }

    public final boolean any(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size > 0) {
            T[] content = getContent();
            int i = 0;
            while (!((Boolean) function1.invoke(content[i])).booleanValue()) {
                i++;
                if (i >= size) {
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public final List<T> asMutableList() {
        List<T> list = this.list;
        if (list != null) {
            return list;
        }
        MutableVectorList mutableVectorList = new MutableVectorList(this);
        this.list = mutableVectorList;
        return mutableVectorList;
    }

    public final void clear() {
        T[] tArr = this.content;
        int size = getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                this.size = 0;
                return;
            }
            tArr[size] = null;
        }
    }

    public final boolean contains(T t) {
        int size = getSize() - 1;
        if (size >= 0) {
            for (int i = 0; !Intrinsics.areEqual(getContent()[i], t); i++) {
                if (i != size) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean containsAll(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "elements");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean contentEquals(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "other");
        if (mutableVector.size != this.size) {
            return false;
        }
        int size = getSize() - 1;
        if (size >= 0) {
            for (int i = 0; Intrinsics.areEqual(mutableVector.getContent()[i], getContent()[i]); i++) {
                if (i != size) {
                }
            }
            return false;
        }
        return true;
    }

    public final void ensureCapacity(int i) {
        T[] tArr = this.content;
        if (tArr.length < i) {
            T[] tArr2 = (T[]) Arrays.copyOf(tArr, Math.max(i, tArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(this, newSize)");
            this.content = tArr2;
        }
    }

    public final T first() {
        if (isEmpty()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return getContent()[0];
    }

    @Nullable
    public final T firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[0];
    }

    public final <R> R fold(R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        int size = getSize();
        if (size > 0) {
            int i = 0;
            T[] content = getContent();
            do {
                r = (R) function2.invoke(r, content[i]);
                i++;
            } while (i < size);
        }
        return r;
    }

    public final <R> R foldIndexed(R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(function3, "operation");
        int size = getSize();
        if (size > 0) {
            int i = 0;
            T[] content = getContent();
            do {
                r = (R) function3.invoke(Integer.valueOf(i), r, content[i]);
                i++;
            } while (i < size);
        }
        return r;
    }

    public final <R> R foldRight(R r, @NotNull Function2<? super T, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        int size = getSize();
        if (size > 0) {
            int i = size - 1;
            T[] content = getContent();
            do {
                r = (R) function2.invoke(content[i], r);
                i--;
            } while (i >= 0);
        }
        return r;
    }

    public final <R> R foldRightIndexed(R r, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(function3, "operation");
        int size = getSize();
        if (size > 0) {
            int i = size - 1;
            T[] content = getContent();
            do {
                r = (R) function3.invoke(Integer.valueOf(i), content[i], r);
                i--;
            } while (i >= 0);
        }
        return r;
    }

    public final void forEach(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int size = getSize();
        if (size > 0) {
            int i = 0;
            T[] content = getContent();
            do {
                function1.invoke(content[i]);
                i++;
            } while (i < size);
        }
    }

    public final void forEachIndexed(@NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size = getSize();
        if (size > 0) {
            int i = 0;
            T[] content = getContent();
            do {
                function2.invoke(Integer.valueOf(i), content[i]);
                i++;
            } while (i < size);
        }
    }

    public final void forEachReversed(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        int size = getSize();
        if (size > 0) {
            int i = size - 1;
            T[] content = getContent();
            do {
                function1.invoke(content[i]);
                i--;
            } while (i >= 0);
        }
    }

    public final void forEachReversedIndexed(@NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (getSize() > 0) {
            int size = getSize() - 1;
            T[] content = getContent();
            do {
                function2.invoke(Integer.valueOf(size), content[size]);
                size--;
            } while (size >= 0);
        }
    }

    public final T get(int i) {
        return getContent()[i];
    }

    @NotNull
    public final T[] getContent() {
        return this.content;
    }

    @NotNull
    public final IntRange getIndices() {
        return new IntRange(0, getSize() - 1);
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final int getSize() {
        return this.size;
    }

    public final int indexOf(T t) {
        int i = this.size;
        if (i <= 0) {
            return -1;
        }
        int i2 = 0;
        T[] tArr = this.content;
        while (!Intrinsics.areEqual(t, tArr[i2])) {
            i2++;
            if (i2 >= i) {
                return -1;
            }
        }
        return i2;
    }

    public final int indexOfFirst(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size <= 0) {
            return -1;
        }
        int i = 0;
        T[] content = getContent();
        while (!((Boolean) function1.invoke(content[i])).booleanValue()) {
            i++;
            if (i >= size) {
                return -1;
            }
        }
        return i;
    }

    public final int indexOfLast(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size <= 0) {
            return -1;
        }
        int i = size - 1;
        T[] content = getContent();
        while (!((Boolean) function1.invoke(content[i])).booleanValue()) {
            i--;
            if (i < 0) {
                return -1;
            }
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size != 0;
    }

    public final T last() {
        if (isEmpty()) {
            throw new NoSuchElementException("MutableVector is empty.");
        }
        return getContent()[getSize() - 1];
    }

    public final int lastIndexOf(T t) {
        int i = this.size;
        if (i <= 0) {
            return -1;
        }
        int i2 = i - 1;
        T[] tArr = this.content;
        while (!Intrinsics.areEqual(t, tArr[i2])) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
        }
        return i2;
    }

    @Nullable
    public final T lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[getSize() - 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> R[] map(Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        int size = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] rArr = (R[]) new Object[size];
        for (int i = 0; i < size; i++) {
            rArr[i] = function1.invoke(getContent()[i]);
        }
        return rArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> R[] mapIndexed(Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "transform");
        int size = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] rArr = (R[]) new Object[size];
        for (int i = 0; i < size; i++) {
            rArr[i] = function2.invoke(Integer.valueOf(i), getContent()[i]);
        }
        return rArr;
    }

    public final /* synthetic */ <R> MutableVector<R> mapIndexedNotNull(Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "transform");
        int size = getSize();
        int i = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] objArr = new Object[size];
        if (size > 0) {
            T[] content = getContent();
            int i2 = 0;
            do {
                Object invoke = function2.invoke(Integer.valueOf(i), content[i]);
                if (invoke != null) {
                    objArr[i2] = invoke;
                    i2++;
                }
                i++;
            } while (i < size);
            i = i2;
        }
        return new MutableVector<>(objArr, i);
    }

    public final /* synthetic */ <R> MutableVector<R> mapNotNull(Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        int size = getSize();
        int i = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] objArr = new Object[size];
        if (size > 0) {
            T[] content = getContent();
            int i2 = 0;
            do {
                Object invoke = function1.invoke(content[i]);
                if (invoke != null) {
                    objArr[i2] = invoke;
                    i2++;
                }
                i++;
            } while (i < size);
            i = i2;
        }
        return new MutableVector<>(objArr, i);
    }

    public final void minusAssign(T t) {
        remove(t);
    }

    public final void plusAssign(T t) {
        add(t);
    }

    public final boolean remove(T t) {
        int indexOf = indexOf(t);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "elements");
        int i = this.size;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            remove(list.get(i2));
        }
        return i != this.size;
    }

    public final T removeAt(int i) {
        T[] tArr = this.content;
        T t = tArr[i];
        if (i != getSize() - 1) {
            ArraysKt.copyInto(tArr, tArr, i, i + 1, this.size);
        }
        int i2 = this.size - 1;
        this.size = i2;
        tArr[i2] = null;
        return t;
    }

    public final void removeRange(int i, int i2) {
        if (i2 > i) {
            int i3 = this.size;
            if (i2 < i3) {
                T[] tArr = this.content;
                ArraysKt.copyInto(tArr, tArr, i, i2, i3);
            }
            int i4 = this.size - (i2 - i);
            int size = getSize() - 1;
            if (i4 <= size) {
                int i5 = i4;
                while (true) {
                    this.content[i5] = null;
                    if (i5 == size) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.size = i4;
        }
    }

    public final boolean retainAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        int i = this.size;
        for (int size = getSize() - 1; -1 < size; size--) {
            if (!collection.contains(getContent()[size])) {
                removeAt(size);
            }
        }
        return i != this.size;
    }

    public final boolean reversedAny(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size <= 0) {
            return false;
        }
        int i = size - 1;
        T[] content = getContent();
        while (!((Boolean) function1.invoke(content[i])).booleanValue()) {
            i--;
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public final T set(int i, T t) {
        T[] tArr = this.content;
        T t2 = tArr[i];
        tArr[i] = t;
        return t2;
    }

    public final void setContent(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<set-?>");
        this.content = tArr;
    }

    public final void sortWith(@NotNull Comparator<T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArraysKt.sortWith(this.content, comparator, 0, this.size);
    }

    public final int sumBy(@NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "selector");
        int size = getSize();
        int i = 0;
        if (size > 0) {
            T[] content = getContent();
            int i2 = 0;
            do {
                i += ((Number) function1.invoke(content[i2])).intValue();
                i2++;
            } while (i2 < size);
        }
        return i;
    }

    @PublishedApi
    @NotNull
    public final Void throwNoSuchElementException() {
        throw new NoSuchElementException("MutableVector contains no element matching the predicate.");
    }

    public final boolean containsAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final T firstOrNull(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size <= 0) {
            return null;
        }
        int i = 0;
        T[] content = getContent();
        do {
            T t = content[i];
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                return t;
            }
            i++;
        } while (i < size);
        return null;
    }

    public final void add(int i, T t) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i2 = this.size;
        if (i != i2) {
            ArraysKt.copyInto(tArr, tArr, i + 1, i, i2);
        }
        tArr[i] = t;
        this.size++;
    }

    public final T first(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size > 0) {
            int i = 0;
            T[] content = getContent();
            do {
                T t = content[i];
                if (((Boolean) function1.invoke(t)).booleanValue()) {
                    return t;
                }
                i++;
            } while (i < size);
        }
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    @Nullable
    public final T lastOrNull(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size <= 0) {
            return null;
        }
        int i = size - 1;
        T[] content = getContent();
        do {
            T t = content[i];
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                return t;
            }
            i--;
        } while (i >= 0);
        return null;
    }

    public final boolean containsAll(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (contains(mutableVector.getContent()[first])) {
                if (first != last) {
                    first++;
                }
            }
            return false;
        }
        return true;
    }

    public final T last(@NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = getSize();
        if (size > 0) {
            int i = size - 1;
            T[] content = getContent();
            do {
                T t = content[i];
                if (((Boolean) function1.invoke(t)).booleanValue()) {
                    return t;
                }
                i--;
            } while (i >= 0);
        }
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    public final boolean removeAll(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        int i = this.size;
        int size = mutableVector.getSize() - 1;
        if (size >= 0) {
            int i2 = 0;
            while (true) {
                remove(mutableVector.getContent()[i2]);
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        return i != this.size;
    }

    public final boolean removeAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        int i = this.size;
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return i != this.size;
    }

    public final boolean addAll(int i, @NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        if (mutableVector.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + mutableVector.size);
        T[] tArr = this.content;
        int i2 = this.size;
        if (i != i2) {
            ArraysKt.copyInto(tArr, tArr, mutableVector.size + i, i, i2);
        }
        ArraysKt.copyInto(mutableVector.content, tArr, i, 0, mutableVector.size);
        this.size += mutableVector.size;
        return true;
    }

    public final boolean addAll(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "elements");
        return addAll(getSize(), (List) list);
    }

    public final boolean addAll(@NotNull MutableVector<T> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "elements");
        return addAll(getSize(), mutableVector);
    }

    public final boolean addAll(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        if (tArr.length == 0) {
            return false;
        }
        ensureCapacity(this.size + tArr.length);
        ArraysKt.copyInto$default(tArr, this.content, this.size, 0, 0, 12, (Object) null);
        this.size += tArr.length;
        return true;
    }

    public final boolean addAll(int i, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        int i2 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + collection.size());
        T[] tArr = this.content;
        if (i != this.size) {
            ArraysKt.copyInto(tArr, tArr, collection.size() + i, i, this.size);
        }
        for (T t : collection) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            tArr[i2 + i] = t;
            i2 = i3;
        }
        this.size += collection.size();
        return true;
    }

    public final boolean addAll(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return addAll(this.size, collection);
    }
}
