package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition$Segment;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextFieldTransitionScope$Transition$labelContentColor$2 extends Lambda implements Function3<Transition$Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>> {
    public static final TextFieldTransitionScope$Transition$labelContentColor$2 INSTANCE = new TextFieldTransitionScope$Transition$labelContentColor$2();

    TextFieldTransitionScope$Transition$labelContentColor$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition$Segment<InputPhase>) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final FiniteAnimationSpec<Color> invoke(@NotNull Transition$Segment<InputPhase> transition$Segment, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(transition$Segment, "$this$animateColor");
        composer.startReplaceableGroup(-32667848);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-32667848, i, -1, "androidx.compose.material.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:328)");
        }
        TweenSpec tween$default = AnimationSpecKt.tween$default(TextFieldImplKt.AnimationDuration, 0, (Easing) null, 6, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tween$default;
    }
}
