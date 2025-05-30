package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class RecyclerView$2 implements Runnable {
    final /* synthetic */ RecyclerView this$0;

    RecyclerView$2(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView.ItemAnimator itemAnimator = this.this$0.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.runPendingAnimations();
        }
        this.this$0.mPostedAnimatorRunner = false;
    }
}
