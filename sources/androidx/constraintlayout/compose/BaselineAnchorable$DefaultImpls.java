package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BaselineAnchorable$DefaultImpls {
    /* renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ void m2733linkToVpY3zN4$default(BaselineAnchorable baselineAnchorable, ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
        if ((i & 2) != 0) {
            f = Dp.constructor-impl(0);
        }
        if ((i & 4) != 0) {
            f2 = Dp.constructor-impl(0);
        }
        baselineAnchorable.linkTo-VpY3zN4(baselineAnchor, f, f2);
    }
}
