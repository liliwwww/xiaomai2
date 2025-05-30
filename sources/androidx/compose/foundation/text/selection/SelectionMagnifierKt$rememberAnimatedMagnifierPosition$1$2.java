package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2 implements FlowCollector<Offset> {
    final /* synthetic */ Animatable<Offset, AnimationVector2D> $animatable;
    final /* synthetic */ CoroutineScope $animationScope;

    SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2(Animatable<Offset, AnimationVector2D> animatable, CoroutineScope coroutineScope) {
        this.$animatable = animatable;
        this.$animationScope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return m468emit3MmeM6k(((Offset) obj).m858unboximpl(), continuation);
    }

    @Nullable
    /* renamed from: emit-3MmeM6k, reason: not valid java name */
    public final Object m468emit3MmeM6k(long j, @NotNull Continuation<? super Unit> continuation) {
        if (OffsetKt.isSpecified-k-4lQ0M(this.$animatable.getValue().m858unboximpl()) && OffsetKt.isSpecified-k-4lQ0M(j)) {
            if (!(Offset.m849getYimpl(this.$animatable.getValue().m858unboximpl()) == Offset.m849getYimpl(j))) {
                d.d(this.$animationScope, (CoroutineContext) null, (CoroutineStart) null, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(this.$animatable, j, null), 3, (Object) null);
                return Unit.INSTANCE;
            }
        }
        Object snapTo = this.$animatable.snapTo(Offset.m837boximpl(j), continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }
}
