package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Motion$1 implements DifferentialInterpolator {
    float mX;
    final /* synthetic */ Easing val$easing;

    Motion$1(Easing easing) {
        this.val$easing = easing;
    }

    @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
    public float getInterpolation(float f) {
        this.mX = f;
        return (float) this.val$easing.get(f);
    }

    @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
    public float getVelocity() {
        return (float) this.val$easing.getDiff(this.mX);
    }
}
