package android.support.v4.media.session;

import android.media.session.MediaSession;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(22)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionCompatApi22 {
    private MediaSessionCompatApi22() {
    }

    public static void setRatingType(Object obj, int i) {
        ((MediaSession) obj).setRatingType(i);
    }
}
