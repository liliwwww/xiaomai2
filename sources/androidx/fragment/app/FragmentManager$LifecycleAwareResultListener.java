package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FragmentManager$LifecycleAwareResultListener implements FragmentResultListener {
    private final Lifecycle mLifecycle;
    private final FragmentResultListener mListener;
    private final LifecycleEventObserver mObserver;

    FragmentManager$LifecycleAwareResultListener(@NonNull Lifecycle lifecycle, @NonNull FragmentResultListener fragmentResultListener, @NonNull LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle = lifecycle;
        this.mListener = fragmentResultListener;
        this.mObserver = lifecycleEventObserver;
    }

    public boolean isAtLeast(Lifecycle.State state) {
        return this.mLifecycle.getCurrentState().isAtLeast(state);
    }

    public void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
        this.mListener.onFragmentResult(str, bundle);
    }

    public void removeObserver() {
        this.mLifecycle.removeObserver(this.mObserver);
    }
}
