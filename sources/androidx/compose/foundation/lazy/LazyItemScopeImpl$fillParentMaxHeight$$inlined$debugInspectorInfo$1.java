package androidx.compose.foundation.lazy;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LazyItemScopeImpl$fillParentMaxHeight$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $fraction$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyItemScopeImpl$fillParentMaxHeight$$inlined$debugInspectorInfo$1(float f) {
        super(1);
        this.$fraction$inlined = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("fillParentMaxHeight");
        inspectorInfo.setValue(Float.valueOf(this.$fraction$inlined));
    }
}
