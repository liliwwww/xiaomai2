package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class NestedScrollModifierKt$nestedScroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ NestedScrollConnection $connection;
    final /* synthetic */ NestedScrollDispatcher $dispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NestedScrollModifierKt$nestedScroll$2(NestedScrollDispatcher nestedScrollDispatcher, NestedScrollConnection nestedScrollConnection) {
        super(3);
        this.$dispatcher = nestedScrollDispatcher;
        this.$connection = nestedScrollConnection;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(410346167);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(410346167, i, -1, "androidx.compose.ui.input.nestedscroll.nestedScroll.<anonymous> (NestedScrollModifier.kt:335)");
        }
        composer.startReplaceableGroup(773894976);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        NestedScrollDispatcher nestedScrollDispatcher = this.$dispatcher;
        composer.startReplaceableGroup(100475956);
        if (nestedScrollDispatcher == null) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new NestedScrollDispatcher();
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            nestedScrollDispatcher = (NestedScrollDispatcher) rememberedValue2;
        }
        composer.endReplaceableGroup();
        NestedScrollConnection nestedScrollConnection = this.$connection;
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(nestedScrollConnection) | composer.changed(nestedScrollDispatcher) | composer.changed(coroutineScope);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == companion.getEmpty()) {
            nestedScrollDispatcher.setOriginNestedScrollScope$ui_release(coroutineScope);
            rememberedValue3 = new NestedScrollModifierLocal(nestedScrollDispatcher, nestedScrollConnection);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        NestedScrollModifierLocal nestedScrollModifierLocal = (NestedScrollModifierLocal) rememberedValue3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return nestedScrollModifierLocal;
    }
}
