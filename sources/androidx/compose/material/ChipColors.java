package androidx.compose.material;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalMaterialApi
/* loaded from: classes2.dex */
public interface ChipColors {
    @Composable
    @NotNull
    State<Color> backgroundColor(boolean z, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> contentColor(boolean z, @Nullable Composer composer, int i);

    @Composable
    @NotNull
    State<Color> leadingIconContentColor(boolean z, @Nullable Composer composer, int i);
}
