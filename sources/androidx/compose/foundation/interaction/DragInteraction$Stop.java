package androidx.compose.foundation.interaction;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DragInteraction$Stop implements DragInteraction {
    public static final int $stable = 0;

    @NotNull
    private final DragInteraction.Start start;

    public DragInteraction$Stop(@NotNull DragInteraction.Start start) {
        Intrinsics.checkNotNullParameter(start, "start");
        this.start = start;
    }

    @NotNull
    public final DragInteraction.Start getStart() {
        return this.start;
    }
}
