package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PersistentSet<E> extends ImmutableSet<E>, PersistentCollection<E> {
    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentSet<E> add(E e);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentSet<E> addAll(@NotNull Collection<? extends E> collection);

    @NotNull
    /* renamed from: builder */
    Builder<E> mo921builder();

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentSet<E> clear();

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentSet<E> remove(E e);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentSet<E> removeAll(@NotNull Collection<? extends E> collection);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection
    @NotNull
    PersistentSet<E> removeAll(@NotNull Function1<? super E, Boolean> function1);

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection, java.util.Collection
    @NotNull
    PersistentSet<E> retainAll(@NotNull Collection<? extends E> collection);
}
