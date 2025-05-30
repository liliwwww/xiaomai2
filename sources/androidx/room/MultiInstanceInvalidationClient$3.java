package androidx.room;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MultiInstanceInvalidationClient$3 implements Runnable {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    MultiInstanceInvalidationClient$3(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
            if (iMultiInstanceInvalidationService != null) {
                multiInstanceInvalidationClient.mClientId = iMultiInstanceInvalidationService.registerCallback(multiInstanceInvalidationClient.mCallback, multiInstanceInvalidationClient.mName);
                MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.this$0;
                multiInstanceInvalidationClient2.mInvalidationTracker.addObserver(multiInstanceInvalidationClient2.mObserver);
            }
        } catch (RemoteException e) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
        }
    }
}
