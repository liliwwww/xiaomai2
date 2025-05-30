package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PopupMenu$1 implements MenuBuilder$Callback {
    final /* synthetic */ PopupMenu this$0;

    PopupMenu$1(PopupMenu popupMenu) {
        this.this$0 = popupMenu;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        PopupMenu$OnMenuItemClickListener popupMenu$OnMenuItemClickListener = this.this$0.mMenuItemClickListener;
        if (popupMenu$OnMenuItemClickListener != null) {
            return popupMenu$OnMenuItemClickListener.onMenuItemClick(menuItem);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
    }
}
