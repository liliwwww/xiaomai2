package android.taobao.windvane.jsbridge.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVUIDialog extends WVApiPlugin {
    private static final String TAG = "WVUIDialog";
    private String _index;
    private String identifier;
    private WVCallBackContext mCallback = null;
    private String okBtnText = "";
    private String cancelBtnText = "";
    protected DialogInterface.OnClickListener confirmClickListener = new 1(this);

    /* compiled from: Taobao */
    protected class AlertListener implements DialogInterface.OnClickListener {
        protected AlertListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (WVUIDialog.this.mCallback != null) {
                WVResult wVResult = new WVResult();
                if (!TextUtils.isEmpty(WVUIDialog.this.identifier)) {
                    wVResult.addData("identifier", WVUIDialog.this.identifier);
                }
                wVResult.setSuccess();
                if (WVUIDialog.this.mCallback != null) {
                    WVUIDialog.this.mCallback.fireEvent("WV.Event.Alert", wVResult.toJsonString());
                    WVUIDialog.this.mCallback.success(wVResult);
                }
            }
        }
    }

    public synchronized void alert(WVCallBackContext wVCallBackContext, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(((WVApiPlugin) this).mContext);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                builder.setTitle(jSONObject.optString("title", "提示"));
                builder.setMessage(jSONObject.optString("message"));
                this.okBtnText = jSONObject.optString("okbutton");
                this.identifier = jSONObject.optString("identifier");
                builder.setPositiveButton(this.okBtnText, new AlertListener());
            } catch (JSONException unused) {
                TaoLog.e("WVUIDialog", "WVUIDialog: param parse to JSON error, param=" + str);
                WVResult wVResult = new WVResult();
                wVResult.setResult(WVResult.PARAM_ERR);
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        this.mCallback = wVCallBackContext;
        try {
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Throwable unused2) {
        }
        TaoLog.d("WVUIDialog", "alert: show");
    }

    public synchronized void confirm(WVCallBackContext wVCallBackContext, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(((WVApiPlugin) this).mContext);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                builder.setTitle(jSONObject.optString("title", ""));
                builder.setMessage(jSONObject.optString("message"));
                String optString = jSONObject.optString("okbutton");
                this.okBtnText = optString;
                builder.setPositiveButton(optString, this.confirmClickListener);
                String optString2 = jSONObject.optString("canclebutton");
                this.cancelBtnText = optString2;
                builder.setNegativeButton(optString2, this.confirmClickListener);
                this._index = jSONObject.optString("_index");
            } catch (JSONException unused) {
                TaoLog.e("WVUIDialog", "WVUIDialog: param parse to JSON error, param=" + str);
                WVResult wVResult = new WVResult();
                wVResult.setResult(WVResult.PARAM_ERR);
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        this.mCallback = wVCallBackContext;
        try {
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        } catch (Throwable unused2) {
        }
        TaoLog.d("WVUIDialog", "confirm: show");
    }

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!(((WVApiPlugin) this).mContext instanceof Activity)) {
            WVResult wVResult = new WVResult();
            wVResult.addData("error", "Context must be Activity!!!");
            wVCallBackContext.error(wVResult);
            return true;
        }
        this.mCallback = wVCallBackContext;
        if ("alert".equals(str)) {
            alert(wVCallBackContext, str2);
            return true;
        }
        if (!"confirm".equals(str)) {
            return false;
        }
        confirm(wVCallBackContext, str2);
        return true;
    }

    public void onDestroy() {
        this.mCallback = null;
        this.cancelBtnText = "";
        this.okBtnText = "";
    }
}
