package androidx.appcompat.widget;

import android.R;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.ActionMenuItem;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ToolbarWidgetWrapper$1 implements View.OnClickListener {
    final ActionMenuItem mNavItem;
    final /* synthetic */ ToolbarWidgetWrapper this$0;

    ToolbarWidgetWrapper$1(ToolbarWidgetWrapper toolbarWidgetWrapper) {
        this.this$0 = toolbarWidgetWrapper;
        this.mNavItem = new ActionMenuItem(toolbarWidgetWrapper.mToolbar.getContext(), 0, R.id.home, 0, 0, toolbarWidgetWrapper.mTitle);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.this$0;
        Window.Callback callback = toolbarWidgetWrapper.mWindowCallback;
        if (callback == null || !toolbarWidgetWrapper.mMenuPrepared) {
            return;
        }
        callback.onMenuItemSelected(0, this.mNavItem);
    }
}
