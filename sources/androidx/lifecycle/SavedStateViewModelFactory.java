package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {

    @Nullable
    private Application application;

    @Nullable
    private Bundle defaultArgs;

    @NotNull
    private final ViewModelProvider.Factory factory;

    @Nullable
    private Lifecycle lifecycle;

    @Nullable
    private SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory();
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls, @NotNull CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(creationExtras, "extras");
        String str = (String) creationExtras.get(ViewModelProvider$NewInstanceFactory.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (creationExtras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) == null || creationExtras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) == null) {
            if (this.lifecycle != null) {
                return (T) create(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) creationExtras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        Constructor findMatchingConstructor = (!isAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p()) : SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
        return findMatchingConstructor == null ? (T) this.factory.create(cls, creationExtras) : (!isAssignableFrom || application == null) ? (T) SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, new Object[]{SavedStateHandleSupport.createSavedStateHandle(creationExtras)}) : (T) SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, new Object[]{application, SavedStateHandleSupport.createSavedStateHandle(creationExtras)});
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public void onRequery(@NotNull ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, this.savedStateRegistry, lifecycle);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.factory = androidViewModelFactory;
    }

    @NotNull
    public final <T extends ViewModel> T create(@NotNull String str, @NotNull Class<T> cls) {
        Constructor findMatchingConstructor;
        T t;
        Application application;
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (this.lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (isAssignableFrom && this.application != null) {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
            } else {
                findMatchingConstructor = SavedStateViewModelFactoryKt.findMatchingConstructor(cls, SavedStateViewModelFactoryKt.access$getVIEWMODEL_SIGNATURE$p());
            }
            if (findMatchingConstructor == null) {
                return this.application != null ? (T) this.factory.create(cls) : (T) ViewModelProvider$NewInstanceFactory.Companion.getInstance().create(cls);
            }
            SavedStateHandleController create = LegacySavedStateHandleController.create(this.savedStateRegistry, this.lifecycle, str, this.defaultArgs);
            if (isAssignableFrom && (application = this.application) != null) {
                Intrinsics.checkNotNull(application);
                SavedStateHandle handle = create.getHandle();
                Intrinsics.checkNotNullExpressionValue(handle, "controller.handle");
                t = (T) SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, new Object[]{application, handle});
            } else {
                SavedStateHandle handle2 = create.getHandle();
                Intrinsics.checkNotNullExpressionValue(handle2, "controller.handle");
                t = (T) SavedStateViewModelFactoryKt.newInstance(cls, findMatchingConstructor, new Object[]{handle2});
            }
            t.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
            return t;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
