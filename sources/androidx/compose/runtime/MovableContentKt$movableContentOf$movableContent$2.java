package androidx.compose.runtime;

import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [P1, P2] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MovableContentKt$movableContentOf$movableContent$2<P1, P2> extends Lambda implements Function3<Pair<? extends P1, ? extends P2>, Composer, Integer, Unit> {
    final /* synthetic */ Function4<P1, P2, Composer, Integer, Unit> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentOf$movableContent$2(Function4<? super P1, ? super P2, ? super Composer, ? super Integer, Unit> function4) {
        super(3);
        this.$content = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull Pair<? extends P1, ? extends P2> pair, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(pair, "it");
        if ((i & 14) == 0) {
            i2 = (composer.changed(pair) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1849814513, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:87)");
        }
        this.$content.invoke(pair.getFirst(), pair.getSecond(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
