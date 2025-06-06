package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DisposableEffectScope {
    public static final int $stable = 0;

    @NotNull
    public final DisposableEffectResult onDispose(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onDisposeEffect");
        return new onDispose.1(function0);
    }
}
