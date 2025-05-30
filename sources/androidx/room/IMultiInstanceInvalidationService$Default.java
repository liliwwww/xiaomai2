package androidx.room;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class IMultiInstanceInvalidationService$Default implements IMultiInstanceInvalidationService {
    public IBinder asBinder() {
        return null;
    }

    public void broadcastInvalidation(int i, String[] strArr) throws RemoteException {
    }

    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException {
        return 0;
    }

    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) throws RemoteException {
    }
}
