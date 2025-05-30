package android.taobao.windvane.extra.embed.video;

import android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
enum MyTBVideoEmbedView$JSMethod$10 extends MyTBVideoEmbedView.JSMethod {
    MyTBVideoEmbedView$JSMethod$10(String str, int i) {
        super(str, i, (MyTBVideoEmbedView$1) null);
    }

    public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
        JSONObject parseObject;
        Object obj;
        if (TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null || (obj = parseObject.get("instanceMode")) == null) {
            return false;
        }
        myTBVideoEmbedView.setDWInstanceType(String.valueOf(obj), true);
        if (wVCallBackContext != null) {
            wVCallBackContext.success();
        }
        return true;
    }
}
