package androidx.fragment.app;

import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FragmentViewModelLazyKt$viewModels$owner$2 extends Lambda implements Function0<ViewModelStoreOwner> {
    final /* synthetic */ Function0<ViewModelStoreOwner> $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$owner$2(Function0<? extends ViewModelStoreOwner> function0) {
        super(0);
        this.$ownerProducer = function0;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ViewModelStoreOwner m2801invoke() {
        return (ViewModelStoreOwner) this.$ownerProducer.invoke();
    }
}
