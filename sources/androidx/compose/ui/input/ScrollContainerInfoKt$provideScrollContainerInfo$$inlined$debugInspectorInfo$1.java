package androidx.compose.ui.input;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ScrollContainerInfoKt$provideScrollContainerInfo$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ ScrollContainerInfo $scrollContainerInfo$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollContainerInfoKt$provideScrollContainerInfo$$inlined$debugInspectorInfo$1(ScrollContainerInfo scrollContainerInfo) {
        super(1);
        this.$scrollContainerInfo$inlined = scrollContainerInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("provideScrollContainerInfo");
        inspectorInfo.setValue(this.$scrollContainerInfo$inlined);
    }
}
