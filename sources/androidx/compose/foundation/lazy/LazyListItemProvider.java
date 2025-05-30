package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: classes2.dex */
public interface LazyListItemProvider extends LazyLayoutItemProvider {
    @NotNull
    List<Integer> getHeaderIndexes();

    @NotNull
    LazyItemScopeImpl getItemScope();
}
