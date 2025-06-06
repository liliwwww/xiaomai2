package android.taobao.windvane.jsbridge.api;

import android.content.Context;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.fullspan.SpanWrapper;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import com.taobao.analysis.v3.FalcoStage;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVFullTrace extends WVApiPlugin {
    private static final String TAG = "WVFullTrace";
    private SpanWrapper spanWrapper;
    private int stageLimit = WVURLRuleConstants.LOGIN;
    private int propertyLimit = WVURLRuleConstants.LOGIN;

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("log".equals(str)) {
            log(str2, wVCallBackContext);
            return true;
        }
        if ("stage".equals(str)) {
            stage(str2, wVCallBackContext);
            return true;
        }
        if (!"property".equals(str)) {
            return false;
        }
        property(str2, wVCallBackContext);
        return true;
    }

    public void initialize(Context context, IWVWebView iWVWebView) {
        super.initialize(context, iWVWebView);
        WVCommonConfig.getInstance();
        if (WVCommonConfig.commonConfig.enableWVFullTrace && (iWVWebView instanceof IFullTrace)) {
            this.spanWrapper = ((IFullTrace) iWVWebView).getSpanWrapper();
        }
    }

    public final void log(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null && this.spanWrapper != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.spanWrapper.releaseLog(next + " " + jSONObject.getString(next));
                }
            }
            wVCallBackContext.success();
        } catch (Throwable th) {
            wVCallBackContext.error(th.toString());
        }
    }

    public final void property(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null && this.spanWrapper != null) {
                while (this.propertyLimit > 0 && keys.hasNext()) {
                    String next = keys.next();
                    this.spanWrapper.setCustomTag(next, jSONObject.getString(next));
                    this.propertyLimit--;
                }
            }
            wVCallBackContext.success();
        } catch (Throwable th) {
            wVCallBackContext.error(th.toString());
        }
    }

    public final void stage(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys != null && this.spanWrapper != null) {
                while (this.stageLimit > 0 && keys.hasNext()) {
                    String next = keys.next();
                    FalcoStage customStage = this.spanWrapper.customStage(next);
                    if (customStage != null) {
                        Long valueOf = Long.valueOf(jSONObject.getLong(next));
                        customStage.start(valueOf);
                        customStage.finish(valueOf);
                    }
                    this.stageLimit--;
                }
            }
            wVCallBackContext.success();
        } catch (Throwable th) {
            wVCallBackContext.error(th.toString());
        }
    }
}
