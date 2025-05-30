package androidx.compose.ui.input;

import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ScrollContainerInfoKt$consumeScrollContainerInfo$1 extends Lambda implements Function1<ModifierLocalReadScope, Unit> {
    final /* synthetic */ Function1<ScrollContainerInfo, Unit> $consumer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollContainerInfoKt$consumeScrollContainerInfo$1(Function1<? super ScrollContainerInfo, Unit> function1) {
        super(1);
        this.$consumer = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ModifierLocalReadScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "$this$modifierLocalConsumer");
        this.$consumer.invoke(modifierLocalReadScope.getCurrent(ScrollContainerInfoKt.getModifierLocalScrollContainerInfo()));
    }
}
