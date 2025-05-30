package androidx.core.provider;

import android.os.Process;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RequestExecutor$DefaultThreadFactory$ProcessPriorityThread extends Thread {
    private final int mPriority;

    RequestExecutor$DefaultThreadFactory$ProcessPriorityThread(Runnable runnable, String str, int i) {
        super(runnable, str);
        this.mPriority = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(this.mPriority);
        super.run();
    }
}
