package android.taobao.windvane.extra.uc;

import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.WVUrlUtil;
import android.webkit.ValueCallback;
import com.taobao.android.IDiagnoseInterface;
import com.taobao.android.diagnose.scene.engine.api.Facts;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class UCCoreController$1 implements ValueCallback<Map<String, Object>> {
    final /* synthetic */ SpanWrapper val$spanWrapper;

    UCCoreController$1(SpanWrapper spanWrapper) {
        this.val$spanWrapper = spanWrapper;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(Map<String, Object> map) {
        try {
            String str = "ThreadWatchdog get callback. pid: " + ((Integer) map.get("pid")).intValue() + ", tid: " + ((Integer) map.get("tid")).intValue() + ", threadName: " + ((String) map.get("threadName")) + ", state: " + ((String) map.get("state")) + ", type: " + ((String) map.get("type")) + ", url: " + ((String) map.get("url")) + ", webviewCount: " + ((Integer) map.get("webviewCount")).intValue() + ", taskInfo: " + ((String) map.get("taskInfo")) + ", elapseInMs: " + ((Integer) map.get("elapseInMs")).intValue() + ", alarmInMs: " + ((Integer) map.get("alarmInMs")).intValue() + ", stack: " + ((String) map.get("stack"));
            this.val$spanWrapper.log(str);
            String removeQueriesUrl = WVUrlUtil.getRemoveQueriesUrl((String) map.get("url"));
            AppMonitorUtil.commitFail("ThreadWatchdog", 0, removeQueriesUrl, str);
            Facts facts = new Facts();
            facts.put("url", removeQueriesUrl);
            facts.put("threadName", (String) map.get("threadName"));
            IDiagnoseInterface.getInstance().sceneTrigger("windvane_render_timeout", facts);
        } catch (Throwable th) {
            AppMonitorUtil.commitFail("ThreadWatchdog", 1, WVUrlUtil.getRemoveQueriesUrl((String) map.get("url")), "err:" + th + " StackTrace::" + CommonUtils.getStackTrace(th));
        }
    }
}
