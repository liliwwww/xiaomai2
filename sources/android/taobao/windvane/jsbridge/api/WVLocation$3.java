package android.taobao.windvane.jsbridge.api;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVLocation$3 implements Runnable {
    final /* synthetic */ WVLocation this$0;

    WVLocation$3(WVLocation wVLocation) {
        this.this$0 = wVLocation;
    }

    @Override // java.lang.Runnable
    public void run() {
        WVLocation.access$000(this.this$0).sendEmptyMessageDelayed(1, 15000L);
    }
}
