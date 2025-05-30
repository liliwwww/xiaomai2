package androidx.compose.ui.graphics.colorspace;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class Rgb$oetf$1 extends Lambda implements Function1<Double, Double> {
    final /* synthetic */ Rgb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Rgb$oetf$1(Rgb rgb) {
        super(1);
        this.this$0 = rgb;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }

    @NotNull
    public final Double invoke(double d) {
        return Double.valueOf(RangesKt.coerceIn(this.this$0.getOetfOrig$ui_graphics_release().invoke(d), Rgb.access$getMin$p(this.this$0), Rgb.access$getMax$p(this.this$0)));
    }
}
