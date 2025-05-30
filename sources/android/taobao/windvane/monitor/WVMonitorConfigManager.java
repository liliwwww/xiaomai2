package android.taobao.windvane.monitor;

import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.config.WVConfigUpdateCallback;
import android.taobao.windvane.config.WVConfigUtils;
import android.taobao.windvane.connect.ConnectManager;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.ConfigStorage;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVMonitorConfigManager {
    private static final String TAG = "WVPackageMonitorImpl";
    private static volatile WVMonitorConfigManager instance;
    public WVMonitorConfig config = new WVMonitorConfig();

    public static WVMonitorConfigManager getInstance() {
        if (instance == null) {
            synchronized (WVMonitorConfigManager.class) {
                if (instance == null) {
                    instance = new WVMonitorConfigManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMonitorConfig(WVConfigUpdateCallback wVConfigUpdateCallback, String str, String str2) {
        if (WVCommonConfig.commonConfig.monitorStatus != 2) {
            wVConfigUpdateCallback.updateStatus(WVConfigUpdateCallback.CONFIG_UPDATE_STATUS.UPDATE_DISABLED, 0);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = WVConfigManager.getInstance().getConfigUrl("3", this.config.v, WVConfigUtils.getTargetValue(), str2);
        }
        ConnectManager.getInstance().connectSync(str, new 2(this, wVConfigUpdateCallback, str));
    }

    public void init() {
        try {
            String stringVal = ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "monitorwv-data", "");
            if (!TextUtils.isEmpty(stringVal)) {
                this.config = parseRule(stringVal);
            }
        } catch (Exception unused) {
        }
        WVConfigManager.getInstance().registerHandler(WVConfigManager.CONFIGNAME_MONITOR, new 1(this));
        WVEventService.getInstance().addEventListener(new PageFinshWVEventListener((1) null));
    }

    protected boolean needSaveConfig(String str) {
        WVMonitorConfig parseRule;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ApiResponse apiResponse = new ApiResponse();
        JSONObject jSONObject = apiResponse.parseJsonResult(str).success ? apiResponse.data : null;
        if (jSONObject == null || (parseRule = parseRule(jSONObject.toString())) == null) {
            return false;
        }
        this.config = parseRule;
        return true;
    }

    public WVMonitorConfig parseRule(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            WVMonitorConfig wVMonitorConfig = new WVMonitorConfig();
            String optString = jSONObject.optString(ApiConstants.V, "");
            wVMonitorConfig.v = optString;
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            wVMonitorConfig.stat.onLoad = jSONObject.optLong("minLoadTime", 0L);
            wVMonitorConfig.stat.onDomLoad = jSONObject.optLong("minDomLoadTime", 0L);
            wVMonitorConfig.stat.resTime = jSONObject.optLong("minResTime", 0L);
            wVMonitorConfig.stat.netstat = jSONObject.optBoolean("reportNetStat", false);
            wVMonitorConfig.stat.resSample = jSONObject.optInt("resSample", 100);
            wVMonitorConfig.isErrorBlacklist = jSONObject.optString("errorType", "b").equals("b");
            JSONArray optJSONArray = jSONObject.optJSONArray("errorRule");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        wVMonitorConfig.errorRule.add(wVMonitorConfig.newErrorRuleInstance(optJSONObject.optString(HttpConnector.URL, ""), optJSONObject.optString("msg", ""), optJSONObject.optString("code", "")));
                    }
                }
            }
            wVMonitorConfig.perfCheckSampleRate = jSONObject.optDouble("perfCheckSampleRate", 0.0d);
            wVMonitorConfig.perfCheckURL = jSONObject.optString("perfCheckURL", "");
            return wVMonitorConfig;
        } catch (JSONException unused) {
            TaoLog.e(TAG, "parseRule error. content=" + str);
            return null;
        }
    }
}
