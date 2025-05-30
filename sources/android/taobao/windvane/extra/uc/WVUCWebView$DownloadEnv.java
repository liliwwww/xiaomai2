package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: protected */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WVUCWebView$DownloadEnv implements Callable<Boolean> {
    Context context;

    WVUCWebView$DownloadEnv(Context context) {
        this.context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        String currentNetworkType = WVUCWebView.getCurrentNetworkType(GlobalConfig.context);
        boolean z = true;
        boolean z2 = GlobalConfig.getInstance().isOpen4GDownload() && TextUtils.equals("4g", currentNetworkType);
        WVCommonConfig.getInstance();
        if (!(WVCommonConfig.commonConfig.open5GAdapter && GlobalConfig.getInstance().isOpen5GDownload() && TextUtils.equals("5g", currentNetworkType)) && !z2 && !TextUtils.equals("WIFI", currentNetworkType)) {
            z = false;
        }
        if (z) {
            TaoLog.i("UCCore", "start download u4 core,is4G=[" + WVCore.getInstance().isOpen4GDownload() + "]");
        } else {
            WVUCWebView.access$1700().set(false);
            WVUCWebView.access$1600().set(false);
            TaoLog.e("UCCore", "current env cannot download u4 core");
        }
        return Boolean.valueOf(z);
    }
}
