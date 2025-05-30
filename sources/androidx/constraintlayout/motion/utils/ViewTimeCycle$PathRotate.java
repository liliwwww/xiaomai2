package androidx.constraintlayout.motion.utils;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ViewTimeCycle$PathRotate extends ViewTimeCycle {
    /* JADX WARN: Multi-variable type inference failed */
    public boolean setPathRotate(View view, KeyCache keyCache, float f, long j, double d, double d2) {
        view.setRotation(get(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        return ((TimeCycleSplineSet) this).mContinue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        return ((TimeCycleSplineSet) this).mContinue;
    }
}
