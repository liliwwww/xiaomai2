package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.selection.SelectableKt$selectable-O2vRcR0$;
import androidx.compose.foundation.selection.SelectableKt$selectable-XHw0xAI$;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SelectableKt {
    @NotNull
    /* renamed from: selectable-O2vRcR0, reason: not valid java name */
    public static final Modifier m352selectableO2vRcR0(@NotNull Modifier modifier, final boolean z, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z2, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$selectable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectable-O2vRcR0$.inlined.debugInspectorInfo.1(z, mutableInteractionSource, indication, z2, role, function0) : InspectableValueKt.getNoInspectorInfo(), SemanticsModifierKt.semantics$default(ClickableKt.clickable-O2vRcR0$default(Modifier.Companion, mutableInteractionSource, indication, z2, (String) null, role, function0, 8, (Object) null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.selection.SelectableKt$selectable$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, z);
            }
        }, 1, null));
    }

    /* renamed from: selectable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m353selectableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function0 function0, int i, Object obj) {
        boolean z3 = (i & 8) != 0 ? true : z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m352selectableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, function0);
    }

    @NotNull
    /* renamed from: selectable-XHw0xAI, reason: not valid java name */
    public static final Modifier m354selectableXHw0xAI(@NotNull Modifier modifier, boolean z, boolean z2, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$selectable");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SelectableKt$selectable-XHw0xAI$.inlined.debugInspectorInfo.1(z, z2, role, function0) : InspectableValueKt.getNoInspectorInfo(), new selectable.2(z, z2, role, function0));
    }

    /* renamed from: selectable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m355selectableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m354selectableXHw0xAI(modifier, z, z2, role, function0);
    }
}
