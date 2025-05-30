package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.alibaba.fastjson.JSON;
import com.taobao.weaver.broadcast.MessageCallback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVBroadcastChannel$1 implements MessageCallback {
    final /* synthetic */ WVBroadcastChannel this$0;
    final /* synthetic */ WVCallBackContext val$callback;
    final /* synthetic */ String val$token;

    WVBroadcastChannel$1(WVBroadcastChannel wVBroadcastChannel, WVCallBackContext wVCallBackContext, String str) {
        this.this$0 = wVBroadcastChannel;
        this.val$callback = wVCallBackContext;
        this.val$token = str;
    }

    public void onMessage(Object obj) {
        WVCallBackContext wVCallBackContext = this.val$callback;
        if (wVCallBackContext != null) {
            wVCallBackContext.fireEvent("Broadcast.Message." + this.val$token, JSON.toJSONString(obj));
        }
    }
}
