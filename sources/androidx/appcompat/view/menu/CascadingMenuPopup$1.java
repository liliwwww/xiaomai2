package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class CascadingMenuPopup$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ CascadingMenuPopup this$0;

    CascadingMenuPopup$1(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.this$0.isShowing() || this.this$0.mShowingMenus.size() <= 0 || ((CascadingMenuPopup$CascadingMenuInfo) this.this$0.mShowingMenus.get(0)).window.isModal()) {
            return;
        }
        View view = this.this$0.mShownAnchorView;
        if (view == null || !view.isShown()) {
            this.this$0.dismiss();
            return;
        }
        Iterator it = this.this$0.mShowingMenus.iterator();
        while (it.hasNext()) {
            ((CascadingMenuPopup$CascadingMenuInfo) it.next()).window.show();
        }
    }
}
