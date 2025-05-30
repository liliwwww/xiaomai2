package androidx.fragment.app;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentActivity$HostCallbacks extends FragmentHostCallback<FragmentActivity> implements OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, SavedStateRegistryOwner, FragmentOnAttachListener, MenuHost {
    final /* synthetic */ FragmentActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentActivity$HostCallbacks(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.this$0 = fragmentActivity;
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider) {
        this.this$0.addMenuProvider(menuProvider);
    }

    public void addOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
        this.this$0.addOnConfigurationChangedListener(consumer);
    }

    public void addOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.this$0.addOnMultiWindowModeChangedListener(consumer);
    }

    public void addOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.this$0.addOnPictureInPictureModeChangedListener(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public void addOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
        this.this$0.addOnTrimMemoryListener(consumer);
    }

    @NonNull
    public ActivityResultRegistry getActivityResultRegistry() {
        return this.this$0.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.this$0.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    @NonNull
    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.this$0.getOnBackPressedDispatcher();
    }

    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.this$0.getSavedStateRegistry();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NonNull
    public ViewModelStore getViewModelStore() {
        return this.this$0.getViewModelStore();
    }

    public void invalidateMenu() {
        this.this$0.invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentOnAttachListener
    public void onAttachFragment(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        this.this$0.onAttachFragment(fragment);
    }

    public void onDump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
        this.this$0.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public View onFindViewById(int i) {
        return this.this$0.findViewById(i);
    }

    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
    }

    public int onGetWindowAnimations() {
        Window window = this.this$0.getWindow();
        if (window == null) {
            return 0;
        }
        return window.getAttributes().windowAnimations;
    }

    public boolean onHasView() {
        Window window = this.this$0.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    public boolean onHasWindowAnimations() {
        return this.this$0.getWindow() != null;
    }

    public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
        return !this.this$0.isFinishing();
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, str);
    }

    public void onSupportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void removeMenuProvider(@NonNull MenuProvider menuProvider) {
        this.this$0.removeMenuProvider(menuProvider);
    }

    public void removeOnConfigurationChangedListener(@NonNull Consumer<Configuration> consumer) {
        this.this$0.removeOnConfigurationChangedListener(consumer);
    }

    public void removeOnMultiWindowModeChangedListener(@NonNull Consumer<MultiWindowModeChangedInfo> consumer) {
        this.this$0.removeOnMultiWindowModeChangedListener(consumer);
    }

    public void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.this$0.removeOnPictureInPictureModeChangedListener(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public void removeOnTrimMemoryListener(@NonNull Consumer<Integer> consumer) {
        this.this$0.removeOnTrimMemoryListener(consumer);
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        this.this$0.addMenuProvider(menuProvider, lifecycleOwner);
    }

    /* renamed from: onGetHost, reason: merged with bridge method [inline-methods] */
    public FragmentActivity m2324onGetHost() {
        return this.this$0;
    }

    public void addMenuProvider(@NonNull MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.State state) {
        this.this$0.addMenuProvider(menuProvider, lifecycleOwner, state);
    }
}
