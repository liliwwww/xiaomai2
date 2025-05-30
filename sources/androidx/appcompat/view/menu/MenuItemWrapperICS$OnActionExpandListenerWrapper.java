package androidx.appcompat.view.menu;

import android.view.MenuItem;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class MenuItemWrapperICS$OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
    private final MenuItem.OnActionExpandListener mObject;
    final /* synthetic */ MenuItemWrapperICS this$0;

    MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.this$0 = menuItemWrapperICS;
        this.mObject = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.mObject.onMenuItemActionCollapse(this.this$0.getMenuItemWrapper(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.mObject.onMenuItemActionExpand(this.this$0.getMenuItemWrapper(menuItem));
    }
}
