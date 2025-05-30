package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class StaticProvidableCompositionLocal<T> extends ProvidableCompositionLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticProvidableCompositionLocal(@NotNull Function0<? extends T> function0) {
        super(function0);
        Intrinsics.checkNotNullParameter(function0, "defaultFactory");
    }

    @Composable
    @NotNull
    public State<T> provided$runtime_release(T t, @Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1121811719);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1121811719, i, -1, "androidx.compose.runtime.StaticProvidableCompositionLocal.provided (CompositionLocal.kt:139)");
        }
        StaticValueHolder staticValueHolder = new StaticValueHolder(t);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return staticValueHolder;
    }
}
