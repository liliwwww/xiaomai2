package android.taobao.windvane.extra.uc;

import android.taobao.windvane.util.TaoLog;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUCWebViewClient$3 implements ValueCallback<String> {
    final /* synthetic */ WVUCWebViewClient this$0;
    final /* synthetic */ WebView val$view;

    WVUCWebViewClient$3(WVUCWebViewClient wVUCWebViewClient, WebView webView) {
        this.this$0 = wVUCWebViewClient;
        this.val$view = webView;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(String str) {
        TaoLog.i("WVJsBridge", "has windvane :" + str);
        if ("false".equals(str)) {
            this.val$view.loadUrl("javascript:(function(f){try{if(f.__windvane__.nativeCall&&!f.__windvane__.call){var h=f.__windvane__||(f.__windvane__={});var c=\"wvapi:\"+(Math.floor(Math.random()*(1<<16))),a=0,b={},g=function(j){if(j&&typeof j==\"string\"){try{return JSON.parse(j)}catch(i){return{ret:\"HY_RESULT_PARSE_ERROR\"}}}else{return j||{}}};h.call=function(i,m,l,e,k){if(typeof l!=\"function\"){l=null}if(typeof e!=\"function\"){e=null}var j=c+(a++);b[j]={s:l,f:e,};if(k>0){b[j].t=setTimeout(function(){h.onFailure(j,{ret:\"HY_TIMEOUT\"})},k)}if(!m){m={}}if(typeof m!=\"string\"){m=JSON.stringify(m)}f.__windvane__.nativeCall(i,m,j,location.href)};h.find=function(i,j){var e=b[i]||{};if(e.t){clearTimeout(e.t);delete e.t}if(!j){delete b[i]}return e};h.onSuccess=function(j,e,k){var i=h.find(j,k).s;if(i){i(g(e))}};h.onFailure=function(j,e){var i=h.find(j,false).f;if(i){i(g(e))}}}}catch(d){}})(window);");
        }
    }
}
