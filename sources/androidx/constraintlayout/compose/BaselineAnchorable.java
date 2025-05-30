package androidx.constraintlayout.compose;

import androidx.compose.p004ui.unit.C0856Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J1\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/constraintlayout/compose/BaselineAnchorable;", "", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "anchor", "Landroidx/compose/ui/unit/Dp;", "margin", "goneMargin", "", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;FF)V", "linkTo", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface BaselineAnchorable {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        /* renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
        public static /* synthetic */ void m5476linkToVpY3zN4$default(BaselineAnchorable baselineAnchorable, ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
            }
            if ((i & 2) != 0) {
                f = C0856Dp.m5216constructorimpl(0);
            }
            if ((i & 4) != 0) {
                f2 = C0856Dp.m5216constructorimpl(0);
            }
            baselineAnchorable.mo5475linkToVpY3zN4(baselineAnchor, f, f2);
        }
    }

    /* renamed from: linkTo-VpY3zN4, reason: not valid java name */
    void mo5475linkToVpY3zN4(@NotNull ConstraintLayoutBaseScope.BaselineAnchor anchor, float margin, float goneMargin);
}
