package androidx.compose.ui;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LayoutScopeMarker
@StabilityInferred(parameters = 0)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J'\u0010\f\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¨\u0006\u000f"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSetScope;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "", "id", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "createRefFor", "ref", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstrainScope;", "", "Lkotlin/ExtensionFunctionType;", "constrainBlock", "constrain", "<init>", "()V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ConstraintSetScope extends ConstraintLayoutBaseScope {
    public static final int $stable = 0;

    @NotNull
    public final ConstrainScope constrain(@NotNull ConstrainedLayoutReference ref, @NotNull Function1<? super ConstrainScope, Unit> constrainBlock) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        Intrinsics.checkNotNullParameter(constrainBlock, "constrainBlock");
        ConstrainScope constrainScope = new ConstrainScope(ref.getId());
        constrainBlock.invoke(constrainScope);
        getTasks().addAll(constrainScope.getTasks$compose_release());
        return constrainScope;
    }

    @NotNull
    public final ConstrainedLayoutReference createRefFor(@NotNull Object id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ConstrainedLayoutReference(id);
    }
}
