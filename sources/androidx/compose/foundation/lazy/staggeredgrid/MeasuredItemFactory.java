package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
interface MeasuredItemFactory {
    @NotNull
    LazyStaggeredGridMeasuredItem createItem(int i, int i2, @NotNull Object obj, @NotNull List<? extends Placeable> list);
}
