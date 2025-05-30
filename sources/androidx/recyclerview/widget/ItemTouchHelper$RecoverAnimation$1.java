package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ItemTouchHelper$RecoverAnimation$1 implements ValueAnimator.AnimatorUpdateListener {
    final /* synthetic */ ItemTouchHelper.RecoverAnimation this$0;

    ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper.RecoverAnimation recoverAnimation) {
        this.this$0 = recoverAnimation;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.this$0.setFraction(valueAnimator.getAnimatedFraction());
    }
}
