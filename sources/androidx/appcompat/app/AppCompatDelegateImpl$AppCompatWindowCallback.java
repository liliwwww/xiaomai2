package androidx.appcompat.app;

import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$AppCompatWindowCallback extends WindowCallbackWrapper {
    private AppCompatDelegateImpl.ActionBarMenuCallback mActionBarCallback;
    private boolean mDispatchKeyEventBypassEnabled;
    private boolean mOnContentChangedBypassEnabled;
    private boolean mOnPanelClosedBypassEnabled;
    final /* synthetic */ AppCompatDelegateImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppCompatDelegateImpl$AppCompatWindowCallback(AppCompatDelegateImpl appCompatDelegateImpl, Window.Callback callback) {
        super(callback);
        this.this$0 = appCompatDelegateImpl;
    }

    public boolean bypassDispatchKeyEvent(Window.Callback callback, KeyEvent keyEvent) {
        try {
            this.mDispatchKeyEventBypassEnabled = true;
            return callback.dispatchKeyEvent(keyEvent);
        } finally {
            this.mDispatchKeyEventBypassEnabled = false;
        }
    }

    public void bypassOnContentChanged(Window.Callback callback) {
        try {
            this.mOnContentChangedBypassEnabled = true;
            callback.onContentChanged();
        } finally {
            this.mOnContentChangedBypassEnabled = false;
        }
    }

    public void bypassOnPanelClosed(Window.Callback callback, int i, Menu menu) {
        try {
            this.mOnPanelClosedBypassEnabled = true;
            callback.onPanelClosed(i, menu);
        } finally {
            this.mOnPanelClosedBypassEnabled = false;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mDispatchKeyEventBypassEnabled ? getWrapped().dispatchKeyEvent(keyEvent) : this.this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.this$0.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
    }

    public void onContentChanged() {
        if (this.mOnContentChangedBypassEnabled) {
            getWrapped().onContentChanged();
        }
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof MenuBuilder)) {
            return super.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    public View onCreatePanelView(int i) {
        View onCreatePanelView;
        AppCompatDelegateImpl.ActionBarMenuCallback actionBarMenuCallback = this.mActionBarCallback;
        return (actionBarMenuCallback == null || (onCreatePanelView = actionBarMenuCallback.onCreatePanelView(i)) == null) ? super.onCreatePanelView(i) : onCreatePanelView;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.this$0.onMenuOpened(i);
        return true;
    }

    public void onPanelClosed(int i, Menu menu) {
        if (this.mOnPanelClosedBypassEnabled) {
            getWrapped().onPanelClosed(i, menu);
        } else {
            super.onPanelClosed(i, menu);
            this.this$0.onPanelClosed(i);
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
        if (i == 0 && menuBuilder == null) {
            return false;
        }
        if (menuBuilder != null) {
            menuBuilder.setOverrideVisibleItems(true);
        }
        AppCompatDelegateImpl.ActionBarMenuCallback actionBarMenuCallback = this.mActionBarCallback;
        boolean z = actionBarMenuCallback != null && actionBarMenuCallback.onPreparePanel(i);
        if (!z) {
            z = super.onPreparePanel(i, view, menu);
        }
        if (menuBuilder != null) {
            menuBuilder.setOverrideVisibleItems(false);
        }
        return z;
    }

    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        MenuBuilder menuBuilder;
        AppCompatDelegateImpl.PanelFeatureState panelState = this.this$0.getPanelState(0, true);
        if (panelState == null || (menuBuilder = panelState.menu) == null) {
            super.onProvideKeyboardShortcuts(list, menu, i);
        } else {
            super.onProvideKeyboardShortcuts(list, menuBuilder, i);
        }
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        return this.this$0.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback);
    }

    void setActionBarCallback(@Nullable AppCompatDelegateImpl.ActionBarMenuCallback actionBarMenuCallback) {
        this.mActionBarCallback = actionBarMenuCallback;
    }

    final ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
        SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, callback);
        androidx.appcompat.view.ActionMode startSupportActionMode = this.this$0.startSupportActionMode(callbackWrapper);
        if (startSupportActionMode != null) {
            return callbackWrapper.getActionModeWrapper(startSupportActionMode);
        }
        return null;
    }

    @RequiresApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        if (this.this$0.isHandleNativeActionModesEnabled() && i == 0) {
            return startAsSupportActionMode(callback);
        }
        return super.onWindowStartingActionMode(callback, i);
    }
}
