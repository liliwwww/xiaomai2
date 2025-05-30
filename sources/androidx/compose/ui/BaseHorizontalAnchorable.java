package androidx.compose.ui;

import androidx.compose.ui.ConstraintLayoutBaseScope;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.ConstraintReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B)\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00100\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J+\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u00100\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/BaseHorizontalAnchorable;", "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "Landroidx/constraintlayout/compose/State;", "state", "Landroidx/constraintlayout/core/state/ConstraintReference;", "getConstraintReference", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "anchor", "Landroidx/compose/ui/unit/Dp;", "margin", "goneMargin", "", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FF)V", "linkTo", "", "Lkotlin/Function1;", "tasks", "Ljava/util/List;", "", "index", "I", "<init>", "(Ljava/util/List;I)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class BaseHorizontalAnchorable implements HorizontalAnchorable {
    private final int index;

    @NotNull
    private final List<Function1<State, Unit>> tasks;

    public BaseHorizontalAnchorable(@NotNull List<Function1<State, Unit>> list, int i) {
        Intrinsics.checkNotNullParameter(list, "tasks");
        this.tasks = list;
        this.index = i;
    }

    @NotNull
    public abstract ConstraintReference getConstraintReference(@NotNull State state);

    @Override // androidx.compose.ui.HorizontalAnchorable
    /* renamed from: linkTo-VpY3zN4, reason: not valid java name */
    public final void mo2255linkToVpY3zN4(@NotNull final ConstraintLayoutBaseScope.HorizontalAnchor anchor, final float margin, final float goneMargin) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this.tasks.add(new Function1<State, Unit>() { // from class: androidx.constraintlayout.compose.BaseHorizontalAnchorable$linkTo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((State) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull State state) {
                int i;
                Intrinsics.checkNotNullParameter(state, "state");
                ConstraintReference constraintReference = BaseHorizontalAnchorable.this.getConstraintReference(state);
                BaseHorizontalAnchorable baseHorizontalAnchorable = BaseHorizontalAnchorable.this;
                ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor = anchor;
                float f = margin;
                float f2 = goneMargin;
                Function2<ConstraintReference, Object, ConstraintReference>[][] horizontalAnchorFunctions = AnchorFunctions.INSTANCE.getHorizontalAnchorFunctions();
                i = baseHorizontalAnchorable.index;
                ((ConstraintReference) horizontalAnchorFunctions[i][horizontalAnchor.getIndex$compose_release()].invoke(constraintReference, horizontalAnchor.getId$compose_release())).margin(Dp.m2140boximpl(f)).marginGone(Dp.m2140boximpl(f2));
            }
        });
    }
}
