package androidx.room;

import androidx.annotation.WorkerThread;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RoomTrackingLiveData$1 implements Runnable {
    final /* synthetic */ RoomTrackingLiveData this$0;

    RoomTrackingLiveData$1(RoomTrackingLiveData roomTrackingLiveData) {
        this.this$0 = roomTrackingLiveData;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        boolean z;
        if (this.this$0.mRegisteredObserver.compareAndSet(false, true)) {
            this.this$0.mDatabase.getInvalidationTracker().addWeakObserver(this.this$0.mObserver);
        }
        do {
            if (this.this$0.mComputing.compareAndSet(false, true)) {
                Object obj = null;
                z = false;
                while (this.this$0.mInvalid.compareAndSet(true, false)) {
                    try {
                        try {
                            obj = this.this$0.mComputeFunction.call();
                            z = true;
                        } catch (Exception e) {
                            throw new RuntimeException("Exception while computing database live data.", e);
                        }
                    } finally {
                        this.this$0.mComputing.set(false);
                    }
                }
                if (z) {
                    RoomTrackingLiveData.access$000(this.this$0, obj);
                }
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
        } while (this.this$0.mInvalid.get());
    }
}
