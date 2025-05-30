package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LazyScopeMarker
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface LazyItemScope {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
    }

    @ExperimentalFoundationApi
    @NotNull
    Modifier animateItemPlacement(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec);

    @NotNull
    Modifier fillParentMaxHeight(@NotNull Modifier modifier, float f);

    @NotNull
    Modifier fillParentMaxSize(@NotNull Modifier modifier, float f);

    @NotNull
    Modifier fillParentMaxWidth(@NotNull Modifier modifier, float f);
}
