package androidx.constraintlayout.motion.utils;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewOscillator$CustomSet extends ViewOscillator {
    protected ConstraintAttribute mCustom;
    float[] value = new float[1];

    ViewOscillator$CustomSet() {
    }

    protected void setCustom(Object obj) {
        this.mCustom = (ConstraintAttribute) obj;
    }

    public void setProperty(View view, float f) {
        this.value[0] = get(f);
        CustomSupport.setInterpolatedValue(this.mCustom, view, this.value);
    }
}
