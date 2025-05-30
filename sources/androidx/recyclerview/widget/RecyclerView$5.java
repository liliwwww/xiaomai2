package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ChildHelper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class RecyclerView$5 implements ChildHelper.Callback {
    final /* synthetic */ RecyclerView this$0;

    RecyclerView$5(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void addView(View view, int i) {
        this.this$0.addView(view, i);
        this.this$0.dispatchChildAttached(view);
    }

    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + this.this$0.exceptionLabel());
            }
            childViewHolderInt.clearTmpDetachFlag();
        }
        RecyclerView.access$000(this.this$0, view, i, layoutParams);
    }

    public void detachViewFromParent(int i) {
        RecyclerView$ViewHolder childViewHolderInt;
        View childAt = getChildAt(i);
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + this.this$0.exceptionLabel());
            }
            childViewHolderInt.addFlags(256);
        }
        RecyclerView.access$100(this.this$0, i);
    }

    public View getChildAt(int i) {
        return this.this$0.getChildAt(i);
    }

    public int getChildCount() {
        return this.this$0.getChildCount();
    }

    public RecyclerView$ViewHolder getChildViewHolder(View view) {
        return RecyclerView.getChildViewHolderInt(view);
    }

    public int indexOfChild(View view) {
        return this.this$0.indexOfChild(view);
    }

    public void onEnteredHiddenState(View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(this.this$0);
        }
    }

    public void onLeftHiddenState(View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onLeftHiddenState(this.this$0);
        }
    }

    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            this.this$0.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        this.this$0.removeAllViews();
    }

    public void removeViewAt(int i) {
        View childAt = this.this$0.getChildAt(i);
        if (childAt != null) {
            this.this$0.dispatchChildDetached(childAt);
            childAt.clearAnimation();
        }
        this.this$0.removeViewAt(i);
    }
}
