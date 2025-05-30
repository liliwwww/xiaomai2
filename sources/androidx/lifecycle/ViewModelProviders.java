package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

/* compiled from: Taobao */
@Deprecated
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ViewModelProviders {
    @Deprecated
    public ViewModelProviders() {
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull FragmentActivity fragmentActivity) {
        return new ViewModelProvider(fragmentActivity);
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull Fragment fragment, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull FragmentActivity fragmentActivity, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
    }
}
