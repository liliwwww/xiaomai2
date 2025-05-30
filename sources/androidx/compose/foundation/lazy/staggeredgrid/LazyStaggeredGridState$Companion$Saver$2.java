package androidx.compose.foundation.lazy.staggeredgrid;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyStaggeredGridState$Companion$Saver$2 extends Lambda implements Function1<List<? extends int[]>, LazyStaggeredGridState> {
    public static final LazyStaggeredGridState$Companion$Saver$2 INSTANCE = new LazyStaggeredGridState$Companion$Saver$2();

    LazyStaggeredGridState$Companion$Saver$2() {
        super(1);
    }

    @Nullable
    public final LazyStaggeredGridState invoke(@NotNull List<int[]> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return new LazyStaggeredGridState(list.get(0), list.get(1), (DefaultConstructorMarker) null);
    }
}
