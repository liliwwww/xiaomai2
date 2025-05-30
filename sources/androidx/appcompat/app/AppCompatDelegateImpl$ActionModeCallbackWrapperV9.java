package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$ActionModeCallbackWrapperV9 implements ActionMode.Callback {
    private ActionMode.Callback mWrapped;
    final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ActionModeCallbackWrapperV9(AppCompatDelegateImpl appCompatDelegateImpl, ActionMode.Callback callback) {
        this.this$0 = appCompatDelegateImpl;
        this.mWrapped = callback;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mWrapped.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrapped.onCreateActionMode(actionMode, menu);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.mWrapped.onDestroyActionMode(actionMode);
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (appCompatDelegateImpl.mActionModePopup != null) {
            appCompatDelegateImpl.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
        }
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
        if (appCompatDelegateImpl2.mActionModeView != null) {
            appCompatDelegateImpl2.endOnGoingFadeAnimation();
            AppCompatDelegateImpl appCompatDelegateImpl3 = this.this$0;
            appCompatDelegateImpl3.mFadeAnim = ViewCompat.animate(appCompatDelegateImpl3.mActionModeView).alpha(0.0f);
            this.this$0.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9.1
                @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter
                public void onAnimationEnd(View view) {
                    AppCompatDelegateImpl$ActionModeCallbackWrapperV9.this.this$0.mActionModeView.setVisibility(8);
                    AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl$ActionModeCallbackWrapperV9.this.this$0;
                    PopupWindow popupWindow = appCompatDelegateImpl4.mActionModePopup;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    } else if (appCompatDelegateImpl4.mActionModeView.getParent() instanceof View) {
                        ViewCompat.requestApplyInsets((View) AppCompatDelegateImpl$ActionModeCallbackWrapperV9.this.this$0.mActionModeView.getParent());
                    }
                    AppCompatDelegateImpl$ActionModeCallbackWrapperV9.this.this$0.mActionModeView.killMode();
                    AppCompatDelegateImpl$ActionModeCallbackWrapperV9.this.this$0.mFadeAnim.setListener(null);
                    AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl$ActionModeCallbackWrapperV9.this.this$0;
                    appCompatDelegateImpl5.mFadeAnim = null;
                    ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
                }
            });
        }
        AppCompatDelegateImpl appCompatDelegateImpl4 = this.this$0;
        AppCompatCallback appCompatCallback = appCompatDelegateImpl4.mAppCompatCallback;
        if (appCompatCallback != null) {
            appCompatCallback.onSupportActionModeFinished(appCompatDelegateImpl4.mActionMode);
        }
        AppCompatDelegateImpl appCompatDelegateImpl5 = this.this$0;
        appCompatDelegateImpl5.mActionMode = null;
        ViewCompat.requestApplyInsets(appCompatDelegateImpl5.mSubDecor);
        this.this$0.updateBackInvokedCallbackState();
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        ViewCompat.requestApplyInsets(this.this$0.mSubDecor);
        return this.mWrapped.onPrepareActionMode(actionMode, menu);
    }
}
