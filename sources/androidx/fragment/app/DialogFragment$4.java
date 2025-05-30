package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DialogFragment$4 implements Observer<LifecycleOwner> {
    final /* synthetic */ DialogFragment this$0;

    DialogFragment$4(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    @SuppressLint({"SyntheticAccessor"})
    public void onChanged(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null || !DialogFragment.access$200(this.this$0)) {
            return;
        }
        View requireView = this.this$0.requireView();
        if (requireView.getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
        }
        if (DialogFragment.access$000(this.this$0) != null) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + DialogFragment.access$000(this.this$0));
            }
            DialogFragment.access$000(this.this$0).setContentView(requireView);
        }
    }
}
