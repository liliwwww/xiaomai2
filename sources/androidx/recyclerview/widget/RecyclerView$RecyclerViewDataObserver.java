package androidx.recyclerview.widget;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RecyclerView$RecyclerViewDataObserver extends RecyclerView.AdapterDataObserver {
    final /* synthetic */ RecyclerView this$0;

    RecyclerView$RecyclerViewDataObserver(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void onChanged() {
        this.this$0.assertNotInLayoutOrScroll((String) null);
        RecyclerView recyclerView = this.this$0;
        recyclerView.mState.mStructureChanged = true;
        recyclerView.processDataSetCompletelyChanged(true);
        if (this.this$0.mAdapterHelper.hasPendingUpdates()) {
            return;
        }
        this.this$0.requestLayout();
    }

    public void onItemRangeChanged(int i, int i2, Object obj) {
        this.this$0.assertNotInLayoutOrScroll((String) null);
        if (this.this$0.mAdapterHelper.onItemRangeChanged(i, i2, obj)) {
            triggerUpdateProcessor();
        }
    }

    public void onItemRangeInserted(int i, int i2) {
        this.this$0.assertNotInLayoutOrScroll((String) null);
        if (this.this$0.mAdapterHelper.onItemRangeInserted(i, i2)) {
            triggerUpdateProcessor();
        }
    }

    public void onItemRangeMoved(int i, int i2, int i3) {
        this.this$0.assertNotInLayoutOrScroll((String) null);
        if (this.this$0.mAdapterHelper.onItemRangeMoved(i, i2, i3)) {
            triggerUpdateProcessor();
        }
    }

    public void onItemRangeRemoved(int i, int i2) {
        this.this$0.assertNotInLayoutOrScroll((String) null);
        if (this.this$0.mAdapterHelper.onItemRangeRemoved(i, i2)) {
            triggerUpdateProcessor();
        }
    }

    public void onStateRestorationPolicyChanged() {
        RecyclerView$Adapter recyclerView$Adapter;
        RecyclerView recyclerView = this.this$0;
        if (recyclerView.mPendingSavedState == null || (recyclerView$Adapter = recyclerView.mAdapter) == null || !recyclerView$Adapter.canRestoreState()) {
            return;
        }
        this.this$0.requestLayout();
    }

    void triggerUpdateProcessor() {
        if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
            RecyclerView recyclerView = this.this$0;
            if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                return;
            }
        }
        RecyclerView recyclerView2 = this.this$0;
        recyclerView2.mAdapterUpdateDuringMeasure = true;
        recyclerView2.requestLayout();
    }
}
