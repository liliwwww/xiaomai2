package androidx.constraintlayout.motion.utils;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewTimeCycle$RotationYset extends ViewTimeCycle {
    ViewTimeCycle$RotationYset() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        view.setRotationY(get(f, j, view, keyCache));
        return ((TimeCycleSplineSet) this).mContinue;
    }
}
