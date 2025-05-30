package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewModelKt {
    private static final <VM extends ViewModel> VM get(ViewModelStoreOwner viewModelStoreOwner, Class<VM> cls, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras) {
        ViewModelProvider viewModelProvider;
        if (factory != null) {
            ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "this.viewModelStore");
            viewModelProvider = new ViewModelProvider(viewModelStore, factory, creationExtras);
        } else if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            ViewModelStore viewModelStore2 = viewModelStoreOwner.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "this.viewModelStore");
            ViewModelProvider.Factory defaultViewModelProviderFactory = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "this.defaultViewModelProviderFactory");
            viewModelProvider = new ViewModelProvider(viewModelStore2, defaultViewModelProviderFactory, creationExtras);
        } else {
            viewModelProvider = new ViewModelProvider(viewModelStoreOwner);
        }
        return str != null ? (VM) viewModelProvider.get(str, cls) : (VM) viewModelProvider.get(cls);
    }

    static /* synthetic */ ViewModel get$default(ViewModelStoreOwner viewModelStoreOwner, Class cls, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            factory = null;
        }
        if ((i & 8) != 0) {
            if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        this.defaultVi…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
        }
        return get(viewModelStoreOwner, cls, str, factory, creationExtras);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModel that takes CreationExtras")
    @Composable
    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-384969861);
        if ((i2 & 1) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
        String str2 = (i2 & 2) != 0 ? null : str;
        ViewModelProvider.Factory factory2 = (i2 & 4) != 0 ? null : factory;
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModel(ViewModel.class, viewModelStoreOwner2, str2, factory2, null, composer, ((i << 3) & 896) | 4168, 16);
        composer.endReplaceableGroup();
        return vm;
    }

    @Composable
    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras, Composer composer, int i, int i2) {
        CreationExtras creationExtras2;
        composer.startReplaceableGroup(1729797275);
        if ((i2 & 1) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
        String str2 = (i2 & 2) != 0 ? null : str;
        ViewModelProvider.Factory factory2 = (i2 & 4) != 0 ? null : factory;
        if ((i2 & 8) != 0) {
            if (viewModelStoreOwner2 instanceof HasDefaultViewModelProviderFactory) {
                creationExtras2 = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner2).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras2, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras2 = CreationExtras.Empty.INSTANCE;
            }
            creationExtras = creationExtras2;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModel(ViewModel.class, viewModelStoreOwner2, str2, factory2, creationExtras, composer, ((i << 3) & 896) | 36936, 0);
        composer.endReplaceableGroup();
        return vm;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModel that takes CreationExtras")
    @Composable
    public static final /* synthetic */ ViewModel viewModel(Class cls, ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        composer.startReplaceableGroup(1324836815);
        if ((i2 & 2) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModel viewModel = get$default(viewModelStoreOwner, cls, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : factory, null, 8, null);
        composer.endReplaceableGroup();
        return viewModel;
    }

    @Composable
    @NotNull
    public static final <VM extends ViewModel> VM viewModel(@NotNull Class<VM> cls, @Nullable ViewModelStoreOwner viewModelStoreOwner, @Nullable String str, @Nullable ViewModelProvider.Factory factory, @Nullable CreationExtras creationExtras, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        composer.startReplaceableGroup(-1439476281);
        if ((i2 & 2) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            factory = null;
        }
        if ((i2 & 16) != 0) {
            if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(creationExtras, "{\n        viewModelStore…ModelCreationExtras\n    }");
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
        }
        VM vm = (VM) get(viewModelStoreOwner, cls, str, factory, creationExtras);
        composer.endReplaceableGroup();
        return vm;
    }

    @Composable
    public static final /* synthetic */ <VM extends ViewModel> VM viewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Function1<? super CreationExtras, ? extends VM> function1, Composer composer, int i, int i2) {
        CreationExtras creationExtras;
        Intrinsics.checkNotNullParameter(function1, "initializer");
        composer.startReplaceableGroup(419377738);
        if ((i2 & 1) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelStoreOwner viewModelStoreOwner2 = viewModelStoreOwner;
        if ((i2 & 2) != 0) {
            str = null;
        }
        String str2 = str;
        Intrinsics.reifiedOperationMarker(4, "VM");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        Intrinsics.reifiedOperationMarker(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(ViewModel.class), function1);
        Unit unit = Unit.INSTANCE;
        ViewModelProvider.Factory build = initializerViewModelFactoryBuilder.build();
        if (viewModelStoreOwner2 instanceof HasDefaultViewModelProviderFactory) {
            creationExtras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner2).getDefaultViewModelCreationExtras();
        } else {
            creationExtras = CreationExtras.Empty.INSTANCE;
        }
        CreationExtras creationExtras2 = creationExtras;
        Intrinsics.checkNotNullExpressionValue(creationExtras2, "if (viewModelStoreOwner …reationExtras.Empty\n    }");
        VM vm = (VM) viewModel(ViewModel.class, viewModelStoreOwner2, str2, build, creationExtras2, composer, ((i << 3) & 896) | 36936, 0);
        composer.endReplaceableGroup();
        return vm;
    }
}
