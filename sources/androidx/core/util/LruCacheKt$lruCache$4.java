package androidx.core.util;

import android.util.LruCache;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ Function1<K, V> $create;
    final /* synthetic */ Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
    final /* synthetic */ Function2<K, V, Integer> $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheKt$lruCache$4(int i, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        super(i);
        this.$sizeOf = function2;
        this.$create = function1;
        this.$onEntryRemoved = function4;
    }

    @Override // android.util.LruCache
    @Nullable
    protected V create(@NotNull K k) {
        Intrinsics.checkNotNullParameter(k, "key");
        return (V) this.$create.invoke(k);
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, @NotNull K k, @NotNull V v, @Nullable V v2) {
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(v, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
    }

    @Override // android.util.LruCache
    protected int sizeOf(@NotNull K k, @NotNull V v) {
        Intrinsics.checkNotNullParameter(k, "key");
        Intrinsics.checkNotNullParameter(v, "value");
        return ((Number) this.$sizeOf.invoke(k, v)).intValue();
    }
}
