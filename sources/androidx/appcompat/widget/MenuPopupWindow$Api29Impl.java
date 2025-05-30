package androidx.appcompat.widget;

import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MenuPopupWindow$Api29Impl {
    private MenuPopupWindow$Api29Impl() {
    }

    @DoNotInline
    static void setTouchModal(PopupWindow popupWindow, boolean z) {
        popupWindow.setTouchModal(z);
    }
}
