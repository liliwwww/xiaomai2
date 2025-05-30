package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SwipeableKt$swipeable$3$3$1 extends Lambda implements Function2<Float, Float, Float> {
    final /* synthetic */ Map<Float, T> $anchors;
    final /* synthetic */ Density $density;
    final /* synthetic */ Function2<T, T, ThresholdConfig> $thresholds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SwipeableKt$swipeable$3$3$1(Map<Float, ? extends T> map, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, Density density) {
        super(2);
        this.$anchors = map;
        this.$thresholds = function2;
        this.$density = density;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
    }

    @NotNull
    public final Float invoke(float f, float f2) {
        return Float.valueOf(((ThresholdConfig) this.$thresholds.invoke(MapsKt.getValue(this.$anchors, Float.valueOf(f)), MapsKt.getValue(this.$anchors, Float.valueOf(f2)))).computeThreshold(this.$density, f, f2));
    }
}
