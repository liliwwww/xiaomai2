package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MultiInstanceInvalidationClient$5 extends InvalidationTracker.Observer {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MultiInstanceInvalidationClient$5(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        super(strArr);
        this.this$0 = multiInstanceInvalidationClient;
    }

    boolean isRemote() {
        return true;
    }

    public void onInvalidated(@NonNull Set<String> set) {
        if (this.this$0.mStopped.get()) {
            return;
        }
        try {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.this$0;
            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.mService;
            if (iMultiInstanceInvalidationService != null) {
                iMultiInstanceInvalidationService.broadcastInvalidation(multiInstanceInvalidationClient.mClientId, (String[]) set.toArray(new String[0]));
            }
        } catch (RemoteException e) {
            Log.w("ROOM", "Cannot broadcast invalidation", e);
        }
    }
}
