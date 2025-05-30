package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.LongSparseArray;
import kotlin.collections.LongIterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LongSparseArrayKt$keyIterator$1 extends LongIterator {
    final /* synthetic */ LongSparseArray<T> $this_keyIterator;
    private int index;

    LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_keyIterator = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    @SuppressLint({"ClassVerificationFailure"})
    public long nextLong() {
        LongSparseArray<T> longSparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return longSparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
