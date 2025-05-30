package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserCompatApi21$SubscriptionCallbackProxy<T extends MediaBrowserCompatApi21.SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
    protected final T mSubscriptionCallback;

    public MediaBrowserCompatApi21$SubscriptionCallbackProxy(T t) {
        this.mSubscriptionCallback = t;
    }

    @Override // android.media.browse.MediaBrowser.SubscriptionCallback
    public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
        this.mSubscriptionCallback.onChildrenLoaded(str, list);
    }

    @Override // android.media.browse.MediaBrowser.SubscriptionCallback
    public void onError(@NonNull String str) {
        this.mSubscriptionCallback.onError(str);
    }
}
