package android.support.v4.media;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserCompat$MediaBrowserImplBase$1 implements Runnable {
    final /* synthetic */ MediaBrowserCompat.MediaBrowserImplBase this$0;

    MediaBrowserCompat$MediaBrowserImplBase$1(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase) {
        this.this$0 = mediaBrowserImplBase;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection] */
    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
        if (mediaBrowserImplBase.mState == 0) {
            return;
        }
        mediaBrowserImplBase.mState = 2;
        if (MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
            throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.this$0.mServiceConnection);
        }
        if (mediaBrowserImplBase.mServiceBinderWrapper != null) {
            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.this$0.mServiceBinderWrapper);
        }
        if (mediaBrowserImplBase.mCallbacksMessenger != null) {
            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.this$0.mCallbacksMessenger);
        }
        Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
        intent.setComponent(this.this$0.mServiceComponent);
        final MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = this.this$0;
        mediaBrowserImplBase2.mServiceConnection = new ServiceConnection() { // from class: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection
            private void postOrRun(Runnable runnable) {
                if (Thread.currentThread() == mediaBrowserImplBase2.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    mediaBrowserImplBase2.mHandler.post(runnable);
                }
            }

            boolean isCurrent(String str) {
                int i;
                MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase3 = mediaBrowserImplBase2;
                if (mediaBrowserImplBase3.mServiceConnection == this && (i = mediaBrowserImplBase3.mState) != 0 && i != 1) {
                    return true;
                }
                int i2 = mediaBrowserImplBase3.mState;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                Log.i("MediaBrowserCompat", str + " for " + mediaBrowserImplBase2.mServiceComponent + " with mServiceConnection=" + mediaBrowserImplBase2.mServiceConnection + " this=" + this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                postOrRun(new 1(this, componentName, iBinder));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                postOrRun(new 2(this, componentName));
            }
        };
        boolean z = false;
        try {
            MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase3 = this.this$0;
            z = mediaBrowserImplBase3.mContext.bindService(intent, mediaBrowserImplBase3.mServiceConnection, 1);
        } catch (Exception unused) {
            Log.e("MediaBrowserCompat", "Failed binding to service " + this.this$0.mServiceComponent);
        }
        if (!z) {
            this.this$0.forceCloseConnection();
            this.this$0.mCallback.onConnectionFailed();
        }
        if (MediaBrowserCompat.DEBUG) {
            Log.d("MediaBrowserCompat", "connect...");
            this.this$0.dump();
        }
    }
}
