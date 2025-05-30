package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RecyclerView$LayoutManager$1 implements ViewBoundsCheck.Callback {
    final /* synthetic */ RecyclerView.LayoutManager this$0;

    RecyclerView$LayoutManager$1(RecyclerView.LayoutManager layoutManager) {
        this.this$0 = layoutManager;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public View getChildAt(int i) {
        return this.this$0.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getChildEnd(View view) {
        return this.this$0.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getChildStart(View view) {
        return this.this$0.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getParentEnd() {
        return this.this$0.getWidth() - this.this$0.getPaddingRight();
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getParentStart() {
        return this.this$0.getPaddingLeft();
    }
}
