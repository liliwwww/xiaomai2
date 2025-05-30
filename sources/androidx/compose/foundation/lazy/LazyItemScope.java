package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LazyScopeMarker
@Stable
/* loaded from: classes2.dex */
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
