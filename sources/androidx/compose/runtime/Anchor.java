package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Anchor {
    private int location;

    public Anchor(int i) {
        this.location = i;
    }

    public final int getLocation$runtime_release() {
        return this.location;
    }

    public final boolean getValid() {
        return this.location != Integer.MIN_VALUE;
    }

    public final void setLocation$runtime_release(int i) {
        this.location = i;
    }

    public final int toIndexFor(@NotNull SlotTable slotTable) {
        Intrinsics.checkNotNullParameter(slotTable, "slots");
        return slotTable.anchorIndex(this);
    }

    public final int toIndexFor(@NotNull SlotWriter slotWriter) {
        Intrinsics.checkNotNullParameter(slotWriter, "writer");
        return slotWriter.anchorIndex(this);
    }
}
