package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PopupMenuCompat$Api19Impl {
    private PopupMenuCompat$Api19Impl() {
    }

    @DoNotInline
    static View.OnTouchListener getDragToOpenListener(PopupMenu popupMenu) {
        return popupMenu.getDragToOpenListener();
    }
}
