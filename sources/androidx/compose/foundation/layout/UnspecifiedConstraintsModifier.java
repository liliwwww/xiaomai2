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
/* loaded from: classes2.dex */
final class UnspecifiedConstraintsModifier extends InspectorValueInfo implements LayoutModifier {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM() : f2, function1, null);
    }

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, function1);
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
        if (!(obj instanceof UnspecifiedConstraintsModifier)) {
            return false;
        }
        UnspecifiedConstraintsModifier unspecifiedConstraintsModifier = (UnspecifiedConstraintsModifier) obj;
        return C0856Dp.m5221equalsimpl0(this.minWidth, unspecifiedConstraintsModifier.minWidth) && C0856Dp.m5221equalsimpl0(this.minHeight, unspecifiedConstraintsModifier.minHeight);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1449getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1450getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    public int hashCode() {
        return (C0856Dp.m5222hashCodeimpl(this.minWidth) * 31) + C0856Dp.m5222hashCodeimpl(this.minHeight);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicHeight(i), !C0856Dp.m5221equalsimpl0(this.minHeight, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo1277roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicWidth(i), !C0856Dp.m5221equalsimpl0(this.minWidth, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo1277roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        float f = this.minWidth;
        C0856Dp.Companion companion = C0856Dp.Companion;
        final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(ConstraintsKt.Constraints((C0856Dp.m5221equalsimpl0(f, companion.m5236getUnspecifiedD9Ej5fM()) || Constraints.m5186getMinWidthimpl(j) != 0) ? Constraints.m5186getMinWidthimpl(j) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo1277roundToPx0680j_4(this.minWidth), Constraints.m5184getMaxWidthimpl(j)), 0), Constraints.m5184getMaxWidthimpl(j), (C0856Dp.m5221equalsimpl0(this.minHeight, companion.m5236getUnspecifiedD9Ej5fM()) || Constraints.m5185getMinHeightimpl(j) != 0) ? Constraints.m5185getMinHeightimpl(j) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.mo1277roundToPx0680j_4(this.minHeight), Constraints.m5183getMaxHeightimpl(j)), 0), Constraints.m5183getMaxHeightimpl(j)));
        return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth(), mo4187measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsModifier$measure$1
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
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicHeight(i), !C0856Dp.m5221equalsimpl0(this.minHeight, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo1277roundToPx0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.p004ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicWidth(i), !C0856Dp.m5221equalsimpl0(this.minWidth, C0856Dp.Companion.m5236getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo1277roundToPx0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    private UnspecifiedConstraintsModifier(float f, float f2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = f;
        this.minHeight = f2;
    }
}
