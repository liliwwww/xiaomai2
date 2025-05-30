package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: classes2.dex */
public final class PagerState implements ScrollableState {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Saver<PagerState, ?> Saver = ListSaverKt.listSaver(new Function2<SaverScope, PagerState, List<? extends Object>>() { // from class: androidx.compose.foundation.pager.PagerState$Companion$Saver$1
        @NotNull
        public final List<Object> invoke(@NotNull SaverScope saverScope, @NotNull PagerState pagerState) {
            Intrinsics.checkNotNullParameter(saverScope, "$this$listSaver");
            Intrinsics.checkNotNullParameter(pagerState, "it");
            return CollectionsKt.listOf(new Object[]{Integer.valueOf(pagerState.getCurrentPage()), Float.valueOf(pagerState.getCurrentPageOffsetFraction())});
        }
    }, new Function1<List, PagerState>() { // from class: androidx.compose.foundation.pager.PagerState$Companion$Saver$2
        @Nullable
        public final PagerState invoke(@NotNull List<? extends Object> list) {
            Intrinsics.checkNotNullParameter(list, "it");
            Object obj = list.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            Object obj2 = list.get(1);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
            return new PagerState(intValue, ((Float) obj2).floatValue());
        }
    });

    @NotNull
    private final MutableState animationTargetPage$delegate;

    @NotNull
    private final AwaitLazyListStateSet awaitLazyListStateSet;

    @NotNull
    private final State currentPage$delegate;

    @NotNull
    private final State currentPageOffsetFraction$delegate;
    private final int initialPage;
    private final float initialPageOffsetFraction;

    @NotNull
    private final MutableState lazyListState$delegate;

    @NotNull
    private final MutableState pageSpacing$delegate;

    @NotNull
    private final State settledPage$delegate;

    @NotNull
    private final MutableState settledPageState$delegate;

    @NotNull
    private final MutableState snapRemainingScrollOffset$delegate;

