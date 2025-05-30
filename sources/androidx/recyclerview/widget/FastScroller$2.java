package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FastScroller$2 extends RecyclerView.OnScrollListener {
    final /* synthetic */ FastScroller this$0;

    FastScroller$2(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.this$0.updateScrollPosition(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
