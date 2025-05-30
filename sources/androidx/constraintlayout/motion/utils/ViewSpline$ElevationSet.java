package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewSpline$ElevationSet extends ViewSpline {
    ViewSpline$ElevationSet() {
    }

    public void setProperty(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(get(f));
        }
    }
}
