package androidx.compose.ui;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ZIndexModifierKt$zIndex$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $zIndex$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZIndexModifierKt$zIndex$$inlined$debugInspectorInfo$1(float f) {
        super(1);
        this.$zIndex$inlined = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("zIndex");
        inspectorInfo.setValue(Float.valueOf(this.$zIndex$inlined));
    }
}
