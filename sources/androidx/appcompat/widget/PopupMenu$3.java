package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class PopupMenu$3 extends ForwardingListener {
    final /* synthetic */ PopupMenu this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PopupMenu$3(PopupMenu popupMenu, View view) {
        super(view);
        this.this$0 = popupMenu;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public ShowableListMenu getPopup() {
        return this.this$0.mPopup.getPopup();
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    protected boolean onForwardingStarted() {
        this.this$0.show();
        return true;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    protected boolean onForwardingStopped() {
        this.this$0.dismiss();
        return true;
    }
}
