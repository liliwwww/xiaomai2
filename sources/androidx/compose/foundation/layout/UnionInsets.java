package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class UnionInsets implements WindowInsets {

    @NotNull
    private final WindowInsets first;

    @NotNull
    private final WindowInsets second;

    public UnionInsets(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        Intrinsics.checkNotNullParameter(windowInsets, "first");
        Intrinsics.checkNotNullParameter(windowInsets2, "second");
        this.first = windowInsets;
        this.second = windowInsets2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnionInsets)) {
            return false;
        }
        UnionInsets unionInsets = (UnionInsets) obj;
        return Intrinsics.areEqual(unionInsets.first, this.first) && Intrinsics.areEqual(unionInsets.second, this.second);
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return Math.max(this.first.getBottom(density), this.second.getBottom(density));
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return Math.max(this.first.getLeft(density, layoutDirection), this.second.getLeft(density, layoutDirection));
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return Math.max(this.first.getRight(density, layoutDirection), this.second.getRight(density, layoutDirection));
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return Math.max(this.first.getTop(density), this.second.getTop(density));
    }

    public int hashCode() {
        return this.first.hashCode() + (this.second.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return '(' + this.first + " ∪ " + this.second + ')';
    }
}
