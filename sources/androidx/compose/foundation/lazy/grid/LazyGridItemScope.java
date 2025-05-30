package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@LazyGridScopeMarker
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface LazyGridItemScope {
    @ExperimentalFoundationApi
    @NotNull
    Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec);
}
