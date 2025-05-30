package androidx.lifecycle;

import androidx.lifecycle.ReportFragment;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ProcessLifecycleOwner$2 implements ReportFragment.ActivityInitializationListener {
    final /* synthetic */ ProcessLifecycleOwner this$0;

    ProcessLifecycleOwner$2(ProcessLifecycleOwner processLifecycleOwner) {
        this.this$0 = processLifecycleOwner;
    }

    public void onCreate() {
    }

    public void onResume() {
        this.this$0.activityResumed();
    }

    public void onStart() {
        this.this$0.activityStarted();
    }
}
