package android.taobao.windvane.embed;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.view.View;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class BaseEmbedView extends WVApiPlugin implements IEmbedView, IEmbedViewContainer.OnParamChangedListener, IEmbedViewContainer.OnStateChangedListener, IEmbedViewContainer.OnVisibilityChangedListener {
    Context context;
    public IWVWebView webView;
    public View view = null;
    public EmbedViewConfig params = null;
    public String id = "";

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        return false;
    }

    protected abstract View generateView(Context context);

    public Bitmap getSnapShot() {
        return null;
    }

    public View getView() {
        View view = this.view;
        if (view != null) {
            return view;
        }
        Context context = this.context;
        if (context == null) {
            return null;
        }
        View generateView = generateView(context);
        this.view = generateView;
        return generateView;
    }

    protected abstract String getViewType();

    public boolean init(String str, String str2, IWVWebView iWVWebView, EmbedViewConfig embedViewConfig) {
        String str3;
        if (!str2.equals(getViewType()) || iWVWebView == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            str3 = "WVEmbedView";
        } else {
            str3 = "WVEmbedView_" + str;
        }
        iWVWebView.addJsObject(str3, this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bridgeId", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        iWVWebView.evaluateJavascript(String.format("javascript:window.WindVane&&window.WindVane.fireEvent('WVEmbed.Ready',%s);", jSONObject.toString()));
        this.context = iWVWebView.getContext();
        if (iWVWebView.getContext() instanceof MutableContextWrapper) {
            this.context = ((MutableContextWrapper) iWVWebView.getContext()).getBaseContext();
        }
        if (!(this.context instanceof Activity)) {
            this.context = null;
        }
        this.webView = iWVWebView;
        this.params = embedViewConfig;
        this.id = str;
        return true;
    }

    public void onAttachedToWebView() {
    }

    public void onDestroy() {
        this.view = null;
        this.context = null;
    }

    public void onDetachedFromWebView() {
    }

    public void onParamChanged(String[] strArr, String[] strArr2) {
    }

    public void onVisibilityChanged(int i) {
    }
}
