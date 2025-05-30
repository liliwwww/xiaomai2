package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class CascadingMenuPopup$2 implements View.OnAttachStateChangeListener {
    final /* synthetic */ CascadingMenuPopup this$0;

    CascadingMenuPopup$2(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewTreeObserver viewTreeObserver = this.this$0.mTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.this$0.mTreeObserver = view.getViewTreeObserver();
            }
            CascadingMenuPopup cascadingMenuPopup = this.this$0;
            cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
        }
        view.removeOnAttachStateChangeListener(this);
    }
}
