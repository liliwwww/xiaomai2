package android.taobao.windvane.extra.jsbridge;

import android.content.Context;
import android.taobao.windvane.extra.uc.preRender.BasePreInitManager;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.taobao.accs.ACCSManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVACCS extends WVApiPlugin {
    private static final String serviceClassName = "android.taobao.windvane.extra.jsbridge.WVACCSService";
    private static final String serviceIdDefault = "windvane";
    private ArrayList<String> serviceIdList = new ArrayList<>();

    private void bindService(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            str2 = new JSONObject(str).optString("serviceId", "");
        } catch (JSONException unused) {
            wVCallBackContext.error(new WVResult(WVResult.PARAM_ERR));
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            wVCallBackContext.error(new WVResult(WVResult.PARAM_ERR));
            return;
        }
        if (this.serviceIdList == null) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                this.serviceIdList = arrayList;
                arrayList.add(serviceIdDefault);
                ACCSManager.registerSerivce(((WVApiPlugin) this).mContext.getApplicationContext(), serviceIdDefault, serviceClassName);
            } catch (Exception unused2) {
            }
        }
        if (this.serviceIdList.contains(str2)) {
            wVCallBackContext.success();
        } else {
            if (((WVApiPlugin) this).mContext == null) {
                wVCallBackContext.error();
                return;
            }
            this.serviceIdList.add(str2);
            ACCSManager.registerSerivce(((WVApiPlugin) this).mContext.getApplicationContext(), str2, serviceClassName);
            wVCallBackContext.success();
        }
    }

    private void connectionState(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        try {
            if (ACCSManager.getChannelState(((WVApiPlugin) this).mContext) == null) {
                wVResult.addData(NotificationCompat.CATEGORY_STATUS, "false");
                wVCallBackContext.error();
            }
        } catch (Exception unused) {
            wVResult.addData(NotificationCompat.CATEGORY_STATUS, "false");
            wVCallBackContext.error();
        }
        wVResult.addData(NotificationCompat.CATEGORY_STATUS, BasePreInitManager.PRE_RENDER_URL_ADDITION_VALUE);
        wVCallBackContext.success(wVResult);
    }

    private void init(Context context) {
        WVEventService.getInstance().addEventListener(new ACCSWVEventListener(((WVApiPlugin) this).mWebView));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setData(android.taobao.windvane.jsbridge.WVCallBackContext r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.jsbridge.WVACCS.setData(android.taobao.windvane.jsbridge.WVCallBackContext, java.lang.String):void");
    }

    private void unBindService(WVCallBackContext wVCallBackContext, String str) {
        String str2;
        try {
            str2 = new JSONObject(str).optString("serviceId", "");
        } catch (JSONException unused) {
            wVCallBackContext.error(new WVResult(WVResult.PARAM_ERR));
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            wVCallBackContext.error(new WVResult(WVResult.PARAM_ERR));
            return;
        }
        if (this.serviceIdList == null) {
            this.serviceIdList = new ArrayList<>();
        }
        if (!this.serviceIdList.contains(str2)) {
            wVCallBackContext.success();
        } else {
            if (((WVApiPlugin) this).mContext == null) {
                wVCallBackContext.error();
                return;
            }
            this.serviceIdList.remove(str2);
            ACCSManager.unregisterService(((WVApiPlugin) this).mContext.getApplicationContext(), str2);
            wVCallBackContext.success();
        }
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("bindService".equals(str)) {
            bindService(wVCallBackContext, str2);
            return true;
        }
        if ("unBindService".equals(str)) {
            unBindService(wVCallBackContext, str2);
            return true;
        }
        if ("setData".equals(str)) {
            setData(wVCallBackContext, str2);
            return true;
        }
        if (!"connectionState".equals(str)) {
            return false;
        }
        connectionState(wVCallBackContext, str2);
        return true;
    }

    public void initialize(Context context, IWVWebView iWVWebView) {
        super.initialize(context, iWVWebView);
        init(context);
    }

    public void onDestroy() {
        if (((WVApiPlugin) this).mContext != null && this.serviceIdList != null) {
            for (int i = 0; i < this.serviceIdList.size(); i++) {
                ACCSManager.unregisterService(((WVApiPlugin) this).mContext.getApplicationContext(), this.serviceIdList.get(i));
            }
            this.serviceIdList.clear();
            this.serviceIdList = null;
        }
        super.onDestroy();
    }
}
