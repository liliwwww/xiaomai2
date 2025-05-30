package android.taobao.windvane.webview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUIModel$2 implements View.OnClickListener {
    final /* synthetic */ WVUIModel this$0;
    final /* synthetic */ ObjectAnimator val$animator2;
    final /* synthetic */ AnimatorSet val$set;

    WVUIModel$2(WVUIModel wVUIModel, AnimatorSet animatorSet, ObjectAnimator objectAnimator) {
        this.this$0 = wVUIModel;
        this.val$set = animatorSet;
        this.val$animator2 = objectAnimator;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (WVUIModel.access$100(this.this$0)) {
            this.val$set.cancel();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(this.val$animator2);
            animatorSet.start();
            WVUIModel.access$102(this.this$0, false);
        }
    }
}
