package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.ZIndexModifierKt$zIndex$;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ZIndexModifierKt {
    @Stable
    @NotNull
    public static final Modifier zIndex(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return modifier.then(new ZIndexModifier(f, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ZIndexModifierKt$zIndex$.inlined.debugInspectorInfo.1(f) : InspectableValueKt.getNoInspectorInfo()));
    }
}
