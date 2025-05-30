package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class SizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean enforceIncoming;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM() : f4, z, function1, null);
    }

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    /* renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m1448getTargetConstraintsOenEA2s(Density density) {
        int i;
        int coerceAtLeast;
        float f = this.maxWidth;
        C0856Dp.Companion companion = C0856Dp.Companion;
        int i2 = 0;
        int mo1277roundToPx0680j_4 = !C0856Dp.m5221equalsimpl0(f, companion.m5236getUnspecifiedD9Ej5fM()) ? density.mo1277roundToPx0680j_4(((C0856Dp) RangesKt.coerceAtLeast(C0856Dp.m5214boximpl(this.maxWidth), C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(0)))).m5230unboximpl()) : Integer.MAX_VALUE;
        int mo1277roundToPx0680j_42 = !C0856Dp.m5221equalsimpl0(this.maxHeight, companion.m5236getUnspecifiedD9Ej5fM()) ? density.mo1277roundToPx0680j_4(((C0856Dp) RangesKt.coerceAtLeast(C0856Dp.m5214boximpl(this.maxHeight), C0856Dp.m5214boximpl(C0856Dp.m5216constructorimpl(0)))).m5230unboximpl()) : Integer.MAX_VALUE;
        if (C0856Dp.m5221equalsimpl0(this.minWidth, companion.m5236getUnspecifiedD9Ej5fM()) || (i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo1277roundToPx0680j_4(this.minWidth), mo1277roundToPx0680j_4), 0)) == Integer.MAX_VALUE) {
            i = 0;
        }
        if (!C0856Dp.m5221equalsimpl0(this.minHeight, companion.m5236getUnspecifiedD9Ej5fM()) && (coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo1277roundToPx0680j_4(this.minHeight), mo1277roundToPx0680j_42), 0)) != Integer.MAX_VALUE) {
            i2 = coerceAtLeast;
        }
        return ConstraintsKt.Constraints(i, mo1277roundToPx0680j_4, i2, mo1277roundToPx0680j_42);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SizeModifier)) {
            return false;
        }
        SizeModifier sizeModifier = (SizeModifier) obj;
        return C0856Dp.m5221equalsimpl0(this.minWidth, sizeModifier.minWidth) && C0856Dp.m5221equalsimpl0(this.minHeight, sizeModifier.minHeight) && C0856Dp.m5221equalsimpl0(this.maxWidth, sizeModifier.maxWidth) && C0856Dp.m5221equalsimpl0(this.maxHeight, sizeModifier.maxHeight) && this.enforceIncoming == sizeModifier.enforceIncoming;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public int hashCode() {
        return ((((((C0856Dp.m5222hashCodeimpl(this.minWidth) * 31) + C0856Dp.m5222hashCodeimpl(this.minHeight)) * 31) + C0856Dp.m5222hashCodeimpl(this.maxWidth)) * 31) + C0856Dp.m5222hashCodeimpl(this.maxHeight)) * 31;
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m1448getTargetConstraintsOenEA2s = m1448getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5181getHasFixedHeightimpl(m1448getTargetConstraintsOenEA2s) ? Constraints.m5183getMaxHeightimpl(m1448getTargetConstraintsOenEA2s) : ConstraintsKt.m5197constrainHeightK40F9xA(m1448getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m1448getTargetConstraintsOenEA2s = m1448getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5182getHasFixedWidthimpl(m1448getTargetConstraintsOenEA2s) ? Constraints.m5184getMaxWidthimpl(m1448getTargetConstraintsOenEA2s) : ConstraintsKt.m5198constrainWidthK40F9xA(m1448getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        long Constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m1448getTargetConstraintsOenEA2s = m1448getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            Constraints = ConstraintsKt.m5196constrainN9IONVI(j, m1448getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            C0856Dp.Companion companion = C0856Dp.Companion;
            Constraints = ConstraintsKt.Constraints(!C0856Dp.m5221equalsimpl0(f, companion.m5236getUnspecifiedD9Ej5fM()) ? Constraints.m5186getMinWidthimpl(m1448getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m5186getMinWidthimpl(j), Constraints.m5184getMaxWidthimpl(m1448getTargetConstraintsOenEA2s)), !C0856Dp.m5221equalsimpl0(this.maxWidth, companion.m5236getUnspecifiedD9Ej5fM()) ? Constraints.m5184getMaxWidthimpl(m1448getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m5184getMaxWidthimpl(j), Constraints.m5186getMinWidthimpl(m1448getTargetConstraintsOenEA2s)), !C0856Dp.m5221equalsimpl0(this.minHeight, companion.m5236getUnspecifiedD9Ej5fM()) ? Constraints.m5185getMinHeightimpl(m1448getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m5185getMinHeightimpl(j), Constraints.m5183getMaxHeightimpl(m1448getTargetConstraintsOenEA2s)), !C0856Dp.m5221equalsimpl0(this.maxHeight, companion.m5236getUnspecifiedD9Ej5fM()) ? Constraints.m5183getMaxHeightimpl(m1448getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m5183getMaxHeightimpl(j), Constraints.m5185getMinHeightimpl(m1448getTargetConstraintsOenEA2s)));
        }
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(Constraints);
        return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeModifier$measure$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m1448getTargetConstraintsOenEA2s = m1448getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5181getHasFixedHeightimpl(m1448getTargetConstraintsOenEA2s) ? Constraints.m5183getMaxHeightimpl(m1448getTargetConstraintsOenEA2s) : ConstraintsKt.m5197constrainHeightK40F9xA(m1448getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m1448getTargetConstraintsOenEA2s = m1448getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m5182getHasFixedWidthimpl(m1448getTargetConstraintsOenEA2s) ? Constraints.m5184getMaxWidthimpl(m1448getTargetConstraintsOenEA2s) : ConstraintsKt.m5198constrainWidthK40F9xA(m1448getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    private SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }
}
