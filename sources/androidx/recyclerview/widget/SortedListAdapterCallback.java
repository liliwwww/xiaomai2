package androidx.recyclerview.widget;

import androidx.recyclerview.widget.SortedList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView$Adapter mAdapter;

    public SortedListAdapterCallback(RecyclerView$Adapter recyclerView$Adapter) {
        this.mAdapter = recyclerView$Adapter;
    }

    public void onChanged(int i, int i2) {
        this.mAdapter.notifyItemRangeChanged(i, i2);
    }

    public void onInserted(int i, int i2) {
        this.mAdapter.notifyItemRangeInserted(i, i2);
    }

    public void onMoved(int i, int i2) {
        this.mAdapter.notifyItemMoved(i, i2);
    }

    public void onRemoved(int i, int i2) {
        this.mAdapter.notifyItemRangeRemoved(i, i2);
    }

    public void onChanged(int i, int i2, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i, i2, obj);
    }
}
