package android.taobao.windvane.extra.ha;

import android.annotation.SuppressLint;
import android.os.Message;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.UCHASettings;
import android.taobao.windvane.config.WVConfigManager;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class UCHAManager implements ValueCallback<Pair<Message, Message>> {
    private static UCHAManager INSTANCE = null;
    private static final String TAG = "UCHA";
    private static boolean closeUCHA = false;
    private static long commonID = 0;
    private static String currentUrl = "";
    private static String lastID = "";
    private static boolean onlyBkpg = true;
    private StringBuilder sb = new StringBuilder();

    private String getConfigsFromSomeWhere(UCHASettings.ConfigRate configRate) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cver", 1);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("u4_collect_url_query", configRate.u4CollectUrlQuery);
            jSONObject3.put("u4_collect_url_query", configRate.u4CollectUrlRef);
            jSONObject3.put("u4_bkpg_sampling_rate", configRate.u4BkpgSamplingRate);
            jSONObject3.put("u4_t1t3detail_sampling_rate", configRate.u4T1t3detailSamplingRate);
            jSONObject3.put("u4_resloadfail_sampling_rate", configRate.u4ResloadfailSamplingRate);
            jSONObject3.put("u4_xhr_sampling_rate", configRate.u4XhrSamplingRate);
            jSONObject3.put("u4_jserr_sampling_rate", configRate.u4JserrSamplingRate);
            jSONObject3.put("u4_har_sampling_rate", configRate.u4HarSamplingRate);
            jSONObject2.put(WVConfigManager.CONFIGNAME_COMMON, jSONObject3);
            jSONObject.put("config", jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static UCHAManager getInstance() {
        if (INSTANCE == null) {
            synchronized (UCHAManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UCHAManager();
                }
            }
        }
        return INSTANCE;
    }

    private void initCallBack() {
        HashMap hashMap = new HashMap();
        hashMap.put("log_upload_callback", this);
        UCCore.notifyCoreEvent(14, hashMap);
    }

    private void setPubOption() {
        HashMap hashMap = new HashMap();
        hashMap.put("bver", GlobalConfig.getInstance().getAppVersion());
        UCCore.notifyCoreEvent(15, hashMap);
        try {
            UCCore.notifyCoreEvent(16, new JSONObject(getConfigsFromSomeWhere(GlobalConfig.getInstance().getConfigRates())));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void commitUCHA() {
    }

    public void initHAParam(UCHASettings uCHASettings) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("context", GlobalConfig.context.getApplicationContext());
            hashMap.put("appid", uCHASettings.appid);
            hashMap.put("app_secret", uCHASettings.appSecret);
            hashMap.put("log_upload_mode", Integer.valueOf(uCHASettings.logUploadMode));
            hashMap.put("config_update_mode", Integer.valueOf(uCHASettings.configUpdateMode));
            hashMap.put("debug", Boolean.valueOf(uCHASettings.debug));
            UCCore.notifyCoreEvent(13, hashMap);
            if (uCHASettings.logUploadMode == 1) {
                initCallBack();
            }
            if (uCHASettings.configUpdateMode == 1) {
                setPubOption();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(Pair<Message, Message> pair) {
        Map map = (Map) ((Message) pair.first).obj;
        String str = (String) map.get("log_type");
        String str2 = (String) map.get("log_data");
        String str3 = (String) map.get("link_key");
        String str4 = (String) map.get("link_id");
        if (TextUtils.equals("pvuv", str)) {
            return;
        }
        if (TextUtils.isEmpty(lastID)) {
            lastID = str4;
        }
        boolean z = true;
        if (onlyBkpg && !TextUtils.equals(str3, "bkpg")) {
            z = false;
        }
        if (!TextUtils.equals(str4, lastID)) {
            commitUCHA();
            StringBuilder sb = this.sb;
            sb.delete(0, sb.length());
            if (z) {
                lastID = str4;
                this.sb.append(str2);
            }
        } else if (z) {
            StringBuilder sb2 = this.sb;
            sb2.append(str2);
            sb2.append("\n");
        }
        if (TextUtils.equals("bkpg", str3)) {
            TaoLog.e(TAG, "linkID:[" + str4 + "];logData:[" + str2 + "]");
            return;
        }
        TaoLog.i(TAG, "linkID:[" + str4 + "];logData:[" + str2 + "]");
    }
}
