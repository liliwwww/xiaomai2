package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.ScrollContainerInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidViewHolder$layoutNode$1$coreModifier$3 extends Lambda implements Function1<ScrollContainerInfo, Unit> {
    final /* synthetic */ AndroidViewHolder $this_run;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$coreModifier$3(AndroidViewHolder androidViewHolder) {
        super(1);
        this.$this_run = androidViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ScrollContainerInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ScrollContainerInfo scrollContainerInfo) {
        AndroidViewHolder.access$setInScrollContainer$p(this.$this_run, new 1(scrollContainerInfo));
    }
}
