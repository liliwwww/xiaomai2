package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatSpinner$DropdownPopup$3 implements PopupWindow.OnDismissListener {
    final /* synthetic */ AppCompatSpinner.DropdownPopup this$1;
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener val$layoutListener;

    AppCompatSpinner$DropdownPopup$3(AppCompatSpinner.DropdownPopup dropdownPopup, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.this$1 = dropdownPopup;
        this.val$layoutListener = onGlobalLayoutListener;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.this$1.this$0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
        }
    }
}
