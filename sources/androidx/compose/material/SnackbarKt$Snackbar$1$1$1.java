package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnackbarKt$Snackbar$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnackbarKt$Snackbar$1$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, boolean z) {
        super(2);
        this.$action = function2;
        this.$content = function22;
        this.$$dirty = i;
        this.$actionOnNewLine = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(225114541, i, -1, "androidx.compose.material.Snackbar.<anonymous>.<anonymous>.<anonymous> (Snackbar.kt:99)");
        }
        if (this.$action == null) {
            composer.startReplaceableGroup(59708346);
            SnackbarKt.access$TextOnlySnackbar(this.$content, composer, (this.$$dirty >> 21) & 14);
            composer.endReplaceableGroup();
        } else if (this.$actionOnNewLine) {
            composer.startReplaceableGroup(59708411);
            Function2<Composer, Integer, Unit> function2 = this.$content;
            Function2<Composer, Integer, Unit> function22 = this.$action;
            int i2 = this.$$dirty;
            SnackbarKt.access$NewLineButtonSnackbar(function2, function22, composer, (i2 & 112) | ((i2 >> 21) & 14));
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(59708478);
            Function2<Composer, Integer, Unit> function23 = this.$content;
            Function2<Composer, Integer, Unit> function24 = this.$action;
            int i3 = this.$$dirty;
            SnackbarKt.access$OneRowSnackbar(function23, function24, composer, (i3 & 112) | ((i3 >> 21) & 14));
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
