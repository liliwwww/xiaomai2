package androidx.compose.runtime;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [P1, P2, P3, P4] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MovableContentKt$movableContentOf$5<P1, P2, P3, P4> extends Lambda implements Function6<P1, P2, P3, P4, Composer, Integer, Unit> {
    final /* synthetic */ MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> $movableContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovableContentKt$movableContentOf$5(MovableContent<Pair<Pair<P1, P2>, Pair<P3, P4>>> movableContent) {
        super(6);
        this.$movableContent = movableContent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        invoke((MovableContentKt$movableContentOf$5<P1, P2, P3, P4>) obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(P1 p1, P2 p2, P3 p3, P4 p4, @Nullable Composer composer, int i) {
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
        if ((i & 7168) == 0) {
            i2 |= composer.changed(p4) ? 2048 : 1024;
        }
        if ((i2 & 46811) == 9362 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1741877681, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:146)");
        }
        composer.insertMovableContent(this.$movableContent, TuplesKt.to(TuplesKt.to(p1, p2), TuplesKt.to(p3, p4)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
