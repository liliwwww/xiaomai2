package androidx.viewpager.widget;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PagerTabStrip$1 implements View.OnClickListener {
    final /* synthetic */ PagerTabStrip this$0;

    PagerTabStrip$1(PagerTabStrip pagerTabStrip) {
        this.this$0 = pagerTabStrip;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((PagerTitleStrip) this.this$0).mPager.setCurrentItem(r2.getCurrentItem() - 1);
    }
}
