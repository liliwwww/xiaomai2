package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FocusChangedModifierKt {
    @NotNull
    public static final Modifier onFocusChanged(@NotNull Modifier modifier, @NotNull final Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onFocusChanged");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusChangedModifierKt$onFocusChanged$$inlined$modifierElementOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("onFocusChanged");
                inspectorInfo.getProperties().set("onFocusChanged", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<FocusChangedModifierNode>(function1, noInspectorInfo) { // from class: androidx.compose.ui.focus.FocusChangedModifierKt$onFocusChanged$$inlined$modifierElementOf$2
            @NotNull
            public FocusChangedModifierNode create() {
                return new FocusChangedModifierNode(function1);
            }

            @NotNull
            public FocusChangedModifierNode update(@NotNull FocusChangedModifierNode focusChangedModifierNode) {
                Intrinsics.checkNotNullParameter(focusChangedModifierNode, "node");
                focusChangedModifierNode.setOnFocusChanged(function1);
                return focusChangedModifierNode;
            }
        });
    }
}
