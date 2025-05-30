package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class InsetsPaddingValues implements PaddingValues {

    @NotNull
    private final Density density;

    @NotNull
    private final WindowInsets insets;

    public InsetsPaddingValues(@NotNull WindowInsets windowInsets, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        Intrinsics.checkNotNullParameter(density, "density");
        this.insets = windowInsets;
        this.density = density;
    }

    /* renamed from: calculateBottomPadding-D9Ej5fM, reason: not valid java name */
    public float m315calculateBottomPaddingD9Ej5fM() {
        Density density = this.density;
        return density.toDp-u2uoSUM(this.insets.getBottom(density));
    }

    /* renamed from: calculateLeftPadding-u2uoSUM, reason: not valid java name */
    public float m316calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Density density = this.density;
        return density.toDp-u2uoSUM(this.insets.getLeft(density, layoutDirection));
    }

    /* renamed from: calculateRightPadding-u2uoSUM, reason: not valid java name */
    public float m317calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Density density = this.density;
        return density.toDp-u2uoSUM(this.insets.getRight(density, layoutDirection));
    }

    /* renamed from: calculateTopPadding-D9Ej5fM, reason: not valid java name */
    public float m318calculateTopPaddingD9Ej5fM() {
        Density density = this.density;
        return density.toDp-u2uoSUM(this.insets.getTop(density));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsetsPaddingValues)) {
            return false;
        }
        InsetsPaddingValues insetsPaddingValues = (InsetsPaddingValues) obj;
        return Intrinsics.areEqual(this.insets, insetsPaddingValues.insets) && Intrinsics.areEqual(this.density, insetsPaddingValues.density);
    }

    @NotNull
    public final WindowInsets getInsets() {
        return this.insets;
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + this.density.hashCode();
    }

    @NotNull
    public String toString() {
        return "InsetsPaddingValues(insets=" + this.insets + ", density=" + this.density + ')';
    }
}
