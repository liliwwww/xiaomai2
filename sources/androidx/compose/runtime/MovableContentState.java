package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalComposeApi
/* loaded from: classes2.dex */
public final class MovableContentState {
    public static final int $stable = 8;

    @NotNull
    private final SlotTable slotTable;

    public MovableContentState(@NotNull SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "slotTable");
        this.slotTable = slotTable;
    }

    @NotNull
    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }
}
