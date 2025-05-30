package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MultiInstanceInvalidationClient$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onInvalidation(final String[] strArr) {
        this.this$0.mExecutor.execute(new Runnable() { // from class: androidx.room.MultiInstanceInvalidationClient$1.1
            @Override // java.lang.Runnable
            public void run() {
                MultiInstanceInvalidationClient$1.this.this$0.mInvalidationTracker.notifyObserversByTableNames(strArr);
            }
        });
    }
}
