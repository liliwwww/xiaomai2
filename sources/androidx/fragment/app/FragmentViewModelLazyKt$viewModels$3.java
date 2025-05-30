package androidx.fragment.app;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FragmentViewModelLazyKt$viewModels$3 extends Lambda implements Function0<CreationExtras> {
    final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$3(Lazy<? extends ViewModelStoreOwner> lazy) {
        super(0);
        this.$owner$delegate = lazy;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final CreationExtras m2334invoke() {
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-0(this.$owner$delegate);
        HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
        CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : null;
        return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
    }
}
