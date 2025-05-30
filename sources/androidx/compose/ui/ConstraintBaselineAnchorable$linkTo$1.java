package androidx.compose.ui;

import androidx.compose.ui.ConstraintLayoutBaseScope;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.ConstraintReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/constraintlayout/compose/State;", "state", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ConstraintBaselineAnchorable$linkTo$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ ConstraintLayoutBaseScope.BaselineAnchor $anchor;
    final /* synthetic */ float $goneMargin;
    final /* synthetic */ float $margin;
    final /* synthetic */ ConstraintBaselineAnchorable this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConstraintBaselineAnchorable$linkTo$1(ConstraintBaselineAnchorable constraintBaselineAnchorable, ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2) {
        super(1);
        this.this$0 = constraintBaselineAnchorable;
        this.$anchor = baselineAnchor;
        this.$margin = f;
        this.$goneMargin = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state != null) {
            ConstraintBaselineAnchorable constraintBaselineAnchorable = this.this$0;
            ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor = this.$anchor;
            state.baselineNeededFor$compose_release(constraintBaselineAnchorable.getId());
            state.baselineNeededFor$compose_release(baselineAnchor.getId$compose_release());
        }
        ConstraintReference constraints = state.constraints(this.this$0.getId());
        ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor2 = this.$anchor;
        float f = this.$margin;
        float f2 = this.$goneMargin;
        Function2<ConstraintReference, Object, ConstraintReference> baselineAnchorFunction = AnchorFunctions.INSTANCE.getBaselineAnchorFunction();
        Intrinsics.checkNotNullExpressionValue(constraints, "this");
        ((ConstraintReference) baselineAnchorFunction.invoke(constraints, baselineAnchor2.getId$compose_release())).margin(Dp.m2140boximpl(f)).marginGone(Dp.m2140boximpl(f2));
    }
}
