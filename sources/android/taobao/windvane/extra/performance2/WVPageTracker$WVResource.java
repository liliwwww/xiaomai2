package android.taobao.windvane.extra.performance2;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVPageTracker$WVResource implements Serializable {
    public int dataSize;
    public boolean isHTML;
    public long loadingEndTime;
    public long loadingStartTime;
    public int statusCode;
    final /* synthetic */ WVPageTracker this$0;
    public String url;
    public String zcacheInfo;
    public int zcacheState;

    WVPageTracker$WVResource(WVPageTracker wVPageTracker) {
        this.this$0 = wVPageTracker;
    }
}
