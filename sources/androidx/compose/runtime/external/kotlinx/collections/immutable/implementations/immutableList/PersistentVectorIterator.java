package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PersistentVectorIterator<T> extends AbstractListIterator<T> {

    @NotNull
    private final T[] tail;

    @NotNull
    private final TrieIterator<T> trieIterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorIterator(@NotNull Object[] objArr, @NotNull T[] tArr, int i, int i2, int i3) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(objArr, "root");
        Intrinsics.checkNotNullParameter(tArr, "tail");
        this.tail = tArr;
        int rootSize = UtilsKt.rootSize(i2);
        this.trieIterator = new TrieIterator<>(objArr, RangesKt.coerceAtMost(i, rootSize), rootSize, i3);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public T next() {
        checkHasNext$runtime_release();
        if (this.trieIterator.hasNext()) {
            setIndex(getIndex() + 1);
            return this.trieIterator.next();
        }
        T[] tArr = this.tail;
        int index = getIndex();
        setIndex(index + 1);
        return tArr[index - this.trieIterator.getSize()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        checkHasPrevious$runtime_release();
        if (getIndex() <= this.trieIterator.getSize()) {
            setIndex(getIndex() - 1);
            return this.trieIterator.previous();
        }
        T[] tArr = this.tail;
        setIndex(getIndex() - 1);
        return tArr[getIndex() - this.trieIterator.getSize()];
    }
}
