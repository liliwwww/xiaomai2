package androidx.appcompat.widget;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ListPopupWindow$1 extends ForwardingListener {
    final /* synthetic */ ListPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ListPopupWindow$1(ListPopupWindow listPopupWindow, View view) {
        super(view);
        this.this$0 = listPopupWindow;
    }

    public ListPopupWindow getPopup() {
        return this.this$0;
    }
}
