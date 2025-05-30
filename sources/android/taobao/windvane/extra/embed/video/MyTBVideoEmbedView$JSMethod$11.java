package android.taobao.windvane.extra.embed.video;

import android.taobao.windvane.extra.embed.video.MyTBVideoEmbedView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
enum MyTBVideoEmbedView$JSMethod$11 extends MyTBVideoEmbedView.JSMethod {
    MyTBVideoEmbedView$JSMethod$11(String str, int i) {
        super(str, i, (MyTBVideoEmbedView$1) null);
    }

    public boolean doSomething(MyTBVideoEmbedView myTBVideoEmbedView, String str, WVCallBackContext wVCallBackContext) {
        JSONObject parseObject;
        MyTBVideoEmbedView$EmbedProperties myTBVideoEmbedView$EmbedProperties;
        if (myTBVideoEmbedView == null || TextUtils.isEmpty(str) || (parseObject = JSON.parseObject(str)) == null) {
            return false;
        }
        Object obj = parseObject.get("key");
        Object obj2 = parseObject.get("value");
        if (obj == null || obj2 == null) {
            return false;
        }
        try {
            myTBVideoEmbedView$EmbedProperties = MyTBVideoEmbedView$EmbedProperties.valueOf(String.valueOf(obj));
        } catch (Throwable unused) {
            myTBVideoEmbedView$EmbedProperties = null;
        }
        if (myTBVideoEmbedView$EmbedProperties == null) {
            return false;
        }
        myTBVideoEmbedView$EmbedProperties.setValue(myTBVideoEmbedView, obj2, true);
        return true;
    }
}
