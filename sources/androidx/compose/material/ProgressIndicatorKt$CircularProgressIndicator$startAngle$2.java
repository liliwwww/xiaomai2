package androidx.compose.material;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ProgressIndicatorKt$CircularProgressIndicator$startAngle$2 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final ProgressIndicatorKt$CircularProgressIndicator$startAngle$2 INSTANCE = new ProgressIndicatorKt$CircularProgressIndicator$startAngle$2();

    ProgressIndicatorKt$CircularProgressIndicator$startAngle$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
        keyframesSpecConfig.setDurationMillis(1332);
        keyframesSpecConfig.with(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorKt.access$getCircularEasing$p());
        keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
    }
}
