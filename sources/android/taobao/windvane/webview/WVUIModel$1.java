package android.taobao.windvane.webview;

import android.animation.Animator;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WVUIModel$1 implements Animator.AnimatorListener {
    final /* synthetic */ WVUIModel this$0;

    WVUIModel$1(WVUIModel wVUIModel) {
        this.this$0 = wVUIModel;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (WVUIModel.access$000(this.this$0) != null) {
            ViewParent parent = WVUIModel.access$000(this.this$0).getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(WVUIModel.access$000(this.this$0));
            }
            WVUIModel.access$002(this.this$0, (TextView) null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (WVUIModel.access$000(this.this$0) != null) {
            ViewParent parent = WVUIModel.access$000(this.this$0).getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(WVUIModel.access$000(this.this$0));
            }
            WVUIModel.access$002(this.this$0, (TextView) null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
