package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt$onKeyEvent$;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class KeyInputModifierKt {
    @NotNull
    public static final Modifier onKeyEvent(@NotNull Modifier modifier, @NotNull Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onKeyEvent");
        return modifier.then(new KeyInputModifierKt$onKeyEvent$.inlined.modifierElementOf.2(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new KeyInputModifierKt$onKeyEvent$.inlined.modifierElementOf.1(function1) : InspectableValueKt.getNoInspectorInfo(), function1, function1));
    }

    @NotNull
    public static final Modifier onPreviewKeyEvent(@NotNull Modifier modifier, @NotNull final Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onPreviewKeyEvent");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.key.KeyInputModifierKt$onPreviewKeyEvent$$inlined$modifierElementOf$1
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
                inspectorInfo.setName("onPreviewKeyEvent");
                inspectorInfo.getProperties().set("onPreviewKeyEvent", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<KeyInputInputModifierNodeImpl>(function1, noInspectorInfo) { // from class: androidx.compose.ui.input.key.KeyInputModifierKt$onPreviewKeyEvent$$inlined$modifierElementOf$2
            @NotNull
            public KeyInputInputModifierNodeImpl create() {
                return new KeyInputInputModifierNodeImpl((Function1) null, function1);
            }

            @NotNull
            public KeyInputInputModifierNodeImpl update(@NotNull KeyInputInputModifierNodeImpl keyInputInputModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(keyInputInputModifierNodeImpl, "node");
                keyInputInputModifierNodeImpl.setOnPreEvent(function1);
                return keyInputInputModifierNodeImpl;
            }
        });
    }
}
