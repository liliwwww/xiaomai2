package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class MediaControllerCompatApi23$TransportControls {
    private MediaControllerCompatApi23$TransportControls() {
    }

    public static void playFromUri(Object obj, Uri uri, Bundle bundle) {
        ((MediaController.TransportControls) obj).playFromUri(uri, bundle);
    }
}
