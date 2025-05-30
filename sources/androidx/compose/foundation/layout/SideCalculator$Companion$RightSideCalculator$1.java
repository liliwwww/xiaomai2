package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SideCalculator$Companion$RightSideCalculator$1 implements SideCalculator {
    SideCalculator$Companion$RightSideCalculator$1() {
    }

    @Override // androidx.compose.foundation.layout.SideCalculator
    @NotNull
    public Insets adjustInsets(@NotNull Insets insets, int i) {
        Intrinsics.checkNotNullParameter(insets, "oldInsets");
        Insets of = Insets.of(insets.left, insets.top, i, insets.bottom);
        Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, oldIn…wValue, oldInsets.bottom)");
        return of;
    }

    @Override // androidx.compose.foundation.layout.SideCalculator
    /* renamed from: consumedOffsets-MK-Hz9U */
    public long mo237consumedOffsetsMKHz9U(long j) {
        return OffsetKt.Offset(Offset.m848getXimpl(j), 0.0f);
    }

    @Override // androidx.compose.foundation.layout.SideCalculator
    /* renamed from: consumedVelocity-QWom1Mo */
    public long mo238consumedVelocityQWom1Mo(long j, float f) {
        return VelocityKt.Velocity(Velocity.getX-impl(j) + f, 0.0f);
    }

    @Override // androidx.compose.foundation.layout.SideCalculator
    public /* synthetic */ float hideMotion(float f, float f2) {
        return a.a(this, f, f2);
    }

    @Override // androidx.compose.foundation.layout.SideCalculator
    public float motionOf(float f, float f2) {
        return -f;
    }

    @Override // androidx.compose.foundation.layout.SideCalculator
    public /* synthetic */ float showMotion(float f, float f2) {
        return a.b(this, f, f2);
    }

    @Override // androidx.compose.foundation.layout.SideCalculator
    public int valueOf(@NotNull Insets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        return insets.right;
    }
}
