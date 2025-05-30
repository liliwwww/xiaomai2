package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1$1 implements FlowCollector<Float> {
    final /* synthetic */ MotionDurationScaleImpl $it;

    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1$1$1$1(MotionDurationScaleImpl motionDurationScaleImpl) {
        this.$it = motionDurationScaleImpl;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit(((Number) obj).floatValue(), (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(float f, @NotNull Continuation<? super Unit> continuation) {
        this.$it.setScaleFactor(f);
        return Unit.INSTANCE;
    }
}
