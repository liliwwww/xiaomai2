package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Slide$4 extends Slide$CalculateSlideHorizontal {
    Slide$4() {
        super(null);
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        return view.getTranslationX() + viewGroup.getWidth();
    }
}
