package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ImmutableMap<K, V> extends Map<K, V>, KMappedMarker {
    @NotNull
    ImmutableSet<Map.Entry<K, V>> getEntries();

    @NotNull
    ImmutableSet<K> getKeys();

    @NotNull
    ImmutableCollection<V> getValues();
}
