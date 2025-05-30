package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1 extends Lambda implements Function1<IntervalList.Interval<? extends LazyLayoutIntervalContent>, Unit> {
    final /* synthetic */ int $first;
    final /* synthetic */ int $last;
    final /* synthetic */ HashMap<Object, Integer> $map;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1(int i, int i2, HashMap<Object, Integer> hashMap) {
        super(1);
        this.$first = i;
        this.$last = i2;
        this.$map = hashMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IntervalList.Interval<? extends LazyLayoutIntervalContent>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IntervalList.Interval<? extends LazyLayoutIntervalContent> interval) {
        Intrinsics.checkNotNullParameter(interval, "it");
        if (interval.getValue().getKey() == null) {
            return;
        }
        Function1<Integer, Object> key = interval.getValue().getKey();
        if (key == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        int max = Math.max(this.$first, interval.getStartIndex());
        int min = Math.min(this.$last, (interval.getStartIndex() + interval.getSize()) - 1);
        if (max > min) {
            return;
        }
        while (true) {
            this.$map.put(key.invoke(Integer.valueOf(max - interval.getStartIndex())), Integer.valueOf(max));
            if (max == min) {
                return;
            } else {
                max++;
            }
        }
    }
}
