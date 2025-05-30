package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultDraggableState implements DraggableState {

    @NotNull
    private final DragScope dragScope;

    @NotNull
    private final Function1<Float, Unit> onDelta;

    @NotNull
    private final MutatorMutex scrollMutex;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultDraggableState(@NotNull Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onDelta");
        this.onDelta = function1;
        this.dragScope = new DragScope() { // from class: androidx.compose.foundation.gestures.DefaultDraggableState$dragScope$1
            public void dragBy(float f) {
                DefaultDraggableState.this.getOnDelta().invoke(Float.valueOf(f));
            }
        };
        this.scrollMutex = new MutatorMutex();
    }

    public void dispatchRawDelta(float f) {
        this.onDelta.invoke(Float.valueOf(f));
    }

    @Nullable
    public Object drag(@NotNull MutatePriority mutatePriority, @NotNull Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        Object g = i80.g(new DefaultDraggableState$drag$2(this, mutatePriority, function2, null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }

    @NotNull
    public final Function1<Float, Unit> getOnDelta() {
        return this.onDelta;
    }
}
