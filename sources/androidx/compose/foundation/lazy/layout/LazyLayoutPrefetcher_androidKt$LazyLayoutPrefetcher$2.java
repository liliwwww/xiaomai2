package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;
    final /* synthetic */ SubcomposeLayoutState $subcomposeLayoutState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2(LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, int i) {
        super(2);
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$itemContentFactory = lazyLayoutItemContentFactory;
        this.$subcomposeLayoutState = subcomposeLayoutState;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(this.$prefetchState, this.$itemContentFactory, this.$subcomposeLayoutState, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
