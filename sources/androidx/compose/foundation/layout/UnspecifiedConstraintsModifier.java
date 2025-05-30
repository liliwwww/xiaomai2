package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class UnspecifiedConstraintsModifier extends InspectorValueInfo implements LayoutModifier {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.getUnspecified-D9Ej5fM() : f2, function1, null);
    }

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsModifier)) {
            return false;
        }
        UnspecifiedConstraintsModifier unspecifiedConstraintsModifier = (UnspecifiedConstraintsModifier) obj;
        return Dp.equals-impl0(this.minWidth, unspecifiedConstraintsModifier.minWidth) && Dp.equals-impl0(this.minHeight, unspecifiedConstraintsModifier.minHeight);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m384getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m385getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    public int hashCode() {
        return (Dp.hashCode-impl(this.minWidth) * 31) + Dp.hashCode-impl(this.minHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicHeight(i), !Dp.equals-impl0(this.minHeight, Dp.Companion.getUnspecified-D9Ej5fM()) ? intrinsicMeasureScope.roundToPx-0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicWidth(i), !Dp.equals-impl0(this.minWidth, Dp.Companion.getUnspecified-D9Ej5fM()) ? intrinsicMeasureScope.roundToPx-0680j_4(this.minWidth) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo49measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        float f = this.minWidth;
        Dp.Companion companion = Dp.Companion;
        final Placeable placeable = measurable.measure-BRTryo0(ConstraintsKt.Constraints((Dp.equals-impl0(f, companion.getUnspecified-D9Ej5fM()) || Constraints.getMinWidth-impl(j) != 0) ? Constraints.getMinWidth-impl(j) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.roundToPx-0680j_4(this.minWidth), Constraints.getMaxWidth-impl(j)), 0), Constraints.getMaxWidth-impl(j), (Dp.equals-impl0(this.minHeight, companion.getUnspecified-D9Ej5fM()) || Constraints.getMinHeight-impl(j) != 0) ? Constraints.getMinHeight-impl(j) : RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.roundToPx-0680j_4(this.minHeight), Constraints.getMaxHeight-impl(j)), 0), Constraints.getMaxHeight-impl(j)));
        return MeasureScope$CC.p(measureScope, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable$PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicHeight(i), !Dp.equals-impl0(this.minHeight, Dp.Companion.getUnspecified-D9Ej5fM()) ? intrinsicMeasureScope.roundToPx-0680j_4(this.minHeight) : 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicWidth(i), !Dp.equals-impl0(this.minWidth, Dp.Companion.getUnspecified-D9Ej5fM()) ? intrinsicMeasureScope.roundToPx-0680j_4(this.minWidth) : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    private UnspecifiedConstraintsModifier(float f, float f2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.minWidth = f;
        this.minHeight = f2;
    }
}
