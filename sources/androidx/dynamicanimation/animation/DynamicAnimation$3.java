package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DynamicAnimation$3 extends DynamicAnimation.ViewProperty {
    DynamicAnimation$3(String str) {
        super(str, (DynamicAnimation$1) null);
    }

    public float getValue(View view) {
        return ViewCompat.getTranslationZ(view);
    }

    public void setValue(View view, float f) {
        ViewCompat.setTranslationZ(view, f);
    }
}
