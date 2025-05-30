package androidx.compose.ui.focus;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusInvalidationManager {

    @NotNull
    private Set<FocusEventModifierNode> focusEventNodes;

    @NotNull
    private Set<FocusPropertiesModifierNode> focusPropertiesNodes;

    @NotNull
    private Set<FocusTargetModifierNode> focusTargetNodes;

    @NotNull
    private final Function0<Unit> invalidateNodes;

    @NotNull
    private final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;

    public FocusInvalidationManager(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onRequestApplyChangesListener");
        this.onRequestApplyChangesListener = function1;
        this.focusTargetNodes = new LinkedHashSet();
        this.focusEventNodes = new LinkedHashSet();
        this.focusPropertiesNodes = new LinkedHashSet();
        this.invalidateNodes = new invalidateNodes.1(this);
    }

    public final void scheduleInvalidation(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "node");
        scheduleInvalidation(this.focusTargetNodes, focusTargetModifierNode);
    }

    public final void scheduleInvalidation(@NotNull FocusEventModifierNode focusEventModifierNode) {
        Intrinsics.checkNotNullParameter(focusEventModifierNode, "node");
        scheduleInvalidation(this.focusEventNodes, focusEventModifierNode);
    }

    public final void scheduleInvalidation(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        Intrinsics.checkNotNullParameter(focusPropertiesModifierNode, "node");
        scheduleInvalidation(this.focusPropertiesNodes, focusPropertiesModifierNode);
    }

    private final <T> void scheduleInvalidation(Set<T> set, T t) {
        if (set.contains(t)) {
            return;
        }
        set.add(t);
        if (this.focusTargetNodes.size() + this.focusEventNodes.size() + this.focusPropertiesNodes.size() == 1) {
            this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
        }
    }
}
