package androidx.compose.ui.modifier;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalProviderKt$modifierLocalProvider$;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ModifierLocalProviderKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final <T> Modifier modifierLocalProvider(@NotNull Modifier modifier, @NotNull ProvidableModifierLocal<T> providableModifierLocal, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(providableModifierLocal, "key");
        Intrinsics.checkNotNullParameter(function0, "value");
        return modifier.then(new modifierLocalProvider.1(providableModifierLocal, function0, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ModifierLocalProviderKt$modifierLocalProvider$.inlined.debugInspectorInfo.1(providableModifierLocal, function0) : InspectableValueKt.getNoInspectorInfo()));
    }
}
