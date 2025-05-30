package androidx.compose.ui.modifier;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ ProvidableModifierLocal $key$inlined;
    final /* synthetic */ Function0 $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1(ProvidableModifierLocal providableModifierLocal, Function0 function0) {
        super(1);
        this.$key$inlined = providableModifierLocal;
        this.$value$inlined = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("modifierLocalProvider");
        inspectorInfo.getProperties().set("key", this.$key$inlined);
        inspectorInfo.getProperties().set("value", this.$value$inlined);
    }
}
