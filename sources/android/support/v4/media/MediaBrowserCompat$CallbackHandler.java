package android.support.v4.media;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaBrowserProtocol;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaBrowserCompat$CallbackHandler extends Handler {
    private final WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
    private WeakReference<Messenger> mCallbacksMessengerRef;

    MediaBrowserCompat$CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
        this.mCallbackImplRef = new WeakReference<>(mediaBrowserServiceCallbackImpl);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        WeakReference<Messenger> weakReference = this.mCallbacksMessengerRef;
        if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
            return;
        }
        Bundle data = message.getData();
        MediaSessionCompat.ensureClassLoader(data);
        MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbackImplRef.get();
        Messenger messenger = this.mCallbacksMessengerRef.get();
        try {
            int i = message.what;
            if (i == 1) {
                Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                MediaSessionCompat.ensureClassLoader(bundle);
                mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
            } else if (i == 2) {
                mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
            } else if (i != 3) {
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
            } else {
                Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                MediaSessionCompat.ensureClassLoader(bundle2);
                Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                MediaSessionCompat.ensureClassLoader(bundle3);
                mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (message.what == 1) {
                mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
            }
        }
    }

    void setCallbacksMessenger(Messenger messenger) {
        this.mCallbacksMessengerRef = new WeakReference<>(messenger);
    }
}
