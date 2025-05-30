package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollableKt$pointerScrollable$1 extends Lambda implements Function1<PointerInputChange, Boolean> {
    public static final ScrollableKt$pointerScrollable$1 INSTANCE = new ScrollableKt$pointerScrollable$1();

    ScrollableKt$pointerScrollable$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "down");
        return Boolean.valueOf(!PointerType.m2036equalsimpl0(pointerInputChange.getType-T8wyACA(), PointerType.Companion.getMouse-T8wyACA()));
    }
}
