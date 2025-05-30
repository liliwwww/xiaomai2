package androidx.compose.ui.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SubcomposeLayoutKt$SubcomposeLayout$5$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ State<SubcomposeLayoutState> $stateHolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutKt$SubcomposeLayout$5$1(State<SubcomposeLayoutState> state) {
        super(1);
        this.$stateHolder = state;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        final State<SubcomposeLayoutState> state = this.$stateHolder;
        return new DisposableEffectResult() { // from class: androidx.compose.ui.layout.SubcomposeLayoutKt$SubcomposeLayout$5$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ((SubcomposeLayoutState) state.getValue()).disposeCurrentNodes$ui_release();
            }
        };
    }
}
