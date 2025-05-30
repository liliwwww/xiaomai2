package androidx.core.util;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LruCacheKt$lruCache$1<K, V> extends Lambda implements Function2<K, V, Integer> {
    public static final LruCacheKt$lruCache$1 INSTANCE = new LruCacheKt$lruCache$1();

    public LruCacheKt$lruCache$1() {
        super(2);
    }

    @NotNull
    public final Integer invoke(@NotNull K k, @NotNull V v) {
        Intrinsics.checkNotNullParameter(k, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(v, "<anonymous parameter 1>");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2323invoke(Object obj, Object obj2) {
        return invoke((LruCacheKt$lruCache$1<K, V>) obj, obj2);
    }
}
