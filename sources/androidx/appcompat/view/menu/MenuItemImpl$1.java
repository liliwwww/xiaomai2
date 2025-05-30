package androidx.appcompat.view.menu;

import androidx.core.view.ActionProvider;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MenuItemImpl$1 implements ActionProvider.VisibilityListener {
    final /* synthetic */ MenuItemImpl this$0;

    MenuItemImpl$1(MenuItemImpl menuItemImpl) {
        this.this$0 = menuItemImpl;
    }

    @Override // androidx.core.view.ActionProvider.VisibilityListener
    public void onActionProviderVisibilityChanged(boolean z) {
        MenuItemImpl menuItemImpl = this.this$0;
        menuItemImpl.mMenu.onItemVisibleChanged(menuItemImpl);
    }
}
