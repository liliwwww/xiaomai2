package android.taobao.windvane.extra.uc;

import android.os.Bundle;
import android.taobao.windvane.util.TaoLog;
import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVUCWebView$OnInitStart implements ValueCallback<Bundle> {
    private WVUCWebView$OnInitStart() {
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(Bundle bundle) {
        TaoLog.i("WVUCWebView", "on init start:[" + bundle + "]");
        if (bundle != null) {
            "bit_by_old_dex_dir".equals(bundle.getString("bo_init_type"));
        }
    }
}
