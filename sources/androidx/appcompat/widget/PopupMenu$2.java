package androidx.appcompat.widget;

import android.widget.PopupWindow;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PopupMenu$2 implements PopupWindow.OnDismissListener {
    final /* synthetic */ PopupMenu this$0;

    PopupMenu$2(PopupMenu popupMenu) {
        this.this$0 = popupMenu;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        PopupMenu popupMenu = this.this$0;
        PopupMenu$OnDismissListener popupMenu$OnDismissListener = popupMenu.mOnDismissListener;
        if (popupMenu$OnDismissListener != null) {
            popupMenu$OnDismissListener.onDismiss(popupMenu);
        }
    }
}
