package androidx.compose.ui;

import androidx.constraintlayout.core.state.ConstraintReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"Landroidx/constraintlayout/core/state/ConstraintReference;", "", "floatValue", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ConstrainScope$translationX$1 extends Lambda implements Function2<ConstraintReference, Float, Unit> {
    public static final ConstrainScope$translationX$1 INSTANCE = new ConstrainScope$translationX$1();

    ConstrainScope$translationX$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ConstraintReference) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ConstraintReference constraintReference, float f) {
        Intrinsics.checkNotNullParameter(constraintReference, "$this$addFloatTransformFromDp");
        constraintReference.translationX(f);
    }
}
