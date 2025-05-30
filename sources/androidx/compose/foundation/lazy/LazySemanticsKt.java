package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazySemanticsKt {
    @Composable
    @NotNull
    public static final LazyLayoutSemanticState rememberLazyListSemanticState(@NotNull LazyListState lazyListState, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, boolean z, boolean z2, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        composer.startReplaceableGroup(1624527721);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1624527721, i, -1, "androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazySemantics.kt:30)");
        }
        boolean z3 = ((((i & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(lazyLayoutItemProvider)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(z)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z2)) || (i & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new rememberLazyListSemanticState.1.1(z, lazyListState, lazyLayoutItemProvider, z2);
            composer.updateRememberedValue(rememberedValue);
        }
        rememberLazyListSemanticState.1.1 r0 = (rememberLazyListSemanticState.1.1) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }
}
