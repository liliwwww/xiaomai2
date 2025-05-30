package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $bottomBarHeight;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(SubcomposeMeasureScope subcomposeMeasureScope, int i, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, int i2) {
        super(2);
        this.$this_SubcomposeLayout = subcomposeMeasureScope;
        this.$bottomBarHeight = i;
        this.$content = function3;
        this.$$dirty = i2;
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
            ComposerKt.traceEventStart(-1132241596, i, -1, "androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:319)");
        }
        this.$content.invoke(PaddingKt.m329PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, this.$this_SubcomposeLayout.toDp-u2uoSUM(this.$bottomBarHeight), 7, null), composer, Integer.valueOf((this.$$dirty >> 6) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
