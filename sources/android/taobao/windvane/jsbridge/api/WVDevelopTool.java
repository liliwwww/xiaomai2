package android.taobao.windvane.jsbridge.api;

import android.os.Build;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.debug.WVPageFinishJSRender;
import android.taobao.windvane.extra.uc.preRender.BasePreInitManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.monitor.WVLocPerformanceMonitor;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.log.AndroidLog;
import android.taobao.windvane.webview.WVWebView;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.location.LocationRequestCompat;
import com.taobao.orange.OrangeConfig;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVDevelopTool extends WVApiPlugin {
    private static final String TAG = "WVDevelopTool";
    private static int mLastMode;
    private boolean mIsDebugOpen = false;

    private void getURLContentType(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        try {
            String optString = new JSONObject(str).optString("url", "");
            if (WVServerConfig.isBlackUrl(optString)) {
                wVResult.addData("type", (Object) (-1));
            } else if (WVServerConfig.isTrustedUrl(optString)) {
                wVResult.addData("type", (Object) 8);
            } else if (WVServerConfig.isThirdPartyUrl(optString)) {
                wVResult.addData("type", (Object) 2);
            } else {
                wVResult.addData("type", (Object) 1);
            }
            wVCallBackContext.success(wVResult);
        } catch (JSONException unused) {
            wVCallBackContext.error(WVResult.RET_PARAM_ERR);
        } catch (Throwable unused2) {
            wVResult.addData("error", "failed to getURLContentType");
            wVCallBackContext.error(wVResult);
        }
    }

    private void readMemoryStatisitcs(WVCallBackContext wVCallBackContext, String str) {
        wVCallBackContext.success();
    }

    private void resetConfig(WVCallBackContext wVCallBackContext, String str) {
        WVConfigManager.getInstance().resetConfig();
        wVCallBackContext.success();
    }

    private void setDebugEnabled(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        try {
            if (new JSONObject(str).optBoolean("logLevel", true)) {
                TaoLog.setImpl(new AndroidLog());
                TaoLog.setLogSwitcher(true);
            } else {
                TaoLog.setLogSwitcher(false);
            }
            wVCallBackContext.success();
        } catch (JSONException unused) {
            wVCallBackContext.error(WVResult.RET_PARAM_ERR);
        } catch (Throwable unused2) {
            wVResult.addData("error", "failed to setDebugEnabled");
            wVCallBackContext.error(wVResult);
        }
    }

    private void updateConfig(WVCallBackContext wVCallBackContext, String str) {
        Map configs;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("configName", "");
            String optString2 = jSONObject.optString("configUrl", "");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                WVConfigManager.getInstance().updateConfig(optString, String.valueOf(LocationRequestCompat.PASSIVE_INTERVAL), optString2, WVConfigManager.WVConfigUpdateFromType.WVConfigUpdateFromTypeCustom);
                wVCallBackContext.success();
                return;
            }
        } catch (JSONException unused) {
            wVCallBackContext.error(WVResult.RET_PARAM_ERR);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            configs = OrangeConfig.getInstance().getConfigs("windvane_domain");
        } catch (JSONException e) {
            e.printStackTrace();
            wVCallBackContext.error();
        }
        if (configs != null && configs.size() != 0) {
            for (Map.Entry entry : configs.entrySet()) {
                String str2 = (String) entry.getValue();
                if (TextUtils.equals("aliDomain", (CharSequence) entry.getKey()) || TextUtils.equals("thirdPartyDomain", (CharSequence) entry.getKey())) {
                    str2 = ".*";
                }
                jSONObject2.put((String) entry.getKey(), str2);
            }
            jSONObject2.put("appVersion", GlobalConfig.getInstance().getAppVersion());
            WVConfigManager.getInstance().updateConfigByKey("windvane_domain", jSONObject2.toString());
            TaoLog.i("WVConfig", "receive name=[windvane_domain]; config=[" + jSONObject2.toString() + "]");
            wVCallBackContext.success();
            return;
        }
        WVConfigManager.getInstance().updateConfigByKey("windvane_domain", "");
    }

    public final void clearWebViewFinishJs(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            WVPageFinishJSRender.clearJsRender();
            wVCallBackContext.success();
        } catch (Throwable unused) {
            wVResult.addData("error", "failed to enable clearWebViewFinishJs");
            wVCallBackContext.error(wVResult);
        }
    }

    public final void clearWindVaneCache(String str, WVCallBackContext wVCallBackContext) {
        ((WVApiPlugin) this).mWebView.clearCache();
        wVCallBackContext.success();
    }

    public void closeLocPerformanceMonitor(String str, WVCallBackContext wVCallBackContext) {
        WVLocPerformanceMonitor.setOpenLocPerformanceMonitor(false);
    }

    public void closeSpdyforDebug(String str, WVCallBackContext wVCallBackContext) {
        EnvUtil.setOpenSpdyforDebug(false);
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("isDebugEnabled".equals(str)) {
            WVResult wVResult = new WVResult();
            wVResult.addData("global", String.valueOf(EnvUtil.isDebug()));
            wVCallBackContext.success(wVResult);
            return true;
        }
        if ("clearWindVaneCache".equals(str)) {
            clearWindVaneCache(str2, wVCallBackContext);
            return true;
        }
        if ("setWebViewDebugEnabled".equals(str)) {
            setWebViewDebugEnabled(str2, wVCallBackContext);
            return true;
        }
        if ("setWebViewFinishJs".equals(str)) {
            setWebViewFinishJs(str2, wVCallBackContext);
            return true;
        }
        if ("clearWebViewFinishJs".equals(str)) {
            clearWebViewFinishJs(str2, wVCallBackContext);
            return true;
        }
        if ("setUCEnabled".equals(str)) {
            setUCEnabled(str2, wVCallBackContext);
            return true;
        }
        if ("isUCEnabled".equals(str)) {
            isUCEnabled(str2, wVCallBackContext);
            return true;
        }
        if ("getLocPerformanceData".equals(str)) {
            getLocPerformanceData(str2, wVCallBackContext);
            return true;
        }
        if ("openSpdyforDebug".equals(str)) {
            openSpdyforDebug(str2, wVCallBackContext);
            return true;
        }
        if ("closeSpdyforDebug".equals(str)) {
            closeSpdyforDebug(str2, wVCallBackContext);
            return true;
        }
        if ("openLocPerformanceMonitor".equals(str)) {
            openLocPerformanceMonitor(str2, wVCallBackContext);
            return true;
        }
        if ("closeLocPerformanceMonitor".equals(str)) {
            closeLocPerformanceMonitor(str2, wVCallBackContext);
            return true;
        }
        if ("resetConfig".equals(str)) {
            resetConfig(wVCallBackContext, str2);
            return true;
        }
        if ("updateConfig".equals(str)) {
            updateConfig(wVCallBackContext, str2);
            return true;
        }
        if ("setDebugEnabled".equals(str)) {
            setDebugEnabled(wVCallBackContext, str2);
            return true;
        }
        if ("readMemoryStatisitcs".equals(str)) {
            readMemoryStatisitcs(wVCallBackContext, str2);
            return true;
        }
        if (!"getURLContentType".equals(str)) {
            return false;
        }
        getURLContentType(wVCallBackContext, str2);
        return true;
    }

    public void getLocPerformanceData(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            wVResult.setData(new JSONObject(WVLocPerformanceMonitor.getInstance().getMonitorData().toString()));
            wVCallBackContext.success(wVResult);
        } catch (Exception e) {
            wVCallBackContext.error(e.getMessage());
        }
    }

    public final void isUCEnabled(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        WVCommonConfig.getInstance();
        if (WVCommonConfig.commonConfig.useSystemWebView) {
            wVResult.addData("enabled", "false");
        } else {
            wVResult.addData("enabled", BasePreInitManager.PRE_RENDER_URL_ADDITION_VALUE);
        }
        wVCallBackContext.success(wVResult);
    }

    public void openLocPerformanceMonitor(String str, WVCallBackContext wVCallBackContext) {
        WVLocPerformanceMonitor.setOpenLocPerformanceMonitor(true);
    }

    public void openSpdyforDebug(String str, WVCallBackContext wVCallBackContext) {
        EnvUtil.setOpenSpdyforDebug(true);
    }

    public final void setUCEnabled(String str, WVCallBackContext wVCallBackContext) {
        try {
            if (new JSONObject(str).optBoolean("enable", false)) {
                WVCommonConfig.getInstance();
                WVCommonConfig.commonConfig.useSystemWebView = false;
                Toast.makeText(((WVApiPlugin) this).mContext, "启用UC, 重启后生效", 1).show();
            } else {
                WVCommonConfig.getInstance();
                WVCommonConfig.commonConfig.useSystemWebView = true;
                Toast.makeText(((WVApiPlugin) this).mContext, "关闭UC, 重启后生效", 1).show();
            }
            wVCallBackContext.success();
        } catch (Exception unused) {
            wVCallBackContext.error();
        }
    }

    public final void setWebViewDebugEnabled(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            boolean optBoolean = new JSONObject(str).optBoolean("enabled", false);
            if (Build.VERSION.SDK_INT < 19) {
                wVResult.addData("error", "api level < 19");
                wVCallBackContext.error(wVResult);
                return;
            }
            WVWebView wVWebView = ((WVApiPlugin) this).mWebView;
            if (wVWebView instanceof WVWebView) {
                WVWebView wVWebView2 = wVWebView;
                WebView.setWebContentsDebuggingEnabled(optBoolean);
            }
            this.mIsDebugOpen = optBoolean;
            wVCallBackContext.success();
        } catch (Throwable unused) {
            wVResult.addData("error", "failed to enable debugging");
            wVCallBackContext.error(wVResult);
        }
    }

    public final void setWebViewFinishJs(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        try {
            WVPageFinishJSRender.setJsContent(new JSONObject(str).optString("js"));
            wVCallBackContext.success();
        } catch (JSONException unused) {
            wVCallBackContext.error(WVResult.RET_PARAM_ERR);
        } catch (Throwable unused2) {
            wVResult.addData("error", "failed to enable setWebViewFinishJs");
            wVCallBackContext.error(wVResult);
        }
    }
}
