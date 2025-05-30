package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PressInteraction$Cancel implements PressInteraction {
    public static final int $stable = 0;

    @NotNull
    private final PressInteraction$Press press;

    public PressInteraction$Cancel(@NotNull PressInteraction$Press pressInteraction$Press) {
        Intrinsics.checkNotNullParameter(pressInteraction$Press, "press");
        this.press = pressInteraction$Press;
    }

    @NotNull
    public final PressInteraction$Press getPress() {
        return this.press;
    }
}
