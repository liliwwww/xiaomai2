package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PersistentMap<K, V> extends ImmutableMap<K, V> {

    /* compiled from: Taobao */
    public interface Builder<K, V> extends Map<K, V>, KMutableMap {
        @NotNull
        PersistentMap<K, V> build();
    }

    @NotNull
    Builder<K, V> builder();

    @NotNull
    PersistentMap<K, V> clear();

    @NotNull
    PersistentMap<K, V> put(K k, V v);

    @NotNull
    PersistentMap<K, V> putAll(@NotNull Map<? extends K, ? extends V> map);

    @NotNull
    PersistentMap<K, V> remove(K k);

    @NotNull
    PersistentMap<K, V> remove(K k, V v);
}
