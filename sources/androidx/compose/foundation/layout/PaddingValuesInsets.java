package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class PaddingValuesInsets implements WindowInsets {

    @NotNull
    private final PaddingValues paddingValues;

    public PaddingValuesInsets(@NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PaddingValuesInsets) {
            return Intrinsics.areEqual(((PaddingValuesInsets) obj).paddingValues, this.paddingValues);
        }
        return false;
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.roundToPx-0680j_4(this.paddingValues.calculateBottomPadding-D9Ej5fM());
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.roundToPx-0680j_4(this.paddingValues.calculateLeftPadding-u2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.roundToPx-0680j_4(this.paddingValues.calculateRightPadding-u2uoSUM(layoutDirection));
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.roundToPx-0680j_4(this.paddingValues.calculateTopPadding-D9Ej5fM());
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    @NotNull
    public String toString() {
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        return "PaddingValues(" + ((Object) Dp.toString-impl(this.paddingValues.calculateLeftPadding-u2uoSUM(layoutDirection))) + ", " + ((Object) Dp.toString-impl(this.paddingValues.calculateTopPadding-D9Ej5fM())) + ", " + ((Object) Dp.toString-impl(this.paddingValues.calculateRightPadding-u2uoSUM(layoutDirection))) + ", " + ((Object) Dp.toString-impl(this.paddingValues.calculateBottomPadding-D9Ej5fM())) + ')';
    }
}
