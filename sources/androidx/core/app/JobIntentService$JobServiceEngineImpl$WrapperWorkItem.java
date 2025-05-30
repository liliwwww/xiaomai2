package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobWorkItem;
import android.content.Intent;
import androidx.core.app.JobIntentService;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class JobIntentService$JobServiceEngineImpl$WrapperWorkItem implements JobIntentService.GenericWorkItem {
    final JobWorkItem mJobWork;
    final /* synthetic */ JobIntentService.JobServiceEngineImpl this$0;

    JobIntentService$JobServiceEngineImpl$WrapperWorkItem(JobIntentService.JobServiceEngineImpl jobServiceEngineImpl, JobWorkItem jobWorkItem) {
        this.this$0 = jobServiceEngineImpl;
        this.mJobWork = jobWorkItem;
    }

    @Override // androidx.core.app.JobIntentService.GenericWorkItem
    public void complete() {
        synchronized (this.this$0.mLock) {
            JobParameters jobParameters = this.this$0.mParams;
            if (jobParameters != null) {
                jobParameters.completeWork(this.mJobWork);
            }
        }
    }

    @Override // androidx.core.app.JobIntentService.GenericWorkItem
    public Intent getIntent() {
        return this.mJobWork.getIntent();
    }
}
