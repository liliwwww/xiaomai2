package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [S] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TransitionKt$animateRect$1<S> extends Lambda implements Function3<Transition$Segment<S>, Composer, Integer, SpringSpec<Rect>> {
    public static final TransitionKt$animateRect$1 INSTANCE = new TransitionKt$animateRect$1();

    public TransitionKt$animateRect$1() {
        super(3);
    }

    @Composable
    @NotNull
    public final SpringSpec<Rect> invoke(@NotNull Transition$Segment<S> transition$Segment, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(transition$Segment, "$this$null");
        composer.startReplaceableGroup(691336298);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(691336298, i, -1, "androidx.compose.animation.core.animateRect.<anonymous> (Transition.kt:1149)");
        }
        SpringSpec<Rect> spring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 3, (Object) null);
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
