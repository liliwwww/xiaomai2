package androidx.appcompat.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ListPopupWindow$Api24Impl {
    private ListPopupWindow$Api24Impl() {
    }

    @DoNotInline
    static int getMaxAvailableHeight(PopupWindow popupWindow, View view, int i, boolean z) {
        return popupWindow.getMaxAvailableHeight(view, i, z);
    }
}
