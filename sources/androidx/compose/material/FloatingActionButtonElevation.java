package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public interface FloatingActionButtonElevation {
    @Composable
    @NotNull
    State<C0856Dp> elevation(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i);
}
