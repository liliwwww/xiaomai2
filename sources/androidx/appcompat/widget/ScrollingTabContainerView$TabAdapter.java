package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ScrollingTabContainerView$TabAdapter extends BaseAdapter {
    final /* synthetic */ ScrollingTabContainerView this$0;

    ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.this$0.mTabLayout.getChildCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.this$0.mTabLayout.getChildAt(i).getTab();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.this$0.createTabView((ActionBar.Tab) getItem(i), true);
        }
        ((ScrollingTabContainerView.TabView) view).bindTab((ActionBar.Tab) getItem(i));
        return view;
    }
}
