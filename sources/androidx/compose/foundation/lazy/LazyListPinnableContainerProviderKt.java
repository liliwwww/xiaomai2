package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListPinnableContainerProviderKt$LazyListPinnableContainerProvider$1$1$invoke$;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyListPinnableContainerProviderKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void LazyListPinnableContainerProvider(@NotNull LazyListState lazyListState, int i, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1178440446);
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(lazyListState) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1178440446, i3, -1, "androidx.compose.foundation.lazy.LazyListPinnableContainerProvider (LazyListPinnableContainerProvider.kt:34)");
            }
            boolean z = (i3 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new LazyListPinnableItem(lazyListState);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final LazyListPinnableItem lazyListPinnableItem = (LazyListPinnableItem) rememberedValue;
            lazyListPinnableItem.setIndex(i);
            lazyListPinnableItem.setParentPinnableContainer((PinnableContainer) startRestartGroup.consume(PinnableContainerKt.getLocalPinnableContainer()));
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(lazyListPinnableItem);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.LazyListPinnableContainerProviderKt$LazyListPinnableContainerProvider$1$1
                    {
                        super(1);
                    }

                    @NotNull
                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                        return new LazyListPinnableContainerProviderKt$LazyListPinnableContainerProvider$1$1$invoke$.inlined.onDispose.1(LazyListPinnableItem.this);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(lazyListPinnableItem, (Function1) rememberedValue2, startRestartGroup, 0);
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{PinnableContainerKt.getLocalPinnableContainer().provides(lazyListPinnableItem)}, function2, startRestartGroup, ((i3 >> 3) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new LazyListPinnableContainerProvider.2(lazyListState, i, function2, i2));
    }
}