    @NotNull
    private final State targetPage$delegate;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<PagerState, ?> getSaver() {
            return PagerState.Saver;
        }
    }

    public PagerState() {
        this(0, 0.0f, 3, null);
    }

    public PagerState(int i, float f) {
        this.initialPage = i;
        this.initialPageOffsetFraction = f;
        double d = f;
        if (!(-0.5d <= d && d <= 0.5d)) {
            throw new IllegalArgumentException(("initialPageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
        }
        this.snapRemainingScrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.lazyListState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.pageSpacing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.awaitLazyListStateSet = new AwaitLazyListStateSet();
        this.currentPage$delegate = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$currentPage$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m1655invoke() {
                LazyListItemInfo closestPageToSnappedPosition;
                closestPageToSnappedPosition = PagerState.this.getClosestPageToSnappedPosition();
                return Integer.valueOf(closestPageToSnappedPosition != null ? closestPageToSnappedPosition.getIndex() : 0);
            }
        });
        this.animationTargetPage$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(-1, null, 2, null);
        this.settledPageState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i), null, 2, null);
        this.settledPage$delegate = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$settledPage$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m1657invoke() {
                int settledPageState;
                int coerceInPageRange;
                if (PagerState.this.getPageCount$foundation_release() == 0) {
                    coerceInPageRange = 0;
                } else {
                    PagerState pagerState = PagerState.this;
                    settledPageState = pagerState.getSettledPageState();
                    coerceInPageRange = pagerState.coerceInPageRange(settledPageState);
                }
                return Integer.valueOf(coerceInPageRange);
            }
        });
        this.targetPage$delegate = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$targetPage$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m1658invoke() {
                int animationTargetPage;
                float positionThresholdFraction;
                float f2;
                int pageAvailableSpace;
                int coerceInPageRange;
                int pageAvailableSpace2;
                if (PagerState.this.isScrollInProgress()) {
                    animationTargetPage = PagerState.this.getAnimationTargetPage();
                    if (animationTargetPage != -1) {
                        coerceInPageRange = PagerState.this.getAnimationTargetPage();
                    } else {
                        float snapRemainingScrollOffset$foundation_release = PagerState.this.getSnapRemainingScrollOffset$foundation_release();
                        float signum = Math.signum(PagerState.this.getCurrentPageOffsetFraction());
                        float abs = Math.abs(PagerState.this.getCurrentPageOffsetFraction());
                        positionThresholdFraction = PagerState.this.getPositionThresholdFraction();
                        if (abs >= Math.abs(positionThresholdFraction)) {
                            float abs2 = Math.abs(PagerState.this.getCurrentPageOffsetFraction()) + 1;
                            pageAvailableSpace2 = PagerState.this.getPageAvailableSpace();
                            f2 = abs2 * pageAvailableSpace2 * signum;
                        } else {
                            f2 = 0.0f;
                        }
                        int roundToInt = MathKt.roundToInt(snapRemainingScrollOffset$foundation_release + f2);
                        pageAvailableSpace = PagerState.this.getPageAvailableSpace();
                        int i2 = roundToInt / pageAvailableSpace;
                        PagerState pagerState = PagerState.this;
                        coerceInPageRange = pagerState.coerceInPageRange(pagerState.getCurrentPage() + i2);
                    }
                } else {
                    coerceInPageRange = PagerState.this.getCurrentPage();
                }
                return Integer.valueOf(coerceInPageRange);
            }
        });
        this.currentPageOffsetFraction$delegate = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.foundation.pager.PagerState$currentPageOffsetFraction$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m1656invoke() {
                LazyListItemInfo closestPageToSnappedPosition;
                int pageAvailableSpace;
                closestPageToSnappedPosition = PagerState.this.getClosestPageToSnappedPosition();
                int offset = closestPageToSnappedPosition != null ? closestPageToSnappedPosition.getOffset() : 0;
                pageAvailableSpace = PagerState.this.getPageAvailableSpace();
                return Float.valueOf(RangesKt.coerceIn((-offset) / pageAvailableSpace, -0.5f, 0.5f));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        return pagerState.animateScrollToPage(i, f, animationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object awaitScrollDependencies(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1 r0 = (androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1 r0 = new androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L63
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.pager.PagerState r2 = (androidx.compose.foundation.pager.PagerState) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.foundation.pager.AwaitLazyListStateSet r6 = r5.awaitLazyListStateSet
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.waitFinalLazyListSetting(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r2 = r5
        L4d:
            androidx.compose.foundation.lazy.LazyListState r6 = r2.getLazyListState()
            if (r6 == 0) goto L66
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r6 = r6.getAwaitLayoutModifier$foundation_release()
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.waitForFirstLayout(r0)
            if (r6 != r1) goto L63
            return r1
        L63:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L66:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.awaitScrollDependencies(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int coerceInPageRange(int i) {
        if (getPageCount$foundation_release() > 0) {
            return RangesKt.coerceIn(i, 0, getPageCount$foundation_release() - 1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int getAnimationTargetPage() {
        return ((Number) this.animationTargetPage$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LazyListItemInfo getClosestPageToSnappedPosition() {
        LazyListItemInfo lazyListItemInfo;
        List<LazyListItemInfo> visiblePages = getVisiblePages();
        if (visiblePages.isEmpty()) {
            lazyListItemInfo = null;
        } else {
            LazyListItemInfo lazyListItemInfo2 = visiblePages.get(0);
            float f = -Math.abs(LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(getDensity(), getLayoutInfo$foundation_release(), lazyListItemInfo2, PagerStateKt.getSnapAlignmentStartToStart()));
            int lastIndex = CollectionsKt.getLastIndex(visiblePages);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    LazyListItemInfo lazyListItemInfo3 = visiblePages.get(i);
                    float f2 = -Math.abs(LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(getDensity(), getLayoutInfo$foundation_release(), lazyListItemInfo3, PagerStateKt.getSnapAlignmentStartToStart()));
                    if (Float.compare(f, f2) < 0) {
                        lazyListItemInfo2 = lazyListItemInfo3;
                        f = f2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            lazyListItemInfo = lazyListItemInfo2;
        }
        return lazyListItemInfo;
    }

    private final Density getDensity() {
        PagerStateKt$UnitDensity$1 pagerStateKt$UnitDensity$1;
        Density density$foundation_release;
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null && (density$foundation_release = lazyListState.getDensity$foundation_release()) != null) {
            return density$foundation_release;
        }
        pagerStateKt$UnitDensity$1 = PagerStateKt.UnitDensity;
        return pagerStateKt$UnitDensity$1;
    }

    private final float getDistanceToSnapPosition() {
        LazyListItemInfo closestPageToSnappedPosition = getClosestPageToSnappedPosition();
        if (closestPageToSnappedPosition != null) {
            return LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(getDensity(), getLayoutInfo$foundation_release(), closestPageToSnappedPosition, PagerStateKt.getSnapAlignmentStartToStart());
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LazyListState getLazyListState() {
        return (LazyListState) this.lazyListState$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPageAvailableSpace() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getPositionThresholdFraction() {
        float f;
        Density density = getDensity();
        f = PagerStateKt.DefaultPositionThreshold;
        return Math.min(density.mo1283toPx0680j_4(f), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int getSettledPageState() {
        return ((Number) this.settledPageState$delegate.getValue()).intValue();
    }

    private final List<LazyListItemInfo> getVisiblePages() {
        return getLayoutInfo$foundation_release().getVisibleItemsInfo();
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.scrollToPage(i, f, continuation);
    }

    private final void setAnimationTargetPage(int i) {
        this.animationTargetPage$delegate.setValue(Integer.valueOf(i));
    }

    private final void setLazyListState(LazyListState lazyListState) {
        this.lazyListState$delegate.setValue(lazyListState);
    }

    private final void setSettledPageState(int i) {
        this.settledPageState$delegate.setValue(Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateScrollToPage(int r18, float r19, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.AnimationSpec<java.lang.Float> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float f) {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.dispatchRawDelta(f);
        }
        return 0.0f;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.getCanScrollBackward();
        }
        return true;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.getCanScrollForward();
        }
        return true;
    }

    public final int getCurrentPage() {
        return ((Number) this.currentPage$delegate.getValue()).intValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return ((Number) this.currentPageOffsetFraction$delegate.getValue()).floatValue();
    }

    public final int getInitialPage() {
        return this.initialPage;
    }

    public final float getInitialPageOffsetFraction() {
        return this.initialPageOffsetFraction;
    }

    @NotNull
    public final InteractionSource getInteractionSource() {
        PagerStateKt$EmptyInteractionSources$1 pagerStateKt$EmptyInteractionSources$1;
        InteractionSource interactionSource;
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null && (interactionSource = lazyListState.getInteractionSource()) != null) {
            return interactionSource;
        }
        pagerStateKt$EmptyInteractionSources$1 = PagerStateKt.EmptyInteractionSources;
        return pagerStateKt$EmptyInteractionSources$1;
    }

    @NotNull
    public final LazyListLayoutInfo getLayoutInfo$foundation_release() {
        PagerStateKt$EmptyLayoutInfo$1 pagerStateKt$EmptyLayoutInfo$1;
        LazyListLayoutInfo layoutInfo;
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null && (layoutInfo = lazyListState.getLayoutInfo()) != null) {
            return layoutInfo;
        }
        pagerStateKt$EmptyLayoutInfo$1 = PagerStateKt.EmptyLayoutInfo;
        return pagerStateKt$EmptyLayoutInfo$1;
    }

    public final int getPageCount$foundation_release() {
        return getLayoutInfo$foundation_release().getTotalItemsCount();
    }

    public final int getPageSize$foundation_release() {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.firstOrNull(getVisiblePages());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getSize();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getPageSpacing$foundation_release() {
        return ((Number) this.pageSpacing$delegate.getValue()).intValue();
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage$delegate.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getSnapRemainingScrollOffset$foundation_release() {
        return ((Number) this.snapRemainingScrollOffset$delegate.getValue()).floatValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage$delegate.getValue()).intValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.isScrollInProgress();
        }
        return false;
    }

    public final void loadNewState$foundation_release(@NotNull LazyListState lazyListState) {
        Intrinsics.checkNotNullParameter(lazyListState, "newState");
        setLazyListState(lazyListState);
        this.awaitLazyListStateSet.onStateLoaded();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    @Nullable
    public Object scroll(@NotNull MutatePriority mutatePriority, @NotNull Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState == null) {
            return Unit.INSTANCE;
        }
        Object scroll = lazyListState.scroll(mutatePriority, function2, continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object scrollToPage(int r11, float r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.pager.PagerState$scrollToPage$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.compose.foundation.pager.PagerState$scrollToPage$1 r0 = (androidx.compose.foundation.pager.PagerState$scrollToPage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.pager.PagerState$scrollToPage$1 r0 = new androidx.compose.foundation.pager.PagerState$scrollToPage$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L86
        L2c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L34:
            float r12 = r0.F$0
            int r11 = r0.I$0
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.pager.PagerState r2 = (androidx.compose.foundation.pager.PagerState) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L53
        L40:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.L$0 = r10
            r0.I$0 = r11
            r0.F$0 = r12
            r0.label = r4
            java.lang.Object r13 = r10.awaitScrollDependencies(r0)
            if (r13 != r1) goto L52
            return r1
        L52:
            r2 = r10
        L53:
            double r5 = (double) r12
            r7 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            r13 = 0
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 > 0) goto L62
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 > 0) goto L62
            goto L63
        L62:
            r4 = 0
        L63:
            if (r4 == 0) goto L95
            int r11 = r2.coerceInPageRange(r11)
            int r13 = r2.getPageAvailableSpace()
            float r13 = (float) r13
            float r13 = r13 * r12
            int r12 = kotlin.math.MathKt.roundToInt(r13)
            androidx.compose.foundation.lazy.LazyListState r13 = r2.getLazyListState()
            if (r13 == 0) goto L89
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r11 = r13.scrollToItem(r11, r12, r0)
            if (r11 != r1) goto L86
            return r1
        L86:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L89:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Required value was null."
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L95:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "pageOffsetFraction "
            r11.append(r13)
            r11.append(r12)
            java.lang.String r12 = " is not within the range -0.5 to 0.5"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scrollToPage(int, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setPageSpacing$foundation_release(int i) {
        this.pageSpacing$delegate.setValue(Integer.valueOf(i));
    }

    public final void setSnapRemainingScrollOffset$foundation_release(float f) {
        this.snapRemainingScrollOffset$delegate.setValue(Float.valueOf(f));
    }

    public final void updateOnScrollStopped$foundation_release() {
        setSettledPageState(getCurrentPage());
    }

    public /* synthetic */ PagerState(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f);
    }
}
