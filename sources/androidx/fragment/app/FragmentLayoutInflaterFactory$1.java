package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class FragmentLayoutInflaterFactory$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ FragmentLayoutInflaterFactory this$0;
    final /* synthetic */ FragmentStateManager val$fragmentStateManager;

    FragmentLayoutInflaterFactory$1(FragmentLayoutInflaterFactory fragmentLayoutInflaterFactory, FragmentStateManager fragmentStateManager) {
        this.this$0 = fragmentLayoutInflaterFactory;
        this.val$fragmentStateManager = fragmentStateManager;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Fragment fragment = this.val$fragmentStateManager.getFragment();
        this.val$fragmentStateManager.moveToExpectedState();
        SpecialEffectsController.getOrCreateController((ViewGroup) fragment.mView.getParent(), this.this$0.mFragmentManager).forceCompleteAllOperations();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
