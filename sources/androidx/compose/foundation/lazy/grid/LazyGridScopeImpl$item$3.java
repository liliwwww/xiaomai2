package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyGridScopeImpl$item$3 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ Object $contentType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyGridScopeImpl$item$3(Object obj) {
        super(1);
        this.$contentType = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @Nullable
    public final Object invoke(int i) {
        return this.$contentType;
    }
}
