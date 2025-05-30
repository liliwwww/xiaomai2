package android.support.v4.media;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaBrowserCompat$ServiceBinderWrapper {
    private Messenger mMessenger;
    private Bundle mRootHints;

    public MediaBrowserCompat$ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
        this.mMessenger = new Messenger(iBinder);
        this.mRootHints = bundle;
    }

    private void sendRequest(int i, Bundle bundle, Messenger messenger) throws RemoteException {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 1;
        obtain.setData(bundle);
        obtain.replyTo = messenger;
        this.mMessenger.send(obtain);
    }

    void addSubscription(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
        BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
        bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
        sendRequest(3, bundle2, messenger);
    }

    void connect(Context context, Messenger messenger) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
        bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
        sendRequest(1, bundle, messenger);
    }

    void disconnect(Messenger messenger) throws RemoteException {
        sendRequest(2, null, messenger);
    }

    void getMediaItem(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
        bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
        sendRequest(5, bundle, messenger);
    }

    void registerCallbackMessenger(Context context, Messenger messenger) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
        bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
        sendRequest(6, bundle, messenger);
    }

    void removeSubscription(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
        BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
        sendRequest(4, bundle, messenger);
    }

    void search(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
        bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
        bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
        sendRequest(8, bundle2, messenger);
    }

    void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
        Bundle bundle2 = new Bundle();
        bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
        bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
        bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
        sendRequest(9, bundle2, messenger);
    }

    void unregisterCallbackMessenger(Messenger messenger) throws RemoteException {
        sendRequest(7, null, messenger);
    }
}
