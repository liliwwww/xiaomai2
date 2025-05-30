package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LimitInsets implements WindowInsets {

    @NotNull
    private final WindowInsets insets;
    private final int sides;

    private LimitInsets(WindowInsets windowInsets, int i) {
        this.insets = windowInsets;
        this.sides = i;
    }

    public /* synthetic */ LimitInsets(WindowInsets windowInsets, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowInsets, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LimitInsets)) {
            return false;
        }
        LimitInsets limitInsets = (LimitInsets) obj;
        return Intrinsics.areEqual(this.insets, limitInsets.insets) && WindowInsetsSides.equals-impl0(this.sides, limitInsets.sides);
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.getBottom-JoeWqyM())) {
            return this.insets.getBottom(density);
        }
        return 0;
    }

    @NotNull
    public final WindowInsets getInsets() {
        return this.insets;
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, layoutDirection == LayoutDirection.Ltr ? WindowInsetsSides.Companion.getAllowLeftInLtr-JoeWqyM$foundation_layout_release() : WindowInsetsSides.Companion.getAllowLeftInRtl-JoeWqyM$foundation_layout_release())) {
            return this.insets.getLeft(density, layoutDirection);
        }
        return 0;
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, layoutDirection == LayoutDirection.Ltr ? WindowInsetsSides.Companion.getAllowRightInLtr-JoeWqyM$foundation_layout_release() : WindowInsetsSides.Companion.getAllowRightInRtl-JoeWqyM$foundation_layout_release())) {
            return this.insets.getRight(density, layoutDirection);
        }
        return 0;
    }

    /* renamed from: getSides-JoeWqyM, reason: not valid java name */
    public final int m209getSidesJoeWqyM() {
        return this.sides;
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        if (WindowInsetsSides.hasAny-bkgdKaI$foundation_layout_release(this.sides, WindowInsetsSides.Companion.getTop-JoeWqyM())) {
            return this.insets.getTop(density);
        }
        return 0;
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + WindowInsetsSides.hashCode-impl(this.sides);
    }

    @NotNull
    public String toString() {
        return '(' + this.insets + " only " + ((Object) WindowInsetsSides.toString-impl(this.sides)) + ')';
    }
}
