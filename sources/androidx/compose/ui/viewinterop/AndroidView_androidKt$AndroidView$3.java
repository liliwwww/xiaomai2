package androidx.compose.ui.viewinterop;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3$invoke$;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidView_androidKt$AndroidView$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ String $stateKey;
    final /* synthetic */ SaveableStateRegistry $stateRegistry;
    final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$AndroidView$3(SaveableStateRegistry saveableStateRegistry, String str, Ref<ViewFactoryHolder<T>> ref) {
        super(1);
        this.$stateRegistry = saveableStateRegistry;
        this.$stateKey = str;
        this.$viewFactoryHolderRef = ref;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new AndroidView_androidKt$AndroidView$3$invoke$.inlined.onDispose.1(this.$stateRegistry.registerProvider(this.$stateKey, new valueProvider.1<>(this.$viewFactoryHolderRef)));
    }
}
