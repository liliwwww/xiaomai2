package android.taobao.windvane.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.config.WVUrlMatchUtils;
import android.taobao.windvane.connect.HttpConnector;
import android.taobao.windvane.extra.p002uc.WVUCWebView;
import android.taobao.windvane.util.TaoLog;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class WVURLFilter {
    private static final String TAG = "WVURLFilter";

    public static boolean doFilter(final String str, final Context context, final IWVWebView iWVWebView) {
        if (!iWVWebView.canUseGlobalUrlConfig() && !iWVWebView.canUseUrlConfig()) {
            return false;
        }
        if (WVUrlMatchUtils.getInstance().isAllowAllOpen(str)) {
            iWVWebView.setAllowAllOpen(true);
            return false;
        }
        if (iWVWebView.allowAllOpen()) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        if (!WVUrlMatchUtils.getInstance().isBrowserOpen(str)) {
            TaoLog.m18d(TAG, "doFilter() called with: url = [" + str + "] allow");
            return false;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Intent intent = new Intent("NON_WHITELIST_URL_VISIT");
        intent.putExtra(HttpConnector.URL, str);
        intent.putExtra("whitelistAvailable", 1);
        intent.putExtra(TypedValues.TransitionType.S_FROM, WVUCWebView.WINDVANE);
        if (context != null) {
            LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(intent);
        }
        new AlertDialog.Builder(context).setTitle("提示").setMessage("下个页面不受我们控制哦，使用时请注意安全" + scheme + "://" + host).setPositiveButton("浏览器打开", new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.webview.WVURLFilter.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    if (iWVWebView.getPageLoadedCount() > 0) {
                        return;
                    }
                    iWVWebView.back();
                } catch (Throwable unused) {
                }
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: android.taobao.windvane.webview.WVURLFilter.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (IWVWebView.this.getPageLoadedCount() > 0) {
                    IWVWebView.this.refresh();
                    return;
                }
                Context context2 = context;
                if (context2 instanceof Activity) {
                    ((Activity) context2).finish();
                }
            }
        }).setCancelable(false).create().show();
        StringBuilder sb = new StringBuilder();
        sb.append("doFilter() called with: url = [");
        sb.append(str);
        sb.append("] block");
        TaoLog.m18d(TAG, sb.toString());
        return true;
    }
}
