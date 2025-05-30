package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FragmentViewModelLazyKt$viewModels$6 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ Lazy<ViewModelStoreOwner> $owner$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$6(Lazy<? extends ViewModelStoreOwner> lazy) {
        super(0);
        this.$owner$delegate = lazy;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ViewModelStore m2337invoke() {
        ViewModelStore viewModelStore = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate).getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "owner.viewModelStore");
        return viewModelStore;
    }
}
