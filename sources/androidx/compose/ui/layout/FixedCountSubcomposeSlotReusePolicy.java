package androidx.compose.ui.layout;

import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FixedCountSubcomposeSlotReusePolicy implements SubcomposeSlotReusePolicy {
    private final int maxSlotsToRetainForReuse;

    public FixedCountSubcomposeSlotReusePolicy(int i) {
        this.maxSlotsToRetainForReuse = i;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(@Nullable Object obj, @Nullable Object obj2) {
        return true;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(@NotNull SubcomposeSlotReusePolicy.SlotIdsSet slotIdsSet) {
        Intrinsics.checkNotNullParameter(slotIdsSet, "slotIds");
        if (slotIdsSet.size() > this.maxSlotsToRetainForReuse) {
            int i = 0;
            Iterator<Object> it = slotIdsSet.iterator();
            while (it.hasNext()) {
                it.next();
                i++;
                if (i > this.maxSlotsToRetainForReuse) {
                    it.remove();
                }
            }
        }
    }
}
