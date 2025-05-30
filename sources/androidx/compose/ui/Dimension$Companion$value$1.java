package androidx.compose.ui;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.Dimension;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/constraintlayout/compose/State;", "state", "Landroidx/constraintlayout/core/state/Dimension;", "Landroidx/constraintlayout/compose/SolverDimension;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class Dimension$Companion$value$1 extends Lambda implements Function1<State, Dimension> {
    final /* synthetic */ float $dp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Dimension$Companion$value$1(float f) {
        super(1);
        this.$dp = f;
    }

    @NotNull
    public final Dimension invoke(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Dimension Fixed = Dimension.Fixed(state.convertDimension(Dp.m2140boximpl(this.$dp)));
        Intrinsics.checkNotNullExpressionValue(Fixed, "Fixed(state.convertDimension(dp))");
        return Fixed;
    }
}
