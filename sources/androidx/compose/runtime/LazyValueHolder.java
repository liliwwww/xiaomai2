package androidx.compose.runtime;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyValueHolder<T> implements State<T> {

    @NotNull
    private final Lazy current$delegate;

    public LazyValueHolder(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "valueProducer");
        this.current$delegate = LazyKt.lazy(function0);
    }

    private final T getCurrent() {
        return (T) this.current$delegate.getValue();
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        return getCurrent();
    }
}
