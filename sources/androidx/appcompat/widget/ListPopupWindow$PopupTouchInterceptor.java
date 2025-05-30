package androidx.appcompat.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ListPopupWindow$PopupTouchInterceptor implements View.OnTouchListener {
    final /* synthetic */ ListPopupWindow this$0;

    ListPopupWindow$PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PopupWindow popupWindow;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0 && (popupWindow = this.this$0.mPopup) != null && popupWindow.isShowing() && x >= 0 && x < this.this$0.mPopup.getWidth() && y >= 0 && y < this.this$0.mPopup.getHeight()) {
            ListPopupWindow listPopupWindow = this.this$0;
            listPopupWindow.mHandler.postDelayed(listPopupWindow.mResizePopupRunnable, 250L);
            return false;
        }
        if (action != 1) {
            return false;
        }
        ListPopupWindow listPopupWindow2 = this.this$0;
        listPopupWindow2.mHandler.removeCallbacks(listPopupWindow2.mResizePopupRunnable);
        return false;
    }
}
