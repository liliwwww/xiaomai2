package androidx.core.app;

import android.app.Activity;
import android.net.Uri;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(22)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActivityCompat$Api22Impl {
    private ActivityCompat$Api22Impl() {
    }

    @DoNotInline
    static Uri getReferrer(Activity activity) {
        return activity.getReferrer();
    }
}
