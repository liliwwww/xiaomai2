package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean enforceIncoming;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m2162getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m2162getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m2162getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m2162getUnspecifiedD9Ej5fM() : f4, z, function1, null);
    }

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    /* renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m240getTargetConstraintsOenEA2s(Density density) {
        int i;
        int coerceAtLeast;
        float f = this.maxWidth;
        Dp.Companion companion = Dp.Companion;
        int i2 = 0;
        int mo319roundToPx0680j_4 = !Dp.m2147equalsimpl0(f, companion.m2162getUnspecifiedD9Ej5fM()) ? density.mo319roundToPx0680j_4(((Dp) RangesKt.coerceAtLeast(Dp.m2140boximpl(this.maxWidth), Dp.m2140boximpl(Dp.m2142constructorimpl(0)))).m2156unboximpl()) : Integer.MAX_VALUE;
        int mo319roundToPx0680j_42 = !Dp.m2147equalsimpl0(this.maxHeight, companion.m2162getUnspecifiedD9Ej5fM()) ? density.mo319roundToPx0680j_4(((Dp) RangesKt.coerceAtLeast(Dp.m2140boximpl(this.maxHeight), Dp.m2140boximpl(Dp.m2142constructorimpl(0)))).m2156unboximpl()) : Integer.MAX_VALUE;
        if (Dp.m2147equalsimpl0(this.minWidth, companion.m2162getUnspecifiedD9Ej5fM()) || (i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo319roundToPx0680j_4(this.minWidth), mo319roundToPx0680j_4), 0)) == Integer.MAX_VALUE) {
            i = 0;
        }
        if (!Dp.m2147equalsimpl0(this.minHeight, companion.m2162getUnspecifiedD9Ej5fM()) && (coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.mo319roundToPx0680j_4(this.minHeight), mo319roundToPx0680j_42), 0)) != Integer.MAX_VALUE) {
            i2 = coerceAtLeast;
        }
        return ConstraintsKt.Constraints(i, mo319roundToPx0680j_4, i2, mo319roundToPx0680j_42);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SizeModifier)) {
            return false;
        }
        SizeModifier sizeModifier = (SizeModifier) obj;
        return Dp.m2147equalsimpl0(this.minWidth, sizeModifier.minWidth) && Dp.m2147equalsimpl0(this.minHeight, sizeModifier.minHeight) && Dp.m2147equalsimpl0(this.maxWidth, sizeModifier.maxWidth) && Dp.m2147equalsimpl0(this.maxHeight, sizeModifier.maxHeight) && this.enforceIncoming == sizeModifier.enforceIncoming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public int hashCode() {
        return ((((((Dp.m2148hashCodeimpl(this.minWidth) * 31) + Dp.m2148hashCodeimpl(this.minHeight)) * 31) + Dp.m2148hashCodeimpl(this.maxWidth)) * 31) + Dp.m2148hashCodeimpl(this.maxHeight)) * 31;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m240getTargetConstraintsOenEA2s = m240getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2119getHasFixedHeightimpl(m240getTargetConstraintsOenEA2s) ? Constraints.m2121getMaxHeightimpl(m240getTargetConstraintsOenEA2s) : ConstraintsKt.m2135constrainHeightK40F9xA(m240getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m240getTargetConstraintsOenEA2s = m240getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2120getHasFixedWidthimpl(m240getTargetConstraintsOenEA2s) ? Constraints.m2122getMaxWidthimpl(m240getTargetConstraintsOenEA2s) : ConstraintsKt.m2136constrainWidthK40F9xA(m240getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m241measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        long Constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m240getTargetConstraintsOenEA2s = m240getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            Constraints = ConstraintsKt.m2134constrainN9IONVI(j, m240getTargetConstraintsOenEA2s);
        } else {
            float f = this.minWidth;
            Dp.Companion companion = Dp.Companion;
            Constraints = ConstraintsKt.Constraints(!Dp.m2147equalsimpl0(f, companion.m2162getUnspecifiedD9Ej5fM()) ? Constraints.m2124getMinWidthimpl(m240getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m2124getMinWidthimpl(j), Constraints.m2122getMaxWidthimpl(m240getTargetConstraintsOenEA2s)), !Dp.m2147equalsimpl0(this.maxWidth, companion.m2162getUnspecifiedD9Ej5fM()) ? Constraints.m2122getMaxWidthimpl(m240getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m2122getMaxWidthimpl(j), Constraints.m2124getMinWidthimpl(m240getTargetConstraintsOenEA2s)), !Dp.m2147equalsimpl0(this.minHeight, companion.m2162getUnspecifiedD9Ej5fM()) ? Constraints.m2123getMinHeightimpl(m240getTargetConstraintsOenEA2s) : RangesKt.coerceAtMost(Constraints.m2123getMinHeightimpl(j), Constraints.m2121getMaxHeightimpl(m240getTargetConstraintsOenEA2s)), !Dp.m2147equalsimpl0(this.maxHeight, companion.m2162getUnspecifiedD9Ej5fM()) ? Constraints.m2121getMaxHeightimpl(m240getTargetConstraintsOenEA2s) : RangesKt.coerceAtLeast(Constraints.m2121getMaxHeightimpl(j), Constraints.m2123getMinHeightimpl(m240getTargetConstraintsOenEA2s)));
        }
        Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(Constraints);
        return MeasureScope.-CC.p(measureScope, mo1521measureBRTryo0.getWidth(), mo1521measureBRTryo0.getHeight(), (Map) null, new measure.1(mo1521measureBRTryo0), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m240getTargetConstraintsOenEA2s = m240getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2119getHasFixedHeightimpl(m240getTargetConstraintsOenEA2s) ? Constraints.m2121getMaxHeightimpl(m240getTargetConstraintsOenEA2s) : ConstraintsKt.m2135constrainHeightK40F9xA(m240getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        long m240getTargetConstraintsOenEA2s = m240getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        return Constraints.m2120getHasFixedWidthimpl(m240getTargetConstraintsOenEA2s) ? Constraints.m2122getMaxWidthimpl(m240getTargetConstraintsOenEA2s) : ConstraintsKt.m2136constrainWidthK40F9xA(m240getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

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
