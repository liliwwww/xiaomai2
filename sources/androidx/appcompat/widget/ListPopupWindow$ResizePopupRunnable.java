package androidx.appcompat.widget;

import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ListPopupWindow$ResizePopupRunnable implements Runnable {
    final /* synthetic */ ListPopupWindow this$0;

    ListPopupWindow$ResizePopupRunnable(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        DropDownListView dropDownListView = this.this$0.mDropDownList;
        if (dropDownListView == null || !ViewCompat.isAttachedToWindow(dropDownListView) || this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) {
            return;
        }
        int childCount = this.this$0.mDropDownList.getChildCount();
        ListPopupWindow listPopupWindow = this.this$0;
        if (childCount <= listPopupWindow.mListItemExpandMaximum) {
            listPopupWindow.mPopup.setInputMethodMode(2);
            this.this$0.show();
        }
    }
}
