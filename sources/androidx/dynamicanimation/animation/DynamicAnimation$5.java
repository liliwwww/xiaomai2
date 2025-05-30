package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DynamicAnimation$5 extends DynamicAnimation.ViewProperty {
    DynamicAnimation$5(String str) {
        super(str, (DynamicAnimation$1) null);
    }

    public float getValue(View view) {
        return view.getScaleY();
    }

    public void setValue(View view, float f) {
        view.setScaleY(f);
    }
}
