package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;

/* compiled from: Taobao */
@VisibleForTesting
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class LifecycleDispatcher$DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
    LifecycleDispatcher$DispatcherActivityCallback() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        ReportFragment.injectIfNeededIn(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
