package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyGridState$prefetchInfoRetriever$2 extends Lambda implements Function1<LineIndex, List<? extends Pair<? extends Integer, ? extends Constraints>>> {
    public static final LazyGridState$prefetchInfoRetriever$2 INSTANCE = new LazyGridState$prefetchInfoRetriever$2();

    LazyGridState$prefetchInfoRetriever$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m468invokebKFJvoY(((LineIndex) obj).m485unboximpl());
    }

    @NotNull
    /* renamed from: invoke-bKFJvoY, reason: not valid java name */
    public final List<Pair<Integer, Constraints>> m468invokebKFJvoY(int i) {
        return CollectionsKt.emptyList();
    }
}
