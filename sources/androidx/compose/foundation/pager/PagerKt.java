package androidx.compose.foundation.pager;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PagerKt {

    @NotNull
    private static final ConsumeAllFlingOnDirection ConsumeHorizontalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Horizontal);

    @NotNull
    private static final ConsumeAllFlingOnDirection ConsumeVerticalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Vertical);

    /* JADX WARN: Removed duplicated region for block: B:101:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x025e  */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.ExperimentalFoundationApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: HorizontalPager-AlbwjTQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m508HorizontalPagerAlbwjTQ(final int r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, @org.jetbrains.annotations.Nullable androidx.compose.foundation.pager.PagerState r38, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r39, @org.jetbrains.annotations.Nullable androidx.compose.foundation.pager.PageSize r40, int r41, float r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Vertical r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r44, boolean r45, boolean r46, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r47, @org.jetbrains.annotations.Nullable androidx.compose.ui.input.nestedscroll.NestedScrollConnection r48, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r50, final int r51, final int r52, final int r53) {
        /*
            Method dump skipped, instructions count: 953
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m508HorizontalPagerAlbwjTQ(int, androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: Pager-wKDqQAw, reason: not valid java name */
    public static final void m509PagerwKDqQAw(@NotNull Modifier modifier, @NotNull PagerState pagerState, int i, @NotNull PageSize pageSize, float f, @NotNull Orientation orientation, int i2, @Nullable Alignment.Vertical vertical, @Nullable Alignment.Horizontal horizontal, @NotNull PaddingValues paddingValues, @NotNull SnapFlingBehavior snapFlingBehavior, boolean z, boolean z2, @Nullable Function1<? super Integer, ? extends Object> function1, @NotNull NestedScrollConnection nestedScrollConnection, @NotNull Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(pagerState, "state");
        Intrinsics.checkNotNullParameter(pageSize, "pageSize");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(paddingValues, "contentPadding");
        Intrinsics.checkNotNullParameter(snapFlingBehavior, "flingBehavior");
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "pageNestedScrollConnection");
        Intrinsics.checkNotNullParameter(function3, "pageContent");
        Composer startRestartGroup = composer.startRestartGroup(-765777783);
        Alignment.Vertical centerVertically = (i5 & 128) != 0 ? Alignment.Companion.getCenterVertically() : vertical;
        Alignment.Horizontal centerHorizontally = (i5 & 256) != 0 ? Alignment.Companion.getCenterHorizontally() : horizontal;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-765777783, i3, i4, "androidx.compose.foundation.pager.Pager (Pager.kt:235)");
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beyondBoundsPageCount should be greater than or equal to 0, you selected " + i2).toString());
        }
        boolean z3 = orientation == Orientation.Vertical;
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        boolean z4 = z3;
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed = startRestartGroup.changed(paddingValues) | startRestartGroup.changed(orientation) | startRestartGroup.changed(layoutDirection);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = Dp.box-impl(calculateContentPaddings(paddingValues, orientation, layoutDirection));
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        float f2 = ((Dp) rememberedValue).unbox-impl();
        int i6 = i3 & 112;
        startRestartGroup.startReplaceableGroup(511388516);
        boolean changed2 = startRestartGroup.changed(snapFlingBehavior) | startRestartGroup.changed(pagerState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new PagerWrapperFlingBehavior(snapFlingBehavior, pagerState);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) rememberedValue2;
        Dp dp = Dp.box-impl(f);
        Dp dp2 = Dp.box-impl(f);
        int i7 = (i3 >> 6) & 896;
        startRestartGroup.startReplaceableGroup(1618982084);
        boolean changed3 = startRestartGroup.changed(dp2) | startRestartGroup.changed(density) | startRestartGroup.changed(pagerState);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Pager.2.1(density, pagerState, f, (Continuation) null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(density, pagerState, dp, (Function2) rememberedValue3, startRestartGroup, i7 | i6 | AccessibilityEventCompat.TYPE_VIEW_SCROLLED);
        int i8 = (i3 >> 3) & 14;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed4 = startRestartGroup.changed(pagerState);
        Object rememberedValue4 = startRestartGroup.rememberedValue();
        if (changed4 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = new Pager.3.1(pagerState, (Continuation) null);
            startRestartGroup.updateRememberedValue(rememberedValue4);
        }
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(pagerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, i8 | 64);
        startRestartGroup.startReplaceableGroup(1445594447);
        Modifier pagerSemantics = z ? pagerSemantics(Modifier.Companion, pagerState, z4, startRestartGroup, i6 | 6) : Modifier.Companion;
        startRestartGroup.endReplaceableGroup();
        BoxWithConstraintsKt.BoxWithConstraints(modifier.then(pagerSemantics), null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1677736225, true, new Pager.4(z4, density, i3, f2, z2, f, paddingValues, pagerWrapperFlingBehavior, z, i2, centerHorizontally, centerVertically, i4, pageSize, pagerState, i, function1, nestedScrollConnection, function3)), startRestartGroup, 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Pager.5(modifier, pagerState, i, pageSize, f, orientation, i2, centerVertically, centerHorizontally, paddingValues, snapFlingBehavior, z, z2, function1, nestedScrollConnection, function3, i3, i4, i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final DecayAnimationSpec<Float> decayAnimationSpec) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.pager.PagerKt$SnapLayoutInfoProvider$1
            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(@NotNull Density density, float f) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                float currentPageOffsetFraction = PagerState.this.getCurrentPageOffsetFraction() * (PagerState.this.getPageSize$foundation_release() + PagerState.this.getPageSpacing$foundation_release());
                float calculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, f);
                int currentPage = PagerState.this.getCurrentPage();
                return ((RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(currentPage, (int) ((((currentPage * r11) + currentPageOffsetFraction) + calculateTargetValue) / r1), f, PagerState.this.getPageSize$foundation_release(), PagerState.this.getPageSpacing$foundation_release()), 0, PagerState.this.getPageCount$foundation_release()) - currentPage) * r11) - currentPageOffsetFraction;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapStepSize(@NotNull Density density) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                LazyListLayoutInfo layoutInfo = getLayoutInfo();
                if (!(!layoutInfo.getVisibleItemsInfo().isEmpty())) {
                    return 0.0f;
                }
                List visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
                int size = visibleItemsInfo.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    i += ((LazyListItemInfo) visibleItemsInfo.get(i2)).getSize();
                }
                return i / layoutInfo.getVisibleItemsInfo().size();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            @NotNull
            public ClosedFloatingPointRange<Float> calculateSnappingOffsetBounds(@NotNull Density density) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                List visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
                int size = visibleItemsInfo.size();
                float f = Float.NEGATIVE_INFINITY;
                float f2 = Float.POSITIVE_INFINITY;
                for (int i = 0; i < size; i++) {
                    float calculateDistanceToDesiredSnapPosition = LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(density, getLayoutInfo(), (LazyListItemInfo) visibleItemsInfo.get(i), PagerStateKt.getSnapAlignmentStartToStart());
                    if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f) {
                        f = calculateDistanceToDesiredSnapPosition;
                    }
                    if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f2) {
                        f2 = calculateDistanceToDesiredSnapPosition;
                    }
                }
                return RangesKt.rangeTo(f, f2);
            }

            @NotNull
            public final LazyListLayoutInfo getLayoutInfo() {
                return PagerState.this.getLayoutInfo$foundation_release();
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x025e  */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.ExperimentalFoundationApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: VerticalPager-AlbwjTQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m510VerticalPagerAlbwjTQ(final int r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, @org.jetbrains.annotations.Nullable androidx.compose.foundation.pager.PagerState r38, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r39, @org.jetbrains.annotations.Nullable androidx.compose.foundation.pager.PageSize r40, int r41, float r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Horizontal r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r44, boolean r45, boolean r46, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r47, @org.jetbrains.annotations.Nullable androidx.compose.ui.input.nestedscroll.NestedScrollConnection r48, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r50, final int r51, final int r52, final int r53) {
        /*
            Method dump skipped, instructions count: 953
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m510VerticalPagerAlbwjTQ(int, androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateContentPaddings(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        Orientation orientation2 = Orientation.Vertical;
        return Dp.constructor-impl((orientation == orientation2 ? paddingValues.calculateTopPadding-D9Ej5fM() : paddingValues.calculateLeftPadding-u2uoSUM(layoutDirection)) + (orientation == orientation2 ? paddingValues.calculateBottomPadding-D9Ej5fM() : paddingValues.calculateRightPadding-u2uoSUM(layoutDirection)));
    }

    @Composable
    private static final Modifier pagerSemantics(Modifier modifier, PagerState pagerState, boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(1509835088);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, i, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:701)");
        }
        composer.startReplaceableGroup(773894976);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Modifier then = modifier.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new pagerSemantics.1(z, pagerState, coroutineScope), 1, (Object) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new pagerSemantics.performBackwardPaging.1(pagerState, (Continuation) null), 3, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, (Object) null);
        return true;
    }
}
