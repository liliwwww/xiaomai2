package androidx.core.util;

import android.util.LruCache;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i, @NotNull Function2<? super K, ? super V, Integer> function2, @NotNull Function1<? super K, ? extends V> function1, @NotNull Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        Intrinsics.checkNotNullParameter(function2, "sizeOf");
        Intrinsics.checkNotNullParameter(function1, "create");
        Intrinsics.checkNotNullParameter(function4, "onEntryRemoved");
        return new lruCache.4(i, function2, function1, function4);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = lruCache.1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            function1 = lruCache.2.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            function4 = lruCache.3.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(function2, "sizeOf");
        Intrinsics.checkNotNullParameter(function1, "create");
        Intrinsics.checkNotNullParameter(function4, "onEntryRemoved");
        return new lruCache.4(i, function2, function1, function4);
    }
}
