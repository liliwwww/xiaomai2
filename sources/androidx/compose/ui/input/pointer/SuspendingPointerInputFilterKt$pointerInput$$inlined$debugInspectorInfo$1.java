package androidx.compose.ui.input.pointer;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function2 $block$inlined;
    final /* synthetic */ Object $key1$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$1(Object obj, Function2 function2) {
        super(1);
        this.$key1$inlined = obj;
        this.$block$inlined = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("pointerInput");
        inspectorInfo.getProperties().set("key1", this.$key1$inlined);
        inspectorInfo.getProperties().set("block", this.$block$inlined);
    }
}
