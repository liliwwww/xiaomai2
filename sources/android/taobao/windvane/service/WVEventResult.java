package android.taobao.windvane.service;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVEventResult {
    public boolean isSuccess;
    public Object resultObj;

    public WVEventResult(boolean z, Object obj) {
        this.isSuccess = z;
        this.resultObj = obj;
    }

    public WVEventResult(boolean z) {
        this.isSuccess = z;
        this.resultObj = null;
    }
}
