package androidx.compose.p004ui.input.rotary;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.ModifierNodeElement;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class RotaryInputModifierKt {
    @NotNull
    public static final Modifier onPreRotaryScrollEvent(@NotNull Modifier modifier, @NotNull final Function1<? super RotaryScrollEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onPreRotaryScrollEvent");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$modifierElementOf$1
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
                inspectorInfo.setName("onPreRotaryScrollEvent");
                inspectorInfo.getProperties().set("onPreRotaryScrollEvent", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<RotaryInputModifierNodeImpl>(function1, noInspectorInfo) { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$modifierElementOf$2
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public RotaryInputModifierNodeImpl create() {
                return new RotaryInputModifierNodeImpl(null, function1);
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public RotaryInputModifierNodeImpl update(@NotNull RotaryInputModifierNodeImpl rotaryInputModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(rotaryInputModifierNodeImpl, "node");
                rotaryInputModifierNodeImpl.setOnPreEvent(function1);
                return rotaryInputModifierNodeImpl;
            }
        });
    }

    @NotNull
    public static final Modifier onRotaryScrollEvent(@NotNull Modifier modifier, @NotNull final Function1<? super RotaryScrollEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onRotaryScrollEvent");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onRotaryScrollEvent$$inlined$modifierElementOf$1
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
                inspectorInfo.setName("onRotaryScrollEvent");
                inspectorInfo.getProperties().set("onRotaryScrollEvent", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<RotaryInputModifierNodeImpl>(function1, noInspectorInfo) { // from class: androidx.compose.ui.input.rotary.RotaryInputModifierKt$onRotaryScrollEvent$$inlined$modifierElementOf$2
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public RotaryInputModifierNodeImpl create() {
                return new RotaryInputModifierNodeImpl(function1, null);
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public RotaryInputModifierNodeImpl update(@NotNull RotaryInputModifierNodeImpl rotaryInputModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(rotaryInputModifierNodeImpl, "node");
                rotaryInputModifierNodeImpl.setOnEvent(function1);
                return rotaryInputModifierNodeImpl;
            }
        });
    }
}
