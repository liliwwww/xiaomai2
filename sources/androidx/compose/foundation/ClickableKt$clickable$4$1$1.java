package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.ScrollContainerInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ClickableKt$clickable$4$1$1 extends Lambda implements Function1<ScrollContainerInfo, Unit> {
    final /* synthetic */ MutableState<Function0<Boolean>> $delayPressInteraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4$1$1(MutableState<Function0<Boolean>> mutableState) {
        super(1);
        this.$delayPressInteraction = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ScrollContainerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ScrollContainerInfo scrollContainerInfo) {
        this.$delayPressInteraction.setValue(new 1(scrollContainerInfo));
    }
}
