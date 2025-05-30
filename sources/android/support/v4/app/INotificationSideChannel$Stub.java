package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class INotificationSideChannel$Stub extends Binder implements INotificationSideChannel {
    static final int TRANSACTION_cancel = 2;
    static final int TRANSACTION_cancelAll = 3;
    static final int TRANSACTION_notify = 1;

    /* compiled from: Taobao */
    private static class Proxy implements INotificationSideChannel {
        private IBinder mRemote;

        Proxy(IBinder iBinder) {
            this.mRemote = iBinder;
        }

        public IBinder asBinder() {
            return this.mRemote;
        }

        public void cancel(String str, int i, String str2) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeString(str2);
                this.mRemote.transact(2, obtain, null, 1);
            } finally {
                obtain.recycle();
            }
        }

        public void cancelAll(String str) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                obtain.writeString(str);
                this.mRemote.transact(3, obtain, null, 1);
            } finally {
                obtain.recycle();
            }
        }

        public String getInterfaceDescriptor() {
            return "android.support.v4.app.INotificationSideChannel";
        }

        public void notify(String str, int i, String str2, Notification notification) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                obtain.writeString(str);
                obtain.writeInt(i);
                obtain.writeString(str2);
                INotificationSideChannel._Parcel.access$100(obtain, notification, 0);
                this.mRemote.transact(1, obtain, null, 1);
            } finally {
                obtain.recycle();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public INotificationSideChannel$Stub() {
        attachInterface(this, "android.support.v4.app.INotificationSideChannel");
    }

    public static INotificationSideChannel asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        INotificationSideChannel queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof INotificationSideChannel)) ? new Proxy(iBinder) : queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
        }
        if (i == 1598968902) {
            parcel2.writeString("android.support.v4.app.INotificationSideChannel");
            return true;
        }
        if (i == 1) {
            notify(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) INotificationSideChannel._Parcel.access$000(parcel, Notification.CREATOR));
        } else if (i == 2) {
            cancel(parcel.readString(), parcel.readInt(), parcel.readString());
        } else {
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            cancelAll(parcel.readString());
        }
        return true;
    }
}
