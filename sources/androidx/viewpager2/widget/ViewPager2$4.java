package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPager2$4 implements RecyclerView.OnChildAttachStateChangeListener {
    final /* synthetic */ ViewPager2 this$0;

    ViewPager2$4(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public void onChildViewAttachedToWindow(@NonNull View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) recyclerView$LayoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) recyclerView$LayoutParams).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    public void onChildViewDetachedFromWindow(@NonNull View view) {
    }
}
