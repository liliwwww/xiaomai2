package androidx.core.util;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LruCacheKt$lruCache$3<K, V> extends Lambda implements Function4<Boolean, K, V, V, Unit> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Boolean) obj).booleanValue(), (boolean) obj2, obj3, obj4);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, @NotNull K k, @NotNull V v, @Nullable V v2) {
        Intrinsics.checkNotNullParameter(k, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(v, "<anonymous parameter 2>");
    }
}
