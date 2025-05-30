package android.support.v4.media;

import android.content.ComponentName;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2 implements Runnable {
    final /* synthetic */ MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection this$1;
    final /* synthetic */ ComponentName val$name;

    MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2(MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mediaServiceConnection, ComponentName componentName) {
        this.this$1 = mediaServiceConnection;
        this.val$name = componentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + this.val$name + " this=" + this + " mServiceConnection=" + this.this$1.this$0.mServiceConnection);
            this.this$1.this$0.dump();
        }
        if (this.this$1.isCurrent("onServiceDisconnected")) {
            MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = this.this$1.this$0;
            mediaBrowserImplBase.mServiceBinderWrapper = null;
            mediaBrowserImplBase.mCallbacksMessenger = null;
            mediaBrowserImplBase.mHandler.setCallbacksMessenger((Messenger) null);
            MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = this.this$1.this$0;
            mediaBrowserImplBase2.mState = 4;
            mediaBrowserImplBase2.mCallback.onConnectionSuspended();
        }
    }
}
