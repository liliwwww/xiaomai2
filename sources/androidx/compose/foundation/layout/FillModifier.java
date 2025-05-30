package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FillModifier extends InspectorValueInfo implements LayoutModifier {

    @NotNull
    private final Direction direction;
    private final float fraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FillModifier(@NotNull Direction direction, float f, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.direction = direction;
        this.fraction = f;
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
        if (obj instanceof FillModifier) {
            FillModifier fillModifier = (FillModifier) obj;
            if (this.direction == fillModifier.direction) {
                if (this.fraction == fillModifier.fraction) {
                    return true;
                }
            }
        }
        return false;
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
        return (this.direction.hashCode() * 31) + Float.floatToIntBits(this.fraction);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m207measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        int m2124getMinWidthimpl;
        int m2122getMaxWidthimpl;
        int m2121getMaxHeightimpl;
        int i;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (!Constraints.m2118getHasBoundedWidthimpl(j) || this.direction == Direction.Vertical) {
            m2124getMinWidthimpl = Constraints.m2124getMinWidthimpl(j);
            m2122getMaxWidthimpl = Constraints.m2122getMaxWidthimpl(j);
        } else {
            m2124getMinWidthimpl = RangesKt.coerceIn(MathKt.roundToInt(Constraints.m2122getMaxWidthimpl(j) * this.fraction), Constraints.m2124getMinWidthimpl(j), Constraints.m2122getMaxWidthimpl(j));
            m2122getMaxWidthimpl = m2124getMinWidthimpl;
        }
        if (!Constraints.m2117getHasBoundedHeightimpl(j) || this.direction == Direction.Horizontal) {
            int m2123getMinHeightimpl = Constraints.m2123getMinHeightimpl(j);
            m2121getMaxHeightimpl = Constraints.m2121getMaxHeightimpl(j);
            i = m2123getMinHeightimpl;
        } else {
            i = RangesKt.coerceIn(MathKt.roundToInt(Constraints.m2121getMaxHeightimpl(j) * this.fraction), Constraints.m2123getMinHeightimpl(j), Constraints.m2121getMaxHeightimpl(j));
            m2121getMaxHeightimpl = i;
        }
        Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(ConstraintsKt.Constraints(m2124getMinWidthimpl, m2122getMaxWidthimpl, i, m2121getMaxHeightimpl));
        return MeasureScope.-CC.p(measureScope, mo1521measureBRTryo0.getWidth(), mo1521measureBRTryo0.getHeight(), (Map) null, new measure.1(mo1521measureBRTryo0), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
