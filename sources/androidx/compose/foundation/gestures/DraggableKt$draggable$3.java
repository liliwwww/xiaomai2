package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DraggableKt$draggable$3 extends Lambda implements Function1<PointerInputChange, Boolean> {
    public static final DraggableKt$draggable$3 INSTANCE = new DraggableKt$draggable$3();

    DraggableKt$draggable$3() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "it");
        return Boolean.TRUE;
    }
}
