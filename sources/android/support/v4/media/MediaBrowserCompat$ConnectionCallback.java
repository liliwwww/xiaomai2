package android.support.v4.media;

import android.os.Build;
import android.support.v4.media.MediaBrowserCompatApi21;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MediaBrowserCompat$ConnectionCallback {
    ConnectionCallbackInternal mConnectionCallbackInternal;
    final Object mConnectionCallbackObj;

    /* compiled from: Taobao */
    interface ConnectionCallbackInternal {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    /* compiled from: Taobao */
    private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
        StubApi21() {
        }

        @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
        public void onConnected() {
            ConnectionCallbackInternal connectionCallbackInternal = MediaBrowserCompat$ConnectionCallback.this.mConnectionCallbackInternal;
            if (connectionCallbackInternal != null) {
                connectionCallbackInternal.onConnected();
            }
            MediaBrowserCompat$ConnectionCallback.this.onConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
        public void onConnectionFailed() {
            ConnectionCallbackInternal connectionCallbackInternal = MediaBrowserCompat$ConnectionCallback.this.mConnectionCallbackInternal;
            if (connectionCallbackInternal != null) {
                connectionCallbackInternal.onConnectionFailed();
            }
            MediaBrowserCompat$ConnectionCallback.this.onConnectionFailed();
        }

        @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
        public void onConnectionSuspended() {
            ConnectionCallbackInternal connectionCallbackInternal = MediaBrowserCompat$ConnectionCallback.this.mConnectionCallbackInternal;
            if (connectionCallbackInternal != null) {
                connectionCallbackInternal.onConnectionSuspended();
            }
            MediaBrowserCompat$ConnectionCallback.this.onConnectionSuspended();
        }
    }

    public MediaBrowserCompat$ConnectionCallback() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21());
        } else {
            this.mConnectionCallbackObj = null;
        }
    }

    public void onConnected() {
    }

    public void onConnectionFailed() {
    }

    public void onConnectionSuspended() {
    }

    void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
        this.mConnectionCallbackInternal = connectionCallbackInternal;
    }
}
