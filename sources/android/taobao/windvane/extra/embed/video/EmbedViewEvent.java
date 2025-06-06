package android.taobao.windvane.extra.embed.video;

import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class EmbedViewEvent {
    public static void firevent(IWVWebView iWVWebView, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "{}";
        }
        iWVWebView.fireEvent("embedviewevent", String.format("{\"param\":{\"eventType\":\"%s\",\"bridgeId\":\"%s\",\"params\":%s}}", str2, str, str3));
    }
}
