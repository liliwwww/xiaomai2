package android.taobao.windvane.extra.mtop;

import android.content.ContextWrapper;
import android.net.Uri;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.IApiAdapter;
import android.taobao.windvane.extra.security.SecurityManager;
import android.taobao.windvane.extra.security.TaoApiSign;
import android.taobao.windvane.util.TaoLog;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MtopApiAdapter implements IApiAdapter {
    private ApiRequest request;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0099, code lost:
    
        if (r2 == 0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkParams() {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.mtop.MtopApiAdapter.checkParams():void");
    }

    private String getSecBodyData(ContextWrapper contextWrapper) {
        return SecurityManager.getInstance().getSecBody(contextWrapper, this.request.getParam("t"), this.request.getParam("appKey"));
    }

    private String getSign() {
        String sign = SecurityManager.getInstance().getSign(0, this.request.getParams(), this.request.getParam("appKey"));
        if (TaoLog.getLogStatus()) {
            TaoLog.d("MtopApiAdapter", "appkey: " + this.request.getParam("appKey") + " params: " + this.request.getParams());
        }
        if (sign != null) {
            return sign;
        }
        TaoLog.w("MtopApiAdapter", "SecurityManager.getSign failed, execute TaoApiSign.getSign");
        return TaoApiSign.getSign(this.request.getParams());
    }

    private String wrapBody() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry entry : this.request.getParams().entrySet()) {
            if (z) {
                sb.append("&");
            } else {
                z = true;
            }
            sb.append(Uri.encode((String) entry.getKey()));
            sb.append("=");
            sb.append(Uri.encode((String) entry.getValue()));
        }
        return sb.toString();
    }

    private String wrapUrl(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        Uri parse = Uri.parse(str);
        Uri.Builder buildUpon = parse.buildUpon();
        String path = parse.getPath();
        if (path == null || path.length() == 0) {
            buildUpon.appendPath("");
        }
        for (Map.Entry entry : this.request.getParams().entrySet()) {
            buildUpon = buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return buildUpon.toString();
    }

    public String formatBody(ApiRequest apiRequest) {
        if (apiRequest == null) {
            return "";
        }
        this.request = apiRequest;
        checkParams();
        return wrapBody();
    }

    public String formatUrl(ApiRequest apiRequest) {
        if (apiRequest == null) {
            return "";
        }
        this.request = apiRequest;
        checkParams();
        return wrapUrl(GlobalConfig.getMtopUrl());
    }
}
