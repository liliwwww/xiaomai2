package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DraggableKt$onDragOrUp$motionFromChange$2 extends Lambda implements Function1<PointerInputChange, Float> {
    public static final DraggableKt$onDragOrUp$motionFromChange$2 INSTANCE = new DraggableKt$onDragOrUp$motionFromChange$2();

    DraggableKt$onDragOrUp$motionFromChange$2() {
        super(1);
    }

    @NotNull
    public final Float invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "it");
        return Float.valueOf(Offset.m848getXimpl(PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange)));
    }
}
