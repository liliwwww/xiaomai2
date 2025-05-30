package android.taobao.windvane.extra.performance2;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.taobao.android.riverlogger.RVLLevel;
import com.taobao.android.riverlogger.d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVPageTracker$1 implements ValueCallback<String> {
    final /* synthetic */ WVPageTracker this$0;

    WVPageTracker$1(WVPageTracker wVPageTracker) {
        this.this$0 = wVPageTracker;
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        try {
            JSONObject jSONObject = new JSONObject(str.replace("\\", ""));
            long optLong = jSONObject.optLong("ns");
            long optLong2 = jSONObject.optLong("rs");
            long optLong3 = jSONObject.optLong("re");
            long optLong4 = jSONObject.optLong("dc");
            RVLLevel rVLLevel = RVLLevel.Error;
            d.a(rVLLevel, WVPageTracker.access$100()).g("navigationStart", WVPageTracker.access$000(this.this$0)).h(optLong).d();
            d.a(rVLLevel, WVPageTracker.access$100()).g("requestStart", WVPageTracker.access$000(this.this$0)).h(optLong2).d();
            d.a(rVLLevel, WVPageTracker.access$100()).g("responseEnd", WVPageTracker.access$000(this.this$0)).h(optLong3).d();
            d.a(rVLLevel, WVPageTracker.access$100()).g("domComplete", WVPageTracker.access$000(this.this$0)).h(optLong4).d();
            if (WVPageTracker.access$200(this.this$0) > 0) {
                d.a(rVLLevel, WVPageTracker.access$100()).g("firstPaint", WVPageTracker.access$000(this.this$0)).h(WVPageTracker.access$200(this.this$0) + optLong).d();
            } else {
                WVPageTracker.access$302(this.this$0, optLong);
            }
            WVPageTracker wVPageTracker = this.this$0;
            WVPageTracker.access$500(wVPageTracker, WVPageTracker.access$400(wVPageTracker)[6], optLong);
            WVPageTracker wVPageTracker2 = this.this$0;
            WVPageTracker.access$500(wVPageTracker2, WVPageTracker.access$400(wVPageTracker2)[7], jSONObject.optLong("fs"));
            WVPageTracker wVPageTracker3 = this.this$0;
            WVPageTracker.access$500(wVPageTracker3, WVPageTracker.access$400(wVPageTracker3)[8], optLong3);
            WVPageTracker wVPageTracker4 = this.this$0;
            WVPageTracker.access$500(wVPageTracker4, WVPageTracker.access$400(wVPageTracker4)[9], jSONObject.optLong("ds"));
            WVPageTracker wVPageTracker5 = this.this$0;
            WVPageTracker.access$500(wVPageTracker5, WVPageTracker.access$400(wVPageTracker5)[10], jSONObject.optLong("ls"));
            WVPageTracker wVPageTracker6 = this.this$0;
            WVPageTracker.access$500(wVPageTracker6, WVPageTracker.access$400(wVPageTracker6)[11], jSONObject.optLong("le"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
