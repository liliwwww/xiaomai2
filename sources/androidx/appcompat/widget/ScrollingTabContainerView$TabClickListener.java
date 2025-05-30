package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ScrollingTabContainerView$TabClickListener implements View.OnClickListener {
    final /* synthetic */ ScrollingTabContainerView this$0;

    ScrollingTabContainerView$TabClickListener(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((ScrollingTabContainerView.TabView) view).getTab().select();
        int childCount = this.this$0.mTabLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.this$0.mTabLayout.getChildAt(i);
            childAt.setSelected(childAt == view);
        }
    }
}
