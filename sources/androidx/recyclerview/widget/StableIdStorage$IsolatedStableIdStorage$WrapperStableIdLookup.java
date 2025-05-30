package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.StableIdStorage;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup implements StableIdStorage.StableIdLookup {
    private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();
    final /* synthetic */ StableIdStorage.IsolatedStableIdStorage this$0;

    StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup(StableIdStorage.IsolatedStableIdStorage isolatedStableIdStorage) {
        this.this$0 = isolatedStableIdStorage;
    }

    public long localToGlobal(long j) {
        Long l = this.mLocalToGlobalLookup.get(j);
        if (l == null) {
            l = Long.valueOf(this.this$0.obtainId());
            this.mLocalToGlobalLookup.put(j, l);
        }
        return l.longValue();
    }
}
