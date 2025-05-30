package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentStateManager$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ FragmentStateManager this$0;
    final /* synthetic */ View val$fragmentView;

    FragmentStateManager$1(FragmentStateManager fragmentStateManager, View view) {
        this.this$0 = fragmentStateManager;
        this.val$fragmentView = view;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.val$fragmentView.removeOnAttachStateChangeListener(this);
        ViewCompat.requestApplyInsets(this.val$fragmentView);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
