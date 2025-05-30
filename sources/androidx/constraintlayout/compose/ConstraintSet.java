package androidx.constraintlayout.compose;

import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0014"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSet;", "", "Landroidx/constraintlayout/compose/State;", "state", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "", "applyTo", "", "name", "", "value", "override", "Landroidx/constraintlayout/core/state/Transition;", "transition", "", "type", "", "isDirty", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface ConstraintSet {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static void applyTo(@NotNull ConstraintSet constraintSet, @NotNull androidx.constraintlayout.core.state.Transition transition, int i) {
            Intrinsics.checkNotNullParameter(constraintSet, "this");
            Intrinsics.checkNotNullParameter(transition, "transition");
        }

        public static boolean isDirty(@NotNull ConstraintSet constraintSet, @NotNull List<? extends Measurable> list) {
            Intrinsics.checkNotNullParameter(constraintSet, "this");
            Intrinsics.checkNotNullParameter(list, "measurables");
            return true;
        }

        @NotNull
        public static ConstraintSet override(@NotNull ConstraintSet constraintSet, @NotNull String str, float f) {
            Intrinsics.checkNotNullParameter(constraintSet, "this");
            Intrinsics.checkNotNullParameter(str, "name");
            return constraintSet;
        }
    }

    void applyTo(@NotNull State state, @NotNull List<? extends Measurable> measurables);

    void applyTo(@NotNull androidx.constraintlayout.core.state.Transition transition, int type);

    boolean isDirty(@NotNull List<? extends Measurable> measurables);

    @NotNull
    ConstraintSet override(@NotNull String name, float value);
}
