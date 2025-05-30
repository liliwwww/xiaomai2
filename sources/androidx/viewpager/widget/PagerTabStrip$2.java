package androidx.viewpager.widget;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PagerTabStrip$2 implements View.OnClickListener {
    final /* synthetic */ PagerTabStrip this$0;

    PagerTabStrip$2(PagerTabStrip pagerTabStrip) {
        this.this$0 = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewPager viewPager = ((PagerTitleStrip) this.this$0).mPager;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }
}
