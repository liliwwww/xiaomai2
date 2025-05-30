package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Slide$5 extends Slide$CalculateSlideHorizontal {
    Slide$5() {
        super(null);
    }

    public float getGoneX(ViewGroup viewGroup, View view) {
        return ViewCompat.getLayoutDirection(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
    }
}
