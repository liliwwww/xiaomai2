package androidx.appcompat.widget;

import android.transition.Transition;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MenuPopupWindow$Api23Impl {
    private MenuPopupWindow$Api23Impl() {
    }

    @DoNotInline
    static void setEnterTransition(PopupWindow popupWindow, Transition transition) {
        popupWindow.setEnterTransition(transition);
    }

    @DoNotInline
    static void setExitTransition(PopupWindow popupWindow, Transition transition) {
        popupWindow.setExitTransition(transition);
    }
}
