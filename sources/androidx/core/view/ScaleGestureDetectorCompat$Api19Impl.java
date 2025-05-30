package androidx.core.view;

import android.view.ScaleGestureDetector;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ScaleGestureDetectorCompat$Api19Impl {
    private ScaleGestureDetectorCompat$Api19Impl() {
    }

    @DoNotInline
    static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return scaleGestureDetector.isQuickScaleEnabled();
    }

    @DoNotInline
    static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z) {
        scaleGestureDetector.setQuickScaleEnabled(z);
    }
}
