package android.taobao.windvane.jsbridge.api;

import android.media.ToneGenerator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVNotification$1 extends Thread {
    final /* synthetic */ WVNotification this$0;
    final /* synthetic */ int val$repeatTime;

    WVNotification$1(WVNotification wVNotification, int i) {
        this.this$0 = wVNotification;
        this.val$repeatTime = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ToneGenerator toneGenerator = new ToneGenerator(1, 100);
        for (int i = 0; i < this.val$repeatTime; i++) {
            toneGenerator.startTone(24);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        toneGenerator.stopTone();
        toneGenerator.release();
    }
}
