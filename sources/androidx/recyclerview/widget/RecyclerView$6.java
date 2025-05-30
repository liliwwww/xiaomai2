package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class RecyclerView$6 implements AdapterHelper.Callback {
    final /* synthetic */ RecyclerView this$0;

    RecyclerView$6(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
        int i = updateOp.cmd;
        if (i == 1) {
            RecyclerView recyclerView = this.this$0;
            recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
            return;
        }
        if (i == 2) {
            RecyclerView recyclerView2 = this.this$0;
            recyclerView2.mLayout.onItemsRemoved(recyclerView2, updateOp.positionStart, updateOp.itemCount);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.this$0;
            recyclerView3.mLayout.onItemsUpdated(recyclerView3, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        } else {
            if (i != 8) {
                return;
            }
            RecyclerView recyclerView4 = this.this$0;
            recyclerView4.mLayout.onItemsMoved(recyclerView4, updateOp.positionStart, updateOp.itemCount, 1);
        }
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public RecyclerView$ViewHolder findViewHolder(int i) {
        RecyclerView$ViewHolder findViewHolderForPosition = this.this$0.findViewHolderForPosition(i, true);
        if (findViewHolderForPosition == null || this.this$0.mChildHelper.isHidden(findViewHolderForPosition.itemView)) {
            return null;
        }
        return findViewHolderForPosition;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public void markViewHoldersUpdated(int i, int i2, Object obj) {
        this.this$0.viewRangeUpdate(i, i2, obj);
        this.this$0.mItemsChanged = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public void offsetPositionsForAdd(int i, int i2) {
        this.this$0.offsetPositionRecordsForInsert(i, i2);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public void offsetPositionsForMove(int i, int i2) {
        this.this$0.offsetPositionRecordsForMove(i, i2);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public void offsetPositionsForRemovingInvisible(int i, int i2) {
        this.this$0.offsetPositionRecordsForRemove(i, i2, true);
        RecyclerView recyclerView = this.this$0;
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i2;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
        this.this$0.offsetPositionRecordsForRemove(i, i2, false);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
        dispatchUpdate(updateOp);
    }

    @Override // androidx.recyclerview.widget.AdapterHelper.Callback
    public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
        dispatchUpdate(updateOp);
    }
}
