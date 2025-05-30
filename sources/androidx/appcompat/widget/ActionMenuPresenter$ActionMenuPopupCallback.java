package androidx.appcompat.widget;

import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActionMenuPresenter;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ActionMenuPresenter$ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
    final /* synthetic */ ActionMenuPresenter this$0;

    ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
        this.this$0 = actionMenuPresenter;
    }

    public ShowableListMenu getPopup() {
        ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = this.this$0.mActionButtonPopup;
        if (actionButtonSubmenu != null) {
            return actionButtonSubmenu.getPopup();
        }
        return null;
    }
}
