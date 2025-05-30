package androidx.core.app;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActivityOptionsCompat$Api23Impl {
    private ActivityOptionsCompat$Api23Impl() {
    }

    @DoNotInline
    static ActivityOptions makeBasic() {
        return ActivityOptions.makeBasic();
    }

    @DoNotInline
    static ActivityOptions makeClipRevealAnimation(View view, int i, int i2, int i3, int i4) {
        return ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4);
    }

    @DoNotInline
    static void requestUsageTimeReport(ActivityOptions activityOptions, PendingIntent pendingIntent) {
        activityOptions.requestUsageTimeReport(pendingIntent);
    }
}
