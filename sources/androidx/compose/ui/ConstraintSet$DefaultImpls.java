package androidx.compose.ui;

import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.core.state.Transition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ConstraintSet$DefaultImpls {
    public static void applyTo(@NotNull ConstraintSet constraintSet, @NotNull Transition transition, int i) {
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
