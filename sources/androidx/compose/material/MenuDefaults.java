package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MenuDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final MenuDefaults INSTANCE = new MenuDefaults();

    @NotNull
    private static final PaddingValues DropdownMenuItemContentPadding = PaddingKt.m326PaddingValuesYgX7TsA(MenuKt.access$getDropdownMenuItemHorizontalPadding$p(), Dp.constructor-impl(0));

    private MenuDefaults() {
    }

    @NotNull
    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }
}
