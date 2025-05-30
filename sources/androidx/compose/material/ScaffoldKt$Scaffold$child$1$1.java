package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ScaffoldKt$Scaffold$child$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScaffoldKt$Scaffold$child$1$1(boolean z, int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i2, int i3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, ScaffoldState scaffoldState) {
        super(2);
        this.$isFloatingActionButtonDocked = z;
        this.$floatingActionButtonPosition = i;
        this.$topBar = function2;
        this.$content = function3;
        this.$floatingActionButton = function22;
        this.$bottomBar = function23;
        this.$$dirty = i2;
        this.$$dirty1 = i3;
        this.$snackbarHost = function32;
        this.$scaffoldState = scaffoldState;
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
            ComposerKt.traceEventStart(-1128984656, i, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)");
        }
        boolean z = this.$isFloatingActionButtonDocked;
        int i2 = this.$floatingActionButtonPosition;
        Function2<Composer, Integer, Unit> function2 = this.$topBar;
        Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final Function3<SnackbarHostState, Composer, Integer, Unit> function32 = this.$snackbarHost;
        final ScaffoldState scaffoldState = this.$scaffoldState;
        final int i3 = this.$$dirty;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 533782017, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$Scaffold$child$1$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(533782017, i4, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)");
                }
                function32.invoke(scaffoldState.getSnackbarHostState(), composer2, Integer.valueOf((i3 >> 9) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
        Function2<Composer, Integer, Unit> function23 = this.$bottomBar;
        int i4 = this.$$dirty;
        ScaffoldKt.m650ScaffoldLayoutMDYNRJg(z, i2, function2, function3, composableLambda, function22, function23, composer, ((i4 >> 21) & 14) | 24576 | ((i4 >> 15) & 112) | (i4 & 896) | ((this.$$dirty1 >> 12) & 7168) | (458752 & i4) | ((i4 << 9) & 3670016));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
