package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.compose.DerivedConstraintSet;
import androidx.constraintlayout.core.state.Transition;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B,\u0012\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0002\b\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R*\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0002\b\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/constraintlayout/compose/DslConstraintSet;", "Landroidx/constraintlayout/compose/DerivedConstraintSet;", "Landroidx/constraintlayout/compose/State;", "state", "", "applyToState", "", "name", "", "value", "Landroidx/constraintlayout/compose/ConstraintSet;", "override", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "Lkotlin/ExtensionFunctionType;", "description", "Lkotlin/jvm/functions/Function1;", "getDescription", "()Lkotlin/jvm/functions/Function1;", "extendFrom", "Landroidx/constraintlayout/compose/ConstraintSet;", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/constraintlayout/compose/ConstraintSet;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DslConstraintSet implements DerivedConstraintSet {

    @NotNull
    private final Function1<ConstraintSetScope, Unit> description;

    @Nullable
    private final ConstraintSet extendFrom;

    public DslConstraintSet(@NotNull Function1<? super ConstraintSetScope, Unit> function1, @Nullable ConstraintSet constraintSet) {
        Intrinsics.checkNotNullParameter(function1, "description");
        this.description = function1;
        this.extendFrom = constraintSet;
    }

    public void applyTo(@NotNull State state, @NotNull List<? extends Measurable> list) {
        DerivedConstraintSet.DefaultImpls.applyTo(this, state, list);
    }

    public void applyToState(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        ConstraintSetScope constraintSetScope = new ConstraintSetScope();
        this.description.invoke(constraintSetScope);
        constraintSetScope.applyTo(state);
    }

    @NotNull
    public final Function1<ConstraintSetScope, Unit> getDescription() {
        return this.description;
    }

    @Nullable
    public ConstraintSet getExtendFrom() {
        return this.extendFrom;
    }

    public boolean isDirty(@NotNull List<? extends Measurable> list) {
        return DerivedConstraintSet.DefaultImpls.isDirty(this, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public ConstraintSet override(@NotNull String name, float value) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this;
    }

    public void applyTo(@NotNull Transition transition, int i) {
        DerivedConstraintSet.DefaultImpls.applyTo(this, transition, i);
    }

    public /* synthetic */ DslConstraintSet(Function1 function1, ConstraintSet constraintSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : constraintSet);
    }
}
