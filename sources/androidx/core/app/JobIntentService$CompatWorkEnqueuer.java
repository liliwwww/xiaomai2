package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class JobIntentService$CompatWorkEnqueuer extends JobIntentService$WorkEnqueuer {
    private final Context mContext;
    private final PowerManager.WakeLock mLaunchWakeLock;
    boolean mLaunchingService;
    private final PowerManager.WakeLock mRunWakeLock;
    boolean mServiceProcessing;

    JobIntentService$CompatWorkEnqueuer(Context context, ComponentName componentName) {
        super(componentName);
        this.mContext = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.mLaunchWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.mRunWakeLock = newWakeLock2;
        newWakeLock2.setReferenceCounted(false);
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    void enqueueWork(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.mComponentName);
        if (this.mContext.startService(intent2) != null) {
            synchronized (this) {
                if (!this.mLaunchingService) {
                    this.mLaunchingService = true;
                    if (!this.mServiceProcessing) {
                        this.mLaunchWakeLock.acquire(60000L);
                    }
                }
            }
        }
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void serviceProcessingFinished() {
        synchronized (this) {
            if (this.mServiceProcessing) {
                if (this.mLaunchingService) {
                    this.mLaunchWakeLock.acquire(60000L);
                }
                this.mServiceProcessing = false;
                this.mRunWakeLock.release();
            }
        }
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void serviceProcessingStarted() {
        synchronized (this) {
            if (!this.mServiceProcessing) {
                this.mServiceProcessing = true;
                this.mRunWakeLock.acquire(600000L);
                this.mLaunchWakeLock.release();
            }
        }
    }

    @Override // androidx.core.app.JobIntentService$WorkEnqueuer
    public void serviceStartReceived() {
        synchronized (this) {
            this.mLaunchingService = false;
        }
    }
}
