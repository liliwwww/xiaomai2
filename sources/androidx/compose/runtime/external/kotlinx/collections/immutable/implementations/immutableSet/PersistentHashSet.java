package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet$Builder;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.AbstractSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PersistentHashSet<E> extends AbstractSet<E> implements PersistentSet<E> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final PersistentHashSet EMPTY = new PersistentHashSet(TrieNode.Companion.getEMPTY$runtime_release(), 0);

    @NotNull
    private final TrieNode<E> node;
    private final int size;

    public PersistentHashSet(@NotNull TrieNode<E> trieNode, int i) {
        Intrinsics.checkNotNullParameter(trieNode, "node");
        this.node = trieNode;
        this.size = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentCollection add(Object obj) {
        return m780add((PersistentHashSet<E>) obj);
    }

    public boolean contains(Object obj) {
        return this.node.contains(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return collection instanceof PersistentHashSet ? this.node.containsAll(((PersistentHashSet) collection).node, 0) : collection instanceof PersistentHashSetBuilder ? this.node.containsAll(((PersistentHashSetBuilder) collection).getNode$runtime_release(), 0) : super/*kotlin.collections.AbstractCollection*/.containsAll(collection);
    }

    @NotNull
    public final TrieNode<E> getNode$runtime_release() {
        return this.node;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Iterator<E> iterator() {
        return new PersistentHashSetIterator(this.node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ PersistentCollection remove(Object obj) {
        return m784remove((PersistentHashSet<E>) obj);
    }

    @NotNull
    /* renamed from: add, reason: collision with other method in class */
    public PersistentSet<E> m780add(E e) {
        TrieNode<E> add = this.node.add(e != null ? e.hashCode() : 0, e, 0);
        return this.node == add ? this : new PersistentHashSet(add, size() + 1);
    }

    @NotNull
    public PersistentSet<E> addAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentSet$Builder builder = builder();
        builder.addAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentSet$Builder<E> builder() {
        return new PersistentHashSetBuilder(this);
    }

    @NotNull
    public PersistentSet<E> clear() {
        return Companion.emptyOf$runtime_release();
    }

    @NotNull
    /* renamed from: remove, reason: collision with other method in class */
    public PersistentSet<E> m784remove(E e) {
        TrieNode<E> remove = this.node.remove(e != null ? e.hashCode() : 0, e, 0);
        return this.node == remove ? this : new PersistentHashSet(remove, size() - 1);
    }

    @NotNull
    public PersistentSet<E> retainAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentSet$Builder builder = builder();
        builder.retainAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentSet<E> removeAll(@NotNull Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        PersistentSet$Builder builder = builder();
        builder.removeAll(collection);
        return builder.build();
    }

    @NotNull
    public PersistentSet<E> removeAll(@NotNull Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        PersistentSet$Builder builder = builder();
        CollectionsKt.removeAll(builder, function1);
        return builder.build();
    }
}
