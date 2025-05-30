package android.taobao.windvane.jsbridge;

import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class WVJSAPIPageAuth implements WVJSAPIAuthCheck {
    protected boolean needAuth(IWVWebView iWVWebView) {
        return false;
    }
}
