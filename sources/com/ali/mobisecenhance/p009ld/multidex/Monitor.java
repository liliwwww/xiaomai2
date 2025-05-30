package com.ali.mobisecenhance.p009ld.multidex;

import android.os.MessageQueue;
import com.j2c.enhance.SoLoad992979061;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public class Monitor {
    private static final boolean enableLog = false;
    private static Monitor sMonitor;
    private ScheduledExecutorService mExecutor = Executors.newScheduledThreadPool(1);
    private String mProcessName;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", Monitor.class);
    }

    static native Monitor get();

    /* JADX INFO: Access modifiers changed from: private */
    public native ScheduledExecutorService getExecutor();

    static native void init(Monitor monitor);

    protected native void doAfterInstall(Runnable runnable);

    protected native void doBeforeHandleOpt();

    native String getProcessName();

    protected native boolean isEnableNativeCheckSum();

    protected native void loadLibrary(String str);

    protected native void logDebug(String str);

    protected native void logError(String str);

    protected native void logError(String str, Throwable th);

    protected native void logErrorAfterInstall(String str, Throwable th);

    protected native void logInfo(String str);

    protected native void logWarning(String str);

    protected native void logWarning(String str, Throwable th);

    protected native void reportAfterInstall(long j, long j2, long j3, String str);

    public native Monitor setExecutor(ScheduledExecutorService scheduledExecutorService);

    public native Monitor setProcessName(String str);

    /* renamed from: com.ali.mobisecenhance.ld.multidex.Monitor$1 */
    class C14071 implements MessageQueue.IdleHandler {
        final /* synthetic */ Runnable val$optRunnable;

        static {
            SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", C14071.class);
        }

        @Override // android.os.MessageQueue.IdleHandler
        public native boolean queueIdle();

        C14071(Runnable runnable) {
            this.val$optRunnable = runnable;
        }
    }
}
