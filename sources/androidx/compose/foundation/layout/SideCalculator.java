package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.unit.Velocity;
import androidx.compose.p004ui.unit.VelocityKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: classes.dex */
interface SideCalculator {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final SideCalculator$Companion$LeftSideCalculator$1 LeftSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$LeftSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            @NotNull
            public Insets adjustInsets(@NotNull Insets insets, int i) {
                Intrinsics.checkNotNullParameter(insets, "oldInsets");
                Insets of = Insets.of(i, insets.top, insets.right, insets.bottom);
                Intrinsics.checkNotNullExpressionValue(of, "of(newValue, oldInsets.t….right, oldInsets.bottom)");
                return of;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedOffsets-MK-Hz9U */
            public long mo1418consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p004ui.geometry.OffsetKt.Offset(Offset.m2556getXimpl(j), 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo1419consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(Velocity.m5441getXimpl(j) - f, 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f, float f2) {
                return C0501a.m63a(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return f;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f, float f2) {
                return C0501a.m64b(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.left;
            }
        };

        @NotNull
        private static final SideCalculator$Companion$TopSideCalculator$1 TopSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$TopSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            @NotNull
            public Insets adjustInsets(@NotNull Insets insets, int i) {
                Intrinsics.checkNotNullParameter(insets, "oldInsets");
                Insets of = Insets.of(insets.left, i, insets.right, insets.bottom);
                Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, newVa….right, oldInsets.bottom)");
                return of;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedOffsets-MK-Hz9U */
            public long mo1418consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p004ui.geometry.OffsetKt.Offset(0.0f, Offset.m2557getYimpl(j));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo1419consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(0.0f, Velocity.m5442getYimpl(j) - f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f, float f2) {
                return C0501a.m63a(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return f2;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f, float f2) {
                return C0501a.m64b(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.top;
            }
        };

        @NotNull
        private static final SideCalculator$Companion$RightSideCalculator$1 RightSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$RightSideCalculator$1
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
            public long mo1418consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p004ui.geometry.OffsetKt.Offset(Offset.m2556getXimpl(j), 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo1419consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(Velocity.m5441getXimpl(j) + f, 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f, float f2) {
                return C0501a.m63a(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return -f;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f, float f2) {
                return C0501a.m64b(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.right;
            }
        };

        @NotNull
        private static final SideCalculator$Companion$BottomSideCalculator$1 BottomSideCalculator = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$BottomSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            @NotNull
            public Insets adjustInsets(@NotNull Insets insets, int i) {
                Intrinsics.checkNotNullParameter(insets, "oldInsets");
                Insets of = Insets.of(insets.left, insets.top, insets.right, i);
                Intrinsics.checkNotNullExpressionValue(of, "of(oldInsets.left, oldIn…ldInsets.right, newValue)");
                return of;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedOffsets-MK-Hz9U */
            public long mo1418consumedOffsetsMKHz9U(long j) {
                return androidx.compose.p004ui.geometry.OffsetKt.Offset(0.0f, Offset.m2557getYimpl(j));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            /* renamed from: consumedVelocity-QWom1Mo */
            public long mo1419consumedVelocityQWom1Mo(long j, float f) {
                return VelocityKt.Velocity(0.0f, Velocity.m5442getYimpl(j) + f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float hideMotion(float f, float f2) {
                return C0501a.m63a(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float motionOf(float f, float f2) {
                return -f2;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public /* synthetic */ float showMotion(float f, float f2) {
                return C0501a.m64b(this, f, f2);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int valueOf(@NotNull Insets insets) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                return insets.bottom;
            }
        };

        private Companion() {
        }

        @NotNull
        /* renamed from: chooseCalculator-ni1skBw, reason: not valid java name */
        public final SideCalculator m1420chooseCalculatorni1skBw(int i, @NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            WindowInsetsSides.Companion companion = WindowInsetsSides.Companion;
            if (WindowInsetsSides.m1462equalsimpl0(i, companion.m1476getLeftJoeWqyM())) {
                return LeftSideCalculator;
            }
            if (WindowInsetsSides.m1462equalsimpl0(i, companion.m1479getTopJoeWqyM())) {
                return TopSideCalculator;
            }
            if (WindowInsetsSides.m1462equalsimpl0(i, companion.m1477getRightJoeWqyM())) {
                return RightSideCalculator;
            }
            if (WindowInsetsSides.m1462equalsimpl0(i, companion.m1473getBottomJoeWqyM())) {
                return BottomSideCalculator;
            }
            if (WindowInsetsSides.m1462equalsimpl0(i, companion.m1478getStartJoeWqyM())) {
                return layoutDirection == LayoutDirection.Ltr ? LeftSideCalculator : RightSideCalculator;
            }
            if (WindowInsetsSides.m1462equalsimpl0(i, companion.m1474getEndJoeWqyM())) {
                return layoutDirection == LayoutDirection.Ltr ? RightSideCalculator : LeftSideCalculator;
            }
            throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
        }
    }

    @NotNull
    Insets adjustInsets(@NotNull Insets insets, int i);

    /* renamed from: consumedOffsets-MK-Hz9U, reason: not valid java name */
    long mo1418consumedOffsetsMKHz9U(long j);

    /* renamed from: consumedVelocity-QWom1Mo, reason: not valid java name */
    long mo1419consumedVelocityQWom1Mo(long j, float f);

    float hideMotion(float f, float f2);

    float motionOf(float f, float f2);

    float showMotion(float f, float f2);

    int valueOf(@NotNull Insets insets);
}
