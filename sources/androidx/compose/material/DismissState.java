package androidx.compose.material;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DismissState extends SwipeableState<DismissValue> {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ DismissState(DismissValue dismissValue, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dismissValue, (i & 2) != 0 ? new Function1<DismissValue, Boolean>() { // from class: androidx.compose.material.DismissState.1
            @NotNull
            public final Boolean invoke(@NotNull DismissValue dismissValue2) {
                Intrinsics.checkNotNullParameter(dismissValue2, "it");
                return Boolean.TRUE;
            }
        } : function1);
    }

    @Nullable
    public final Object dismiss(@NotNull DismissDirection dismissDirection, @NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart, null, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @Nullable
    public final DismissDirection getDismissDirection() {
        if (((Number) getOffset().getValue()).floatValue() == 0.0f) {
            return null;
        }
        return ((Number) getOffset().getValue()).floatValue() > 0.0f ? DismissDirection.StartToEnd : DismissDirection.EndToStart;
    }

    public final boolean isDismissed(@NotNull DismissDirection dismissDirection) {
        Intrinsics.checkNotNullParameter(dismissDirection, "direction");
        return getCurrentValue() == (dismissDirection == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart);
    }

    @Nullable
    public final Object reset(@NotNull Continuation<? super Unit> continuation) {
        Object animateTo$default = SwipeableState.animateTo$default(this, DismissValue.Default, null, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DismissState(@NotNull DismissValue dismissValue, @NotNull Function1<? super DismissValue, Boolean> function1) {
        super(dismissValue, null, function1, 2, null);
        Intrinsics.checkNotNullParameter(dismissValue, "initialValue");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
    }
}
