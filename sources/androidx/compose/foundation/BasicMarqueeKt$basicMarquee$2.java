package androidx.compose.foundation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BasicMarqueeKt$basicMarquee$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ int $animationMode;
    final /* synthetic */ int $delayMillis;
    final /* synthetic */ int $initialDelayMillis;
    final /* synthetic */ int $iterations;
    final /* synthetic */ MarqueeSpacing $spacing;
    final /* synthetic */ float $velocity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicMarqueeKt$basicMarquee$2(int i, int i2, int i3, float f, MarqueeSpacing marqueeSpacing, int i4) {
        super(3);
        this.$iterations = i;
        this.$delayMillis = i2;
        this.$initialDelayMillis = i3;
        this.$velocity = f;
        this.$spacing = marqueeSpacing;
        this.$animationMode = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-562302205);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-562302205, i, -1, "androidx.compose.foundation.basicMarquee.<anonymous> (BasicMarquee.kt:147)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object obj = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        Object[] objArr = {Integer.valueOf(this.$iterations), Integer.valueOf(this.$delayMillis), Integer.valueOf(this.$initialDelayMillis), Dp.m2140boximpl(this.$velocity), density, obj};
        int i2 = this.$iterations;
        int i3 = this.$delayMillis;
        int i4 = this.$initialDelayMillis;
        float f = this.$velocity;
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i5 = 0; i5 < 6; i5++) {
            z |= composer.changed(objArr[i5]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new MarqueeModifier(i2, i3, i4, Dp.m2142constructorimpl(f * (obj == LayoutDirection.Ltr ? 1.0f : -1.0f)), density, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MarqueeModifier marqueeModifier = (MarqueeModifier) rememberedValue;
        marqueeModifier.setSpacing(this.$spacing);
        marqueeModifier.m147setAnimationMode97h66l8(this.$animationMode);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(marqueeModifier);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new 1.1(marqueeModifier, (Continuation) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(marqueeModifier, (Function2) rememberedValue2, composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return marqueeModifier;
    }
}
