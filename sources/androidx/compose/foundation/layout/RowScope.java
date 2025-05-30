package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.HorizontalAlignmentLine;
import androidx.compose.p004ui.layout.Measured;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LayoutScopeMarker
@Immutable
/* loaded from: classes.dex */
public interface RowScope {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
    }

    @Stable
    @NotNull
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment.Vertical vertical);

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
