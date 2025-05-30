package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NestedScrollModifierKt {
    @NotNull
    public static final Modifier nestedScroll(@NotNull Modifier modifier, @NotNull NestedScrollConnection nestedScrollConnection, @Nullable NestedScrollDispatcher nestedScrollDispatcher) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "connection");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new NestedScrollModifierKt$nestedScroll$.inlined.debugInspectorInfo.1(nestedScrollConnection, nestedScrollDispatcher) : InspectableValueKt.getNoInspectorInfo(), new nestedScroll.2(nestedScrollDispatcher, nestedScrollConnection));
    }

    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollConnection, nestedScrollDispatcher);
    }
}
