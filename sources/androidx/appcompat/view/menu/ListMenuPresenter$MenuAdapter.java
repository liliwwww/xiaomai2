package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ListMenuPresenter$MenuAdapter extends BaseAdapter {
    private int mExpandedIndex = -1;
    final /* synthetic */ ListMenuPresenter this$0;

    public ListMenuPresenter$MenuAdapter(ListMenuPresenter listMenuPresenter) {
        this.this$0 = listMenuPresenter;
        findExpandedIndex();
    }

    void findExpandedIndex() {
        MenuItemImpl expandedItem = this.this$0.mMenu.getExpandedItem();
        if (expandedItem != null) {
            ArrayList nonActionItems = this.this$0.mMenu.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (((MenuItemImpl) nonActionItems.get(i)) == expandedItem) {
                    this.mExpandedIndex = i;
                    return;
                }
            }
        }
        this.mExpandedIndex = -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size = this.this$0.mMenu.getNonActionItems().size() - this.this$0.mItemIndexOffset;
        return this.mExpandedIndex < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            ListMenuPresenter listMenuPresenter = this.this$0;
            view = listMenuPresenter.mInflater.inflate(listMenuPresenter.mItemLayoutRes, viewGroup, false);
        }
        ((MenuView.ItemView) view).initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        ArrayList nonActionItems = this.this$0.mMenu.getNonActionItems();
        int i2 = i + this.this$0.mItemIndexOffset;
        int i3 = this.mExpandedIndex;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (MenuItemImpl) nonActionItems.get(i2);
    }
}
