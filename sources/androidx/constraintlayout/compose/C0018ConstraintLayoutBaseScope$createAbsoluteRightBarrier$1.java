package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.State$Direction;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/constraintlayout/compose/State;", "state", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createAbsoluteRightBarrier$1, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class C0018ConstraintLayoutBaseScope$createAbsoluteRightBarrier$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ ConstrainedLayoutReference[] $elements;
    final /* synthetic */ int $id;
    final /* synthetic */ float $margin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0018ConstraintLayoutBaseScope$createAbsoluteRightBarrier$1(int i, float f, ConstrainedLayoutReference[] constrainedLayoutReferenceArr) {
        super(1);
        this.$id = i;
        this.$margin = f;
        this.$elements = constrainedLayoutReferenceArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        BarrierReference barrier = state.barrier(Integer.valueOf(this.$id), State$Direction.RIGHT);
        ConstrainedLayoutReference[] constrainedLayoutReferenceArr = this.$elements;
        ArrayList arrayList = new ArrayList(constrainedLayoutReferenceArr.length);
        for (ConstrainedLayoutReference constrainedLayoutReference : constrainedLayoutReferenceArr) {
            arrayList.add(constrainedLayoutReference.getId());
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        barrier.add(Arrays.copyOf(array, array.length));
        barrier.margin(state.convertDimension(Dp.box-impl(this.$margin)));
    }
}
