package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/constraintlayout/compose/State;", "state", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$createGuidelineFromStart$1, reason: from Kotlin metadata and case insensitive filesystem */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class C0022ConstraintLayoutBaseScope$createGuidelineFromStart$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ int $id;
    final /* synthetic */ float $offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0022ConstraintLayoutBaseScope$createGuidelineFromStart$1(int i, float f) {
        super(1);
        this.$id = i;
        this.$offset = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        GuidelineReference verticalGuideline = state.verticalGuideline(Integer.valueOf(this.$id));
        float f = this.$offset;
        if (state.getLayoutDirection() == LayoutDirection.Ltr) {
            verticalGuideline.start(Dp.box-impl(f));
        } else {
            verticalGuideline.end(Dp.box-impl(f));
        }
    }
}
