package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MediaSessionCompatApi21$QueueItem {
    private MediaSessionCompatApi21$QueueItem() {
    }

    public static Object createItem(Object obj, long j) {
        return new MediaSession.QueueItem((MediaDescription) obj, j);
    }

    public static Object getDescription(Object obj) {
        return ((MediaSession.QueueItem) obj).getDescription();
    }

    public static long getQueueId(Object obj) {
        return ((MediaSession.QueueItem) obj).getQueueId();
    }
}
