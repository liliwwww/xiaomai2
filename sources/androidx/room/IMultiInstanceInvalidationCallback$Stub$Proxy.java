package androidx.room;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class IMultiInstanceInvalidationCallback$Stub$Proxy implements IMultiInstanceInvalidationCallback {
    public static IMultiInstanceInvalidationCallback sDefaultImpl;
    private IBinder mRemote;

    IMultiInstanceInvalidationCallback$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "androidx.room.IMultiInstanceInvalidationCallback";
    }

    public void onInvalidation(String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
            obtain.writeStringArray(strArr);
            if (this.mRemote.transact(1, obtain, null, 1) || IMultiInstanceInvalidationCallback.Stub.getDefaultImpl() == null) {
                return;
            }
            IMultiInstanceInvalidationCallback.Stub.getDefaultImpl().onInvalidation(strArr);
        } finally {
            obtain.recycle();
        }
    }
}
