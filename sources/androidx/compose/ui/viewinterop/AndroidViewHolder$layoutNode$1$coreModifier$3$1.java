package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.ScrollContainerInfo;
import androidx.compose.ui.input.ScrollContainerInfoKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AndroidViewHolder$layoutNode$1$coreModifier$3$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ScrollContainerInfo $scrollContainerInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$coreModifier$3$1(ScrollContainerInfo scrollContainerInfo) {
        super(0);
        this.$scrollContainerInfo = scrollContainerInfo;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Boolean m2241invoke() {
        ScrollContainerInfo scrollContainerInfo = this.$scrollContainerInfo;
        return Boolean.valueOf(scrollContainerInfo != null && ScrollContainerInfoKt.canScroll(scrollContainerInfo));
    }
}
