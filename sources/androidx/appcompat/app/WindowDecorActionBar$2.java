package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WindowDecorActionBar$2 extends ViewPropertyAnimatorListenerAdapter {
    final /* synthetic */ WindowDecorActionBar this$0;

    WindowDecorActionBar$2(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationEnd(View view) {
        WindowDecorActionBar windowDecorActionBar = this.this$0;
        windowDecorActionBar.mCurrentShowAnim = null;
        windowDecorActionBar.mContainerView.requestLayout();
    }
}
