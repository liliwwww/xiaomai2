package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPager2$2 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ ViewPager2 this$0;

    ViewPager2$2(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            this.this$0.updateCurrentItem();
        }
    }

    public void onPageSelected(int i) {
        ViewPager2 viewPager2 = this.this$0;
        if (viewPager2.mCurrentItem != i) {
            viewPager2.mCurrentItem = i;
            viewPager2.mAccessibilityProvider.onSetNewCurrentItem();
        }
    }
}
