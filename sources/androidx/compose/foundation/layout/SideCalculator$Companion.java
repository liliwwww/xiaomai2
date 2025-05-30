package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SideCalculator$Companion {
    static final /* synthetic */ SideCalculator$Companion $$INSTANCE = new SideCalculator$Companion();

    @NotNull
    private static final SideCalculator$Companion$LeftSideCalculator$1 LeftSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$LeftSideCalculator$1
        @NotNull
        public Insets adjustInsets(@NotNull Insets insets, int i) {
            Intrinsics.checkNotNullParameter(insets, "oldInsets");
            Insets of = Insets.of(i, insets.top, insets.right, insets.bottom);
            Intrinsics.checkNotNullExpressionValue(of, "of(newValue, oldInsets.t….right, oldInsets.bottom)");
            return of;
        }

        /* renamed from: consumedOffsets-MK-Hz9U, reason: not valid java name */
        public long m354consumedOffsetsMKHz9U(long j) {
            return androidx.compose.ui.geometry.OffsetKt.Offset(Offset.getX-impl(j), 0.0f);
        }

        /* renamed from: consumedVelocity-QWom1Mo, reason: not valid java name */
        public long m355consumedVelocityQWom1Mo(long j, float f) {
            return VelocityKt.Velocity(Velocity.m2710getXimpl(j) - f, 0.0f);
        }

        public /* synthetic */ float hideMotion(float f, float f2) {
            return a.a(this, f, f2);
        }

        public float motionOf(float f, float f2) {
            return f;
        }

        public /* synthetic */ float showMotion(float f, float f2) {
            return a.b(this, f, f2);
        }

        public int valueOf(@NotNull Insets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            return insets.left;
        }
    };

    @NotNull
    private static final SideCalculator$Companion$TopSideCalculator$1 TopSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$TopSideCalculator$1
        @NotNull
        public Insets adjustInsets(@NotNull Insets insets, int i) {
            Intrinsics.checkNotNullParameter(insets, "oldInsets");
            Insets of = Insets.of(insets.left, i, insets.right, insets.bottom);
            Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, newVa….right, oldInsets.bottom)");
            return of;
        }

        /* renamed from: consumedOffsets-MK-Hz9U, reason: not valid java name */
        public long m356consumedOffsetsMKHz9U(long j) {
            return androidx.compose.ui.geometry.OffsetKt.Offset(0.0f, Offset.getY-impl(j));
        }

        /* renamed from: consumedVelocity-QWom1Mo, reason: not valid java name */
        public long m357consumedVelocityQWom1Mo(long j, float f) {
            return VelocityKt.Velocity(0.0f, Velocity.m2711getYimpl(j) - f);
        }

        public /* synthetic */ float hideMotion(float f, float f2) {
            return a.a(this, f, f2);
        }

        public float motionOf(float f, float f2) {
            return f2;
        }

        public /* synthetic */ float showMotion(float f, float f2) {
            return a.b(this, f, f2);
        }

        public int valueOf(@NotNull Insets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            return insets.top;
        }
    };

    @NotNull
    private static final RightSideCalculator.1 RightSideCalculator = new RightSideCalculator.1();

    @NotNull
    private static final SideCalculator$Companion$BottomSideCalculator$1 BottomSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$BottomSideCalculator$1
        @NotNull
        public Insets adjustInsets(@NotNull Insets insets, int i) {
            Intrinsics.checkNotNullParameter(insets, "oldInsets");
            Insets of = Insets.of(insets.left, insets.top, insets.right, i);
            Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, oldIn…ldInsets.right, newValue)");
            return of;
        }

        /* renamed from: consumedOffsets-MK-Hz9U, reason: not valid java name */
        public long m352consumedOffsetsMKHz9U(long j) {
            return androidx.compose.ui.geometry.OffsetKt.Offset(0.0f, Offset.getY-impl(j));
        }

        /* renamed from: consumedVelocity-QWom1Mo, reason: not valid java name */
        public long m353consumedVelocityQWom1Mo(long j, float f) {
            return VelocityKt.Velocity(0.0f, Velocity.m2711getYimpl(j) + f);
        }

        public /* synthetic */ float hideMotion(float f, float f2) {
            return a.a(this, f, f2);
        }

        public float motionOf(float f, float f2) {
            return -f2;
        }

        public /* synthetic */ float showMotion(float f, float f2) {
            return a.b(this, f, f2);
        }

        public int valueOf(@NotNull Insets insets) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            return insets.bottom;
        }
    };

    private SideCalculator$Companion() {
    }

    @NotNull
    /* renamed from: chooseCalculator-ni1skBw, reason: not valid java name */
    public final SideCalculator m351chooseCalculatorni1skBw(int i, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        WindowInsetsSides.Companion companion = WindowInsetsSides.Companion;
        if (WindowInsetsSides.m396equalsimpl0(i, companion.m410getLeftJoeWqyM())) {
            return LeftSideCalculator;
        }
        if (WindowInsetsSides.m396equalsimpl0(i, companion.m413getTopJoeWqyM())) {
            return TopSideCalculator;
        }
        if (WindowInsetsSides.m396equalsimpl0(i, companion.m411getRightJoeWqyM())) {
            return RightSideCalculator;
        }
        if (WindowInsetsSides.m396equalsimpl0(i, companion.m407getBottomJoeWqyM())) {
            return BottomSideCalculator;
        }
        if (WindowInsetsSides.m396equalsimpl0(i, companion.m412getStartJoeWqyM())) {
            return layoutDirection == LayoutDirection.Ltr ? LeftSideCalculator : RightSideCalculator;
        }
        if (WindowInsetsSides.m396equalsimpl0(i, companion.m408getEndJoeWqyM())) {
            return layoutDirection == LayoutDirection.Ltr ? RightSideCalculator : LeftSideCalculator;
        }
        throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
    }
}
