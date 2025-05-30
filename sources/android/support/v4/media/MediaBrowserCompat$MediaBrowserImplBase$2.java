package android.support.v4.media;

import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserCompat$MediaBrowserImplBase$2 implements Runnable {
    final /* synthetic */ MediaBrowserCompat.MediaBrowserImplBase this$0;

    MediaBrowserCompat$MediaBrowserImplBase$2(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase) {
        this.this$0 = mediaBrowserImplBase;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
        Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
        if (messenger != null) {
            try {
                mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
            } catch (RemoteException unused) {
                Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.this$0.mServiceComponent);
            }
        }
        MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = this.this$0;
        int i = mediaBrowserImplBase2.mState;
        mediaBrowserImplBase2.forceCloseConnection();
        if (i != 0) {
            this.this$0.mState = i;
        }
        if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "disconnect...");
            this.this$0.dump();
        }
    }
}
