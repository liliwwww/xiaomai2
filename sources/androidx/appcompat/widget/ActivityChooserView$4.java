package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ActivityChooserView$4 extends ForwardingListener {
    final /* synthetic */ ActivityChooserView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityChooserView$4(ActivityChooserView activityChooserView, View view) {
        super(view);
        this.this$0 = activityChooserView;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public ShowableListMenu getPopup() {
        return this.this$0.getListPopupWindow();
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    protected boolean onForwardingStarted() {
        this.this$0.showPopup();
        return true;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    protected boolean onForwardingStopped() {
        this.this$0.dismissPopup();
        return true;
    }
}
