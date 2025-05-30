package androidx.compose.foundation.interaction;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class HoverInteraction$Exit implements HoverInteraction {
    public static final int $stable = 0;

    @NotNull
    private final HoverInteraction.Enter enter;

    public HoverInteraction$Exit(@NotNull HoverInteraction.Enter enter) {
        Intrinsics.checkNotNullParameter(enter, "enter");
        this.enter = enter;
    }

    @NotNull
    public final HoverInteraction.Enter getEnter() {
        return this.enter;
    }
}
