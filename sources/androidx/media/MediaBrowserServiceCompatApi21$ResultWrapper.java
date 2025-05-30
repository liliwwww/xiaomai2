package androidx.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserServiceCompatApi21$ResultWrapper<T> {
    MediaBrowserService.Result mResultObj;

    MediaBrowserServiceCompatApi21$ResultWrapper(MediaBrowserService.Result result) {
        this.mResultObj = result;
    }

    public void detach() {
        this.mResultObj.detach();
    }

    List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcel parcel : list) {
            parcel.setDataPosition(0);
            arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void sendResult(T t) {
        if (t instanceof List) {
            this.mResultObj.sendResult(parcelListToItemList((List) t));
            return;
        }
        if (!(t instanceof Parcel)) {
            this.mResultObj.sendResult(null);
            return;
        }
        Parcel parcel = (Parcel) t;
        parcel.setDataPosition(0);
        this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
        parcel.recycle();
    }
}
