package androidx.core.app;

import android.app.Service;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ServiceCompat$Api24Impl {
    private ServiceCompat$Api24Impl() {
    }

    @DoNotInline
    static void stopForeground(Service service, int i) {
        service.stopForeground(i);
    }
}
