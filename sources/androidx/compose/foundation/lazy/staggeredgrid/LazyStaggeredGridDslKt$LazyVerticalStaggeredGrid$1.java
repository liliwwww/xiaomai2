package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ StaggeredGridCells $columns;
    final /* synthetic */ Function1<LazyStaggeredGridScope, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ Arrangement$Horizontal $horizontalArrangement;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LazyStaggeredGridState $state;
    final /* synthetic */ boolean $userScrollEnabled;
    final /* synthetic */ Arrangement$Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridDslKt$LazyVerticalStaggeredGrid$1(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, Arrangement$Vertical arrangement$Vertical, Arrangement$Horizontal arrangement$Horizontal, FlingBehavior flingBehavior, boolean z, Function1<? super LazyStaggeredGridScope, Unit> function1, int i, int i2) {
        super(2);
        this.$columns = staggeredGridCells;
        this.$modifier = modifier;
        this.$state = lazyStaggeredGridState;
        this.$contentPadding = paddingValues;
        this.$verticalArrangement = arrangement$Vertical;
        this.$horizontalArrangement = arrangement$Horizontal;
        this.$flingBehavior = flingBehavior;
        this.$userScrollEnabled = z;
        this.$content = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid(this.$columns, this.$modifier, this.$state, this.$contentPadding, this.$verticalArrangement, this.$horizontalArrangement, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
