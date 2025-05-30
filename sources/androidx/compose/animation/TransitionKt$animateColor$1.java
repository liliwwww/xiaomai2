package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition$Segment;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [S] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TransitionKt$animateColor$1<S> extends Lambda implements Function3<Transition$Segment<S>, Composer, Integer, SpringSpec<Color>> {
    public static final TransitionKt$animateColor$1 INSTANCE = new TransitionKt$animateColor$1();

    public TransitionKt$animateColor$1() {
        super(3);
    }

    @Composable
    @NotNull
    public final SpringSpec<Color> invoke(@NotNull Transition$Segment<S> transition$Segment, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(transition$Segment, "$this$null");
        composer.startReplaceableGroup(-1457805428);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1457805428, i, -1, "androidx.compose.animation.animateColor.<anonymous> (Transition.kt:64)");
        }
        SpringSpec<Color> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return spring$default;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition$Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
