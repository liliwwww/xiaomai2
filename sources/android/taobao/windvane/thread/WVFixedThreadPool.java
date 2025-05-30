package android.taobao.windvane.thread;

import android.taobao.windvane.util.TaoLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVFixedThreadPool {
    private static final int CORE_POOL_SIZE = 1;
    private static ExecutorService SingleExecutor = null;
    public static int bufferSize = 4096;
    private static WVFixedThreadPool threadManager;
    private BufferWrapper tempBuffer = null;

    public static WVFixedThreadPool getInstance() {
        if (threadManager == null) {
            threadManager = new WVFixedThreadPool();
        }
        return threadManager;
    }

    public void execute(Runnable runnable) {
        if (SingleExecutor == null) {
            SingleExecutor = Executors.newFixedThreadPool(1);
        }
        if (runnable == null) {
            TaoLog.w("WVThreadPool", "executeSingle is null.");
        } else {
            SingleExecutor.execute(runnable);
        }
    }

    public BufferWrapper getTempBuffer() {
        if (this.tempBuffer == null) {
            this.tempBuffer = new BufferWrapper();
        }
        return this.tempBuffer;
    }

    public void reSetTempBuffer() {
        BufferWrapper bufferWrapper = this.tempBuffer;
        if (bufferWrapper != null || BufferWrapper.access$000(bufferWrapper)) {
            BufferWrapper bufferWrapper2 = this.tempBuffer;
            bufferWrapper2.tempBuffer = null;
            BufferWrapper.access$002(bufferWrapper2, false);
            this.tempBuffer = null;
        }
    }
}
