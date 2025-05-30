package androidx.constraintlayout.compose;

import androidx.compose.p004ui.unit.C0856Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.core.state.ConstraintReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u00110\u0010¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintBaselineAnchorable;", "Landroidx/constraintlayout/compose/BaselineAnchorable;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "anchor", "Landroidx/compose/ui/unit/Dp;", "margin", "goneMargin", "", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;FF)V", "linkTo", "", "id", "Ljava/lang/Object;", "getId", "()Ljava/lang/Object;", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "tasks", "Ljava/util/List;", "getTasks", "()Ljava/util/List;", "<init>", "(Ljava/lang/Object;Ljava/util/List;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class ConstraintBaselineAnchorable implements BaselineAnchorable {

    @NotNull
    private final Object id;

    @NotNull
    private final List<Function1<State, Unit>> tasks;

    public ConstraintBaselineAnchorable(@NotNull Object obj, @NotNull List<Function1<State, Unit>> list) {
        Intrinsics.checkNotNullParameter(obj, "id");
        Intrinsics.checkNotNullParameter(list, "tasks");
        this.id = obj;
        this.tasks = list;
    }

    @NotNull
    public final Object getId() {
        return this.id;
    }

    @NotNull
    public final List<Function1<State, Unit>> getTasks() {
        return this.tasks;
    }

    @Override // androidx.constraintlayout.compose.BaselineAnchorable
    /* renamed from: linkTo-VpY3zN4 */
    public void mo5475linkToVpY3zN4(@NotNull final ConstraintLayoutBaseScope.BaselineAnchor anchor, final float margin, final float goneMargin) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintBaselineAnchorable$linkTo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (state != null) {
                    ConstraintBaselineAnchorable constraintBaselineAnchorable = ConstraintBaselineAnchorable.this;
                    ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor = anchor;
                    state.baselineNeededFor$compose_release(constraintBaselineAnchorable.getId());
                    state.baselineNeededFor$compose_release(baselineAnchor.getId$compose_release());
                }
                ConstraintReference constraints = state.constraints(ConstraintBaselineAnchorable.this.getId());
                ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor2 = anchor;
                float f = margin;
                float f2 = goneMargin;
                Function2<ConstraintReference, Object, ConstraintReference> baselineAnchorFunction = AnchorFunctions.INSTANCE.getBaselineAnchorFunction();
                Intrinsics.checkNotNullExpressionValue(constraints, "this");
                ((ConstraintReference) baselineAnchorFunction.invoke(constraints, baselineAnchor2.getId$compose_release())).margin(C0856Dp.m5214boximpl(f)).marginGone(C0856Dp.m5214boximpl(f2));
            }
        });
    }
}
