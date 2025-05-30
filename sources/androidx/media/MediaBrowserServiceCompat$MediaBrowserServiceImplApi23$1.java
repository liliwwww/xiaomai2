package androidx.media;

import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import androidx.media.MediaBrowserServiceCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1 extends MediaBrowserServiceCompat.Result<MediaBrowserCompat$MediaItem> {
    final /* synthetic */ MediaBrowserServiceCompat.MediaBrowserServiceImplApi23 this$1;
    final /* synthetic */ MediaBrowserServiceCompatApi21$ResultWrapper val$resultWrapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1(MediaBrowserServiceCompat.MediaBrowserServiceImplApi23 mediaBrowserServiceImplApi23, Object obj, MediaBrowserServiceCompatApi21$ResultWrapper mediaBrowserServiceCompatApi21$ResultWrapper) {
        super(obj);
        this.this$1 = mediaBrowserServiceImplApi23;
        this.val$resultWrapper = mediaBrowserServiceCompatApi21$ResultWrapper;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public void detach() {
        this.val$resultWrapper.detach();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public void onResultSent(MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
        if (mediaBrowserCompat$MediaItem == null) {
            this.val$resultWrapper.sendResult(null);
            return;
        }
        Parcel obtain = Parcel.obtain();
        mediaBrowserCompat$MediaItem.writeToParcel(obtain, 0);
        this.val$resultWrapper.sendResult(obtain);
    }
}
