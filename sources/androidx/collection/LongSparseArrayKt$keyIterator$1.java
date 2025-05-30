package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.LongIterator;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"androidx/collection/LongSparseArrayKt$keyIterator$1", "Lkotlin/collections/LongIterator;", "", "hasNext", "", "nextLong", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "collection-ktx"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LongSparseArrayKt$keyIterator$1 extends LongIterator {
    final /* synthetic */ LongSparseArray $this_keyIterator;
    private int index;

    LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_keyIterator = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public long nextLong() {
        LongSparseArray longSparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return longSparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
