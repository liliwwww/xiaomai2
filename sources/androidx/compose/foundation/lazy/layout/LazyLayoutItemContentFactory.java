package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyLayoutItemContentFactory {

    @NotNull
    private final Function0<LazyLayoutItemProvider> itemProvider;

    @NotNull
    private final Map<Object, CachedItemContent> lambdasCache;

    @NotNull
    private final SaveableStateHolder saveableStateHolder;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutItemContentFactory(@NotNull SaveableStateHolder saveableStateHolder, @NotNull Function0<? extends LazyLayoutItemProvider> function0) {
        Intrinsics.checkNotNullParameter(saveableStateHolder, "saveableStateHolder");
        Intrinsics.checkNotNullParameter(function0, "itemProvider");
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = function0;
        this.lambdasCache = new LinkedHashMap();
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getContent(int i, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        CachedItemContent cachedItemContent = this.lambdasCache.get(obj);
        Object contentType = ((LazyLayoutItemProvider) this.itemProvider.invoke()).getContentType(i);
        if (cachedItemContent != null && cachedItemContent.getLastKnownIndex() == i && Intrinsics.areEqual(cachedItemContent.getType(), contentType)) {
            return cachedItemContent.getContent();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(this, i, obj, contentType);
        this.lambdasCache.put(obj, cachedItemContent2);
        return cachedItemContent2.getContent();
    }

    @Nullable
    public final Object getContentType(@Nullable Object obj) {
        CachedItemContent cachedItemContent = this.lambdasCache.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.getType();
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.itemProvider.invoke();
        Integer num = lazyLayoutItemProvider.getKeyToIndexMap().get(obj);
        if (num != null) {
            return lazyLayoutItemProvider.getContentType(num.intValue());
        }
        return null;
    }

    @NotNull
    public final Function0<LazyLayoutItemProvider> getItemProvider() {
        return this.itemProvider;
    }
}
