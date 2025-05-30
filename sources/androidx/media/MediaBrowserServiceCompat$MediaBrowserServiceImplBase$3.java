package androidx.media;

import android.os.Bundle;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.MediaBrowserServiceImplBase this$1;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;
    final /* synthetic */ MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

    MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3(MediaBrowserServiceCompat.MediaBrowserServiceImplBase mediaBrowserServiceImplBase, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
        this.this$1 = mediaBrowserServiceImplBase;
        this.val$remoteUserInfo = remoteUserInfo;
        this.val$parentId = str;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.this$1.this$0.mConnections.size(); i++) {
            MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord) this.this$1.this$0.mConnections.valueAt(i);
            if (connectionRecord.browserInfo.equals(this.val$remoteUserInfo)) {
                this.this$1.notifyChildrenChangedOnHandler(connectionRecord, this.val$parentId, this.val$options);
                return;
            }
        }
    }
}
