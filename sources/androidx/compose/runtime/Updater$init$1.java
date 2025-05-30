package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Updater$init$1<T> extends Lambda implements Function2<T, Unit, Unit> {
    final /* synthetic */ Function1<T, Unit> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Updater$init$1(Function1<? super T, Unit> function1) {
        super(2);
        this.$block = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Updater$init$1<T>) obj, (Unit) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(T t, @NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        this.$block.invoke(t);
    }
}
