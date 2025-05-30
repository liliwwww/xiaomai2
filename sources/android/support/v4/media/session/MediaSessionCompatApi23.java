package android.support.v4.media.session;

import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MediaSessionCompatApi23 {
    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
