package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserCompat$MediaBrowserImplApi21$3 implements Runnable {
    final /* synthetic */ MediaBrowserCompat.MediaBrowserImplApi21 this$0;
    final /* synthetic */ MediaBrowserCompat$ItemCallback val$cb;
    final /* synthetic */ String val$mediaId;

    MediaBrowserCompat$MediaBrowserImplApi21$3(MediaBrowserCompat.MediaBrowserImplApi21 mediaBrowserImplApi21, MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback, String str) {
        this.this$0 = mediaBrowserImplApi21;
        this.val$cb = mediaBrowserCompat$ItemCallback;
        this.val$mediaId = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$cb.onError(this.val$mediaId);
    }
}
