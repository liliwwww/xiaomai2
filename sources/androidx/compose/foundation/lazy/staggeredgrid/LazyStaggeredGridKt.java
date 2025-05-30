package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LazyStaggeredGridKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalFoundationApi
    public static final void LazyStaggeredGrid(@NotNull final LazyStaggeredGridState lazyStaggeredGridState, @NotNull final Orientation orientation, @NotNull final Function2<? super Density, ? super Constraints, int[]> function2, @Nullable Modifier modifier, @Nullable PaddingValues paddingValues, boolean z, @Nullable FlingBehavior flingBehavior, boolean z2, @Nullable Arrangement.Vertical vertical, @Nullable Arrangement.Horizontal horizontal, @NotNull final Function1<? super LazyStaggeredGridScope, Unit> function1, @Nullable Composer composer, final int i, final int i2, final int i3) {
        FlingBehavior flingBehavior2;
        int i4;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(function2, "slotSizesSums");
        Intrinsics.checkNotNullParameter(function1, "content");
        Composer startRestartGroup = composer.startRestartGroup(845690866);
        Modifier modifier2 = (i3 & 8) != 0 ? Modifier.Companion : modifier;
        PaddingValues m1387PaddingValues0680j_4 = (i3 & 16) != 0 ? PaddingKt.m1387PaddingValues0680j_4(C0856Dp.m5216constructorimpl(0)) : paddingValues;
        boolean z3 = (i3 & 32) != 0 ? false : z;
        if ((i3 & 64) != 0) {
            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
            i4 = i & (-3670017);
        } else {
            flingBehavior2 = flingBehavior;
            i4 = i;
        }
        boolean z4 = (i3 & 128) != 0 ? true : z2;
        Arrangement.Vertical top = (i3 & 256) != 0 ? Arrangement.INSTANCE.getTop() : vertical;
        Arrangement.Horizontal start = (i3 & 512) != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(845690866, i4, i2, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        OverscrollEffect overscrollEffect = scrollableDefaults.overscrollEffect(startRestartGroup, 6);
        LazyLayoutItemProvider rememberStaggeredGridItemProvider = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProvider(lazyStaggeredGridState, function1, startRestartGroup, ((i2 << 3) & 112) | 8);
        int i5 = i4 >> 6;
        int i6 = i4 >> 9;
        final boolean z5 = z3;
        final Modifier modifier3 = modifier2;
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> rememberStaggeredGridMeasurePolicy = LazyStaggeredGridMeasurePolicyKt.rememberStaggeredGridMeasurePolicy(lazyStaggeredGridState, rememberStaggeredGridItemProvider, m1387PaddingValues0680j_4, z3, orientation, top, start, function2, startRestartGroup, (i5 & 7168) | (i5 & 896) | 8 | ((i4 << 9) & 57344) | (458752 & i6) | (3670016 & i6) | ((i4 << 15) & 29360128));
        LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, rememberStaggeredGridItemProvider, z5, startRestartGroup, (i6 & 896) | 8);
        ScrollPositionUpdater(rememberStaggeredGridItemProvider, lazyStaggeredGridState, startRestartGroup, 64);
        LazyLayoutKt.LazyLayout(rememberStaggeredGridItemProvider, LazyLayoutSemanticsKt.lazyLayoutSemantics(ScrollableKt.scrollable(OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(modifier3.then(lazyStaggeredGridState.getRemeasurementModifier$foundation_release()), orientation), overscrollEffect), lazyStaggeredGridState, orientation, overscrollEffect, z4, scrollableDefaults.reverseDirection((LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z5), flingBehavior2, lazyStaggeredGridState.getMutableInteractionSource$foundation_release()), rememberStaggeredGridItemProvider, rememberLazyStaggeredGridSemanticState, orientation, z4, startRestartGroup, ((i4 << 6) & 7168) | (i6 & 57344)), lazyStaggeredGridState.getPrefetchState$foundation_release(), rememberStaggeredGridMeasurePolicy, startRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final PaddingValues paddingValues2 = m1387PaddingValues0680j_4;
        final FlingBehavior flingBehavior3 = flingBehavior2;
        final boolean z6 = z4;
        final Arrangement.Vertical vertical2 = top;
        final Arrangement.Horizontal horizontal2 = start;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$LazyStaggeredGrid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i7) {
                LazyStaggeredGridKt.LazyStaggeredGrid(LazyStaggeredGridState.this, orientation, function2, modifier3, paddingValues2, z5, flingBehavior3, z6, vertical2, horizontal2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void ScrollPositionUpdater(final LazyLayoutItemProvider lazyLayoutItemProvider, final LazyStaggeredGridState lazyStaggeredGridState, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(231106410);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231106410, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:113)");
        }
        if (lazyLayoutItemProvider.getItemCount() > 0) {
            lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyLayoutItemProvider);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$ScrollPositionUpdater$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                LazyStaggeredGridKt.ScrollPositionUpdater(LazyLayoutItemProvider.this, lazyStaggeredGridState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }
}
