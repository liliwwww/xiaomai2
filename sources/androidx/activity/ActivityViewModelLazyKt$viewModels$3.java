package androidx.activity;

import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ActivityViewModelLazyKt$viewModels$3 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$3(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ViewModelStore m2invoke() {
        ViewModelStore viewModelStore = this.$this_viewModels.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
