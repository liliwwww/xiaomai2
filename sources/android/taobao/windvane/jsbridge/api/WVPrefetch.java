package android.taobao.windvane.jsbridge.api;

import android.net.Uri;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weaver.prefetch.GetPrefetchCallback;
import com.taobao.weaver.prefetch.PrefetchDataResponse;
import com.taobao.weaver.prefetch.WMLPrefetch;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVPrefetch extends WVApiPlugin {
    private String getMatchingUrl(String str) {
        Uri parse = Uri.parse(str);
        return parse.getHost() + parse.getPath();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getData".equals(str)) {
            getData(str2, wVCallBackContext);
            return true;
        }
        if (!"requestData".equals(str)) {
            return false;
        }
        requestData(str2, wVCallBackContext);
        return true;
    }

    public void getData(String str, final WVCallBackContext wVCallBackContext) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            IWVWebView webview = wVCallBackContext.getWebview();
            if (webview == null) {
                WVResult wVResult = new WVResult();
                wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "NO_WEBVIEW");
                wVCallBackContext.error(wVResult);
                return;
            }
            String string = parseObject.getString("externalKey");
            String string2 = parseObject.getString(HttpConnector.URL);
            if (TextUtils.isEmpty(string2)) {
                string2 = webview.getUrl();
            }
            String matchingUrl = getMatchingUrl(string2);
            if (!TextUtils.isEmpty(string)) {
                matchingUrl = matchingUrl + "#" + string;
            }
            TaoLog.m18d("WVPrefetch", "getData: " + matchingUrl);
            WMLPrefetch.getInstance().getData(matchingUrl, new GetPrefetchCallback() { // from class: android.taobao.windvane.jsbridge.api.WVPrefetch.1
                public void onComplete(PrefetchDataResponse prefetchDataResponse) {
                    try {
                        if (!TextUtils.isEmpty(prefetchDataResponse.jsonData)) {
                            wVCallBackContext.success(prefetchDataResponse.jsonData);
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                    if (prefetchDataResponse.data instanceof JSONObject) {
                        wVCallBackContext.success(prefetchDataResponse.data.toJSONString());
                    } else {
                        wVCallBackContext.success(new JSONObject(prefetchDataResponse.data).toJSONString());
                    }
                }

                public void onError(PrefetchDataResponse prefetchDataResponse) {
                    WVResult wVResult2 = new WVResult();
                    wVResult2.addData(NotificationCompat.CATEGORY_MESSAGE, prefetchDataResponse.performanceData.getStatus().getMsg());
                    wVResult2.addData("code", prefetchDataResponse.performanceData.getStatus().getCode());
                    wVCallBackContext.error(wVResult2);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            WVResult wVResult2 = new WVResult();
            wVResult2.addData(NotificationCompat.CATEGORY_MESSAGE, "exception");
            wVResult2.addData("code", "-1");
            wVCallBackContext.error(wVResult2);
        }
    }

    public void requestData(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            String string = parseObject.getString(HttpConnector.URL);
            if (TextUtils.isEmpty(string)) {
                wVCallBackContext.error(WVResult.RET_PARAM_ERR);
                return;
            }
            parseObject.put("userAgent", this.mWebView.getUserAgentString());
            TaoLog.m18d("WVPrefetch", "requestData: " + string + " with params: " + parseObject.toJSONString());
            WMLPrefetch.getInstance().prefetchData(string, parseObject);
        } catch (Throwable th) {
            th.printStackTrace();
            WVResult wVResult = new WVResult();
            wVResult.addData(NotificationCompat.CATEGORY_MESSAGE, "exception");
            wVResult.addData("code", "-1");
            wVCallBackContext.error(wVResult);
        }
    }
}
