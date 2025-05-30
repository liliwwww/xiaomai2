package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FocusInteraction$Unfocus implements FocusInteraction {
    public static final int $stable = 0;

    @NotNull
    private final FocusInteraction$Focus focus;

    public FocusInteraction$Unfocus(@NotNull FocusInteraction$Focus focusInteraction$Focus) {
        Intrinsics.checkNotNullParameter(focusInteraction$Focus, "focus");
        this.focus = focusInteraction$Focus;
    }

    @NotNull
    public final FocusInteraction$Focus getFocus() {
        return this.focus;
    }
}
