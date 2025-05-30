package androidx.core.app;

import android.content.Intent;
import androidx.core.app.JobIntentService;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class JobIntentService$CompatWorkItem implements JobIntentService.GenericWorkItem {
    final Intent mIntent;
    final int mStartId;
    final /* synthetic */ JobIntentService this$0;

    JobIntentService$CompatWorkItem(JobIntentService jobIntentService, Intent intent, int i) {
        this.this$0 = jobIntentService;
        this.mIntent = intent;
        this.mStartId = i;
    }

    public void complete() {
        this.this$0.stopSelf(this.mStartId);
    }

    public Intent getIntent() {
        return this.mIntent;
    }
}
