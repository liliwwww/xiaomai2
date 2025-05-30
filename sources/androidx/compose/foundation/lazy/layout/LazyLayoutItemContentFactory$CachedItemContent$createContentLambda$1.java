package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyLayoutItemContentFactory this$0;
    final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutItemContentFactory.CachedItemContent cachedItemContent) {
        super(2);
        this.this$0 = lazyLayoutItemContentFactory;
        this.this$1 = cachedItemContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        int lastKnownIndex;
        SaveableStateHolder saveableStateHolder;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1403994769, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:89)");
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.this$0.getItemProvider().invoke();
        Integer num = lazyLayoutItemProvider.getKeyToIndexMap().get(this.this$1.getKey());
        if (num != null) {
            LazyLayoutItemContentFactory.CachedItemContent.access$setLastKnownIndex(this.this$1, num.intValue());
            lastKnownIndex = num.intValue();
        } else {
            lastKnownIndex = this.this$1.getLastKnownIndex();
        }
        composer.startReplaceableGroup(-715770513);
        if (lastKnownIndex < lazyLayoutItemProvider.getItemCount()) {
            Object key = lazyLayoutItemProvider.getKey(lastKnownIndex);
            if (Intrinsics.areEqual(key, this.this$1.getKey())) {
                saveableStateHolder = this.this$0.saveableStateHolder;
                saveableStateHolder.SaveableStateProvider(key, ComposableLambdaKt.composableLambda(composer, -1238863364, true, new 1(lazyLayoutItemProvider, lastKnownIndex)), composer, 568);
            }
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(this.this$1.getKey(), new 2(this.this$1), composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
