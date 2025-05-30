package androidx.media;

import android.os.Parcel;
import androidx.annotation.RequiresApi;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
    final /* synthetic */ MediaBrowserServiceCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$MediaBrowserServiceImplApi23(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        Object createService = MediaBrowserServiceCompatApi23.createService(this.this$0, this);
        this.mServiceObj = createService;
        MediaBrowserServiceCompatApi21.onCreate(createService);
    }

    @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
    public void onLoadItem(String str, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
        this.this$0.onLoadItem(str, new 1(this, str, resultWrapper));
    }
}
