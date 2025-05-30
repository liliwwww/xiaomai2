package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScaffoldKt$Scaffold$child$1 extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScaffoldKt$Scaffold$child$1(long j, long j2, int i, boolean z, int i2, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, ScaffoldState scaffoldState) {
        super(3);
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$$dirty1 = i;
        this.$isFloatingActionButtonDocked = z;
        this.$floatingActionButtonPosition = i2;
        this.$topBar = function2;
        this.$content = function3;
        this.$floatingActionButton = function22;
        this.$bottomBar = function23;
        this.$$dirty = i3;
        this.$snackbarHost = function32;
        this.$scaffoldState = scaffoldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "childModifier");
        if ((i & 14) == 0) {
            i2 = i | (composer.changed(modifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1823402604, i2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)");
        }
        long j = this.$backgroundColor;
        long j2 = this.$contentColor;
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1128984656, true, new 1(this.$isFloatingActionButtonDocked, this.$floatingActionButtonPosition, this.$topBar, this.$content, this.$floatingActionButton, this.$bottomBar, this.$$dirty, this.$$dirty1, this.$snackbarHost, this.$scaffoldState));
        int i3 = 1572864 | (i2 & 14);
        int i4 = this.$$dirty1;
        SurfaceKt.Surface-F-jzlyU(modifier, (Shape) null, j, j2, (BorderStroke) null, 0.0f, composableLambda, composer, i3 | ((i4 >> 9) & 896) | ((i4 >> 9) & 7168), 50);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
