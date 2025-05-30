package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/constraintlayout/compose/State;", "state", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ConstrainScope$height$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ Dimension $value;
    final /* synthetic */ ConstrainScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConstrainScope$height$1(ConstrainScope constrainScope, Dimension dimension) {
        super(1);
        this.this$0 = constrainScope;
        this.$value = dimension;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        state.constraints(this.this$0.getId$compose_release()).height(this.$value.toSolverDimension$compose_release(state));
    }
}
