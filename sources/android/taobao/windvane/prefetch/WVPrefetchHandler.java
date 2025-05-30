package android.taobao.windvane.prefetch;

import android.net.Uri;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.connect.HttpResponse;
import android.taobao.windvane.jsbridge.api.WVAPI;
import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weaver.prefetch.PrefetchDataCallback;
import com.taobao.weaver.prefetch.PrefetchDataResponse;
import com.taobao.weaver.prefetch.PrefetchHandler;
import com.taobao.weaver.prefetch.PrefetchType;
import com.taobao.weaver.prefetch.WMLPrefetchDecision;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVPrefetchHandler implements PrefetchHandler {
    private static String GET_DATA = "Prefetch.getData";
    private static String REQUEST_DATA = "Prefetch.requestData";
    private static String TEST_KEY = "test";

    public WMLPrefetchDecision isSupported(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject(map);
        boolean booleanValue = jSONObject.getBoolean("isSupport") != null ? jSONObject.getBoolean("isSupport").booleanValue() : false;
        String queryParameter = Uri.parse(str).getQueryParameter("apiName");
        WMLPrefetchDecision wMLPrefetchDecision = new WMLPrefetchDecision();
        if (GET_DATA.equals(queryParameter) || REQUEST_DATA.equals(queryParameter) || booleanValue) {
            wMLPrefetchDecision.externalKey = TEST_KEY;
            if (map.containsKey("externalKey")) {
                wMLPrefetchDecision.externalKey = jSONObject.getString("externalKey");
            }
            wMLPrefetchDecision.status = PrefetchType.SUPPORTED;
        }
        return wMLPrefetchDecision;
    }

    public String prefetchData(String str, Map<String, Object> map, final PrefetchDataCallback prefetchDataCallback) {
        JSONObject jSONObject = new JSONObject(map);
        if (!(jSONObject.getBoolean("isLocal") != null ? jSONObject.getBoolean("isLocal").booleanValue() : true)) {
            ConnectManager.getInstance().connect(str, new HttpConnectListener<HttpResponse>() { // from class: android.taobao.windvane.prefetch.WVPrefetchHandler.1
                @Override // android.taobao.windvane.connect.HttpConnectListener
                public void onFinish(HttpResponse httpResponse, int i) {
                    if (httpResponse == null || httpResponse.getData().length == 0) {
                        prefetchDataCallback.onError("-4", "getData Error");
                        return;
                    }
                    try {
                        String str2 = new String(httpResponse.getData(), "utf-8");
                        PrefetchDataResponse prefetchDataResponse = new PrefetchDataResponse();
                        prefetchDataResponse.data = JSON.parseObject(str2);
                        prefetchDataResponse.maxAge = WVURLRuleConstants.ORDER_LIST;
                        prefetchDataResponse.usageLimit = 10;
                        prefetchDataCallback.onComplete(prefetchDataResponse);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("client", "TBClient");
        hashMap.put("apiName", WVAPI.PluginName.API_PREFETCH);
        hashMap.put("type", "Local");
        PrefetchDataResponse prefetchDataResponse = new PrefetchDataResponse();
        prefetchDataResponse.data = hashMap;
        prefetchDataResponse.usageLimit = 10;
        prefetchDataResponse.maxAge = WVURLRuleConstants.ORDER_LIST;
        prefetchDataCallback.onComplete(prefetchDataResponse);
        return null;
    }
}
