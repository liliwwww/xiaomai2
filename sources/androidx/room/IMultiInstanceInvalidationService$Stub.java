package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class IMultiInstanceInvalidationService$Stub extends Binder implements IMultiInstanceInvalidationService {
    private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";
    static final int TRANSACTION_broadcastInvalidation = 3;
    static final int TRANSACTION_registerCallback = 1;
    static final int TRANSACTION_unregisterCallback = 2;

    /* JADX WARN: Multi-variable type inference failed */
    public IMultiInstanceInvalidationService$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IMultiInstanceInvalidationService asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IMultiInstanceInvalidationService queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        return (queryLocalInterface == null || !(queryLocalInterface instanceof IMultiInstanceInvalidationService)) ? new Proxy(iBinder) : queryLocalInterface;
    }

    public static IMultiInstanceInvalidationService getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static boolean setDefaultImpl(IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
        if (Proxy.sDefaultImpl != null) {
            throw new IllegalStateException("setDefaultImpl() called twice");
        }
        if (iMultiInstanceInvalidationService == null) {
            return false;
        }
        Proxy.sDefaultImpl = iMultiInstanceInvalidationService;
        return true;
    }

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.enforceInterface(DESCRIPTOR);
            int registerCallback = registerCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(registerCallback);
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface(DESCRIPTOR);
            unregisterCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
        if (i == 3) {
            parcel.enforceInterface(DESCRIPTOR);
            broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel2.writeString(DESCRIPTOR);
        return true;
    }
}
