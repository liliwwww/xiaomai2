package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ListPopupWindowCompat$Api19Impl {
    private ListPopupWindowCompat$Api19Impl() {
    }

    @DoNotInline
    static View.OnTouchListener createDragToOpenListener(ListPopupWindow listPopupWindow, View view) {
        return listPopupWindow.createDragToOpenListener(view);
    }
}
