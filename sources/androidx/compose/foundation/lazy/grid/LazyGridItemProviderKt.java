package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyGridItemProviderKt {
    private static final int NearestItemsExtraItemCount = 200;
    private static final int NearestItemsSlidingWindowSize = 90;

    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public static final LazyGridItemProvider rememberLazyGridItemProvider(@NotNull LazyGridState lazyGridState, @NotNull Function1<? super LazyGridScope, Unit> function1, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyGridState, "state");
        Intrinsics.checkNotNullParameter(function1, "content");
        composer.startReplaceableGroup(1831211759);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1831211759, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridItemProvider (LazyGridItemProvider.kt:39)");
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(lazyGridState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new rememberLazyGridItemProvider.nearestItemsRangeState.1.1(lazyGridState);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        State rememberLazyNearestItemsRangeState = LazyNearestItemsRangeKt.rememberLazyNearestItemsRangeState((Function0) rememberedValue, new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$2
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m459invoke() {
                return 90;
            }
        }, new Function0<Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt$rememberLazyGridItemProvider$nearestItemsRangeState$3
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m460invoke() {
                return 200;
            }
        }, composer, 432);
        composer.startReplaceableGroup(1157296644);
        boolean changed2 = composer.changed(rememberLazyNearestItemsRangeState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new rememberLazyGridItemProvider.1.1(SnapshotStateKt.derivedStateOf(new rememberLazyGridItemProvider.1.itemProviderState.1(rememberUpdatedState, rememberLazyNearestItemsRangeState)));
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        rememberLazyGridItemProvider.1.1 r0 = (rememberLazyGridItemProvider.1.1) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }
}
