package androidx.compose.p004ui.input.key;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.ModifierNodeElement;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class KeyInputModifierKt {
    @NotNull
    public static final Modifier onKeyEvent(@NotNull Modifier modifier, @NotNull final Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onKeyEvent");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.key.KeyInputModifierKt$onKeyEvent$$inlined$modifierElementOf$1
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
                inspectorInfo.setName("onKeyEvent");
                inspectorInfo.getProperties().set("onKeyEvent", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<KeyInputInputModifierNodeImpl>(function1, noInspectorInfo) { // from class: androidx.compose.ui.input.key.KeyInputModifierKt$onKeyEvent$$inlined$modifierElementOf$2
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public KeyInputInputModifierNodeImpl create() {
                return new KeyInputInputModifierNodeImpl(function1, null);
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public KeyInputInputModifierNodeImpl update(@NotNull KeyInputInputModifierNodeImpl keyInputInputModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(keyInputInputModifierNodeImpl, "node");
                keyInputInputModifierNodeImpl.setOnEvent(function1);
                return keyInputInputModifierNodeImpl;
            }
        });
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
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public KeyInputInputModifierNodeImpl create() {
                return new KeyInputInputModifierNodeImpl(null, function1);
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public KeyInputInputModifierNodeImpl update(@NotNull KeyInputInputModifierNodeImpl keyInputInputModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(keyInputInputModifierNodeImpl, "node");
                keyInputInputModifierNodeImpl.setOnPreEvent(function1);
                return keyInputInputModifierNodeImpl;
            }
        });
    }
}
