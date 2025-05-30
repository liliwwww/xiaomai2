package android.taobao.windvane.extra.p002uc;

import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.WVUrlUtil;
import android.webkit.ValueCallback;
import com.taobao.android.IDiagnoseInterface;
import com.taobao.android.diagnose.scene.engine.api.Facts;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UCCoreController {
    private static final String TAG = "UCCoreController";
    private static final AtomicBoolean sRegisteredThreadANRCallback = new AtomicBoolean(false);

    public static void registerThreadANRCallback(final SpanWrapper spanWrapper) {
        if (sRegisteredThreadANRCallback.compareAndSet(false, true)) {
            spanWrapper.log("registerThreadANRCallback");
            new ValueCallback<Map<String, Object>>() { // from class: android.taobao.windvane.extra.uc.UCCoreController.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Map<String, Object> map) {
                    try {
                        String str = "ThreadWatchdog get callback. pid: " + ((Integer) map.get("pid")).intValue() + ", tid: " + ((Integer) map.get("tid")).intValue() + ", threadName: " + ((String) map.get("threadName")) + ", state: " + ((String) map.get("state")) + ", type: " + ((String) map.get("type")) + ", url: " + ((String) map.get(HttpConnector.URL)) + ", webviewCount: " + ((Integer) map.get("webviewCount")).intValue() + ", taskInfo: " + ((String) map.get("taskInfo")) + ", elapseInMs: " + ((Integer) map.get("elapseInMs")).intValue() + ", alarmInMs: " + ((Integer) map.get("alarmInMs")).intValue() + ", stack: " + ((String) map.get("stack"));
                        SpanWrapper.this.log(str);
                        String removeQueriesUrl = WVUrlUtil.getRemoveQueriesUrl((String) map.get(HttpConnector.URL));
                        AppMonitorUtil.commitFail("ThreadWatchdog", 0, removeQueriesUrl, str);
                        Facts facts = new Facts();
                        facts.put(HttpConnector.URL, removeQueriesUrl);
                        facts.put("threadName", (String) map.get("threadName"));
                        IDiagnoseInterface.getInstance().sceneTrigger("windvane_render_timeout", facts);
                    } catch (Throwable th) {
                        AppMonitorUtil.commitFail("ThreadWatchdog", 1, WVUrlUtil.getRemoveQueriesUrl((String) map.get(HttpConnector.URL)), "err:" + th + " StackTrace::" + CommonUtils.getStackTrace(th));
                    }
                }
            };
        }
    }
}
