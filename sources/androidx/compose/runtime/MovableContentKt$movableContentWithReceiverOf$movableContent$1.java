package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class MovableContentKt$movableContentWithReceiverOf$movableContent$1<R> extends Lambda implements Function3<R, Composer, Integer, Unit> {
    final /* synthetic */ Function3<R, Composer, Integer, Unit> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    MovableContentKt$movableContentWithReceiverOf$movableContent$1(Function3<? super R, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$content = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((MovableContentKt$movableContentWithReceiverOf$movableContent$1<R>) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(R r, @Nullable Composer composer, int i) {
        if ((i & 14) == 0) {
            i |= composer.changed(r) ? 4 : 2;
        }
        if ((i & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(250838178, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:170)");
        }
        this.$content.invoke(r, composer, Integer.valueOf(i & 14));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
