package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aø\u0001\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000328\b\u0006\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u00052%\b\u0006\u0010\f\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000b2d\b\u0006\u0010\u0013\u001a^\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0086\b¨\u0006\u0016"}, d2 = {"", "K", "V", "", "maxSize", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "sizeOf", "Lkotlin/Function1;", "create", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "onEntryRemoved", "Landroidx/collection/LruCache;", "lruCache", "collection-ktx"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i, @NotNull Function2<? super K, ? super V, Integer> function2, @NotNull Function1<? super K, ? extends V> function1, @NotNull Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        Intrinsics.checkParameterIsNotNull(function2, "sizeOf");
        Intrinsics.checkParameterIsNotNull(function1, "create");
        Intrinsics.checkParameterIsNotNull(function4, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function2, function1, function4, i, i);
    }

    @NotNull
    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = new Function2<K, V, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                public final int invoke(@NotNull K k, @NotNull V v) {
                    Intrinsics.checkParameterIsNotNull(k, "<anonymous parameter 0>");
                    Intrinsics.checkParameterIsNotNull(v, "<anonymous parameter 1>");
                    return 1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m21invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(invoke((LruCacheKt$lruCache$1<K, V>) obj2, obj3));
                }
            };
        }
        Function2 function22 = function2;
        if ((i2 & 4) != 0) {
            function1 = new Function1<K, V>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Nullable
                public final V invoke(@NotNull K k) {
                    Intrinsics.checkParameterIsNotNull(k, "it");
                    return null;
                }
            };
        }
        Function1 function12 = function1;
        if ((i2 & 8) != 0) {
            function4 = new Function4<Boolean, K, V, V, Unit>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke(((Boolean) obj2).booleanValue(), (boolean) obj3, obj4, obj5);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, @NotNull K k, @NotNull V v, @Nullable V v2) {
                    Intrinsics.checkParameterIsNotNull(k, "<anonymous parameter 1>");
                    Intrinsics.checkParameterIsNotNull(v, "<anonymous parameter 2>");
                }
            };
        }
        Function4 function42 = function4;
        Intrinsics.checkParameterIsNotNull(function22, "sizeOf");
        Intrinsics.checkParameterIsNotNull(function12, "create");
        Intrinsics.checkParameterIsNotNull(function42, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(function22, function12, function42, i, i);
    }
}
