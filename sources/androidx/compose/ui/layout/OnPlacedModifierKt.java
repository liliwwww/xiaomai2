package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnPlacedModifierKt$onPlaced$;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class OnPlacedModifierKt {
    @Stable
    @NotNull
    public static final Modifier onPlaced(@NotNull Modifier modifier, @NotNull Function1<? super LayoutCoordinates, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onPlaced");
        return modifier.then(new OnPlacedModifierImpl(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OnPlacedModifierKt$onPlaced$.inlined.debugInspectorInfo.1(function1) : InspectableValueKt.getNoInspectorInfo()));
    }
}
