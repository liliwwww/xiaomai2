package androidx.media;

import android.service.media.MediaBrowserService;
import androidx.annotation.RequiresApi;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplApi28 extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 {
    final /* synthetic */ MediaBrowserServiceCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$MediaBrowserServiceImplApi28(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = this.this$0.mCurConnection;
        return connectionRecord != null ? connectionRecord.browserInfo : new MediaSessionManager$RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
    }
}
