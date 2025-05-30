package androidx.compose.ui;

import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.core.state.Transition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/DerivedConstraintSet;", "Landroidx/constraintlayout/compose/ConstraintSet;", "Landroidx/constraintlayout/compose/State;", "state", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "", "applyTo", "applyToState", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "extendFrom", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface DerivedConstraintSet extends ConstraintSet {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        public static void applyTo(@NotNull DerivedConstraintSet derivedConstraintSet, @NotNull Transition transition, int i) {
            Intrinsics.checkNotNullParameter(derivedConstraintSet, "this");
            Intrinsics.checkNotNullParameter(transition, "transition");
            ConstraintSet$DefaultImpls.applyTo(derivedConstraintSet, transition, i);
        }

        public static boolean isDirty(@NotNull DerivedConstraintSet derivedConstraintSet, @NotNull List<? extends Measurable> list) {
            Intrinsics.checkNotNullParameter(derivedConstraintSet, "this");
            Intrinsics.checkNotNullParameter(list, "measurables");
            return ConstraintSet$DefaultImpls.isDirty(derivedConstraintSet, list);
        }

        @NotNull
        public static ConstraintSet override(@NotNull DerivedConstraintSet derivedConstraintSet, @NotNull String str, float f) {
            Intrinsics.checkNotNullParameter(derivedConstraintSet, "this");
            Intrinsics.checkNotNullParameter(str, "name");
            return ConstraintSet$DefaultImpls.override(derivedConstraintSet, str, f);
        }

        public static void applyTo(@NotNull DerivedConstraintSet derivedConstraintSet, @NotNull State state, @NotNull List<? extends Measurable> list) {
            Intrinsics.checkNotNullParameter(derivedConstraintSet, "this");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(list, "measurables");
            Modifier.buildMapping(state, list);
            ConstraintSet extendFrom = derivedConstraintSet.getExtendFrom();
            DerivedConstraintSet derivedConstraintSet2 = extendFrom instanceof DerivedConstraintSet ? (DerivedConstraintSet) extendFrom : null;
            if (derivedConstraintSet2 != null) {
                derivedConstraintSet2.applyTo(state, list);
            }
            derivedConstraintSet.applyToState(state);
        }
    }

    void applyTo(@NotNull State state, @NotNull List<? extends Measurable> measurables);

    void applyToState(@NotNull State state);

    @Nullable
    ConstraintSet getExtendFrom();
}
