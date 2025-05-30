package androidx.core.util;

import android.util.LruCache;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i, @NotNull Function2<? super K, ? super V, Integer> function2, @NotNull Function1<? super K, ? extends V> function1, @NotNull Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        Intrinsics.checkNotNullParameter(function2, "sizeOf");
        Intrinsics.checkNotNullParameter(function1, "create");
        Intrinsics.checkNotNullParameter(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i, function2, function1, function4);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = new Function2<K, V, Integer>() { // from class: androidx.core.util.LruCacheKt$lruCache$1
                @NotNull
                public final Integer invoke(@NotNull K k, @NotNull V v) {
                    Intrinsics.checkNotNullParameter(k, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(v, "<anonymous parameter 1>");
                    return 1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m5579invoke(Object obj2, Object obj3) {
                    return invoke((LruCacheKt$lruCache$1<K, V>) obj2, obj3);
                }
            };
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<K, V>() { // from class: androidx.core.util.LruCacheKt$lruCache$2
                @Nullable
                public final V invoke(@NotNull K k) {
                    Intrinsics.checkNotNullParameter(k, "it");
                    return null;
                }
            };
        }
        if ((i2 & 8) != 0) {
            function4 = new Function4<Boolean, K, V, V, Unit>() { // from class: androidx.core.util.LruCacheKt$lruCache$3
                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Boolean) obj2).booleanValue(), (boolean) obj3, obj4, obj5);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, @NotNull K k, @NotNull V v, @Nullable V v2) {
                    Intrinsics.checkNotNullParameter(k, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(v, "<anonymous parameter 2>");
                }
            };
        }
        Intrinsics.checkNotNullParameter(function2, "sizeOf");
        Intrinsics.checkNotNullParameter(function1, "create");
        Intrinsics.checkNotNullParameter(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(i, function2, function1, function4);
    }
}
