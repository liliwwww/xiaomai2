package androidx.constraintlayout.compose;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Landroidx/constraintlayout/compose/Transition;", "", "Landroidx/constraintlayout/core/state/Transition;", "transition", "", "type", "", "applyTo", "", "getStartConstraintSetId", "getEndConstraintSetId", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface Transition {
    void applyTo(@NotNull androidx.constraintlayout.core.state.Transition transition, int type);

    @NotNull
    String getEndConstraintSetId();

    @NotNull
    String getStartConstraintSetId();
}
