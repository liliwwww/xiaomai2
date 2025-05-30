package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Slide$3 extends Slide.CalculateSlideVertical {
    Slide$3() {
        super((Slide$1) null);
    }

    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY() - viewGroup.getHeight();
    }
}
