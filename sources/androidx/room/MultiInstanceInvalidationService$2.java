package androidx.room;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MultiInstanceInvalidationService$2 extends IMultiInstanceInvalidationService$Stub {
    final /* synthetic */ MultiInstanceInvalidationService this$0;

    MultiInstanceInvalidationService$2(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public void broadcastInvalidation(int i, String[] strArr) {
        synchronized (this.this$0.mCallbackList) {
            String str = (String) this.this$0.mClientNames.get(Integer.valueOf(i));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int beginBroadcast = this.this$0.mCallbackList.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                try {
                    int intValue = ((Integer) this.this$0.mCallbackList.getBroadcastCookie(i2)).intValue();
                    String str2 = (String) this.this$0.mClientNames.get(Integer.valueOf(intValue));
                    if (i != intValue && str.equals(str2)) {
                        try {
                            ((IMultiInstanceInvalidationCallback) this.this$0.mCallbackList.getBroadcastItem(i2)).onInvalidation(strArr);
                        } catch (RemoteException e) {
                            Log.w("ROOM", "Error invoking a remote callback", e);
                        }
                    }
                } finally {
                    this.this$0.mCallbackList.finishBroadcast();
                }
            }
        }
    }

    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
        if (str == null) {
            return 0;
        }
        synchronized (this.this$0.mCallbackList) {
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.this$0;
            int i = multiInstanceInvalidationService.mMaxClientId + 1;
            multiInstanceInvalidationService.mMaxClientId = i;
            if (multiInstanceInvalidationService.mCallbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i))) {
                this.this$0.mClientNames.put(Integer.valueOf(i), str);
                return i;
            }
            MultiInstanceInvalidationService multiInstanceInvalidationService2 = this.this$0;
            multiInstanceInvalidationService2.mMaxClientId--;
            return 0;
        }
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
        synchronized (this.this$0.mCallbackList) {
            this.this$0.mCallbackList.unregister(iMultiInstanceInvalidationCallback);
            this.this$0.mClientNames.remove(Integer.valueOf(i));
        }
    }
}
