package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LazyListPinnableContainerProviderKt$LazyListPinnableContainerProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ int $index;
    final /* synthetic */ LazyListState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyListPinnableContainerProviderKt$LazyListPinnableContainerProvider$2(LazyListState lazyListState, int i, Function2<? super Composer, ? super Integer, Unit> function2, int i2) {
        super(2);
        this.$state = lazyListState;
        this.$index = i;
        this.$content = function2;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        LazyListPinnableContainerProviderKt.LazyListPinnableContainerProvider(this.$state, this.$index, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
