package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AnimatedVisibilityScope$DefaultImpls {
    @ExperimentalAnimationApi
    @Deprecated
    @NotNull
    public static Modifier animateEnterExit(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull Modifier modifier, @NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition, @NotNull String str) {
        Modifier a;
        Intrinsics.checkNotNullParameter(modifier, "$receiver");
        Intrinsics.checkNotNullParameter(enterTransition, "enter");
        Intrinsics.checkNotNullParameter(exitTransition, "exit");
        Intrinsics.checkNotNullParameter(str, "label");
        a = AnimatedVisibilityScope$CC.a(animatedVisibilityScope, modifier, enterTransition, exitTransition, str);
        return a;
    }

    @ExperimentalAnimationApi
    public static /* synthetic */ void getTransition$annotations() {
    }
}
