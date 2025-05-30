package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ColumnScopeInstance$weight$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ boolean $fill$inlined;
    final /* synthetic */ float $weight$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColumnScopeInstance$weight$$inlined$debugInspectorInfo$1(float f, boolean z) {
        super(1);
        this.$weight$inlined = f;
        this.$fill$inlined = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("weight");
        inspectorInfo.setValue(Float.valueOf(this.$weight$inlined));
        inspectorInfo.getProperties().set("weight", Float.valueOf(this.$weight$inlined));
        inspectorInfo.getProperties().set("fill", Boolean.valueOf(this.$fill$inlined));
    }
}
