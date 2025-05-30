package androidx.constraintlayout.compose;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.layout.LayoutIdParentData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR*\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutParentData;", "Landroidx/compose/ui/layout/LayoutIdParentData;", "", "other", "", "equals", "", "hashCode", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "ref", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getRef", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "", "Lkotlin/ExtensionFunctionType;", "constrain", "Lkotlin/jvm/functions/Function1;", "getConstrain", "()Lkotlin/jvm/functions/Function1;", "layoutId", "Ljava/lang/Object;", "getLayoutId", "()Ljava/lang/Object;", "<init>", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;Lkotlin/jvm/functions/Function1;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ConstraintLayoutParentData implements LayoutIdParentData {

    @NotNull
    private final Function1<ConstrainScope, Unit> constrain;

    @NotNull
    private final Object layoutId;

    @NotNull
    private final ConstrainedLayoutReference ref;

    /* JADX WARN: Multi-variable type inference failed */
    public ConstraintLayoutParentData(@NotNull ConstrainedLayoutReference constrainedLayoutReference, @NotNull Function1<? super ConstrainScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "ref");
        Intrinsics.checkNotNullParameter(function1, "constrain");
        this.ref = constrainedLayoutReference;
        this.constrain = function1;
        this.layoutId = constrainedLayoutReference.getId();
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof ConstraintLayoutParentData) {
            ConstraintLayoutParentData constraintLayoutParentData = (ConstraintLayoutParentData) other;
            if (Intrinsics.areEqual(this.ref.getId(), constraintLayoutParentData.ref.getId()) && Intrinsics.areEqual(this.constrain, constraintLayoutParentData.constrain)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Function1<ConstrainScope, Unit> getConstrain() {
        return this.constrain;
    }

    @NotNull
    public Object getLayoutId() {
        return this.layoutId;
    }

    @NotNull
    public final ConstrainedLayoutReference getRef() {
        return this.ref;
    }

    public int hashCode() {
        return (this.ref.getId().hashCode() * 31) + this.constrain.hashCode();
    }
}
