package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyLayoutSemanticsKt {
    @Composable
    @NotNull
    public static final Modifier lazyLayoutSemantics(@NotNull Modifier modifier, @NotNull final LazyLayoutItemProvider lazyLayoutItemProvider, @NotNull final LazyLayoutSemanticState lazyLayoutSemanticState, @NotNull Orientation orientation, boolean z, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyLayoutSemanticState, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        composer.startReplaceableGroup(1548174271);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1548174271, i, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:39)");
        }
        composer.startReplaceableGroup(773894976);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Object[] objArr = {lazyLayoutItemProvider, lazyLayoutSemanticState, orientation, Boolean.valueOf(z)};
        composer.startReplaceableGroup(-568225417);
        boolean z2 = false;
        for (int i2 = 0; i2 < 4; i2++) {
            z2 |= composer.changed(objArr[i2]);
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            boolean z3 = orientation == Orientation.Vertical;
            rememberedValue2 = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new lazyLayoutSemantics.1.1(new lazyLayoutSemantics.1.indexForKeyMapping.1(lazyLayoutItemProvider), z3, lazyLayoutSemanticState.scrollAxisRange(), z ? new lazyLayoutSemantics.1.scrollByAction.1(z3, coroutineScope, lazyLayoutSemanticState) : null, z ? new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                @NotNull
                public final Boolean invoke(int i3) {
                    boolean z4 = i3 >= 0 && i3 < LazyLayoutItemProvider.this.getItemCount();
                    LazyLayoutItemProvider lazyLayoutItemProvider2 = LazyLayoutItemProvider.this;
                    if (z4) {
                        d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new 2(lazyLayoutSemanticState, i3, (Continuation) null), 3, (Object) null);
                        return Boolean.TRUE;
                    }
                    throw new IllegalArgumentException(("Can't scroll to index " + i3 + ", it is out of bounds [0, " + lazyLayoutItemProvider2.getItemCount() + ')').toString());
                }
            } : null, lazyLayoutSemanticState.collectionInfo()), 1, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
