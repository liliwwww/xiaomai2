package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BackdropScaffoldKt$rememberBackdropScaffoldState$3 extends Lambda implements Function0<BackdropScaffoldState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<BackdropValue, Boolean> $confirmStateChange;
    final /* synthetic */ BackdropValue $initialValue;
    final /* synthetic */ SnackbarHostState $snackbarHostState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BackdropScaffoldKt$rememberBackdropScaffoldState$3(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        super(0);
        this.$initialValue = backdropValue;
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = function1;
        this.$snackbarHostState = snackbarHostState;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final BackdropScaffoldState m504invoke() {
        return new BackdropScaffoldState(this.$initialValue, this.$animationSpec, this.$confirmStateChange, this.$snackbarHostState);
    }
}
