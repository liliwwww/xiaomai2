package androidx.compose.runtime.snapshots;

import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableListIterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SubList$listIterator$1<T> implements ListIterator<T>, KMutableListIterator {
    final /* synthetic */ Ref.IntRef $current;
    final /* synthetic */ SubList<T> this$0;

    SubList$listIterator$1(Ref.IntRef intRef, SubList<T> subList) {
        this.$current = intRef;
        this.this$0 = subList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void add(Object obj) {
        add((SubList$listIterator$1<T>) obj);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.$current.element < this.this$0.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.$current.element >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        int i = this.$current.element + 1;
        SnapshotStateListKt.validateRange(i, this.this$0.size());
        this.$current.element = i;
        return (T) this.this$0.get(i);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.$current.element + 1;
    }

    @Override // java.util.ListIterator
    public T previous() {
        int i = this.$current.element;
        SnapshotStateListKt.validateRange(i, this.this$0.size());
        this.$current.element = i - 1;
        return (T) this.this$0.get(i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.$current.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    public /* bridge */ /* synthetic */ void set(Object obj) {
        set((SubList$listIterator$1<T>) obj);
    }

    @Override // java.util.ListIterator
    @NotNull
    public Void add(T t) {
        SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    @NotNull
    public Void remove() {
        SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    @Override // java.util.ListIterator
    @NotNull
    public Void set(T t) {
        SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }
}
