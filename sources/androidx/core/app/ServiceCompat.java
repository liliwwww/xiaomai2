package androidx.core.app;

import android.app.Service;
import android.os.Build;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    private ServiceCompat() {
    }

    public static void stopForeground(@NonNull Service service, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.stopForeground(service, i);
        } else {
            service.stopForeground((i & 1) != 0);
        }
    }
}
