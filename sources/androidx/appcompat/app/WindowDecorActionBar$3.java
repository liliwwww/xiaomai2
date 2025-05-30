package androidx.appcompat.app;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WindowDecorActionBar$3 implements ViewPropertyAnimatorUpdateListener {
    final /* synthetic */ WindowDecorActionBar this$0;

    WindowDecorActionBar$3(WindowDecorActionBar windowDecorActionBar) {
        this.this$0 = windowDecorActionBar;
    }

    public void onAnimationUpdate(View view) {
        ((View) this.this$0.mContainerView.getParent()).invalidate();
    }
}
