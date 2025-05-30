package androidx.compose.foundation;

import androidx.compose.foundation.IndicationKt$indication$;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class IndicationKt {

    @NotNull
    private static final ProvidableCompositionLocal<Indication> LocalIndication = CompositionLocalKt.staticCompositionLocalOf(LocalIndication.1.INSTANCE);

    @NotNull
    public static final ProvidableCompositionLocal<Indication> getLocalIndication() {
        return LocalIndication;
    }

    @NotNull
    public static final Modifier indication(@NotNull Modifier modifier, @NotNull InteractionSource interactionSource, @Nullable Indication indication) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new IndicationKt$indication$.inlined.debugInspectorInfo.1(indication, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new indication.2(indication, interactionSource));
    }
}
