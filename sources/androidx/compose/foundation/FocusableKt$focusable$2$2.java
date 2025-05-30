package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FocusableKt$focusable$2$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableState<FocusInteraction$Focus> $focusedInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2$2(boolean z, CoroutineScope coroutineScope, MutableState<FocusInteraction$Focus> mutableState, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.$enabled = z;
        this.$scope = coroutineScope;
        this.$focusedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        if (!this.$enabled) {
            d.d(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new 1(this.$focusedInteraction, this.$interactionSource, (Continuation) null), 3, (Object) null);
        }
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$2$invoke$$inlined$onDispose$1
            public void dispose() {
            }
        };
    }
}
