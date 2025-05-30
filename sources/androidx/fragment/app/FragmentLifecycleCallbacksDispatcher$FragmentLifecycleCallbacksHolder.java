package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder {

    @NonNull
    final FragmentManager.FragmentLifecycleCallbacks mCallback;
    final boolean mRecursive;

    FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.mCallback = fragmentLifecycleCallbacks;
        this.mRecursive = z;
    }
}
