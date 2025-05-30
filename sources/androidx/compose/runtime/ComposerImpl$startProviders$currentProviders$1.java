package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposerImpl$startProviders$currentProviders$1 extends Lambda implements Function2<Composer, Integer, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>>> {
    final /* synthetic */ PersistentMap<CompositionLocal<Object>, State<Object>> $parentScope;
    final /* synthetic */ ProvidedValue<?>[] $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ComposerImpl$startProviders$currentProviders$1(ProvidedValue<?>[] providedValueArr, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        super(2);
        this.$values = providedValueArr;
        this.$parentScope = persistentMap;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Composer) obj, ((Number) obj2).intValue());
    }

    @Composable
    @NotNull
    public final PersistentMap<CompositionLocal<Object>, State<Object>> invoke(@Nullable Composer composer, int i) {
        PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocalMapOf;
        composer.startReplaceableGroup(935231726);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(935231726, i, -1, "androidx.compose.runtime.ComposerImpl.startProviders.<anonymous> (Composer.kt:1953)");
        }
        compositionLocalMapOf = ComposerKt.compositionLocalMapOf(this.$values, this.$parentScope, composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return compositionLocalMapOf;
    }
}
