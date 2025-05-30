package androidx.fragment.app;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FragmentViewModelLazyKt$viewModels$8 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;
    final /* synthetic */ Fragment $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$8(Fragment fragment, Lazy<? extends ViewModelStoreOwner> lazy) {
        super(0);
        this.$this_viewModels = fragment;
        this.$owner$delegate = lazy;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ViewModelProvider.Factory m2339invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory;
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
        if (hasDefaultViewModelProviderFactory2 == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) == null) {
            defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        }
        Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "(owner as? HasDefaultVie…tViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
