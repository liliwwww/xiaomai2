package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.AndroidOverscrollKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ScrollableDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final ScrollableDefaults INSTANCE = new ScrollableDefaults();

    private ScrollableDefaults() {
    }

    @Composable
    @NotNull
    public final FlingBehavior flingBehavior(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1107739818);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1107739818, i, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:186)");
        }
        DecayAnimationSpec rememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(rememberSplineBasedDecay);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new DefaultFlingBehavior(rememberSplineBasedDecay, (MotionDurationScale) null, 2, (DefaultConstructorMarker) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultFlingBehavior;
    }

    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public final OverscrollEffect overscrollEffect(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(1809802212);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1809802212, i, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.overscrollEffect (Scrollable.kt:199)");
        }
        OverscrollEffect rememberOverscrollEffect = AndroidOverscrollKt.rememberOverscrollEffect(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberOverscrollEffect;
    }

    public final boolean reverseDirection(@NotNull LayoutDirection layoutDirection, @NotNull Orientation orientation, boolean z) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        boolean z2 = !z;
        return (!(layoutDirection == LayoutDirection.Rtl) || orientation == Orientation.Vertical) ? z2 : !z2;
    }
}
