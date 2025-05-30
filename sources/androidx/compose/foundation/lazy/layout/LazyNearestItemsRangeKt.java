package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyNearestItemsRangeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange calculateNearestItemsRange(int i, int i2, int i3) {
        int i4 = (i / i2) * i2;
        return RangesKt.until(Math.max(i4 - i3, 0), i4 + i2 + i3);
    }

    @Composable
    @ExperimentalFoundationApi
    @NotNull
    public static final State<IntRange> rememberLazyNearestItemsRangeState(@NotNull Function0<Integer> function0, @NotNull Function0<Integer> function02, @NotNull Function0<Integer> function03, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "firstVisibleItemIndex");
        Intrinsics.checkNotNullParameter(function02, "slidingWindowSize");
        Intrinsics.checkNotNullParameter(function03, "extraItemCount");
        composer.startReplaceableGroup(429733345);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(429733345, i, -1, "androidx.compose.foundation.lazy.layout.rememberLazyNearestItemsRangeState (LazyNearestItemsRange.kt:41)");
        }
        boolean z = ((((i & 896) ^ 384) > 256 && composer.changedInstance(function03)) || (i & 384) == 256) | ((((i & 14) ^ 6) > 4 && composer.changedInstance(function0)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changedInstance(function02)) || (i & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
                try {
                    Object mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(calculateNearestItemsRange(((Number) function0.invoke()).intValue(), ((Number) function02.invoke()).intValue(), ((Number) function03.invoke()).intValue()), (SnapshotMutationPolicy) null, 2, (Object) null);
                    createNonObservableSnapshot.dispose();
                    composer.updateRememberedValue(mutableStateOf$default);
                    rememberedValue = mutableStateOf$default;
                } finally {
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                }
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
        MutableState mutableState = (MutableState) rememberedValue;
        Object[] objArr = {function0, function02, function03, mutableState};
        composer.startReplaceableGroup(-568225417);
        boolean z2 = false;
        for (int i2 = 0; i2 < 4; i2++) {
            z2 |= composer.changed(objArr[i2]);
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new rememberLazyNearestItemsRangeState.1.1(function0, function02, function03, mutableState, (Continuation) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(mutableState, (Function2) rememberedValue2, composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
