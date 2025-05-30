package androidx.constraintlayout.motion.utils;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewSpline$AlphaSet extends ViewSpline {
    ViewSpline$AlphaSet() {
    }

    public void setProperty(View view, float f) {
        view.setAlpha(get(f));
    }
}
