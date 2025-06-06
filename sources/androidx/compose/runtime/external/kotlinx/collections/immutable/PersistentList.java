package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PersistentList<E> extends ImmutableList<E>, PersistentCollection<E> {

    /* compiled from: Taobao */
    public interface Builder<E> extends List<E>, PersistentCollection.Builder<E>, KMutableList {
        @NotNull
        PersistentList<E> build();
    }

    @NotNull
    PersistentList<E> add(int i, E e);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentList<E> add(E e);

    @NotNull
    PersistentList<E> addAll(int i, @NotNull Collection<? extends E> collection);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentList<E> addAll(@NotNull Collection<? extends E> collection);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    Builder<E> builder();

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentList<E> clear();

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentList<E> remove(E e);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentList<E> removeAll(@NotNull Collection<? extends E> collection);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentList<E> removeAll(@NotNull Function1<? super E, Boolean> function1);

    @NotNull
    PersistentList<E> removeAt(int i);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentList<E> retainAll(@NotNull Collection<? extends E> collection);

    @NotNull
    PersistentList<E> set(int i, E e);
}
