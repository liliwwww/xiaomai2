package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BackdropScaffoldState$Companion$Saver$2 extends Lambda implements Function1<BackdropValue, BackdropScaffoldState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<BackdropValue, Boolean> $confirmStateChange;
    final /* synthetic */ SnackbarHostState $snackbarHostState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BackdropScaffoldState$Companion$Saver$2(AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = function1;
        this.$snackbarHostState = snackbarHostState;
    }

    @Nullable
    public final BackdropScaffoldState invoke(@NotNull BackdropValue backdropValue) {
        Intrinsics.checkNotNullParameter(backdropValue, "it");
        return new BackdropScaffoldState(backdropValue, this.$animationSpec, this.$confirmStateChange, this.$snackbarHostState);
    }
}
