package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
    private static final float DefaultPositionThreshold = Dp.m2142constructorimpl(56);

    @NotNull
    private static final EmptyLayoutInfo.1 EmptyLayoutInfo = new EmptyLayoutInfo.1();

    @NotNull
    private static final UnitDensity.1 UnitDensity = new UnitDensity.1();

    @NotNull
    private static final PagerStateKt$EmptyInteractionSources$1 EmptyInteractionSources = new InteractionSource() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyInteractionSources$1
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
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, (AnimationSpec) null, continuation, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    @Nullable
    public static final Object animateToPreviousPage(@NotNull PagerState pagerState, @NotNull Continuation<? super Unit> continuation) {
        if (pagerState.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() - 1, 0.0f, (AnimationSpec) null, continuation, 6, (Object) null);
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
        Saver saver = PagerState.Companion.getSaver();
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
                public final PagerState m348invoke() {
                    return new PagerState(i, f);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PagerState pagerState = (PagerState) RememberSaveableKt.m795rememberSaveable(objArr, saver, (String) null, (Function0) rememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pagerState;
    }
}
