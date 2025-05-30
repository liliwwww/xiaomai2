package android.support.v4.media;

import android.os.Build;
import android.os.Parcel;
import android.support.v4.media.MediaBrowserCompatApi23;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class MediaBrowserCompat$ItemCallback {
    final Object mItemCallbackObj;

    /* compiled from: Taobao */
    private class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
        StubApi23() {
        }

        public void onError(@NonNull String str) {
            MediaBrowserCompat$ItemCallback.this.onError(str);
        }

        public void onItemLoaded(Parcel parcel) {
            if (parcel == null) {
                MediaBrowserCompat$ItemCallback.this.onItemLoaded(null);
                return;
            }
            parcel.setDataPosition(0);
            MediaBrowserCompat$MediaItem createFromParcel = MediaBrowserCompat$MediaItem.CREATOR.createFromParcel(parcel);
            parcel.recycle();
            MediaBrowserCompat$ItemCallback.this.onItemLoaded(createFromParcel);
        }
    }

    public MediaBrowserCompat$ItemCallback() {
        if (Build.VERSION.SDK_INT >= 23) {
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23());
        } else {
            this.mItemCallbackObj = null;
        }
    }

    public void onError(@NonNull String str) {
    }

    public void onItemLoaded(MediaBrowserCompat$MediaItem mediaBrowserCompat$MediaItem) {
    }
}
