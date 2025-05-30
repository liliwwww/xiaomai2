package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserServiceCompat$ConnectionRecord$1 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.ConnectionRecord this$1;

    MediaBrowserServiceCompat$ConnectionRecord$1(MediaBrowserServiceCompat.ConnectionRecord connectionRecord) {
        this.this$1 = connectionRecord;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = this.this$1;
        connectionRecord.this$0.mConnections.remove(connectionRecord.callbacks.asBinder());
    }
}
