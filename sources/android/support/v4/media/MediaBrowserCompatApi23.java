package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaBrowserCompatApi23 {

    /* compiled from: Taobao */
    static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        public ItemCallbackProxy(T t) {
            this.mItemCallback = t;
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(@NonNull String str) {
            this.mItemCallback.onError(str);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.mItemCallback.onItemLoaded((Parcel) null);
                return;
            }
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.mItemCallback.onItemLoaded(obtain);
        }
    }

    private MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }

    public static void getItem(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (MediaBrowser.ItemCallback) obj2);
    }
}
