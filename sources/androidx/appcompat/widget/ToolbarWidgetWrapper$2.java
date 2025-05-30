package androidx.appcompat.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ToolbarWidgetWrapper$2 extends ViewPropertyAnimatorListenerAdapter {
    private boolean mCanceled = false;
    final /* synthetic */ ToolbarWidgetWrapper this$0;
    final /* synthetic */ int val$visibility;

    ToolbarWidgetWrapper$2(ToolbarWidgetWrapper toolbarWidgetWrapper, int i) {
        this.this$0 = toolbarWidgetWrapper;
        this.val$visibility = i;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter
    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter
    public void onAnimationEnd(View view) {
        if (this.mCanceled) {
            return;
        }
        this.this$0.mToolbar.setVisibility(this.val$visibility);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter
    public void onAnimationStart(View view) {
        this.this$0.mToolbar.setVisibility(0);
    }
}
