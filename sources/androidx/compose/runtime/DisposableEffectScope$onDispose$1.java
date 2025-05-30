package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DisposableEffectScope$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Function0<Unit> $onDisposeEffect;

    public DisposableEffectScope$onDispose$1(Function0<Unit> function0) {
        this.$onDisposeEffect = function0;
    }

    public void dispose() {
        this.$onDisposeEffect.invoke();
    }
}
