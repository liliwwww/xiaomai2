package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p004ui.layout.SubcomposeSlotReusePolicy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: classes.dex */
final class LazyLayoutItemReusePolicy implements SubcomposeSlotReusePolicy {

    @NotNull
    private final Map<Object, Integer> countPerType;

    @NotNull
    private final LazyLayoutItemContentFactory factory;

    public LazyLayoutItemReusePolicy(@NotNull LazyLayoutItemContentFactory lazyLayoutItemContentFactory) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "factory");
        this.factory = lazyLayoutItemContentFactory;
        this.countPerType = new LinkedHashMap();
    }

    @Override // androidx.compose.p004ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(@Nullable Object obj, @Nullable Object obj2) {
        return Intrinsics.areEqual(this.factory.getContentType(obj), this.factory.getContentType(obj2));
    }

    @Override // androidx.compose.p004ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(@NotNull SubcomposeSlotReusePolicy.SlotIdsSet slotIdsSet) {
        Intrinsics.checkNotNullParameter(slotIdsSet, "slotIds");
        this.countPerType.clear();
        Iterator<Object> it = slotIdsSet.iterator();
        while (it.hasNext()) {
            Object contentType = this.factory.getContentType(it.next());
            Integer num = this.countPerType.get(contentType);
            int intValue = num != null ? num.intValue() : 0;
            if (intValue == 7) {
                it.remove();
            } else {
                this.countPerType.put(contentType, Integer.valueOf(intValue + 1));
            }
        }
    }
}
