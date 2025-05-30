package androidx.core.util;

import android.util.SparseArray;
import kotlin.collections.IntIterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SparseArrayKt$keyIterator$1 extends IntIterator {
    final /* synthetic */ SparseArray<T> $this_keyIterator;
    private int index;

    SparseArrayKt$keyIterator$1(SparseArray<T> sparseArray) {
        this.$this_keyIterator = sparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public int nextInt() {
        SparseArray<T> sparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
