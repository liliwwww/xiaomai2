package androidx.room.paging;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker$Observer;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class LimitOffsetDataSource$1 extends InvalidationTracker$Observer {
    final /* synthetic */ LimitOffsetDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LimitOffsetDataSource$1(LimitOffsetDataSource limitOffsetDataSource, String[] strArr) {
        super(strArr);
        this.this$0 = limitOffsetDataSource;
    }

    @Override // androidx.room.InvalidationTracker$Observer
    public void onInvalidated(@NonNull Set<String> set) {
        this.this$0.invalidate();
    }
}
