package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2 implements Runnable {
    final /* synthetic */ MediaBrowserServiceCompat.MediaBrowserServiceImplBase this$1;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ String val$parentId;

    MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2(MediaBrowserServiceCompat.MediaBrowserServiceImplBase mediaBrowserServiceImplBase, String str, Bundle bundle) {
        this.this$1 = mediaBrowserServiceImplBase;
        this.val$parentId = str;
        this.val$options = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<IBinder> it = this.this$1.this$0.mConnections.keySet().iterator();
        while (it.hasNext()) {
            this.this$1.notifyChildrenChangedOnHandler((MediaBrowserServiceCompat.ConnectionRecord) this.this$1.this$0.mConnections.get(it.next()), this.val$parentId, this.val$options);
        }
    }
}
