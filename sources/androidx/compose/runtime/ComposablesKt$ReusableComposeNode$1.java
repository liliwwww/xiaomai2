package androidx.compose.runtime;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ComposablesKt$ReusableComposeNode$1<T> extends Lambda implements Function0<T> {
    final /* synthetic */ Function0<T> $factory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ComposablesKt$ReusableComposeNode$1(Function0<? extends T> function0) {
        super(0);
        this.$factory = function0;
    }

    @NotNull
    public final T invoke() {
        return (T) this.$factory.invoke();
    }
}
