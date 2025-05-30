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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float f, boolean z, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
        if (f > ((float) 0)) {
            return;
        }
        throw new IllegalArgumentException(("aspectRatio " + f + " must be > 0").toString());
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m292findSizeToXhtMw(long j) {
        if (this.matchHeightConstraintsFirst) {
            long m294tryMaxHeightJN0ABg$default = m294tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion = IntSize.Companion;
            if (!IntSize.m2683equalsimpl0(m294tryMaxHeightJN0ABg$default, companion.m2690getZeroYbymL2g())) {
                return m294tryMaxHeightJN0ABg$default;
            }
            long m296tryMaxWidthJN0ABg$default = m296tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2683equalsimpl0(m296tryMaxWidthJN0ABg$default, companion.m2690getZeroYbymL2g())) {
                return m296tryMaxWidthJN0ABg$default;
            }
            long m298tryMinHeightJN0ABg$default = m298tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2683equalsimpl0(m298tryMinHeightJN0ABg$default, companion.m2690getZeroYbymL2g())) {
                return m298tryMinHeightJN0ABg$default;
            }
            long m300tryMinWidthJN0ABg$default = m300tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2683equalsimpl0(m300tryMinWidthJN0ABg$default, companion.m2690getZeroYbymL2g())) {
                return m300tryMinWidthJN0ABg$default;
            }
            long m293tryMaxHeightJN0ABg = m293tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m293tryMaxHeightJN0ABg, companion.m2690getZeroYbymL2g())) {
                return m293tryMaxHeightJN0ABg;
            }
            long m295tryMaxWidthJN0ABg = m295tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m295tryMaxWidthJN0ABg, companion.m2690getZeroYbymL2g())) {
                return m295tryMaxWidthJN0ABg;
            }
            long m297tryMinHeightJN0ABg = m297tryMinHeightJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m297tryMinHeightJN0ABg, companion.m2690getZeroYbymL2g())) {
                return m297tryMinHeightJN0ABg;
            }
            long m299tryMinWidthJN0ABg = m299tryMinWidthJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m299tryMinWidthJN0ABg, companion.m2690getZeroYbymL2g())) {
                return m299tryMinWidthJN0ABg;
            }
        } else {
            long m296tryMaxWidthJN0ABg$default2 = m296tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            IntSize.Companion companion2 = IntSize.Companion;
            if (!IntSize.m2683equalsimpl0(m296tryMaxWidthJN0ABg$default2, companion2.m2690getZeroYbymL2g())) {
                return m296tryMaxWidthJN0ABg$default2;
            }
            long m294tryMaxHeightJN0ABg$default2 = m294tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2683equalsimpl0(m294tryMaxHeightJN0ABg$default2, companion2.m2690getZeroYbymL2g())) {
                return m294tryMaxHeightJN0ABg$default2;
            }
            long m300tryMinWidthJN0ABg$default2 = m300tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2683equalsimpl0(m300tryMinWidthJN0ABg$default2, companion2.m2690getZeroYbymL2g())) {
                return m300tryMinWidthJN0ABg$default2;
            }
            long m298tryMinHeightJN0ABg$default2 = m298tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m2683equalsimpl0(m298tryMinHeightJN0ABg$default2, companion2.m2690getZeroYbymL2g())) {
                return m298tryMinHeightJN0ABg$default2;
            }
            long m295tryMaxWidthJN0ABg2 = m295tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m295tryMaxWidthJN0ABg2, companion2.m2690getZeroYbymL2g())) {
                return m295tryMaxWidthJN0ABg2;
            }
            long m293tryMaxHeightJN0ABg2 = m293tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m293tryMaxHeightJN0ABg2, companion2.m2690getZeroYbymL2g())) {
                return m293tryMaxHeightJN0ABg2;
            }
            long m299tryMinWidthJN0ABg2 = m299tryMinWidthJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m299tryMinWidthJN0ABg2, companion2.m2690getZeroYbymL2g())) {
                return m299tryMinWidthJN0ABg2;
            }
            long m297tryMinHeightJN0ABg2 = m297tryMinHeightJN0ABg(j, false);
            if (!IntSize.m2683equalsimpl0(m297tryMinHeightJN0ABg2, companion2.m2690getZeroYbymL2g())) {
                return m297tryMinHeightJN0ABg2;
            }
        }
        return IntSize.Companion.m2690getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m293tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int i = Constraints.getMaxHeight-impl(j);
        if (i != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(i * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, i);
            if (!z || ConstraintsKt.isSatisfiedBy-4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m2690getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m294tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m293tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m295tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int i = Constraints.getMaxWidth-impl(j);
        if (i != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(i / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(i, roundToInt);
            if (!z || ConstraintsKt.isSatisfiedBy-4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m2690getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m296tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m295tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m297tryMinHeightJN0ABg(long j, boolean z) {
        int i = Constraints.getMinHeight-impl(j);
        int roundToInt = MathKt.roundToInt(i * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, i);
            if (!z || ConstraintsKt.isSatisfiedBy-4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m2690getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m298tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m297tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m299tryMinWidthJN0ABg(long j, boolean z) {
        int i = Constraints.getMinWidth-impl(j);
        int roundToInt = MathKt.roundToInt(i / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(i, roundToInt);
            if (!z || ConstraintsKt.isSatisfiedBy-4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m2690getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m300tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m299tryMinWidthJN0ABg(j, z);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        AspectRatioModifier aspectRatioModifier = obj instanceof AspectRatioModifier ? (AspectRatioModifier) obj : null;
        if (aspectRatioModifier == null) {
            return false;
        }
        return ((this.aspectRatio > aspectRatioModifier.aspectRatio ? 1 : (this.aspectRatio == aspectRatioModifier.aspectRatio ? 0 : -1)) == 0) && this.matchHeightConstraintsFirst == ((AspectRatioModifier) obj).matchHeightConstraintsFirst;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.aspectRatio) * 31) + l3.a(this.matchHeightConstraintsFirst);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i / this.aspectRatio) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i * this.aspectRatio) : intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo49measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long m292findSizeToXhtMw = m292findSizeToXhtMw(j);
        if (!IntSize.m2683equalsimpl0(m292findSizeToXhtMw, IntSize.Companion.m2690getZeroYbymL2g())) {
            j = Constraints.Companion.fixed-JhjzzOo(IntSize.m2685getWidthimpl(m292findSizeToXhtMw), IntSize.m2684getHeightimpl(m292findSizeToXhtMw));
        }
        final Placeable placeable = measurable.measure-BRTryo0(j);
        return MeasureScope$CC.p(measureScope, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioModifier$measure$1
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
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i / this.aspectRatio) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return i != Integer.MAX_VALUE ? MathKt.roundToInt(i * this.aspectRatio) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
