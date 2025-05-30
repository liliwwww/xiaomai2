package androidx.recyclerview.widget;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class RecyclerView$1 implements Runnable {
    final /* synthetic */ RecyclerView this$0;

    RecyclerView$1(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.this$0;
        if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
            return;
        }
        RecyclerView recyclerView2 = this.this$0;
        if (!recyclerView2.mIsAttached) {
            recyclerView2.requestLayout();
        } else if (recyclerView2.mLayoutSuppressed) {
            recyclerView2.mLayoutWasDefered = true;
        } else {
            recyclerView2.consumePendingUpdateOperations();
        }
    }
}
