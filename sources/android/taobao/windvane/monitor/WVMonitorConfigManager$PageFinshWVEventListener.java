package android.taobao.windvane.monitor;

import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVMonitorConfigManager$PageFinshWVEventListener implements WVEventListener {
    private WVMonitorConfigManager$PageFinshWVEventListener() {
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        if (i != 1002) {
            return null;
        }
        try {
            double d = WVMonitorConfigManager.getInstance().config.perfCheckSampleRate;
            String str = WVMonitorConfigManager.getInstance().config.perfCheckURL;
            if (TextUtils.isEmpty("scriptUrl") || d <= Math.random()) {
                return null;
            }
            wVEventContext.webView.evaluateJavascript(String.format("(function(d){var s = d.createElement('script');s.src='%s';d.head.appendChild(s);})(document)", str));
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* synthetic */ WVMonitorConfigManager$PageFinshWVEventListener(WVMonitorConfigManager$1 wVMonitorConfigManager$1) {
        this();
    }
}
