package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.p004ui.layout.Placeable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
interface MeasuredItemFactory {
    @NotNull
    LazyStaggeredGridMeasuredItem createItem(int i, int i2, @NotNull Object obj, @NotNull List<? extends Placeable> list);
}
