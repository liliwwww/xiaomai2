package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LayoutScopeMarker
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ColumnScope {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
    }

    @Stable
    @NotNull
    Modifier align(@NotNull Modifier modifier, @NotNull Alignment$Horizontal alignment$Horizontal);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull VerticalAlignmentLine verticalAlignmentLine);

    @Stable
    @NotNull
    Modifier alignBy(@NotNull Modifier modifier, @NotNull Function1<? super Measured, Integer> function1);

    @Stable
    @NotNull
    Modifier weight(@NotNull Modifier modifier, float f, boolean z);
}
