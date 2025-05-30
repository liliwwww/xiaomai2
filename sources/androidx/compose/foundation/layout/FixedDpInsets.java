package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FixedDpInsets implements WindowInsets {
    private final float bottomDp;
    private final float leftDp;
    private final float rightDp;
    private final float topDp;

    private FixedDpInsets(float f, float f2, float f3, float f4) {
        this.leftDp = f;
        this.topDp = f2;
        this.rightDp = f3;
        this.bottomDp = f4;
    }

    public /* synthetic */ FixedDpInsets(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDpInsets)) {
            return false;
        }
        FixedDpInsets fixedDpInsets = (FixedDpInsets) obj;
        return Dp.m2147equalsimpl0(this.leftDp, fixedDpInsets.leftDp) && Dp.m2147equalsimpl0(this.topDp, fixedDpInsets.topDp) && Dp.m2147equalsimpl0(this.rightDp, fixedDpInsets.rightDp) && Dp.m2147equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp);
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo319roundToPx0680j_4(this.bottomDp);
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.mo319roundToPx0680j_4(this.leftDp);
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.mo319roundToPx0680j_4(this.rightDp);
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo319roundToPx0680j_4(this.topDp);
    }

    public int hashCode() {
        return (((((Dp.m2148hashCodeimpl(this.leftDp) * 31) + Dp.m2148hashCodeimpl(this.topDp)) * 31) + Dp.m2148hashCodeimpl(this.rightDp)) * 31) + Dp.m2148hashCodeimpl(this.bottomDp);
    }

    @NotNull
    public String toString() {
        return "Insets(left=" + ((Object) Dp.m2153toStringimpl(this.leftDp)) + ", top=" + ((Object) Dp.m2153toStringimpl(this.topDp)) + ", right=" + ((Object) Dp.m2153toStringimpl(this.rightDp)) + ", bottom=" + ((Object) Dp.m2153toStringimpl(this.bottomDp)) + ')';
    }
}
