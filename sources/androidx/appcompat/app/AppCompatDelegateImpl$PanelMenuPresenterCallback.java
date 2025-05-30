package androidx.appcompat.app;

import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AppCompatDelegateImpl$PanelMenuPresenterCallback implements MenuPresenter.Callback {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl$PanelMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z) {
        MenuBuilder rootMenu = menuBuilder.getRootMenu();
        boolean z2 = rootMenu != menuBuilder;
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (z2) {
            menuBuilder = rootMenu;
        }
        AppCompatDelegateImpl.PanelFeatureState findMenuPanel = appCompatDelegateImpl.findMenuPanel(menuBuilder);
        if (findMenuPanel != null) {
            if (!z2) {
                this.this$0.closePanel(findMenuPanel, z);
            } else {
                this.this$0.callOnPanelClosed(findMenuPanel.featureId, findMenuPanel, rootMenu);
                this.this$0.closePanel(findMenuPanel, true);
            }
        }
    }

    public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
        Window.Callback windowCallback;
        if (menuBuilder != menuBuilder.getRootMenu()) {
            return true;
        }
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (!appCompatDelegateImpl.mHasActionBar || (windowCallback = appCompatDelegateImpl.getWindowCallback()) == null || this.this$0.mDestroyed) {
            return true;
        }
        windowCallback.onMenuOpened(108, menuBuilder);
        return true;
    }
}
