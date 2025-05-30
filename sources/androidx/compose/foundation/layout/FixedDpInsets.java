package androidx.compose.foundation.layout;

import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
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
        return C0856Dp.m5221equalsimpl0(this.leftDp, fixedDpInsets.leftDp) && C0856Dp.m5221equalsimpl0(this.topDp, fixedDpInsets.topDp) && C0856Dp.m5221equalsimpl0(this.rightDp, fixedDpInsets.rightDp) && C0856Dp.m5221equalsimpl0(this.bottomDp, fixedDpInsets.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo1277roundToPx0680j_4(this.bottomDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.mo1277roundToPx0680j_4(this.leftDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return density.mo1277roundToPx0680j_4(this.rightDp);
    }

    @Override // androidx.compose.foundation.layout.WindowInsets
    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo1277roundToPx0680j_4(this.topDp);
    }

    public int hashCode() {
        return (((((C0856Dp.m5222hashCodeimpl(this.leftDp) * 31) + C0856Dp.m5222hashCodeimpl(this.topDp)) * 31) + C0856Dp.m5222hashCodeimpl(this.rightDp)) * 31) + C0856Dp.m5222hashCodeimpl(this.bottomDp);
    }

    @NotNull
    public String toString() {
        return "Insets(left=" + ((Object) C0856Dp.m5227toStringimpl(this.leftDp)) + ", top=" + ((Object) C0856Dp.m5227toStringimpl(this.topDp)) + ", right=" + ((Object) C0856Dp.m5227toStringimpl(this.rightDp)) + ", bottom=" + ((Object) C0856Dp.m5227toStringimpl(this.bottomDp)) + ')';
    }
}
