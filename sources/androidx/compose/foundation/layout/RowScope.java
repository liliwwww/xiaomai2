package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LayoutScopeMarker
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface RowScope {
    @Stable
    @NotNull
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment$Vertical alignment$Vertical);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull HorizontalAlignmentLine horizontalAlignmentLine);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull Function1<? super Measured, Integer> function1);

    @Stable
    @NotNull
    Modifier alignByBaseline(@NotNull Modifier modifier);

    @Stable
    @NotNull
    Modifier weight(@NotNull Modifier modifier, float f, boolean z);
}
