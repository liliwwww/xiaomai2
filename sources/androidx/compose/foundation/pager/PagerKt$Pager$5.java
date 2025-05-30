package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PagerKt$Pager$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ SnapFlingBehavior $flingBehavior;
    final /* synthetic */ Alignment$Horizontal $horizontalAlignment;
    final /* synthetic */ Function1<Integer, Object> $key;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $pageContent;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ NestedScrollConnection $pageNestedScrollConnection;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ boolean $userScrollEnabled;
    final /* synthetic */ Alignment$Vertical $verticalAlignment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PagerKt$Pager$5(Modifier modifier, PagerState pagerState, int i, PageSize pageSize, float f, Orientation orientation, int i2, Alignment$Vertical alignment$Vertical, Alignment$Horizontal alignment$Horizontal, PaddingValues paddingValues, SnapFlingBehavior snapFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, int i3, int i4, int i5) {
        super(2);
        this.$modifier = modifier;
        this.$state = pagerState;
        this.$pageCount = i;
        this.$pageSize = pageSize;
        this.$pageSpacing = f;
        this.$orientation = orientation;
        this.$beyondBoundsPageCount = i2;
        this.$verticalAlignment = alignment$Vertical;
        this.$horizontalAlignment = alignment$Horizontal;
        this.$contentPadding = paddingValues;
        this.$flingBehavior = snapFlingBehavior;
        this.$userScrollEnabled = z;
        this.$reverseLayout = z2;
        this.$key = function1;
        this.$pageNestedScrollConnection = nestedScrollConnection;
        this.$pageContent = function3;
        this.$$changed = i3;
        this.$$changed1 = i4;
        this.$$default = i5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        PagerKt.Pager-wKDqQAw(this.$modifier, this.$state, this.$pageCount, this.$pageSize, this.$pageSpacing, this.$orientation, this.$beyondBoundsPageCount, this.$verticalAlignment, this.$horizontalAlignment, this.$contentPadding, this.$flingBehavior, this.$userScrollEnabled, this.$reverseLayout, this.$key, this.$pageNestedScrollConnection, this.$pageContent, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
