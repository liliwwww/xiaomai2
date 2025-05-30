package androidx.lifecycle;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LiveData$1 implements Runnable {
    final /* synthetic */ LiveData this$0;

    LiveData$1(LiveData liveData) {
        this.this$0 = liveData;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        synchronized (this.this$0.mDataLock) {
            obj = this.this$0.mPendingData;
            this.this$0.mPendingData = LiveData.NOT_SET;
        }
        this.this$0.setValue(obj);
    }
}
