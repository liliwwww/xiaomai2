package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CustomAccessibilityAction {
    public static final int $stable = 0;

    @NotNull
    private final Function0<Boolean> action;

    @NotNull
    private final String label;

    public CustomAccessibilityAction(@NotNull String str, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(function0, "action");
        this.label = str;
        this.action = function0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAccessibilityAction)) {
            return false;
        }
        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) obj;
        return Intrinsics.areEqual(this.label, customAccessibilityAction.label) && Intrinsics.areEqual(this.action, customAccessibilityAction.action);
    }

    @NotNull
    public final Function0<Boolean> getAction() {
        return this.action;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "CustomAccessibilityAction(label=" + this.label + ", action=" + this.action + ')';
    }
}
