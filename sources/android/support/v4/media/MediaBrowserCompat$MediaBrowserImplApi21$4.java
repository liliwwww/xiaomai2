package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserCompat$MediaBrowserImplApi21$4 implements Runnable {
    final /* synthetic */ MediaBrowserCompat.MediaBrowserImplApi21 this$0;
    final /* synthetic */ MediaBrowserCompat.SearchCallback val$callback;
    final /* synthetic */ Bundle val$extras;
    final /* synthetic */ String val$query;

    MediaBrowserCompat$MediaBrowserImplApi21$4(MediaBrowserCompat.MediaBrowserImplApi21 mediaBrowserImplApi21, MediaBrowserCompat.SearchCallback searchCallback, String str, Bundle bundle) {
        this.this$0 = mediaBrowserImplApi21;
        this.val$callback = searchCallback;
        this.val$query = str;
        this.val$extras = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callback.onError(this.val$query, this.val$extras);
    }
}
