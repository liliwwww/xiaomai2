package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ MouseSelectionObserver $observer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextSelectionMouseDetectorKt$mouseSelectionDetector$2$1(MouseSelectionObserver mouseSelectionObserver) {
        super(1);
        this.$observer = mouseSelectionObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "it");
        if (this.$observer.onExtendDrag-k-4lQ0M(pointerInputChange.m1465getPositionF1C5BW0())) {
            pointerInputChange.consume();
        }
    }
}
