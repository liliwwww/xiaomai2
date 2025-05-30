package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeableState$performFling$2<T> implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ float $velocity;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$performFling$2(SwipeableState<T> swipeableState, float f) {
        this.this$0 = swipeableState;
        this.$velocity = f;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((Map) obj, (Continuation<? super Unit>) continuation);
    }

    @Nullable
    public final Object emit(@NotNull Map<Float, ? extends T> map, @NotNull Continuation<? super Unit> continuation) {
        Float access$getOffset = SwipeableKt.access$getOffset(map, this.this$0.getCurrentValue());
        Intrinsics.checkNotNull(access$getOffset);
        float floatValue = access$getOffset.floatValue();
        T t = map.get(Boxing.boxFloat(SwipeableKt.access$computeTarget(((Number) this.this$0.getOffset().getValue()).floatValue(), floatValue, map.keySet(), this.this$0.getThresholds$material_release(), this.$velocity, this.this$0.getVelocityThreshold$material_release())));
        if (t != null && ((Boolean) this.this$0.getConfirmStateChange$material_release().invoke(t)).booleanValue()) {
            Object animateTo$default = SwipeableState.animateTo$default(this.this$0, t, (AnimationSpec) null, continuation, 2, (Object) null);
            return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
        }
        SwipeableState<T> swipeableState = this.this$0;
        Object access$animateInternalToOffset = SwipeableState.access$animateInternalToOffset(swipeableState, floatValue, swipeableState.getAnimationSpec$material_release(), continuation);
        return access$animateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateInternalToOffset : Unit.INSTANCE;
    }
}
