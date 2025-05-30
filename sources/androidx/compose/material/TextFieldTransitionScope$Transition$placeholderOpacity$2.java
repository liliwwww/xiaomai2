package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition$Segment;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextFieldTransitionScope$Transition$placeholderOpacity$2 extends Lambda implements Function3<Transition$Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TextFieldTransitionScope$Transition$placeholderOpacity$2 INSTANCE = new TextFieldTransitionScope$Transition$placeholderOpacity$2();

    TextFieldTransitionScope$Transition$placeholderOpacity$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition$Segment<InputPhase>) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final FiniteAnimationSpec<Float> invoke(@NotNull Transition$Segment<InputPhase> transition$Segment, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(transition$Segment, "$this$animateFloat");
        composer.startReplaceableGroup(-1079955085);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1079955085, i, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:291)");
        }
        InputPhase inputPhase = InputPhase.Focused;
        InputPhase inputPhase2 = InputPhase.UnfocusedEmpty;
        TweenSpec tween$default = transition$Segment.isTransitioningTo(inputPhase, inputPhase2) ? AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, (Object) null) : (transition$Segment.isTransitioningTo(inputPhase2, inputPhase) || transition$Segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase2)) ? AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing()) : AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tween$default;
    }
}
