package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Slide;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class Slide$CalculateSlideHorizontal implements Slide.CalculateSlide {
    private Slide$CalculateSlideHorizontal() {
    }

    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY();
    }

    /* synthetic */ Slide$CalculateSlideHorizontal(Slide$1 slide$1) {
        this();
    }
}
