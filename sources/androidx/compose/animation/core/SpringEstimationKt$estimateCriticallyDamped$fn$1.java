package androidx.compose.animation.core;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SpringEstimationKt$estimateCriticallyDamped$fn$1 extends Lambda implements Function1<Double, Double> {
    final /* synthetic */ double $c1;
    final /* synthetic */ double $c2;
    final /* synthetic */ double $r;
    final /* synthetic */ double $signedDelta;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SpringEstimationKt$estimateCriticallyDamped$fn$1(double d, double d2, double d3, double d4) {
        super(1);
        this.$c1 = d;
        this.$c2 = d2;
        this.$r = d3;
        this.$signedDelta = d4;
    }

    @NotNull
    public final Double invoke(double d) {
        return Double.valueOf(((this.$c1 + (this.$c2 * d)) * Math.exp(this.$r * d)) + this.$signedDelta);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }
}
