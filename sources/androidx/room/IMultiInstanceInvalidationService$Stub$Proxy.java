package androidx.room;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationService;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class IMultiInstanceInvalidationService$Stub$Proxy implements IMultiInstanceInvalidationService {
    public static IMultiInstanceInvalidationService sDefaultImpl;
    private IBinder mRemote;

    IMultiInstanceInvalidationService$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public void broadcastInvalidation(int i, String[] strArr) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            obtain.writeInt(i);
            obtain.writeStringArray(strArr);
            if (this.mRemote.transact(3, obtain, null, 1) || IMultiInstanceInvalidationService.Stub.getDefaultImpl() == null) {
                return;
            }
            IMultiInstanceInvalidationService.Stub.getDefaultImpl().broadcastInvalidation(i, strArr);
        } finally {
            obtain.recycle();
        }
    }

    public String getInterfaceDescriptor() {
        return "androidx.room.IMultiInstanceInvalidationService";
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            obtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
            obtain.writeString(str);
            if (!this.mRemote.transact(1, obtain, obtain2, 0) && IMultiInstanceInvalidationService.Stub.getDefaultImpl() != null) {
                return IMultiInstanceInvalidationService.Stub.getDefaultImpl().registerCallback(iMultiInstanceInvalidationCallback, str);
            }
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
            obtain.writeStrongBinder(iMultiInstanceInvalidationCallback != null ? iMultiInstanceInvalidationCallback.asBinder() : null);
            obtain.writeInt(i);
            if (this.mRemote.transact(2, obtain, obtain2, 0) || IMultiInstanceInvalidationService.Stub.getDefaultImpl() == null) {
                obtain2.readException();
            } else {
                IMultiInstanceInvalidationService.Stub.getDefaultImpl().unregisterCallback(iMultiInstanceInvalidationCallback, i);
            }
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
