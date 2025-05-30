package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final SmallPersistentVector EMPTY = new SmallPersistentVector(new Object[0]);

    @NotNull
    private final Object[] buffer;

    public SmallPersistentVector(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.buffer = objArr;
        CommonFunctionsKt.assert(objArr.length <= 32);
    }

    private final Object[] bufferOfSize(int i) {
        return new Object[i];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ PersistentCollection add(Object obj) {
        return add((SmallPersistentVector<E>) obj);
    }

    @Override // java.util.List
    public E get(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        return (E) this.buffer[i];
    }

    public int getSize() {
        return this.buffer.length;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return ArraysKt.indexOf(this.buffer, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return ArraysKt.lastIndexOf(this.buffer, obj);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        return new BufferIterator(this.buffer, i, size());
    }

    @NotNull
    public PersistentList<E> removeAt(int i) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        if (size() == 1) {
            return EMPTY;
        }
        Object[] copyOf = Arrays.copyOf(this.buffer, size() - 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        ArraysKt.copyInto(this.buffer, copyOf, i, i + 1, size());
        return new SmallPersistentVector(copyOf);
    }

    @Override // java.util.List
    @NotNull
    public PersistentList<E> set(int i, E e) {
        ListImplementation.checkElementIndex$runtime_release(i, size());
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i] = e;
        return new SmallPersistentVector(copyOf);
    }

    @Override // java.util.List, java.util.Collection
    @NotNull
    public PersistentList<E> add(E e) {
        if (size() >= 32) {
            return new PersistentVector(this.buffer, UtilsKt.presizedBufferWith(e), size() + 1, 0);
        }
        Object[] copyOf = Arrays.copyOf(this.buffer, size() + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[size()] = e;
        return new SmallPersistentVector(copyOf);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.List, java.util.Collection
    @NotNull
    public PersistentList<E> addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (size() + collection.size() > 32) {
            PersistentList.Builder builder = builder();
            builder.addAll(collection);
            return builder.build();
        }
        Object[] copyOf = Arrays.copyOf(this.buffer, size() + collection.size());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        int size = size();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            copyOf[size] = it.next();
            size++;
        }
        return new SmallPersistentVector(copyOf);
    }

    @NotNull
    public PersistentList.Builder<E> builder() {
        return new PersistentVectorBuilder(this, null, this.buffer, 0);
    }

    @NotNull
    public PersistentList<E> removeAll(@NotNull Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.buffer;
        int size = size();
        int size2 = size();
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            Object obj = this.buffer[i];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                if (!z) {
                    Object[] objArr2 = this.buffer;
                    objArr = Arrays.copyOf(objArr2, objArr2.length);
                    Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, size)");
                    z = true;
                    size = i;
                }
            } else if (z) {
                objArr[size] = obj;
                size++;
            }
        }
        return size == size() ? this : size == 0 ? EMPTY : new SmallPersistentVector(ArraysKt.copyOfRange(objArr, 0, size));
    }

    @Override // java.util.List
    @NotNull
    public PersistentList<E> add(int i, E e) {
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (i == size()) {
            return add((SmallPersistentVector<E>) e);
        }
        if (size() < 32) {
            Object[] bufferOfSize = bufferOfSize(size() + 1);
            ArraysKt.copyInto$default(this.buffer, bufferOfSize, 0, 0, i, 6, (Object) null);
            ArraysKt.copyInto(this.buffer, bufferOfSize, i + 1, i, size());
            bufferOfSize[i] = e;
            return new SmallPersistentVector(bufferOfSize);
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt.copyInto(this.buffer, copyOf, i + 1, i, size() - 1);
        copyOf[i] = e;
        return new PersistentVector(copyOf, UtilsKt.presizedBufferWith(this.buffer[31]), size() + 1, 0);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.List
    @NotNull
    public PersistentList<E> addAll(int i, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "c");
        ListImplementation.checkPositionIndex$runtime_release(i, size());
        if (size() + collection.size() <= 32) {
            Object[] bufferOfSize = bufferOfSize(size() + collection.size());
            ArraysKt.copyInto$default(this.buffer, bufferOfSize, 0, 0, i, 6, (Object) null);
            ArraysKt.copyInto(this.buffer, bufferOfSize, collection.size() + i, i, size());
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                bufferOfSize[i] = it.next();
                i++;
            }
            return new SmallPersistentVector(bufferOfSize);
        }
        PersistentList.Builder builder = builder();
        builder.addAll(i, collection);
        return builder.build();
    }
}
