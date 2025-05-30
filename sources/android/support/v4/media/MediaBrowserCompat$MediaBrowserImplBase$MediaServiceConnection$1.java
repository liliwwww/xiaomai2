package android.support.v4.media;

import android.content.ComponentName;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1 implements Runnable {
    final /* synthetic */ MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection this$1;
    final /* synthetic */ IBinder val$binder;
    final /* synthetic */ ComponentName val$name;

    MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1(MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mediaServiceConnection, ComponentName componentName, IBinder iBinder) {
        this.this$1 = mediaServiceConnection;
        this.val$name = componentName;
        this.val$binder = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z = MediaBrowserCompat.DEBUG;
        if (z) {
            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + this.val$name + " binder=" + this.val$binder);
            this.this$1.this$0.dump();
        }
        if (this.this$1.isCurrent("onServiceConnected")) {
            MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = this.this$1.this$0;
            mediaBrowserImplBase.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(this.val$binder, mediaBrowserImplBase.mRootHints);
            this.this$1.this$0.mCallbacksMessenger = new Messenger((Handler) this.this$1.this$0.mHandler);
            MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = this.this$1.this$0;
            mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
            this.this$1.this$0.mState = 2;
            if (z) {
                try {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    this.this$1.this$0.dump();
                } catch (RemoteException unused) {
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.this$1.this$0.mServiceComponent);
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                        this.this$1.this$0.dump();
                        return;
                    }
                    return;
                }
            }
            MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase3 = this.this$1.this$0;
            mediaBrowserImplBase3.mServiceBinderWrapper.connect(mediaBrowserImplBase3.mContext, mediaBrowserImplBase3.mCallbacksMessenger);
        }
    }
}
