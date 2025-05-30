package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BackdropScaffoldState extends SwipeableState<BackdropValue> {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private final NestedScrollConnection nestedScrollConnection;

    @NotNull
    private final SnackbarHostState snackbarHostState;

    public /* synthetic */ BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backdropValue, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? 1.INSTANCE : function1, (i & 8) != 0 ? new SnackbarHostState() : snackbarHostState);
    }

    @Nullable
    public final Object conceal(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Concealed, null, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @NotNull
    public final NestedScrollConnection getNestedScrollConnection$material_release() {
        return this.nestedScrollConnection;
    }

    @NotNull
    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    public final boolean isConcealed() {
        return getCurrentValue() == BackdropValue.Concealed;
    }

    public final boolean isRevealed() {
        return getCurrentValue() == BackdropValue.Revealed;
    }

    @Nullable
    public final Object reveal(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, BackdropValue.Revealed, null, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldState(@NotNull BackdropValue backdropValue, @NotNull AnimationSpec<Float> animationSpec, @NotNull Function1<? super BackdropValue, Boolean> function1, @NotNull SnackbarHostState snackbarHostState) {
        super(backdropValue, animationSpec, function1);
        Intrinsics.checkNotNullParameter(backdropValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        this.snackbarHostState = snackbarHostState;
        this.nestedScrollConnection = SwipeableKt.getPreUpPostDownNestedScrollConnection(this);
    }
}
