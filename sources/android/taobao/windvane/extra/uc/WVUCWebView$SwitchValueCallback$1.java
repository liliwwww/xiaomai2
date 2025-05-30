package android.taobao.windvane.extra.uc;

import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.CoreEventCallback;
import com.uc.webview.export.WebView;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVUCWebView$SwitchValueCallback$1 implements Runnable {
    final /* synthetic */ WVUCWebView.SwitchValueCallback this$0;

    WVUCWebView$SwitchValueCallback$1(WVUCWebView.SwitchValueCallback switchValueCallback) {
        this.this$0 = switchValueCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        CoreEventCallback coreEventCallback;
        AtomicBoolean atomicBoolean;
        CoreEventCallback coreEventCallback2;
        coreEventCallback = WVUCWebView.coreEventCallback;
        if (coreEventCallback != null) {
            WVCoreSettings wVCoreSettings = WVCoreSettings.getInstance();
            coreEventCallback2 = WVUCWebView.coreEventCallback;
            wVCoreSettings.setCoreEventCallback(coreEventCallback2);
        }
        if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
            for (CoreEventCallback coreEventCallback3 : WVCoreSettings.getInstance().coreEventCallbacks) {
                if (coreEventCallback3 != null) {
                    coreEventCallback3.onCoreSwitch();
                }
            }
        }
        WVEventService.getInstance().onEvent(3017);
        if (WVCore.getInstance().isUCSupport() || WebView.getCoreType() != 3) {
            if (WebView.getCoreType() == 2) {
                WVCore.getInstance().setUCSupport(false);
                return;
            }
            return;
        }
        WVCore.getInstance().setUCSupport(true);
        WVEventService.getInstance().onEvent(3016);
        TaoLog.i("WVUCWebView", "UCSDK onUCMCoreSwitched: " + WebView.getCoreType());
        if (WVCoreSettings.getInstance().coreEventCallbacks != null) {
            for (CoreEventCallback coreEventCallback4 : WVCoreSettings.getInstance().coreEventCallbacks) {
                if (coreEventCallback4 != null) {
                    coreEventCallback4.onUCCorePrepared();
                }
            }
        }
        if (GlobalConfig.context != null) {
            atomicBoolean = WVUCWebView.initAfterUCCoreReady;
            if (atomicBoolean.compareAndSet(false, true)) {
                WVUCWebView.initAfterUCReady(GlobalConfig.context, this.this$0.startTime);
            }
        }
    }
}
