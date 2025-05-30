package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPager2$3 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ ViewPager2 this$0;

    ViewPager2$3(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public void onPageSelected(int i) {
        this.this$0.clearFocus();
        if (this.this$0.hasFocus()) {
            this.this$0.mRecyclerView.requestFocus(2);
        }
    }
}
