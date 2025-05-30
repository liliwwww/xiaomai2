package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyGridScopeImpl$item$1$1 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ Object $key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridScopeImpl$item$1$1(Object obj) {
        super(1);
        this.$key = obj;
    }

    @NotNull
    public final Object invoke(int i) {
        return this.$key;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
