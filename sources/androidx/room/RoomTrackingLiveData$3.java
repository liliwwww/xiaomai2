package androidx.room;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RoomTrackingLiveData$3 extends InvalidationTracker$Observer {
    final /* synthetic */ RoomTrackingLiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RoomTrackingLiveData$3(RoomTrackingLiveData roomTrackingLiveData, String[] strArr) {
        super(strArr);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // androidx.room.InvalidationTracker$Observer
    public void onInvalidated(@NonNull Set<String> set) {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.this$0.mInvalidationRunnable);
    }
}
