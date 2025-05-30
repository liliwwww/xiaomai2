package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class AbstractMapBuilderEntries<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((AbstractMapBuilderEntries<E, K, V>) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(@NotNull Map.Entry<? extends K, ? extends V> entry);

    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((AbstractMapBuilderEntries<E, K, V>) obj);
        }
        return false;
    }

    public abstract boolean removeEntry(@NotNull Map.Entry<? extends K, ? extends V> entry);

    public final boolean contains(@NotNull E e) {
        Intrinsics.checkNotNullParameter(e, "element");
        if ((e instanceof Object ? e : null) instanceof Map.Entry) {
            return containsEntry(e);
        }
        return false;
    }

    public final boolean remove(@NotNull E e) {
        Intrinsics.checkNotNullParameter(e, "element");
        if ((e instanceof Object ? e : null) instanceof Map.Entry) {
            return removeEntry(e);
        }
        return false;
    }
}
