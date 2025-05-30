package androidx.compose.material;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2 INSTANCE = new ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2();

    ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
        Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
        keyframesSpecConfig.setDurationMillis(1800);
        keyframesSpecConfig.with(keyframesSpecConfig.at(Float.valueOf(0.0f), 1000), ProgressIndicatorKt.access$getSecondLineHeadEasing$p());
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1567);
    }
}
