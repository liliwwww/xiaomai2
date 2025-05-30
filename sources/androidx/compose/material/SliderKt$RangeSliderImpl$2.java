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
final class SliderKt$RangeSliderImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Modifier $endThumbSemantics;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $positionFractionEnd;
    final /* synthetic */ float $positionFractionStart;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ Modifier $startThumbSemantics;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ float $width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSliderImpl$2(boolean z, float f, float f2, List<Float> list, SliderColors sliderColors, float f3, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, int i, int i2) {
        super(2);
        this.$enabled = z;
        this.$positionFractionStart = f;
        this.$positionFractionEnd = f2;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$width = f3;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$modifier = modifier;
        this.$startThumbSemantics = modifier2;
        this.$endThumbSemantics = modifier3;
        this.$$changed = i;
        this.$$changed1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        SliderKt.access$RangeSliderImpl(this.$enabled, this.$positionFractionStart, this.$positionFractionEnd, this.$tickFractions, this.$colors, this.$width, this.$startInteractionSource, this.$endInteractionSource, this.$modifier, this.$startThumbSemantics, this.$endThumbSemantics, composer, this.$$changed | 1, this.$$changed1);
    }
}
