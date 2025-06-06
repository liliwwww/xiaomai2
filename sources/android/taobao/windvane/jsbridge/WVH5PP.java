package android.taobao.windvane.jsbridge;

import android.os.SystemClock;
import android.taobao.windvane.extra.performance2.IPerformance;
import android.taobao.windvane.extra.uc.preRender.BasePreInitManager;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.utils.TimeUtils;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.monitor.procedure.IProcedure;
import com.taobao.monitor.procedure.ViewToken;
import com.uc.webview.export.WebView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tb.zy3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVH5PP extends WVApiPlugin {
    private static final String TAG = "WVH5PP";
    private static Set<String> activityPropertiedSet;
    private static Set<String> activityStagedSet;
    private static Set<String> launcherPropertiedSet;
    private static Set<String> launcherStagedSet;
    private static Set<String> procedurePropertiedSet;
    private static Set<String> procedureStagedSet;

    private void procedureProperty(JSONObject jSONObject, IProcedure iProcedure, Set<String> set, WVCallBackContext wVCallBackContext) throws JSONException {
        FalcoSpan falcoSpan;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (set.contains(next)) {
                TaoLog.v(TAG, "property add abort because added:" + next);
            } else {
                String string = jSONObject.getString(next);
                TaoLog.v(TAG, "key:" + next + " value:" + string);
                IPerformance webview = wVCallBackContext.getWebview();
                if ("isFinished".equals(next) && BasePreInitManager.PRE_RENDER_URL_ADDITION_VALUE.equalsIgnoreCase(string)) {
                    if (webview instanceof WebView) {
                        try {
                            ((WebView) webview).setTag(ViewToken.APM_VIEW_TOKEN, "valid_view");
                        } catch (Throwable th) {
                            TaoLog.d(TAG, "ViewToken doesn't exist: " + th);
                        }
                        TaoLog.d(TAG, "receive isFinished setTag " + SystemClock.uptimeMillis());
                    }
                    if (webview instanceof IPerformance) {
                        webview.setReportedFSP(true);
                    }
                }
                iProcedure.addProperty("H5_H5_" + next, string);
                if ((webview instanceof IFullTrace) && (falcoSpan = ((IFullTrace) webview).getFalcoSpan()) != null) {
                    falcoSpan.setTag("H5_H5_" + next, string);
                }
                set.add(next);
            }
        }
    }

    private void procedureStage(JSONObject jSONObject, IProcedure iProcedure, Set<String> set, IWVWebView iWVWebView) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (set.contains(next)) {
                TaoLog.v(TAG, "stage add abort because added:" + next);
            } else {
                Long valueOf = Long.valueOf(jSONObject.getLong(next));
                Long valueOf2 = Long.valueOf(TimeUtils.generateUptimeFromCurrentTime(valueOf.longValue()));
                TaoLog.v(TAG, "stage:" + next + " time:" + valueOf2);
                StringBuilder sb = new StringBuilder();
                sb.append("H5_H5_");
                sb.append(next);
                iProcedure.stage(sb.toString(), valueOf2.longValue());
                if (iWVWebView instanceof IFullTrace) {
                    FullTraceUtils.addCustomStage(((IFullTrace) iWVWebView).getFalcoSpan(), "H5_H5_" + next, valueOf);
                }
                set.add(next);
            }
        }
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("receiveFSPTime".equals(str)) {
            receiveFSPTime(str2, wVCallBackContext);
            return true;
        }
        if ("receiveFPTime".equals(str)) {
            receiveFPTime(str2, wVCallBackContext);
            return true;
        }
        if ("receiveTTITime".equals(str)) {
            receiveTTITime(str2, wVCallBackContext);
            return true;
        }
        if ("onStage".equals(str)) {
            onStage(str2, wVCallBackContext);
            return true;
        }
        if (!"onProperty".equals(str)) {
            return false;
        }
        onProperty(str2, wVCallBackContext);
        return true;
    }

    public final void onProperty(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("property");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                IProcedure launcherProcedure = zy3.b.getLauncherProcedure();
                if (launcherProcedure == null || !launcherProcedure.isAlive()) {
                    TaoLog.v(TAG, "LauncherProcedure is not Alive");
                } else {
                    procedureProperty(optJSONObject, launcherProcedure, launcherPropertiedSet, wVCallBackContext);
                }
                IProcedure currentActivityProcedure = zy3.b.getCurrentActivityProcedure();
                if (currentActivityProcedure == null || !currentActivityProcedure.isAlive()) {
                    TaoLog.v(TAG, "CurrentActivityProcedure is not Alive");
                } else {
                    procedureProperty(optJSONObject, currentActivityProcedure, activityPropertiedSet, wVCallBackContext);
                }
                IProcedure procedure = zy3.b.getProcedure(wVCallBackContext.getWebview());
                if (procedure == null || !procedure.isAlive()) {
                    TaoLog.v(TAG, "Procedure is not Alive");
                } else {
                    procedureProperty(optJSONObject, procedure, procedurePropertiedSet, wVCallBackContext);
                }
            }
            wVCallBackContext.success();
        } catch (Throwable unused) {
            wVCallBackContext.error();
        }
    }

    public final void onStage(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("stage");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                IProcedure launcherProcedure = zy3.b.getLauncherProcedure();
                if (launcherProcedure == null || !launcherProcedure.isAlive()) {
                    TaoLog.v(TAG, "LauncherProcedure is not Alive");
                } else {
                    procedureStage(optJSONObject, launcherProcedure, launcherStagedSet, wVCallBackContext.getWebview());
                }
                IProcedure currentActivityProcedure = zy3.b.getCurrentActivityProcedure();
                if (currentActivityProcedure == null || !currentActivityProcedure.isAlive()) {
                    TaoLog.v(TAG, "CurrentActivityProcedure is not Alive");
                } else {
                    procedureStage(optJSONObject, currentActivityProcedure, activityStagedSet, wVCallBackContext.getWebview());
                }
                IProcedure procedure = zy3.b.getProcedure(wVCallBackContext.getWebview());
                if (procedure == null || !procedure.isAlive()) {
                    TaoLog.v(TAG, "LauncherProcedure is not Alive");
                } else {
                    procedureStage(optJSONObject, procedure, procedureStagedSet, wVCallBackContext.getWebview());
                }
            }
            wVCallBackContext.success();
        } catch (Throwable unused) {
            wVCallBackContext.error();
        }
    }

    public final void receiveFPTime(String str, WVCallBackContext wVCallBackContext) {
        if (((WVApiPlugin) this).performance == null) {
            return;
        }
        try {
            long optLong = new JSONObject(str).optLong("time");
            if (optLong != 0) {
                ((WVApiPlugin) this).performance.receiveJSMessageForFP(optLong);
            }
            wVCallBackContext.success();
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    public final void receiveFSPTime(String str, WVCallBackContext wVCallBackContext) {
        if (((WVApiPlugin) this).performance == null) {
            return;
        }
        try {
            long optLong = new JSONObject(str).optLong("time");
            if (optLong != 0) {
                ((WVApiPlugin) this).performance.receiveJSMessageForFSP(optLong);
            }
            wVCallBackContext.success();
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    public final void receiveTTITime(String str, WVCallBackContext wVCallBackContext) {
        if (((WVApiPlugin) this).performance == null) {
            return;
        }
        try {
            long optLong = new JSONObject(str).optLong("time");
            if (optLong != 0) {
                ((WVApiPlugin) this).performance.receiveJSMessageForTTI(optLong);
            }
            wVCallBackContext.success();
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    public void resetAllStoredSet() {
        launcherStagedSet = new HashSet();
        activityStagedSet = new HashSet();
        procedureStagedSet = new HashSet();
        launcherPropertiedSet = new HashSet();
        activityPropertiedSet = new HashSet();
        procedurePropertiedSet = new HashSet();
    }
}
