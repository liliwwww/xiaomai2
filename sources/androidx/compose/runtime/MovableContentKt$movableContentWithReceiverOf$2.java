package androidx.compose.runtime;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [P, R] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MovableContentKt$movableContentWithReceiverOf$2<P, R> extends Lambda implements Function4<R, P, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<R, P>> $movableContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentWithReceiverOf$2(MovableContent<Pair<R, P>> movableContent) {
        super(4);
        this.$movableContent = movableContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((MovableContentKt$movableContentWithReceiverOf$2<P, R>) obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(R r, P p, @Nullable Composer composer, int i) {
        int i2;
        if ((i & 14) == 0) {
            i2 = (composer.changed(r) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composer.changed(p) ? 32 : 16;
        }
        if ((i2 & 731) == 146 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(627354118, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:198)");
        }
        composer.insertMovableContent(this.$movableContent, TuplesKt.to(r, p));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
