package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPager2$1 extends ViewPager2.DataSetChangeObserver {
    final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewPager2$1(ViewPager2 viewPager2) {
        super((ViewPager2$1) null);
        this.this$0 = viewPager2;
    }

    public void onChanged() {
        ViewPager2 viewPager2 = this.this$0;
        viewPager2.mCurrentItemDirty = true;
        viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
    }
}
