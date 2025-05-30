package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.util.Pair;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActivityOptionsCompat$Api21Impl {
    private ActivityOptionsCompat$Api21Impl() {
    }

    @DoNotInline
    static ActivityOptions makeSceneTransitionAnimation(Activity activity, View view, String str) {
        return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
    }

    @DoNotInline
    static ActivityOptions makeTaskLaunchBehind() {
        return ActivityOptions.makeTaskLaunchBehind();
    }

    @SafeVarargs
    @DoNotInline
    static ActivityOptions makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
    }
}
