package androidx.compose.ui.tooling;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: androidx.compose.ui.tooling.ComposableSingletons$PreviewActivityKt$lambda-1$1, reason: invalid class name */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposableSingletons$PreviewActivityKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$PreviewActivityKt$lambda1$1 INSTANCE = new ComposableSingletons$PreviewActivityKt$lambda1$1();

    ComposableSingletons$PreviewActivityKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(38142554, i, -1, "androidx.compose.ui.tooling.ComposableSingletons$PreviewActivityKt.lambda-1.<anonymous> (PreviewActivity.kt:119)");
        }
        TextKt.m878TextfLXpl1I("Next", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 6, 0, 65534);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
