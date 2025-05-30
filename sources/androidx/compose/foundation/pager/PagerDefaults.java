package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PagerDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final PagerDefaults INSTANCE = new PagerDefaults();

    private PagerDefaults() {
    }

    @Composable
    @NotNull
    public final SnapFlingBehavior flingBehavior(@NotNull PagerState pagerState, @Nullable PagerSnapDistance pagerSnapDistance, @Nullable AnimationSpec<Float> animationSpec, @Nullable DecayAnimationSpec<Float> decayAnimationSpec, @Nullable AnimationSpec<Float> animationSpec2, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(pagerState, "state");
        composer.startReplaceableGroup(-344874176);
        PagerSnapDistance atMost = (i2 & 2) != 0 ? PagerSnapDistance.Companion.atMost(1) : pagerSnapDistance;
        AnimationSpec<Float> tween$default = (i2 & 4) != 0 ? AnimationSpecKt.tween$default(0, 0, EasingKt.getLinearOutSlowInEasing(), 3, (Object) null) : animationSpec;
        DecayAnimationSpec<Float> rememberSplineBasedDecay = (i2 & 8) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        AnimationSpec<Float> spring$default = (i2 & 16) != 0 ? AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null) : animationSpec2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-344874176, i, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:457)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = {tween$default, rememberSplineBasedDecay, spring$default, atMost, density};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 5; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SnapFlingBehavior(PagerKt.access$SnapLayoutInfoProvider(pagerState, atMost, rememberSplineBasedDecay), tween$default, rememberSplineBasedDecay, spring$default, density, 0.0f, 32, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    @NotNull
    public final NestedScrollConnection pageNestedScrollConnection(@NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == Orientation.Horizontal ? PagerKt.access$getConsumeHorizontalFlingNestedScrollConnection$p() : PagerKt.access$getConsumeVerticalFlingNestedScrollConnection$p();
    }
}
