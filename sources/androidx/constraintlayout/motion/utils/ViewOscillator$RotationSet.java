package androidx.constraintlayout.motion.utils;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewOscillator$RotationSet extends ViewOscillator {
    ViewOscillator$RotationSet() {
    }

    public void setProperty(View view, float f) {
        view.setRotation(get(f));
    }
}
