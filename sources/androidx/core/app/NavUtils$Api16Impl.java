package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(16)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class NavUtils$Api16Impl {
    private NavUtils$Api16Impl() {
    }

    @DoNotInline
    static Intent getParentActivityIntent(Activity activity) {
        return activity.getParentActivityIntent();
    }

    @DoNotInline
    static boolean navigateUpTo(Activity activity, Intent intent) {
        return activity.navigateUpTo(intent);
    }

    @DoNotInline
    static boolean shouldUpRecreateTask(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
