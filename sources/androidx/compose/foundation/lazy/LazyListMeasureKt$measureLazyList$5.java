package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable$PlacementScope;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyListMeasureKt$measureLazyList$5 extends Lambda implements Function1<Placeable$PlacementScope, Unit> {
    final /* synthetic */ LazyListPositionedItem $headerItem;
    final /* synthetic */ List<LazyListPositionedItem> $positionedItems;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListMeasureKt$measureLazyList$5(List<LazyListPositionedItem> list, LazyListPositionedItem lazyListPositionedItem) {
        super(1);
        this.$positionedItems = list;
        this.$headerItem = lazyListPositionedItem;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable$PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
        Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$invoke");
        List<LazyListPositionedItem> list = this.$positionedItems;
        LazyListPositionedItem lazyListPositionedItem = this.$headerItem;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LazyListPositionedItem lazyListPositionedItem2 = list.get(i);
            if (lazyListPositionedItem2 != lazyListPositionedItem) {
                lazyListPositionedItem2.place(placeable$PlacementScope);
            }
        }
        LazyListPositionedItem lazyListPositionedItem3 = this.$headerItem;
        if (lazyListPositionedItem3 != null) {
            lazyListPositionedItem3.place(placeable$PlacementScope);
        }
    }
}
