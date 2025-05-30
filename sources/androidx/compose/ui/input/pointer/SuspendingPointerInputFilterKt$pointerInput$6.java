package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SuspendingPointerInputFilterKt$pointerInput$6 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function2<PointerInputScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Object[] $keys;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendingPointerInputFilterKt$pointerInput$6(Object[] objArr, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(3);
        this.$keys = objArr;
        this.$block = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(664422852);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(664422852, i, -1, "androidx.compose.ui.input.pointer.pointerInput.<anonymous> (SuspendingPointerInputFilter.kt:330)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SuspendingPointerInputFilter(viewConfiguration, density);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Object[] objArr = this.$keys;
        Function2<PointerInputScope, Continuation<? super Unit>, Object> function2 = this.$block;
        SuspendingPointerInputFilter suspendingPointerInputFilter = (SuspendingPointerInputFilter) rememberedValue;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(suspendingPointerInputFilter);
        spreadBuilder.addSpread(objArr);
        EffectsKt.LaunchedEffect(spreadBuilder.toArray(new Object[spreadBuilder.size()]), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new 2.1(suspendingPointerInputFilter, function2, (Continuation) null), composer, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return suspendingPointerInputFilter;
    }
}
