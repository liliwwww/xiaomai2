package androidx.appcompat.view.menu;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MenuItemWrapperICS$CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
    final android.view.CollapsibleActionView mWrappedView;

    /* JADX WARN: Multi-variable type inference failed */
    MenuItemWrapperICS$CollapsibleActionViewWrapper(View view) {
        super(view.getContext());
        this.mWrappedView = (android.view.CollapsibleActionView) view;
        addView(view);
    }

    View getWrappedView() {
        return (View) this.mWrappedView;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        this.mWrappedView.onActionViewCollapsed();
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        this.mWrappedView.onActionViewExpanded();
    }
}
