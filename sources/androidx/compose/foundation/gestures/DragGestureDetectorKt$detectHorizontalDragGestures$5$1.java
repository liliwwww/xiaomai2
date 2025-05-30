package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DragGestureDetectorKt$detectHorizontalDragGestures$5$1 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DragGestureDetectorKt$detectHorizontalDragGestures$5$1(Function2<? super PointerInputChange, ? super Float, Unit> function2) {
        super(1);
        this.$onHorizontalDrag = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "it");
        this.$onHorizontalDrag.invoke(pointerInputChange, Float.valueOf(Offset.m848getXimpl(PointerEventKt.positionChange(pointerInputChange))));
        pointerInputChange.consume();
    }
}
