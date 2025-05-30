package androidx.compose.ui.input.key;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class KeyInputModifierKt$onKeyEvent$$inlined$modifierElementOf$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function1 $onKeyEvent$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyInputModifierKt$onKeyEvent$$inlined$modifierElementOf$1(Function1 function1) {
        super(1);
        this.$onKeyEvent$inlined = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("onKeyEvent");
        inspectorInfo.getProperties().set("onKeyEvent", this.$onKeyEvent$inlined);
    }
}
