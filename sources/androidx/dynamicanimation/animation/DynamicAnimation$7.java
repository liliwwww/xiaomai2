package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DynamicAnimation$7 extends DynamicAnimation.ViewProperty {
    DynamicAnimation$7(String str) {
        super(str, (DynamicAnimation$1) null);
    }

    public float getValue(View view) {
        return view.getRotationX();
    }

    public void setValue(View view, float f) {
        view.setRotationX(f);
    }
}
