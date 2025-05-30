package androidx.room;

import androidx.annotation.MainThread;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RoomTrackingLiveData$2 implements Runnable {
    final /* synthetic */ RoomTrackingLiveData this$0;

    RoomTrackingLiveData$2(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    @Override // java.lang.Runnable
    @MainThread
    public void run() {
        boolean hasActiveObservers = this.this$0.hasActiveObservers();
        if (this.this$0.mInvalid.compareAndSet(false, true) && hasActiveObservers) {
            this.this$0.getQueryExecutor().execute(this.this$0.mRefreshRunnable);
        }
    }
}
