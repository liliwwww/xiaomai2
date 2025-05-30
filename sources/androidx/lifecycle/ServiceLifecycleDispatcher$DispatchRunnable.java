package androidx.lifecycle;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ServiceLifecycleDispatcher$DispatchRunnable implements Runnable {
    final Lifecycle$Event mEvent;
    private final LifecycleRegistry mRegistry;
    private boolean mWasExecuted = false;

    ServiceLifecycleDispatcher$DispatchRunnable(@NonNull LifecycleRegistry lifecycleRegistry, Lifecycle$Event lifecycle$Event) {
        this.mRegistry = lifecycleRegistry;
        this.mEvent = lifecycle$Event;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mWasExecuted) {
            return;
        }
        this.mRegistry.handleLifecycleEvent(this.mEvent);
        this.mWasExecuted = true;
    }
}
