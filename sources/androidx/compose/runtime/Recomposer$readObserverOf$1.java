package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Recomposer$readObserverOf$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ ControlledComposition $composition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$readObserverOf$1(ControlledComposition controlledComposition) {
        super(1);
        this.$composition = controlledComposition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m905invoke(obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m905invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        this.$composition.recordReadOf(obj);
    }
}
