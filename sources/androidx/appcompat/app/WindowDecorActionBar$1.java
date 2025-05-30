package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WindowDecorActionBar$1 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ WindowDecorActionBar this$0;

    WindowDecorActionBar$1(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationEnd(View view) {
        View view2;
        WindowDecorActionBar windowDecorActionBar = this.this$0;
        if (windowDecorActionBar.mContentAnimations && (view2 = windowDecorActionBar.mContentView) != null) {
            view2.setTranslationY(0.0f);
            this.this$0.mContainerView.setTranslationY(0.0f);
        }
        this.this$0.mContainerView.setVisibility(8);
        this.this$0.mContainerView.setTransitioning(false);
        WindowDecorActionBar windowDecorActionBar2 = this.this$0;
        windowDecorActionBar2.mCurrentShowAnim = null;
        windowDecorActionBar2.completeDeferredDestroyActionMode();
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            ViewCompat.requestApplyInsets(actionBarOverlayLayout);
        }
    }
}
