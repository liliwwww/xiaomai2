package androidx.compose.foundation.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyListState$scrollableState$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ LazyListState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListState$scrollableState$1(LazyListState lazyListState) {
        super(1);
        this.this$0 = lazyListState;
    }

    @NotNull
    public final Float invoke(float f) {
        return Float.valueOf(-this.this$0.onScroll$foundation_release(-f));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
