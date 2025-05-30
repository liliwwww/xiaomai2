package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$2 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function1 $alignmentLineBlock$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$2(Function1 function1) {
        super(1);
        this.$alignmentLineBlock$inlined = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("alignBy");
        inspectorInfo.setValue(this.$alignmentLineBlock$inlined);
    }
}
