package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RecomposerKt {
    private static final int RecomposerCompoundHashKey = 1000;

    @NotNull
    private static final Object ProduceAnotherFrame = new Object();

    @NotNull
    private static final Object FramePending = new Object();

    public static final <K, V> boolean addMultiValue(@NotNull Map<K, List<V>> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        List<V> list = map.get(k);
        if (list == null) {
            list = new ArrayList<>();
            map.put(k, list);
        }
        return list.add(v);
    }

    @Nullable
    public static final <K, V> V removeLastMultiValue(@NotNull Map<K, List<V>> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        List<V> list = map.get(k);
        if (list == null) {
            return null;
        }
        V v = (V) CollectionsKt.removeFirst(list);
        if (!list.isEmpty()) {
            return v;
        }
        map.remove(k);
        return v;
    }

    @Nullable
    public static final <R> Object withRunningRecomposer(@NotNull Function3<? super CoroutineScope, ? super Recomposer, ? super Continuation<? super R>, ? extends Object> function3, @NotNull Continuation<? super R> continuation) {
        return i80.g(new RecomposerKt$withRunningRecomposer$2(function3, null), continuation);
    }
}
