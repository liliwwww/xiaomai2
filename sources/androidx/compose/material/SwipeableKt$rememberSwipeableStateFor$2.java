package androidx.compose.material;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableKt$rememberSwipeableStateFor$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<Boolean> $forceAnimationCheck;
    final /* synthetic */ Function1<T, Unit> $onValueChange;
    final /* synthetic */ SwipeableState<T> $swipeableState;
    final /* synthetic */ T $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeableKt$rememberSwipeableStateFor$2(T t, SwipeableState<T> swipeableState, Function1<? super T, Unit> function1, MutableState<Boolean> mutableState) {
        super(1);
        this.$value = t;
        this.$swipeableState = swipeableState;
        this.$onValueChange = function1;
        this.$forceAnimationCheck = mutableState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        if (!Intrinsics.areEqual(this.$value, this.$swipeableState.getCurrentValue())) {
            this.$onValueChange.invoke(this.$swipeableState.getCurrentValue());
            this.$forceAnimationCheck.setValue(Boolean.valueOf(!((Boolean) r2.getValue()).booleanValue()));
        }
        return new DisposableEffectResult() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1
            public void dispose() {
            }
        };
    }
}
