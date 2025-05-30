package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class RecyclerView$LayoutManager$2 implements ViewBoundsCheck.Callback {
    final /* synthetic */ RecyclerView.LayoutManager this$0;

    RecyclerView$LayoutManager$2(RecyclerView.LayoutManager layoutManager) {
        this.this$0 = layoutManager;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public View getChildAt(int i) {
        return this.this$0.getChildAt(i);
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getChildEnd(View view) {
        return this.this$0.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getChildStart(View view) {
        return this.this$0.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getParentEnd() {
        return this.this$0.getHeight() - this.this$0.getPaddingBottom();
    }

    @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
    public int getParentStart() {
        return this.this$0.getPaddingTop();
    }
}
