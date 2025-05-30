package androidx.compose.runtime;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [P1, P2, P3] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MovableContentKt$movableContentOf$4<P1, P2, P3> extends Lambda implements Function5<P1, P2, P3, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<Pair<P1, P2>, P3>> $movableContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$4(MovableContent<Pair<Pair<P1, P2>, P3>> movableContent) {
        super(5);
        this.$movableContent = movableContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        invoke((MovableContentKt$movableContentOf$4<P1, P2, P3>) obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(P1 p1, P2 p2, P3 p3, @Nullable Composer composer, int i) {
        int i2;
        if ((i & 14) == 0) {
            i2 = (composer.changed(p1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composer.changed(p2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composer.changed(p3) ? 256 : 128;
        }
        if ((i2 & 5851) == 1170 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1083870185, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:117)");
        }
        composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(p1, p2), p3));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
