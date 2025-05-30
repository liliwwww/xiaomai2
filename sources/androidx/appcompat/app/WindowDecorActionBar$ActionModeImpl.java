package androidx.appcompat.app;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowDecorActionBar$ActionModeImpl extends ActionMode implements MenuBuilder$Callback {
    private final Context mActionModeContext;
    private ActionMode$Callback mCallback;
    private WeakReference<View> mCustomView;
    private final MenuBuilder mMenu;
    final /* synthetic */ WindowDecorActionBar this$0;

    public WindowDecorActionBar$ActionModeImpl(WindowDecorActionBar windowDecorActionBar, Context context, ActionMode$Callback actionMode$Callback) {
        this.this$0 = windowDecorActionBar;
        this.mActionModeContext = context;
        this.mCallback = actionMode$Callback;
        MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
        this.mMenu = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
    }

    public boolean dispatchOnCreate() {
        this.mMenu.stopDispatchingItemsChanged();
        try {
            return this.mCallback.onCreateActionMode(this, this.mMenu);
        } finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }

    public void finish() {
        WindowDecorActionBar windowDecorActionBar = this.this$0;
        if (windowDecorActionBar.mActionMode != this) {
            return;
        }
        if (WindowDecorActionBar.checkShowingFlags(windowDecorActionBar.mHiddenByApp, windowDecorActionBar.mHiddenBySystem, false)) {
            this.mCallback.onDestroyActionMode(this);
        } else {
            WindowDecorActionBar windowDecorActionBar2 = this.this$0;
            windowDecorActionBar2.mDeferredDestroyActionMode = this;
            windowDecorActionBar2.mDeferredModeDestroyCallback = this.mCallback;
        }
        this.mCallback = null;
        this.this$0.animateToMode(false);
        this.this$0.mContextView.closeMode();
        WindowDecorActionBar windowDecorActionBar3 = this.this$0;
        windowDecorActionBar3.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar3.mHideOnContentScroll);
        this.this$0.mActionMode = null;
    }

    public View getCustomView() {
        WeakReference<View> weakReference = this.mCustomView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mActionModeContext);
    }

    public CharSequence getSubtitle() {
        return this.this$0.mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.this$0.mContextView.getTitle();
    }

    public void invalidate() {
        if (this.this$0.mActionMode != this) {
            return;
        }
        this.mMenu.stopDispatchingItemsChanged();
        try {
            this.mCallback.onPrepareActionMode(this, this.mMenu);
        } finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }

    public boolean isTitleOptional() {
        return this.this$0.mContextView.isTitleOptional();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public boolean onMenuItemSelected(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        ActionMode$Callback actionMode$Callback = this.mCallback;
        if (actionMode$Callback != null) {
            return actionMode$Callback.onActionItemClicked(this, menuItem);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder$Callback
    public void onMenuModeChange(@NonNull MenuBuilder menuBuilder) {
        if (this.mCallback == null) {
            return;
        }
        invalidate();
        this.this$0.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (this.mCallback == null) {
            return false;
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.this$0.getThemedContext(), subMenuBuilder).show();
        return true;
    }

    public void setCustomView(View view) {
        this.this$0.mContextView.setCustomView(view);
        this.mCustomView = new WeakReference<>(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.this$0.mContextView.setSubtitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.this$0.mContextView.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.this$0.mContextView.setTitleOptional(z);
    }

    public void setSubtitle(int i) {
        setSubtitle(this.this$0.mContext.getResources().getString(i));
    }

    public void setTitle(int i) {
        setTitle(this.this$0.mContext.getResources().getString(i));
    }
}
