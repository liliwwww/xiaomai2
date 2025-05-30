package androidx.core.net;

import android.net.ConnectivityManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

/* compiled from: Taobao */
@RequiresApi(16)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ConnectivityManagerCompat$Api16Impl {
    private ConnectivityManagerCompat$Api16Impl() {
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    @DoNotInline
    static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
