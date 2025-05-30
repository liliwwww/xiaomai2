package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyStaggeredGridState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, LazyStaggeredGridState, List<? extends int[]>> {
    public static final LazyStaggeredGridState$Companion$Saver$1 INSTANCE = new LazyStaggeredGridState$Companion$Saver$1();

    LazyStaggeredGridState$Companion$Saver$1() {
        super(2);
    }

    @NotNull
    public final List<int[]> invoke(@NotNull SaverScope saverScope, @NotNull LazyStaggeredGridState lazyStaggeredGridState) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$listSaver");
        Intrinsics.checkNotNullParameter(lazyStaggeredGridState, "state");
        return CollectionsKt.listOf(new int[][]{lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices(), lazyStaggeredGridState.getScrollPosition$foundation_release().getOffsets()});
    }
}
