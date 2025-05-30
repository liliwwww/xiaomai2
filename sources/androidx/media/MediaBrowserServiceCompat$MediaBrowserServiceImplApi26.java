package androidx.media;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompat;
import androidx.annotation.RequiresApi;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi26;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserServiceCompat$MediaBrowserServiceImplApi26 extends MediaBrowserServiceCompat$MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
    final /* synthetic */ MediaBrowserServiceCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaBrowserServiceCompat$MediaBrowserServiceImplApi26(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        super(mediaBrowserServiceCompat);
        this.this$0 = mediaBrowserServiceCompat;
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public Bundle getBrowserRootHints() {
        MediaBrowserServiceCompat.ConnectionRecord connectionRecord = this.this$0.mCurConnection;
        if (connectionRecord == null) {
            return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
        }
        if (connectionRecord.rootHints == null) {
            return null;
        }
        return new Bundle(this.this$0.mCurConnection.rootHints);
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
    void notifyChildrenChangedForFramework(String str, Bundle bundle) {
        if (bundle != null) {
            MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, str, bundle);
        } else {
            super.notifyChildrenChangedForFramework(str, bundle);
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
    public void onCreate() {
        Object createService = MediaBrowserServiceCompatApi26.createService(this.this$0, this);
        this.mServiceObj = createService;
        MediaBrowserServiceCompatApi21.onCreate(createService);
    }

    @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
    public void onLoadChildren(String str, final MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
        this.this$0.onLoadChildren(str, new MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26.1
            public void detach() {
                resultWrapper.detach();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel obtain = Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                resultWrapper.sendResult(arrayList, getFlags());
            }
        }, bundle);
    }
}
