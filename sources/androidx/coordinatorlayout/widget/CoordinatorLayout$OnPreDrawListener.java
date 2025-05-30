package androidx.coordinatorlayout.widget;

import android.view.ViewTreeObserver;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class CoordinatorLayout$OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout this$0;

    CoordinatorLayout$OnPreDrawListener(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.this$0.onChildViewsChanged(0);
        return true;
    }
}
