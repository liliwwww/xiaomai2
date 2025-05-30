package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public abstract class ProvidableCompositionLocal<T> extends CompositionLocal<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProvidableCompositionLocal(@NotNull Function0<? extends T> function0) {
        super(function0, null);
        Intrinsics.checkNotNullParameter(function0, "defaultFactory");
    }

    @NotNull
    public final ProvidedValue<T> provides(T t) {
        return new ProvidedValue<>(this, t, true);
    }

    @NotNull
    public final ProvidedValue<T> providesDefault(T t) {
        return new ProvidedValue<>(this, t, false);
    }
}
