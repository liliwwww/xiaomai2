package androidx.compose.animation;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* renamed from: androidx.compose.animation.AnimatedVisibilityScope$-CC, reason: invalid class name */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class AnimatedVisibilityScope$CC {
    @ExperimentalAnimationApi
    @NotNull
    public static Modifier a(@NotNull AnimatedVisibilityScope _this, @NotNull Modifier modifier, @NotNull final EnterTransition enterTransition, @NotNull final ExitTransition exitTransition, final String str) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(enterTransition, "enter");
        Intrinsics.checkNotNullParameter(exitTransition, "exit");
        Intrinsics.checkNotNullParameter(str, "label");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityScope$animateEnterExit$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("animateEnterExit");
                inspectorInfo.getProperties().set("enter", EnterTransition.this);
                inspectorInfo.getProperties().set("exit", exitTransition);
                inspectorInfo.getProperties().set("label", str);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new AnimatedVisibilityScope.animateEnterExit.2(_this, enterTransition, exitTransition, str));
    }

    public static /* synthetic */ Modifier c(AnimatedVisibilityScope animatedVisibilityScope, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateEnterExit");
        }
        if ((i & 1) != 0) {
            enterTransition = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
        }
        if ((i & 2) != 0) {
            exitTransition = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
        }
        if ((i & 4) != 0) {
            str = "animateEnterExit";
        }
        return animatedVisibilityScope.animateEnterExit(modifier, enterTransition, exitTransition, str);
    }
}
