package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
abstract class JobIntentService$WorkEnqueuer {
    final ComponentName mComponentName;
    boolean mHasJobId;
    int mJobId;

    JobIntentService$WorkEnqueuer(ComponentName componentName) {
        this.mComponentName = componentName;
    }

    abstract void enqueueWork(Intent intent);

    void ensureJobId(int i) {
        if (!this.mHasJobId) {
            this.mHasJobId = true;
            this.mJobId = i;
        } else {
            if (this.mJobId == i) {
                return;
            }
            throw new IllegalArgumentException("Given job ID " + i + " is different than previous " + this.mJobId);
        }
    }

    public void serviceProcessingFinished() {
    }

    public void serviceProcessingStarted() {
    }

    public void serviceStartReceived() {
    }
}
