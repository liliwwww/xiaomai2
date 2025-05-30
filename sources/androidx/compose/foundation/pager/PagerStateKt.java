package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;
import tb.ld2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PagerStateKt {
    private static final float MaxPageOffset = 0.5f;
    private static final int MaxPagesForAnimateScroll = 3;
    private static final float MinPageOffset = -0.5f;

    @NotNull
    private static final Function3<Density, Float, Float, Float> SnapAlignmentStartToStart = new Function3<Density, Float, Float, Float>() { // from class: androidx.compose.foundation.pager.PagerStateKt$SnapAlignmentStartToStart$1
        @NotNull
        public final Float invoke(@NotNull Density density, float f, float f2) {
            Intrinsics.checkNotNullParameter(density, "$this$null");
            return Float.valueOf(0.0f);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Density) obj, ((Number) obj2).floatValue(), ((Number) obj3).floatValue());
        }
    };
    private static final float DefaultPositionThreshold = C0856Dp.m5216constructorimpl(56);

    @NotNull
    private static final PagerStateKt$EmptyLayoutInfo$1 EmptyLayoutInfo = new LazyListLayoutInfo() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1
        private final int totalItemsCount;
        private final int viewportEndOffset;
        private final int viewportStartOffset;

        @NotNull
        private final List<LazyListItemInfo> visibleItemsInfo = CollectionsKt.emptyList();

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        public /* synthetic */ int getAfterContentPadding() {
            return ld2.a(this);
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        public /* synthetic */ int getBeforeContentPadding() {
            return ld2.b(this);
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        public /* synthetic */ Orientation getOrientation() {
            return ld2.c(this);
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        public /* synthetic */ boolean getReverseLayout() {
            return ld2.d(this);
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        public int getTotalItemsCount() {
            return this.totalItemsCount;
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        public int getViewportEndOffset() {
            return this.viewportEndOffset;
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        /* renamed from: getViewportSize-YbymL2g */
        public /* synthetic */ long mo1494getViewportSizeYbymL2g() {
            return ld2.e(this);
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        public int getViewportStartOffset() {
            return this.viewportStartOffset;
        }

        @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
        @NotNull
        public List<LazyListItemInfo> getVisibleItemsInfo() {
            return this.visibleItemsInfo;
        }
    };

    @NotNull
    private static final PagerStateKt$UnitDensity$1 UnitDensity = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.p004ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.p004ui.unit.Density
        public float getFontScale() {
            return this.fontScale;
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public /* synthetic */ int mo1276roundToPxR2X_6o(long j) {
            return jw0.a(this, j);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public /* synthetic */ int mo1277roundToPx0680j_4(float f) {
            return jw0.b(this, f);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toDp-GaN1DYA */
        public /* synthetic */ float mo1278toDpGaN1DYA(long j) {
            return jw0.c(this, j);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo1279toDpu2uoSUM(float f) {
            return jw0.d(this, f);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo1280toDpu2uoSUM(int i) {
            return jw0.e(this, i);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public /* synthetic */ long mo1281toDpSizekrfVVM(long j) {
            return jw0.f(this, j);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public /* synthetic */ float mo1282toPxR2X_6o(long j) {
            return jw0.g(this, j);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public /* synthetic */ float mo1283toPx0680j_4(float f) {
            return jw0.h(this, f);
        }

        @Override // androidx.compose.p004ui.unit.Density
        public /* synthetic */ Rect toRect(DpRect dpRect) {
            return jw0.i(this, dpRect);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public /* synthetic */ long mo1284toSizeXkaWNTQ(long j) {
            return jw0.j(this, j);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toSp-0xMU5do */
        public /* synthetic */ long mo1285toSp0xMU5do(float f) {
            return jw0.k(this, f);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo1286toSpkPz2Gy4(float f) {
            return jw0.l(this, f);
        }

        @Override // androidx.compose.p004ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo1287toSpkPz2Gy4(int i) {
            return jw0.m(this, i);
        }
    };

    @NotNull
    private static final PagerStateKt$EmptyInteractionSources$1 EmptyInteractionSources = new InteractionSource() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyInteractionSources$1
        @Override // androidx.compose.foundation.interaction.InteractionSource
        @NotNull
        public Flow<Interaction> getInteractions() {
            return d.q();
        }
    };

    @Nullable
    public static final Object animateToNextPage(@NotNull PagerState pagerState, @NotNull Continuation<? super Unit> continuation) {
        if (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount$foundation_release()) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, null, continuation, 6, null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    @Nullable
    public static final Object animateToPreviousPage(@NotNull PagerState pagerState, @NotNull Continuation<? super Unit> continuation) {
        if (pagerState.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() - 1, 0.0f, null, continuation, 6, null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    @NotNull
    public static final Function3<Density, Float, Float, Float> getSnapAlignmentStartToStart() {
        return SnapAlignmentStartToStart;
    }

    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public static final PagerState rememberPagerState(final int i, final float f, @Nullable Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(144687223);
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            f = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(144687223, i2, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:66)");
        }
        Object[] objArr = new Object[0];
        Saver<PagerState, ?> saver = PagerState.Companion.getSaver();
        Integer valueOf = Integer.valueOf(i);
        Float valueOf2 = Float.valueOf(f);
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(valueOf) | composer.changed(valueOf2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0<PagerState>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final PagerState m1659invoke() {
                    return new PagerState(i, f);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PagerState pagerState = (PagerState) RememberSaveableKt.m2434rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pagerState;
    }
}
