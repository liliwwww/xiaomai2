package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.grid.LazyGridItemScopeImpl$animateItemPlacement$;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LazyGridItemScopeImpl implements LazyGridItemScope {

    @NotNull
    public static final LazyGridItemScopeImpl INSTANCE = new LazyGridItemScopeImpl();

    private LazyGridItemScopeImpl() {
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemScope
    @ExperimentalFoundationApi
    @NotNull
    public Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return modifier.then(new AnimateItemPlacementModifier(finiteAnimationSpec, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LazyGridItemScopeImpl$animateItemPlacement$.inlined.debugInspectorInfo.1(finiteAnimationSpec) : InspectableValueKt.getNoInspectorInfo()));
    }
}
