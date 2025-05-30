package android.support.v4.media;

import android.media.browse.MediaBrowser;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaBrowserCompatApi21$MediaItem {
    private MediaBrowserCompatApi21$MediaItem() {
    }

    public static Object getDescription(Object obj) {
        return ((MediaBrowser.MediaItem) obj).getDescription();
    }

    public static int getFlags(Object obj) {
        return ((MediaBrowser.MediaItem) obj).getFlags();
    }
}
