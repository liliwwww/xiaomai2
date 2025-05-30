package androidx.compose.runtime;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [P1, P2] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MovableContentKt$movableContentOf$3<P1, P2> extends Lambda implements Function4<P1, P2, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<P1, P2>> $movableContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$3(MovableContent<Pair<P1, P2>> movableContent) {
        super(4);
        this.$movableContent = movableContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((MovableContentKt$movableContentOf$3<P1, P2>) obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(P1 p1, P2 p2, @Nullable Composer composer, int i) {
        int i2;
        if ((i & 14) == 0) {
            i2 = (composer.changed(p1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composer.changed(p2) ? 32 : 16;
        }
        if ((i2 & 731) == 146 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1200019734, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:88)");
        }
        composer.insertMovableContent(this.$movableContent, TuplesKt.to(p1, p2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
