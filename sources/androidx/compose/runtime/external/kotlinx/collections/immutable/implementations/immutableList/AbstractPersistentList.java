package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class AbstractPersistentList<E> extends AbstractList<E> implements PersistentList<E> {
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public Iterator<E> iterator() {
        return listIterator();
    }

    @NotNull
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentCollection remove(Object obj) {
        return m760remove((AbstractPersistentList<E>) obj);
    }

    @Override // java.util.List, java.util.Collection
    @NotNull
    public PersistentList<E> addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentList.Builder builder = builder();
        builder.addAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentList<E> clear() {
        return UtilsKt.persistentVectorOf();
    }

    @NotNull
    /* renamed from: remove, reason: collision with other method in class */
    public PersistentList<E> m760remove(E e) {
        int indexOf = indexOf(e);
        return indexOf != -1 ? removeAt(indexOf) : this;
    }

    @NotNull
    public PersistentList<E> removeAll(@NotNull final Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return removeAll(new Function1<E, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList$removeAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(E e) {
                return Boolean.valueOf(collection.contains(e));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m764invoke(Object obj) {
                return invoke((AbstractPersistentList$removeAll$1<E>) obj);
            }
        });
    }

    @NotNull
    public PersistentList<E> retainAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return removeAll(new retainAll.1(collection));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: subList, reason: merged with bridge method [inline-methods] */
    public ImmutableList<E> m763subList(int i, int i2) {
        return a.a(this, i, i2);
    }

    @NotNull
    public PersistentList<E> addAll(int i, @NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "c");
        PersistentList.Builder builder = builder();
        builder.addAll(i, collection);
        return builder.build();
    }
}
