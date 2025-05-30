package androidx.appcompat.view.menu;

import android.os.SystemClock;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.MenuItemHoverListener;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class CascadingMenuPopup$3 implements MenuItemHoverListener {
    final /* synthetic */ CascadingMenuPopup this$0;

    CascadingMenuPopup$3(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    public void onItemHoverEnter(@NonNull final MenuBuilder menuBuilder, @NonNull final MenuItem menuItem) {
        this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
        int size = this.this$0.mShowingMenus.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuPopup$CascadingMenuInfo) this.this$0.mShowingMenus.get(i)).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        final CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo = i2 < this.this$0.mShowingMenus.size() ? (CascadingMenuPopup$CascadingMenuInfo) this.this$0.mShowingMenus.get(i2) : null;
        this.this$0.mSubMenuHoverHandler.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup$3.1
            @Override // java.lang.Runnable
            public void run() {
                CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo2 = cascadingMenuPopup$CascadingMenuInfo;
                if (cascadingMenuPopup$CascadingMenuInfo2 != null) {
                    CascadingMenuPopup$3.this.this$0.mShouldCloseImmediately = true;
                    cascadingMenuPopup$CascadingMenuInfo2.menu.close(false);
                    CascadingMenuPopup$3.this.this$0.mShouldCloseImmediately = false;
                }
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    menuBuilder.performItemAction(menuItem, 4);
                }
            }
        }, menuBuilder, SystemClock.uptimeMillis() + 200);
    }

    public void onItemHoverExit(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
    }
}
