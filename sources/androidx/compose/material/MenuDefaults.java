package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class MenuDefaults {
    public static final int $stable = 0;

    @NotNull
    private static final PaddingValues DropdownMenuItemContentPadding;

    @NotNull
    public static final MenuDefaults INSTANCE = new MenuDefaults();

    static {
        float f;
        f = MenuKt.DropdownMenuItemHorizontalPadding;
        DropdownMenuItemContentPadding = PaddingKt.m1388PaddingValuesYgX7TsA(f, C0856Dp.m5216constructorimpl(0));
    }

    private MenuDefaults() {
    }

    @NotNull
    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }
}
