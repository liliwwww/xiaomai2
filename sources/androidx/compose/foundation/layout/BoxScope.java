package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LayoutScopeMarker
@Immutable
/* loaded from: classes2.dex */
public interface BoxScope {
    @Stable
    @NotNull
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment);

    @Stable
    @NotNull
    Modifier matchParentSize(@NotNull Modifier modifier);
}
