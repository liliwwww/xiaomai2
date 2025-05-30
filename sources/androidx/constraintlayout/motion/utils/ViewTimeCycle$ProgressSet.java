package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewTimeCycle$ProgressSet extends ViewTimeCycle {
    boolean mNoMethod = false;

    ViewTimeCycle$ProgressSet() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(get(f, j, view, keyCache));
        } else {
            if (this.mNoMethod) {
                return false;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.mNoMethod = true;
            }
            Method method2 = method;
            if (method2 != null) {
                try {
                    method2.invoke(view, Float.valueOf(get(f, j, view, keyCache)));
                } catch (IllegalAccessException e) {
                    Log.e("ViewTimeCycle", "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e("ViewTimeCycle", "unable to setProgress", e2);
                }
            }
        }
        return ((TimeCycleSplineSet) this).mContinue;
    }
}
