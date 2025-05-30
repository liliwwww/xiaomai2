package androidx.compose.runtime;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [P1, R, P2, P3] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MovableContentKt$movableContentWithReceiverOf$movableContent$4<P1, P2, P3, R> extends Lambda implements Function3<Pair<? extends Pair<? extends R, ? extends P1>, ? extends Pair<? extends P2, ? extends P3>>, Composer, Integer, Unit> {
    final /* synthetic */ Function6<R, P1, P2, P3, Composer, Integer, Unit> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentWithReceiverOf$movableContent$4(Function6<? super R, ? super P1, ? super P2, ? super P3, ? super Composer, ? super Integer, Unit> function6) {
        super(3);
        this.$content = function6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull Pair<? extends Pair<? extends R, ? extends P1>, ? extends Pair<? extends P2, ? extends P3>> pair, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(838586922, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:253)");
        }
        this.$content.invoke(((Pair) pair.getFirst()).getFirst(), ((Pair) pair.getFirst()).getSecond(), ((Pair) pair.getSecond()).getFirst(), ((Pair) pair.getSecond()).getSecond(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
