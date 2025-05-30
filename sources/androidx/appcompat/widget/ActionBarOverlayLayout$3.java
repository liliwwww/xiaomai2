package androidx.appcompat.widget;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActionBarOverlayLayout$3 implements Runnable {
    final /* synthetic */ ActionBarOverlayLayout this$0;

    ActionBarOverlayLayout$3(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.this$0 = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(-this.this$0.mActionBarTop.getHeight()).setListener(this.this$0.mTopAnimatorListener);
    }
}
