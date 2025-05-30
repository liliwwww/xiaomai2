package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatSpinner$DropdownPopup$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ AppCompatSpinner.DropdownPopup this$1;

    AppCompatSpinner$DropdownPopup$2(AppCompatSpinner.DropdownPopup dropdownPopup) {
        this.this$1 = dropdownPopup;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        AppCompatSpinner.DropdownPopup dropdownPopup = this.this$1;
        if (!dropdownPopup.isVisibleToUser(dropdownPopup.this$0)) {
            this.this$1.dismiss();
        } else {
            this.this$1.computeContentWidth();
            AppCompatSpinner.DropdownPopup.access$001(this.this$1);
        }
    }
}
