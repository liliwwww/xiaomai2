package android.taobao.windvane.thread;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class LockObject {
    public int result = 0;
    private boolean needwait = true;

    public synchronized void lnotify() {
        if (this.needwait) {
            this.needwait = false;
            notify();
        }
    }

    public synchronized void lwait() {
        while (this.needwait) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
