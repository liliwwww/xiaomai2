package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$invoke$;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SelectionContainerKt$SelectionContainer$4 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ SelectionManager $manager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$4(SelectionManager selectionManager) {
        super(1);
        this.$manager = selectionManager;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        return new SelectionContainerKt$SelectionContainer$4$invoke$.inlined.onDispose.1(this.$manager);
    }
}
