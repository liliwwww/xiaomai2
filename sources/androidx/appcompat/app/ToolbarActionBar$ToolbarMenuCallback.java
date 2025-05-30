package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ToolbarActionBar$ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
    final /* synthetic */ ToolbarActionBar this$0;

    ToolbarActionBar$ToolbarMenuCallback(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
    public View onCreatePanelView(int i) {
        if (i == 0) {
            return new View(this.this$0.mDecorToolbar.getContext());
        }
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatDelegateImpl.ActionBarMenuCallback
    public boolean onPreparePanel(int i) {
        if (i != 0) {
            return false;
        }
        ToolbarActionBar toolbarActionBar = this.this$0;
        if (toolbarActionBar.mToolbarMenuPrepared) {
            return false;
        }
        toolbarActionBar.mDecorToolbar.setMenuPrepared();
        this.this$0.mToolbarMenuPrepared = true;
        return false;
    }
}
