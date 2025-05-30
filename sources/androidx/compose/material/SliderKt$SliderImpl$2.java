package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SliderKt$SliderImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $positionFraction;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$SliderImpl$2(boolean z, float f, List<Float> list, SliderColors sliderColors, float f2, MutableInteractionSource mutableInteractionSource, Modifier modifier, int i) {
        super(2);
        this.$enabled = z;
        this.$positionFraction = f;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$width = f2;
        this.$interactionSource = mutableInteractionSource;
        this.$modifier = modifier;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        SliderKt.access$SliderImpl(this.$enabled, this.$positionFraction, this.$tickFractions, this.$colors, this.$width, this.$interactionSource, this.$modifier, composer, this.$$changed | 1);
    }
}
