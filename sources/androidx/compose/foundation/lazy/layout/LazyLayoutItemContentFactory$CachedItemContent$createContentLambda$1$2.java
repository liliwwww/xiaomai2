package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ LazyLayoutItemContentFactory$CachedItemContent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2(LazyLayoutItemContentFactory$CachedItemContent lazyLayoutItemContentFactory$CachedItemContent) {
        super(1);
        this.this$0 = lazyLayoutItemContentFactory$CachedItemContent;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        final LazyLayoutItemContentFactory$CachedItemContent lazyLayoutItemContentFactory$CachedItemContent = this.this$0;
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$2$invoke$$inlined$onDispose$1
            public void dispose() {
                LazyLayoutItemContentFactory$CachedItemContent.this._content = null;
            }
        };
    }
}
