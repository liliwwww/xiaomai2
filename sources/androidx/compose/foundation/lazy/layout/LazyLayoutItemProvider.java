package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public interface LazyLayoutItemProvider {
    @Composable
    void Item(int i, @Nullable Composer composer, int i2);

    @Nullable
    Object getContentType(int i);

    int getItemCount();

    @NotNull
    Object getKey(int i);

    @NotNull
    Map<Object, Integer> getKeyToIndexMap();
}
