package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.Easing;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewTransition$1 implements Interpolator {
    final /* synthetic */ Easing val$easing;

    ViewTransition$1(ViewTransition viewTransition, Easing easing) {
        this.val$easing = easing;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) this.val$easing.get(f);
    }
}
