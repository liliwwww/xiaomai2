package androidx.compose.foundation.pager;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class PagerKt$Pager$4 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ float $calculatedContentPaddings;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Density $density;
    final /* synthetic */ Alignment$Horizontal $horizontalAlignment;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function1<Integer, Object> $key;
    final /* synthetic */ Function3<Integer, Composer, Integer, Unit> $pageContent;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ NestedScrollConnection $pageNestedScrollConnection;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ PagerWrapperFlingBehavior $pagerFlingBehavior;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ boolean $userScrollEnabled;
    final /* synthetic */ Alignment$Vertical $verticalAlignment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PagerKt$Pager$4(boolean z, Density density, int i, float f, boolean z2, float f2, PaddingValues paddingValues, PagerWrapperFlingBehavior pagerWrapperFlingBehavior, boolean z3, int i2, Alignment$Horizontal alignment$Horizontal, Alignment$Vertical alignment$Vertical, int i3, PageSize pageSize, PagerState pagerState, int i4, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$isVertical = z;
        this.$density = density;
        this.$$dirty = i;
        this.$calculatedContentPaddings = f;
        this.$reverseLayout = z2;
        this.$pageSpacing = f2;
        this.$contentPadding = paddingValues;
        this.$pagerFlingBehavior = pagerWrapperFlingBehavior;
        this.$userScrollEnabled = z3;
        this.$beyondBoundsPageCount = i2;
        this.$horizontalAlignment = alignment$Horizontal;
        this.$verticalAlignment = alignment$Vertical;
        this.$$dirty1 = i3;
        this.$pageSize = pageSize;
        this.$state = pagerState;
        this.$pageCount = i4;
        this.$key = function1;
        this.$pageNestedScrollConnection = nestedScrollConnection;
        this.$pageContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ef, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L48;
     */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.layout.BoxWithConstraintsScope r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt$Pager$4.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
