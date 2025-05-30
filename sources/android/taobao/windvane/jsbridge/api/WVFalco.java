package android.taobao.windvane.jsbridge.api;

import android.content.Context;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.extra.performance2.IPerformance;
import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.analysis.v3.FalcoSpan;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVFalco extends WVApiPlugin {
    private static final String FAIL_REASON = "fail_reason";
    private static final int LEVEL_PHASE = 1;
    private static final int LEVEL_STAGE = 2;
    private static final String MONITOR_MODULE = "WindVane";
    private static final String MONITOR_POINT = "WVFalco";
    private static final String TAG = "WVFalco";
    private IPerformance webView;
    private SpanWrapper webviewSpanWrapper;
    private SpanWrapper windvaneSpanWrapper;
    boolean webviewSpanFinished = false;
    private int stageLimit = 1000;
    private int propertyLimit = 1000;
    private Map<String, SpanWrapper> phaseMap = new HashMap();
    private Map<String, SpanWrapper> stageMap = new HashMap();
    private String pageName = "h5_page";

    private boolean findSpan(SpanWrapper spanWrapper, WVCallBackContext wVCallBackContext, JSONObject jSONObject) {
        SpanWrapper spanWrapper2 = this.webviewSpanWrapper;
        if (spanWrapper2 != null) {
            spanWrapper.setFalcoSpan(spanWrapper2);
        } else {
            spanWrapper.setFalcoSpan(this.windvaneSpanWrapper);
            TaoLog.m21e("WVFalco", "pageName not set,use windvane span to findSpan");
            IPerformance iPerformance = this.webView;
            AppMonitor.Alarm.commitFail("WindVane", "WVFalco", iPerformance != null ? iPerformance.getCachedUrl() : EnvironmentCompat.MEDIA_UNKNOWN, ExifInterface.GPS_MEASUREMENT_2D, "findSpan");
        }
        String optString = jSONObject.optString("phaseID");
        if (!TextUtils.isEmpty(optString)) {
            SpanWrapper spanWrapper3 = this.phaseMap.get(optString);
            if (spanWrapper3 == null) {
                wVCallBackContext.error(FAIL_REASON, "no such phase");
                return false;
            }
            spanWrapper.setFalcoSpan(spanWrapper3);
        }
        String optString2 = jSONObject.optString("stageID");
        if (TextUtils.isEmpty(optString2)) {
            return true;
        }
        SpanWrapper spanWrapper4 = this.stageMap.get(optString2);
        if (spanWrapper4 == null) {
            wVCallBackContext.error(FAIL_REASON, "no such stage");
            return false;
        }
        spanWrapper.setFalcoSpan(spanWrapper4);
        return true;
    }

    private void finishSpan(String str, WVCallBackContext wVCallBackContext, int i) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("errorCode");
            if (i == 1) {
                SpanWrapper remove = this.phaseMap.remove(jSONObject.optString("phaseID"));
                if (remove == null) {
                    wVCallBackContext.error(FAIL_REASON, "phase doesn't exist");
                    return;
                }
                finishSpan(optString, remove);
            } else {
                SpanWrapper remove2 = this.stageMap.remove(jSONObject.optString("stageID"));
                if (remove2 == null) {
                    wVCallBackContext.error(FAIL_REASON, "stage doesn't exist");
                    return;
                }
                finishSpan(optString, remove2);
            }
            wVCallBackContext.success();
        } catch (Throwable th) {
            wVCallBackContext.error(FAIL_REASON, th.toString());
        }
    }

    private void startSpan(String str, WVCallBackContext wVCallBackContext, int i) {
        FalcoSpan makeSpanChildOf;
        String spanId;
        Iterator<String> keys;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (i == 1) {
                String optString = jSONObject.optString("phaseName");
                SpanWrapper spanWrapper = this.webviewSpanWrapper;
                if (spanWrapper != null) {
                    String str2 = this.pageName;
                    makeSpanChildOf = FullTraceUtils.makeSpanChildOf(str2, str2, spanWrapper);
                } else {
                    String str3 = this.pageName;
                    FalcoSpan makeSpanChildOf2 = FullTraceUtils.makeSpanChildOf(str3, str3, this.windvaneSpanWrapper);
                    TaoLog.m21e("WVFalco", "pageName not set,use windvane span to make Span");
                    String str4 = EnvironmentCompat.MEDIA_UNKNOWN;
                    IPerformance iPerformance = this.webView;
                    if (iPerformance != null) {
                        str4 = iPerformance.getCachedUrl();
                    }
                    AppMonitor.Alarm.commitFail("WindVane", "WVFalco", str4, "1", "makeSpan");
                    makeSpanChildOf = makeSpanChildOf2;
                }
                if (makeSpanChildOf == null) {
                    wVCallBackContext.error(FAIL_REASON, "fail to make new span");
                    return;
                } else {
                    makeSpanChildOf.setOperationName(optString);
                    spanId = makeSpanChildOf.context().toSpanId();
                    this.phaseMap.put(spanId, new SpanWrapper(makeSpanChildOf));
                }
            } else {
                String optString2 = jSONObject.optString("phaseID");
                String optString3 = jSONObject.optString("stageName");
                SpanWrapper spanWrapper2 = this.phaseMap.get(optString2);
                if (spanWrapper2 == null) {
                    wVCallBackContext.error(FAIL_REASON, "phase doesn't exist");
                    return;
                }
                String str5 = this.pageName;
                makeSpanChildOf = FullTraceUtils.makeSpanChildOf(str5, str5, spanWrapper2);
                if (makeSpanChildOf == null) {
                    wVCallBackContext.error(FAIL_REASON, "fail to make new span");
                    return;
                } else {
                    makeSpanChildOf.setOperationName(optString3);
                    spanId = makeSpanChildOf.context().toSpanId();
                    this.stageMap.put(spanId, new SpanWrapper(makeSpanChildOf));
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("property");
            if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
                while (this.propertyLimit > 0 && keys.hasNext()) {
                    String next = keys.next();
                    makeSpanChildOf.setTag(next, optJSONObject.getString(next));
                    this.propertyLimit--;
                }
            }
            WVResult wVResult = new WVResult();
            if (i == 1) {
                wVResult.addData("phaseID", spanId);
            } else {
                wVResult.addData("stageID", spanId);
            }
            wVCallBackContext.success(wVResult);
        } catch (Throwable th) {
            wVCallBackContext.error(FAIL_REASON, th.toString());
        }
    }

    public final void addLog(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("log");
            if (jSONObject2 == null) {
                wVCallBackContext.error(FAIL_REASON, "There is no log");
                return;
            }
            SpanWrapper spanWrapper = new SpanWrapper();
            if (findSpan(spanWrapper, wVCallBackContext, jSONObject)) {
                Iterator<String> keys = jSONObject2.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        spanWrapper.releaseLog(next + "  " + jSONObject2.getString(next));
                    }
                }
                wVCallBackContext.success();
            }
        } catch (Throwable th) {
            wVCallBackContext.error(FAIL_REASON, th.toString());
        }
    }

    public final void addProperty(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("property");
            if (jSONObject2 == null) {
                wVCallBackContext.error(FAIL_REASON, "There is no property");
                return;
            }
            SpanWrapper spanWrapper = new SpanWrapper();
            if (findSpan(spanWrapper, wVCallBackContext, jSONObject)) {
                Iterator<String> keys = jSONObject2.keys();
                if (keys != null) {
                    while (this.propertyLimit > 0 && keys.hasNext()) {
                        String next = keys.next();
                        spanWrapper.setCustomTag(next, jSONObject2.getString(next));
                        this.propertyLimit--;
                    }
                }
                wVCallBackContext.success();
            }
        } catch (Throwable th) {
            wVCallBackContext.error(FAIL_REASON, th.toString());
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        TaoLog.m21e("WVFalco", "execute() called with: action = [" + str + "], params = [" + str2 + "], callback = [" + wVCallBackContext + "]");
        if ("addLog".equals(str)) {
            addLog(str2, wVCallBackContext);
            return true;
        }
        if ("addProperties".equals(str)) {
            addProperty(str2, wVCallBackContext);
            return true;
        }
        if ("startPhase".equals(str)) {
            startSpan(str2, wVCallBackContext, 1);
            return true;
        }
        if ("finishPhase".equals(str)) {
            finishSpan(str2, wVCallBackContext, 1);
            return true;
        }
        if ("startStage".equals(str)) {
            startSpan(str2, wVCallBackContext, 2);
            return true;
        }
        if (!"finishStage".equals(str)) {
            return false;
        }
        finishSpan(str2, wVCallBackContext, 2);
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void initialize(Context context, IWVWebView iWVWebView) {
        super.initialize(context, iWVWebView);
        WVCommonConfig.getInstance();
        if (WVCommonConfig.commonConfig.enableWVFullTrace) {
            if (iWVWebView instanceof IFullTrace) {
                this.windvaneSpanWrapper = ((IFullTrace) iWVWebView).getSpanWrapper();
            }
            if (iWVWebView instanceof IPerformance) {
                this.webView = (IPerformance) iWVWebView;
            }
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onDestroy() {
        SpanWrapper spanWrapper;
        if (this.webviewSpanFinished || (spanWrapper = this.webviewSpanWrapper) == null) {
            return;
        }
        spanWrapper.finish();
        this.webviewSpanFinished = true;
    }

    public void setPageName(String str) {
        SpanWrapper spanWrapper;
        WVCommonConfig.getInstance();
        if (WVCommonConfig.commonConfig.enableWVFullTrace && !TextUtils.isEmpty(str)) {
            if (TextUtils.equals("h5_" + str, this.pageName)) {
                return;
            }
            String str2 = "h5_" + str;
            if (!this.webviewSpanFinished && (spanWrapper = this.webviewSpanWrapper) != null) {
                spanWrapper.finish();
            }
            this.pageName = str2;
            TaoLog.m21e("WVFalco", "pageName=" + str2);
            this.webviewSpanWrapper = new SpanWrapper(FullTraceUtils.makeSpanChildOf(str2, str2, this.windvaneSpanWrapper));
            this.webviewSpanFinished = false;
        }
    }

    private void finishSpan(String str, SpanWrapper spanWrapper) {
        if (TextUtils.isEmpty(str)) {
            spanWrapper.finish();
        } else {
            spanWrapper.setFailStatus();
            spanWrapper.finish(str);
        }
    }
}
