package androidx.compose.runtime;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class DisposableEffectImpl implements RememberObserver {

    @NotNull
    private final Function1<DisposableEffectScope, DisposableEffectResult> effect;

    @Nullable
    private DisposableEffectResult onDispose;

    /* JADX WARN: Multi-variable type inference failed */
    public DisposableEffectImpl(@NotNull Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> function1) {
        Intrinsics.checkNotNullParameter(function1, "effect");
        this.effect = function1;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        DisposableEffectResult disposableEffectResult = this.onDispose;
        if (disposableEffectResult != null) {
            disposableEffectResult.dispose();
        }
        this.onDispose = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        DisposableEffectScope disposableEffectScope;
        Function1<DisposableEffectScope, DisposableEffectResult> function1 = this.effect;
        disposableEffectScope = EffectsKt.InternalDisposableEffectScope;
        this.onDispose = (DisposableEffectResult) function1.invoke(disposableEffectScope);
    }
}
