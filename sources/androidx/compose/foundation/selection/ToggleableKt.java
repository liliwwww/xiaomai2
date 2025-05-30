package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$;
import androidx.compose.foundation.selection.ToggleableKt$triStateToggleable-O2vRcR0$;
import androidx.compose.foundation.selection.ToggleableKt$triStateToggleable-XHw0xAI$;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ToggleableKt {
    @NotNull
    /* renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m356toggleableO2vRcR0(@NotNull Modifier modifier, final boolean z, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z2, @Nullable Role role, @NotNull final Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "$this$toggleable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleable-O2vRcR0$.inlined.debugInspectorInfo.1(z, mutableInteractionSource, indication, z2, role, function1) : InspectableValueKt.getNoInspectorInfo(), m360triStateToggleableO2vRcR0(Modifier.Companion, ToggleableStateKt.ToggleableState(z), mutableInteractionSource, indication, z2, role, new Function0<Unit>() { // from class: androidx.compose.foundation.selection.ToggleableKt$toggleable$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m364invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m364invoke() {
                function1.invoke(Boolean.valueOf(!z));
            }
        }));
    }

    /* renamed from: toggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m357toggleableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1 function1, int i, Object obj) {
        boolean z3 = (i & 8) != 0 ? true : z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m356toggleableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, function1);
    }

    @NotNull
    /* renamed from: toggleable-XHw0xAI, reason: not valid java name */
    public static final Modifier m358toggleableXHw0xAI(@NotNull Modifier modifier, final boolean z, final boolean z2, @Nullable final Role role, @NotNull final Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "$this$toggleable");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.selection.ToggleableKt$toggleable-XHw0xAI$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("toggleable");
                inspectorInfo.getProperties().set("value", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onValueChange", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new toggleable.2(z, z2, role, function1));
    }

    /* renamed from: toggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m359toggleableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m358toggleableXHw0xAI(modifier, z, z2, role, function1);
    }

    @NotNull
    /* renamed from: triStateToggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m360triStateToggleableO2vRcR0(@NotNull Modifier modifier, @NotNull ToggleableState toggleableState, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, boolean z, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleable-O2vRcR0$.inlined.debugInspectorInfo.1(toggleableState, z, role, mutableInteractionSource, indication, function0) : InspectableValueKt.getNoInspectorInfo(), SemanticsModifierKt.semantics$default(ClickableKt.clickable-O2vRcR0$default(Modifier.Companion, mutableInteractionSource, indication, z, (String) null, role, function0, 8, (Object) null), false, new triStateToggleable.4.1(toggleableState), 1, null));
    }

    /* renamed from: triStateToggleable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m361triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0 function0, int i, Object obj) {
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            role = null;
        }
        return m360triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z2, role, function0);
    }

    @NotNull
    /* renamed from: triStateToggleable-XHw0xAI, reason: not valid java name */
    public static final Modifier m362triStateToggleableXHw0xAI(@NotNull Modifier modifier, @NotNull ToggleableState toggleableState, boolean z, @Nullable Role role, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(toggleableState, "state");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleable-XHw0xAI$.inlined.debugInspectorInfo.1(toggleableState, z, role, function0) : InspectableValueKt.getNoInspectorInfo(), new triStateToggleable.2(toggleableState, z, role, function0));
    }

    /* renamed from: triStateToggleable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m363triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m362triStateToggleableXHw0xAI(modifier, toggleableState, z, role, function0);
    }
}
